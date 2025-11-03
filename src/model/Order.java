package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase encargada del almacenamiento de información sobre las ordenes.
 * <p>
 * Esta clase se encarga de almacenar los obejtos de la clase {@link Product} solicitados para una orden, determinar precio total 
 * y mostrar los datos de una compra.
 * 
 * @author Felipe Becerra
 * @version 1.0
 * @since 2024-09-15
 */

public class Order {
    /**Identificador numerico de la orden*/
    private int ord_id;
    /**Lista que almacena todos los productos que se incluyen en la orden*/
    private List<Product> products=new ArrayList<>();
    /**Fecha en la que se realizó la orden */
    private LocalDate ord_date;
    /**
     * Constructor para crear un nuevo objeto Orden.
     * <p>
     * Inicializa un nuevo objeto Orden con los datos ingresados como la id y la fecha en que se realizó la orden.
     * 
     * @param ord_id        Identificador numerico de la orden
     * @param ord_date      Fecha de realización de la orden
     */
    public Order(int ord_id,LocalDate ord_date){
        this.ord_id=ord_id;
        this.ord_date=ord_date;
    }
    /**Obtiene la fecha en que se realizó la orden
     * 
     * @return la fecha en la que se realizó la orden
     */
    public LocalDate getOrd_date() {
        return ord_date;
    }
    /**Modifica la información correspondiente a la fecha
     * 
     * @param ord_date
     */
    public void setOrd_date(LocalDate ord_date) {
        this.ord_date = ord_date;
    }
    /**Obtiene el identificador correspondiente a la orden requerida
     * 
     * @return La id de la orden
     */
    public int getOrd_id() {
        return ord_id;
    }
    /**Modifica el valor de la id de la orden
     * 
     * @param ord_id
     */
    public void setOrd_id(int ord_id){
        this.ord_id = ord_id;
    }
    /**Agrega, modifica y reemplaza (en caso de haber otra lista) la lista de productos en la orden
     * 
     * @param products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**Agrega un producto a la lista existente dentro de la orden
     * 
     * @param newProduct
     */
    public void AddProduct(Product newProduct)throws IllegalArgumentException{
        if(products==null)throw new IllegalArgumentException("El producto no puede ser nulo");
        products.add(newProduct);
    }

    /**Elimina todos los productos agregados a la lista de la orden
     */
    public void DeleteAll(){
        products.clear();
    }
    /**Cálcula el precio de la orden con cada uno de los productos agregados
     * 
     * @return el precio total de una orden
     */
    public double TotalCost(){
        double totalCost=0; //value 0,00 by default

        for(int i=0;i<products.size();i++){
            totalCost+= products.get(i).getPro_price();
        }
        return totalCost;
    }
    /**Muestra la información de la orden tal como su ID, su fecha la lista de productos agregados con sus respectivas
     * características 
     * 
     * @param Price
     */
    public void ShowOrder(double Price){
        System.out.println("\nFarmaTodo Order /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Order ID: "+ord_id+"--------------------------------------------");
        System.out.println("Order Date: "+LocalDate.now()+"\n");

        int counter=1;

        for(Product p: products){
            System.out.println("Product N."+counter+": ");
            System.out.println("Product ID: "+p.getPro_id());
            System.out.println("Name: "+p.getPro_name());
            System.out.println("Price: "+p.getPro_price());
            System.out.println("\n");
        }
    }
    /**Muestra la información en pantalla en formato compatible con JFrame
     * 
     * @return Una cadena de texto con la información de la orden
     */
    public String getOrderDetails(){
    StringBuilder sb = new StringBuilder();
    int counter = 1;
    sb.append("\n----------------------------------------------------------------------------------------\n");
     for(Product p : products){
        sb.append("Product N.").append(counter++).append(": ")
          .append(p.getPro_name())
          .append(" - $")
          .append(String.format("%,.2f", p.getPro_price()))
          .append("\n");
    }


    return sb.toString();
}
}