package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.management.InvalidAttributeValueException;
import javax.naming.NameNotFoundException;
import javax.swing.JOptionPane;

public class WriteFiles {
    public static void SaveFiles(String pathFile,List<Druggist>changesListDruggist){
        try(BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(pathFile))) {
            for (Druggist druggist : changesListDruggist) {
                String valores= druggist.getName()+","+druggist.getDoc_type()+","+druggist.getDoc_num()+","+druggist.getDruggist_user()+","+druggist.getDruggist_password();
                bufferedWriter.write(valores);
                bufferedWriter.newLine();
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encontro el documento", pathFile, 0);
        }catch( IOException e){
            JOptionPane.showMessageDialog(null, e, pathFile, 0);
        }

    }
}
