package UI;

import javax.swing.*;
import java.util.List;
import model.Druggist;
import model.FilesLoader;

/**
 * Clase encargada de gestionar la interfaz de inicio de sesión para los farmacéuticos (Druggists).
 * <p>
 * Esta clase muestra un cuadro de diálogo donde el usuario debe ingresar un nombre de usuario
 * y una contraseña, los valida contra una lista de usuarios cargada desde un archivo,
 * y en caso de éxito abre el menú principal del sistema.
 * </p>
 * 
 * @author Axel
 */
public class LoginGUI {

    /**
     * Lista de objetos {@link Druggist} que representan los farmacéuticos autorizados
     * a ingresar al sistema.
     */
    private List<Druggist> druggistList;

    /**
     * Método estático que inicia el proceso de inicio de sesión.
     * <p>
     * - Carga los usuarios desde un archivo.<br>
     * - Solicita credenciales mediante cuadros de diálogo.<br>
     * - Valida las credenciales ingresadas contra la lista cargada.<br>
     * - En caso de éxito, muestra un mensaje de bienvenida y abre el menú principal.<br>
     * - En caso de error, muestra un mensaje de advertencia y vuelve a solicitar las credenciales.
     * </p>
     * 
     * El programa finalizará si el usuario cancela el ingreso de credenciales.
     */

    
    public static void startLogin() {
        String pathfiledruggist="druggistList.txt";

        boolean logged = false;
        boolean found = false;

        while (!logged) {

            // Cargar lista de farmacéuticos desde archivo
            List<Druggist> druggList = FilesLoader.LoadDruggists(pathfiledruggist);

            // Solicitar nombre de usuario
            String log_user = JOptionPane.showInputDialog(null, "Ingrese usuario:", "Login", JOptionPane.QUESTION_MESSAGE);

            if (log_user == null) { // Cancelar
                System.exit(0);
            }

            // Solicitar contraseña
            JPasswordField pf = new JPasswordField();
            int option = JOptionPane.showConfirmDialog(null, pf, "Ingrese contraseña:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (option != JOptionPane.OK_OPTION) {
                System.exit(0);
            }

            String pass = new String(pf.getPassword());

            // Validación de credenciales
            for (Druggist d : druggList) {
                if (d.getDruggist_user().equals(log_user) && d.getDruggist_password().equals(pass)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + d.getName(), "Acceso concedido", JOptionPane.INFORMATION_MESSAGE);

                    SwingUtilities.invokeLater(() -> { // Mostrar menú principal
                        new UI.MainMenuGUI().setVisible(true);
                    });

                    logged = true;
                    found = true;
                    break;
                }
            }

            // Si no encontró coincidencia, mostrar error
            if (!found) {
                JOptionPane.showMessageDialog(null, "Credenciales inválidas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
