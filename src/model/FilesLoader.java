package model;
import java.io.*;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class FilesLoader{

        public static List<Product> LoadProducts(String pathFile){
            List<Product> products=new ArrayList<>();

            try(BufferedReader buffer_reader=new BufferedReader(new FileReader(pathFile))){
                String line;
                while ((line=buffer_reader.readLine())!=null){

                    String[]values=line.split(",");

                    int id=Integer.parseInt(values[0]);
                    String name=values[1];
                    double price=Double.parseDouble(values[2]);
                    int stock=Integer.parseInt(values[3]);
                    LocalDate expirDate=LocalDate.parse(values[4]);

                    products.add(new Product(id, name, price, stock, expirDate));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
        
                JOptionPane.showMessageDialog(null,"Error leyendo el archivo "+ e.getMessage());
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Algun elemento de la lista es incorrecto"+e.getMessage());
            }
            return products;
        }

        public static List<Druggist> LoadDruggists(String pathFile){
            List<Druggist> druggists=new ArrayList<>();

            try(BufferedReader buffer_reader=new BufferedReader(new FileReader(pathFile))){
                String line;
                while ((line=buffer_reader.readLine())!=null){

                    String[]values=line.split(",");

                    String dru_name=values[0];
                    char dru_docType=values[1].charAt(0);
                    String dru_docNum=values[2];
                    String dru_user=values[3];
                    String dru_password=values[4];
                
                    druggists.add(new Druggist(dru_name, dru_docType, dru_docNum, dru_user, dru_password));
                }

            } catch (FileNotFoundException e) {
            
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Probablemente "+ e.getMessage());
            }
            return druggists;
        }
}