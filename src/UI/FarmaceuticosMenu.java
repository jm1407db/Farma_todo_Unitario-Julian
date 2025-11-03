package UI;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.border.Border;

import model.Druggist;
import model.FilesLoader;
import model.WriteFiles;

/**
 * Clase encargada de la generacion de la ventana para manejo de farmacéuticos.
 * <p>
 * Esta clase se encarga de mostrar una ventana donde el farmacéutico podra
 * generar nuevos farmacéuticos con usuario contraseña para que pueda accede a
 * sus respectivas funciones.
 * 
 * @author Julian Moreno
 * @version 1.0
 * @since 2024-09-15
 */
public class FarmaceuticosMenu extends JFrame {
    /**Lista visual que muestra los objetos {@link Druggist} en la ventana.*/
    private JList listViewDruggist;
    /**Administrador de la lista de objetos {@link Druggist} que se encarga de manejar los datos que se ven en el JList.*/
    private DefaultListModel<String> modelListDruggist;
    /**Lista donde se pasan los objetos {@link Druggist} para que luego sean manejados por el DefaulListModel.*/
    private List<Druggist> listDruggist;
    /**Objeto JButtton para generar nuevos objetos {@link Druggist}*/
    private JButton addDruggist;

    /**
     * Constructor de la clase FarmaceuticosMenu.
     * <p>
     * Este constructor realiza las siguientes acciones:
     * <ul>
     * <li>Inicializa la ventana y la configura el ancho y alto ademas de la distribucion de los espacios de la ventana.
     * <li>Carga la lista de farmaceuticos a travez de un archivo txt y los organiza para que se puedan ver en la ventan, ademas de que les asigna un espacio.
     * <li>Genera los componentes de la ventana como el JButton para los botones de nuevo farmaceutico y de regresar, ademas de generar una area para los botones con el JPanel.
     * <li>Crea un JScrollPane en caso de que sean muchos datos para que salga una barra de navegacion.
     * <li>Crea un Jlist que permite organizar los datos de los objetos farmacéuticos para que se muestren en el JPanel de forma ordenada.
     */
    public FarmaceuticosMenu() {
        setTitle("Lista de Farmaceuticos");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        listDruggist = FilesLoader.LoadDruggists("druggistList.txt");
        modelListDruggist = new DefaultListModel<>();
        byte contador = 0;
        for (Druggist druggist : listDruggist) {
            contador++;
            modelListDruggist.addElement("Farmaceutico N" + contador + "        |    Nombre Farmaceutico:"
                    + druggist.getName() + "        |    Doc:" + druggist.getDoc_num() + "      |     username:"
                    + druggist.getDruggist_user() + "       |    password:" + druggist.getDruggist_password());
        }
        listViewDruggist = new JList<>(modelListDruggist);
        JScrollPane scrollDruggist = new JScrollPane(listViewDruggist);
        add(scrollDruggist, BorderLayout.CENTER);
        addDruggist = new JButton("Agregar farmaceutico");
        JPanel bottomsArea = new JPanel();
        bottomsArea.add(addDruggist);
        add(bottomsArea, BorderLayout.SOUTH);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            new MainMenuGUI().setVisible(true);
            this.dispose();
        });
        bottomsArea.add(backButton, BorderLayout.SOUTH);

        addDruggist.addActionListener((e) -> {
            String name;
            do {
                name = JOptionPane.showInputDialog("Escribe el nombre del farmaceutico");
                if (name == null) {
                    return;
                }
            } while (name.trim().isEmpty());
            String docTypeStr;
            char docType;
            boolean verificacionDocumento;
            do {
                verificacionDocumento=true;
                docTypeStr = JOptionPane.showInputDialog("Escribe el tipo de documento\n Tarjeta de identidad (T) o Cedula(C)");
                if (docTypeStr == null) {
                    verificacionDocumento=false;
                    return;
                }
                if (docTypeStr.length() != 1) {
                    verificacionDocumento=false;
                    JOptionPane.showMessageDialog(this, "Error: Debes introducir solo un caracter", "entrada invalida",
                            JOptionPane.ERROR_MESSAGE);
                }
                if(!docTypeStr.equals("C")){
                    if(!docTypeStr.equals("T")){
                    JOptionPane.showMessageDialog(this, "Error debe introducir entre las opciones(Tarjeta de identidad (T) o Cedula (C))","entrada invalida",JOptionPane.ERROR_MESSAGE);
                    verificacionDocumento=false; }
                } 
            } while (verificacionDocumento==false);
            docType = docTypeStr.charAt(0);
            String numDoc;
            do {
                numDoc = JOptionPane.showInputDialog("Escribe el numero del documento");
                if (numDoc.equals("")) {
                    numDoc=null;
                    JOptionPane.showMessageDialog(null, "El número de documento no puede ser vacio");
                }
                for (int i = 0; i < listDruggist.size(); i++) {
                    if (numDoc!=null) {
                       if (numDoc.equals(listDruggist.get(i).getDoc_num())) {
                        numDoc=null;
                        JOptionPane.showMessageDialog(null, "No puede tener el mismo número de documento que otra persona");
                    } 
                    }
                }
            } while (numDoc==null);
            String druggiestUser;
            do {
                druggiestUser = JOptionPane.showInputDialog("Escribe el user del farmaceutico");
                if (druggiestUser == null) {
                    return;
                }
            } while (druggiestUser.trim().isEmpty());
            String druggiestPassword;
            do {
                druggiestPassword = JOptionPane.showInputDialog("Escribe la contraseña del farmaceutico");
                if (druggiestPassword == null) {
                    return;
                }
            } while (druggiestPassword.trim().isEmpty());
            modelListDruggist.addElement("Farmaceutico N" + (listDruggist.size() + 1) + "    |    Nombre Farmaceutico:"
                    + name + "    |    Doc:" + numDoc + "    |    username:" + druggiestUser + "    |    password:"
                    + druggiestPassword);
            listDruggist.add(new Druggist(name, docType, numDoc, druggiestUser, druggiestPassword));
            WriteFiles.SaveFiles("druggistList.txt", listDruggist);
        });
    }
}
