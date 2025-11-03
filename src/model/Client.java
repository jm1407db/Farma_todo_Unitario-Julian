package model;

import javax.swing.JOptionPane;

/**
 * Representa a un Cliente, trayendo atributos y metodos de la clase {@link Person} para incluir atributos basicos.
 * <p>
 * Esta clase hereda sus atributos de la clase {@link Person} como nombre, tipo de documento, numero de documento. Ademas de los
 * atributos que se añaden como las unidades del producto que el Cliente solicita.
 * 
 *@author Felipe Becerra
 *@version 1.0
 *@since 2025-09-15
 */

public class Client extends Person {
    /**Nombre de usuario de fa para el inicio de sesion */
    private int pro_amount;
     /**
     * Constructor para crear un nuevo objeto Cliente.
     * <p>
     * Inicializa un nuevo objeto Farmacéutico con los datos ingresados y los datos para el inicio de sesion.
     * 
     * @param name                  El nombre del farmacéutico.
     * @param doc_type              El tipo de documento del farmacéutico(ej C para cedula o T para tarjeta de identidad).        
     * @param doc_num               El numero de documento de identidad.
     * @param druggist_user         El nombre de usuario para el inicio de sesion.
     * @param druggist_password     La contraseña de usuario para el inicio de sesion.
     * @param pro_amount            Describe la cantidad de unidades de un producto que un cliente solicita
     */

    public Client(String name, char doc_type, String doc_num, int pro_amount) {
        super(name, doc_type, doc_num);
    }
    /**Obtiene la cantidad de unidades del producto que el cliente solicita.
     * 
     * @return La cantidad de unidades del producto que el cliente solicita.
    */

    public int getPro_amount() {
        return pro_amount;
    }
    /**Permite editar la cantidad de unidades del producto que el cliente solicita.
     * 
     * @param pro_amount La nueva cantidad de unidades del producto que el cliente solicita.
    */
    public void setPro_amount(int pro_amount) {
        try {
            this.pro_amount = pro_amount;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error leyendo el dato");
        }
        
    }
}
