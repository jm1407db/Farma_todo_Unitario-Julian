package model;
import java.util.Scanner;
/**Representa a una persona, siendo la clase padre de CLiente y Farmaceutico desde la cual heredan sus atributos
 * <p>
 * Tiene sus propios métodos y atributos que luego son heredados a otras dos clases
 * 
 * @author Felipe Becerra
 * @version 1.0
 * @since 2024-09-15
 */
public class Person {
    /**Nombre completo de la persona */
    private String name;
    /**Tipo de documento de la persona, representado con un caracter como C para cédula */
    private char doc_type;
    /**Numero del documento o en el caso de que posea otros cáracteres también los admite */
    private String doc_num;

    /**Método constructor de la clase Persona, clave para los metodos constructores de las demas clases
     * 
     * @param name          Nombre completo de la persona
     * @param doc_type      Tipo de documento 
     * @param doc_num       Numero o indicativo correspondiente al documento
     */
    public Person(String name, char doc_type, String doc_num)throws IllegalArgumentException{
        if(name==null)throw new IllegalArgumentException("el nombre no puede ser vacío");
        if( doc_type == '\u0000')throw new IllegalArgumentException("el tipo de documento no puede ser vacio");
        if(doc_num==null)throw new IllegalArgumentException("el número de documento no puede ser vacio");
        this.name=name;
        this.doc_type=doc_type;
        this.doc_num=doc_num;
    }
    /**Obtener el nombre de la persona
     * 
     * @return el nombre de la persona
     */
    public String getName(){
        return name;
    }
    /**Obtener el  tipo de documento de la persona
     * 
     * @return Un caracter indicativo sobre el tipo de documento de la persona
     */
    public char getDoc_type(){
        return doc_type;
    }
    /**Obtener el numero de documento correspondiente a la persona
     * 
     * @return Obtener la cadena de texto asociada al documento de la persona
     */
    public String getDoc_num(){
        return doc_num;
    }
    
    /**Crear una nueva persona ingresando los datos necesarios para el método constructor
     * 
     * @return    Un nuevo objeto persona
     */
    public static Person register(){
        
        Scanner ent=new Scanner(System.in);
        System.out.println("What's your name?");
        String name=ent.nextLine();
        char doc_type=' ';
        try {
        System.out.println("What's your document type?");
        doc_type=ent.nextLine().charAt(0);
        } catch (StringIndexOutOfBoundsException e) {
            
        }
        System.out.println("What's your document number?");
        String doc_num=ent.nextLine();
        ent.close();
        return new Person(name, doc_type, doc_num); 
        
    }

    /**Mostrar la información de un cliente
     * 
     */
    public void cli_showInfo(){
        
        System.out.println("\nClient Information 0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0 "+"\n    Client name: "+name+"\n    ID Type: "+doc_type+"\n    sNumber: "+doc_num+"\n0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0 ");
    }
    
}