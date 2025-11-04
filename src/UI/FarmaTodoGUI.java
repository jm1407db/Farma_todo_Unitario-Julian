package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import model.Order;
import model.Product;
import java.util.List;
import model.FilesLoader;
import java.time.LocalDate;


public class FarmaTodoGUI extends JFrame{
    private JList<String> productList;
    private DefaultListModel<String> listModel;
    private JTextArea cartArea;
    private Order order;
    private List<Product>catalog;
    public double Price=0;

    public FarmaTodoGUI(){

        setTitle("Farma Todo - Shopping Cart");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        //Loading Products
        catalog=FilesLoader.LoadProducts("catalog.txt");
        order=new Order(101, LocalDate.now());

        //Catalog Panel
        listModel=new DefaultListModel<>();
        for (Product p : catalog) {
            listModel.addElement(p.getPro_id()+" - "+p.getPro_name()+" - "+" Stock: "+p.getPro_stock()+" - "+p.getPro_expirarion()+" - ($"+p.getPro_price()+")");
        }

        productList=new JList<>(listModel);

        JScrollPane scrollCatalog=new JScrollPane(productList);

        JButton addButton=new JButton("Add to cart");
        addButton.addActionListener((ActionEvent e)->{
            int option = 0;
            int selectProduct=productList.getSelectedIndex();
            int stock=0;
            boolean allCorrect=true;
            if (selectProduct!=-1) {
                Product product=catalog.get(selectProduct);
                do {
                    allCorrect=true;
                try {
                    stock= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea"));
                    if (stock>product.getPro_stock() || stock<=0) {
                        JOptionPane.showMessageDialog(null, "ERROR: se ingreso una cantidad invalida lo que significa que: \n 1. Se ingreso una cantidad mayor a las unidades disponibles \n 2. Se ingreso 0 o un valor negativo");
                        allCorrect=false;
                    }
                } catch (NumberFormatException i) {
                    JOptionPane.showMessageDialog(null, "Se ingreso un valor no numerico");
                    allCorrect=false; 
                }  
                } while (allCorrect==false);
                
            
            option=JOptionPane.showConfirmDialog(null, "El medicamento: "+product.getPro_name()+" con esa cantidad, tiene un costo de"+(product.getPro_price()*stock)+"\n"+"¿Desea confirmar su compra?");
            if (option==JOptionPane.YES_OPTION) {
                order.AddProduct(product);
                cartArea.append(product.getPro_name()+ "- ($"+product.getPro_price()*stock+") \n");
                Price+=product.getPro_price()*stock;
            }else if (option==JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Compra cancelada exitosamente");
            }
                
            }
        });


        JPanel leftPanel=new JPanel(new BorderLayout());
        leftPanel.add(new JLabel("Product Catalog: "),BorderLayout.NORTH);
        leftPanel.add(scrollCatalog, BorderLayout.CENTER);
        leftPanel.add(addButton, BorderLayout.SOUTH);
        

        //Cart Panel
        cartArea = new JTextArea();
        cartArea.setEditable(false);
        JScrollPane ScrollCart=new JScrollPane(cartArea);

        JPanel rightPanel=new JPanel(new BorderLayout());
        rightPanel.add(new JLabel("Shopping Cart"), BorderLayout.NORTH);
        rightPanel.add(ScrollCart, BorderLayout.CENTER);

        JButton checkoutButton=new JButton("End Purchase");
        checkoutButton.addActionListener((ActionEvent e)->{
            cartArea.append(order.getOrderDetails());
            cartArea.append("Precio Total: "+Price+"\n");
            Price=0;
            order.DeleteAll();
        });
        rightPanel.add(checkoutButton,BorderLayout.SOUTH);


        JButton backButton=new JButton("Back"); //Back Button
        backButton.addActionListener(e->{
            new MainMenuGUI().setVisible(true);
            this.dispose();
        });
        rightPanel.add(backButton,BorderLayout.SOUTH);

        //Back Panel
        JPanel buttonsPanel=new JPanel(new FlowLayout());
        buttonsPanel.add(checkoutButton);
        buttonsPanel.add(backButton);    

        rightPanel.add(buttonsPanel, BorderLayout.SOUTH);
    
        //Dividir la pantalla en dos
        add(leftPanel,BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    } 

    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            new FarmaTodoGUI().setVisible(true);
        });
    }
}