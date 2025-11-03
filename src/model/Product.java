package model;

import java.time.LocalDate;

/**
 * Representa a un Producto con sus propios metodos y atributos .
 * <p>
 * Esta clase se encarga de proporcionar la información de cada uno de los productos existentes.
 * 
 *@author Axel Rincón
 *@version 1.0
 *@since 2025-09-15
 */
public class Product {
    /** Nombre del producto */
    private String pro_name;
    /**Identificador numerico del producto */
    private int pro_id;
    /**Precio por unidad del producto */
    private double pro_price;
    /**Fecha de expiración del producto */
    private LocalDate pro_expirarion;
    /**La cantidad de unidades disponibles de ese producto */
    private int pro_stock;

    /**Método constructor del producto con sus respectivos atributos
     * 
     * @param pro_id            Identificador numerico del documento
     * @param pro_name          Nombre del producto
     * @param pro_price         Precio por unidad del producto
     * @param pro_stock         Cantidad de unidades iniciales del producto
     * @param pro_expirarion    Fecha de expiración del producto
     */
    public Product(int pro_id, String pro_name, double pro_price, int pro_stock, LocalDate pro_expirarion){
        //No es necesario meter un try catch dado que el filesloader ya posee uno 
        this.pro_id=pro_id;
        this.pro_name=pro_name;
        this.pro_price=pro_price;
        this.pro_expirarion=pro_expirarion;
        this.pro_stock=pro_stock;
    }
    /**Obtiene el identificador numerico del producto
     * 
     * @return ID del producto
     */
    public int getPro_id(){
        return pro_id;
    }
    /**Obtiene el nombre del producto
     * 
     * @return El nombre del producto
     */
    public String getPro_name(){
        return pro_name;
    }
    /**Obtiene el precio por unidad del producto
     * 
     * @return Precio del producto
     */
    public double getPro_price(){
        return pro_price;
    }
    /**Obtiene la cantidad de unidades disponibles
     * 
     * @return el numero de unidades disponibles 
     */
    public int getPro_stock(){
        return pro_stock;
    }
    /**Obtiene la fehca de expiración del producto
     * 
     * @return   la fecha de expiración del producto
     */
    public LocalDate getPro_expirarion() {
        return pro_expirarion;
    }

    /**Modifica la fecha de expiración de un producto 
     * 
     * @param pro_expirarion       La fecha por la cual se va a modificar
     */
    public void setPro_expirarion(LocalDate pro_expirarion) {
        this.pro_expirarion = pro_expirarion;
    }
    /**Modifica el nombre de un producto
     * 
     * @param pro_name      El nombre por el cual se va a cambiar el anterior
     */
    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }
    /**Modifica la id de un producto
     * 
     * @param pro_id         La id por la cual se va a cambiar la anterior
     */
    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }
    /**Modifica el precio de un producto
     * 
     * @param pro_price     El precio del producto por el que se cambiará el anterior
     */
    public void setPro_price(double pro_price) {
        this.pro_price = pro_price;
    }
    /**Modifica la cantidad disponible de un producto
     * 
     * @param pro_stock        La nueva cantidad disponible de un producto
     */
    public void setPro_stock(int pro_stock){
        this.pro_stock=pro_stock;
    }
    
    @Override
    public String toString() {
        return "Product [pro_name=" + pro_name + ", pro_id=" + pro_id + ", pro_price=" + pro_price + "Stock= "+pro_stock+", pro_expirarion="+ pro_expirarion + "]";
    }
    /**Muestra la información de un producto en pantalla */
    public void pro_showInfo(){
        System.out.println("Product Information--------- "+"\nProduct name: "+pro_name+"\nID: "+pro_id+"\nPrice: "+pro_price+"\n Stock: "+pro_stock+"\nExpiration: "+pro_expirarion);
    }
}