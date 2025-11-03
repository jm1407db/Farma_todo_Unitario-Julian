import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

import model.Druggist;
import model.FilesLoader;


public class TestLoginGUI{
    @Test
    public void TeststartLogin(){
        boolean logged = false;
        boolean found = false;

        while (!logged) {
            String pathfiledruggist="druggistList.txt";
            // Cargar lista de farmacéuticos desde archivo
            List<Druggist> druggList = FilesLoader.LoadDruggists(pathfiledruggist);
            assertEquals("druggistList.txt", pathfiledruggist);
            

            // Solicitar nombre de usuario
            String log_user = JOptionPane.showInputDialog(null, "Ingrese usuario:", "Login", JOptionPane.QUESTION_MESSAGE);
            assertNotNull(log_user);
            

            

            // Solicitar contraseña
            JPasswordField pf = new JPasswordField();
            int option = JOptionPane.showConfirmDialog(null, pf, "Ingrese contraseña:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (option != JOptionPane.OK_OPTION) {
                System.exit(0);
            }

            
            String pass = new String(pf.getPassword());
            assertNotNull("La Contraseña ingresada es nula.",pass);

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
