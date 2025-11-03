package model;
/**
 * Representa a un Farmacéutico, trayendo atributos y metodos de la clase {@link Person} para incluir atributos basicos.
 * <p>
 * Esta clase hereda sus atributos de la clase {@link Person} como nombre, tipo de documento, numero de documento. Ademas de los
 * atributos que se añaden como el usuario y la contraseña.
 * 
 *@author Julian Moreno
 *@version 1.0
 *@since 2025-09-15
 */
public class Druggist extends Person{
    /**Nombre de usuario de farmaceutico para el inicio de sesion */
    private String druggist_user;
    /**Contraseña del farmacéutico para el inicio de sesion */
    private String druggist_password;
    /**
     * Constructor para crear un nuevo objeto farmacéutico.
     * <p>
     * Inicializa un nuevo objeto Farmacéutico con los datos ingresados y los datos para el inicio de sesion.
     * 
     * @param name                  El nombre del farmacéutico.
     * @param doc_type              El tipo de documento del farmacéutico(ej C para cedula o T para tarjeta de identidad).        
     * @param doc_num               El numero de documento de identidad.
     * @param druggist_user         El nombre de usuario para el inicio de sesion.
     * @param druggist_password     La contraseña de usuario para el inicio de sesion.
     */
    public Druggist(String name, char doc_type, String doc_num, String druggist_user, String druggist_password)throws IllegalArgumentException{
        super(name, doc_type, doc_num);
        if(name==null) throw new IllegalArgumentException("El nombre no puede ser vacio");
        if(druggist_password==null) throw new IllegalArgumentException("La contraseña no puede ser vacia");
        this.druggist_user = druggist_user;
        this.druggist_password = druggist_password;
    }
    /**Obtiene el nombre del farmaceutico.
     * 
     * @return El nombre actual del usuario.
    */
    public String getDruggist_user() {
        return druggist_user;
    }
    /**Permite editar el nombre del usuario del farmacéutico.
     * 
     * @param druggist_user El nuevo nombre del usuario que se va a asignar.
    */
    public void setDruggist_user(String druggist_user) throws IllegalArgumentException{
        if(druggist_user==null)throw new IllegalArgumentException("El nombre de usuario no puede ser vacio");
        this.druggist_user = druggist_user;
    }
    /**Obtiene la contraseña del farmaceutico.
     * 
     * @return La contraseña actual del farmaceutico.
    */
    public String getDruggist_password() {
        return druggist_password;
    }
    /**Permite editar la contraseña del farmacéutico.
     * 
     * @param druggist_password  la nueva contraseña del usuario que se va a asignar.
    */
    public void setDruggist_password(String druggist_password) {
        if(druggist_password==null)throw new IllegalArgumentException("La contraseña no puede ser vacia");
        this.druggist_password = druggist_password;
    }
    /**
     *Devuelve los atributos del objeto farmaceutico en formato String.
     *<p>
     *Este metodo trae los atributos del objeto farmaceutico y los muestra de forma ordenada.
     *
     *@return Una cadena de texto donde se muestra el nombre, tipo de documento, numero de documento, 
     *usuario y contraseña. 
    */
    @Override
    public String toString() {
        return "Name :"+getName()+" \n "+ "Doc type: "+getDoc_type()+" \n "+"Doc Num: "+
        getDoc_num()+" \n "+"User: "+getDruggist_user()+ " \n "+"Password: "+getDruggist_password()+"\n";
    }


    
}
