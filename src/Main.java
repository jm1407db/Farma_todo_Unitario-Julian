import javax.swing.SwingUtilities;
//AHOY
//Este es el main del proyecto.

import org.junit.Test;

import UI.FarmaTodoGUI;
import UI.FarmaceuticosMenu;
import UI.LoginGUI;
import model.Druggist;
import model.FilesLoader;

import static org.junit.Assert.assertEquals;

import java.util.*;

public class Main {
    
    public static void app(String[] args) throws Exception {
        //Comentario por julian
        //Comentario por Axel
        String pathfiledruggist="druggistList.txt";
        List<Druggist> druggList=FilesLoader.LoadDruggists(pathfiledruggist);
         SwingUtilities.invokeLater(()->{
             LoginGUI.startLogin();
             //COMENTARIO POR FELP
        });
}}

