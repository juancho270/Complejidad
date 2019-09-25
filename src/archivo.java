
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juancho270
 */
public class archivo {
    archivo(){
        
    }
     
    public void escribir(int numero,int limite,List campos) throws IOException{
        File archivo = new File("src/archivos/instanciaPeriodico.dzn");
        BufferedWriter bw;
        List<String> minimos = new ArrayList<>();
        List<String> maximos = new ArrayList<>();
        List<String> lectores = new ArrayList<>();
        List<String> topics = new ArrayList<>();
        for(int i = 0; i<campos.size();i= i+4){
            topics.add((String) campos.get(i));
        }
        for(int i = 1; i<campos.size();i= i+4){
            minimos.add((String) campos.get(i));
        }
        for(int i = 2; i<campos.size();i= i+4){
            maximos.add((String) campos.get(i));
        }
        for(int i = 3; i<campos.size();i= i+4){
            lectores.add((String) campos.get(i));
        }
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("n = " + numero + ";" + "\n");
            bw.write("L = " + limite + ";" + "\n");
            bw.write("LI = ");
            bw.write("[");
            for (int i = 0; i < minimos.size(); i++) {
                if(i != minimos.size()-1){
                    bw.write(minimos.get(i));
                    bw.write(",");
                }else{
                    bw.write(minimos.get(i));
                }
            }
            bw.write("];" + "\n");
            bw.write("LS = ");
            bw.write("[");
            for (int i = 0; i < maximos.size(); i++) {
                if(i != maximos.size()-1){
                    bw.write(maximos.get(i));
                    bw.write(",");
                }else{
                    bw.write(maximos.get(i));
                }
            }
            bw.write("];" + "\n");
            bw.write("NT = ");
            bw.write("[");
            for (int i = 0; i < topics.size(); i++) {
                if(i != topics.size()-1){
                    bw.write('"');
                    bw.write(topics.get(i));
                    bw.write('"');
                    bw.write(",");
                }else{
                    bw.write('"');
                    bw.write(topics.get(i));
                    bw.write('"');
                }
            }
            bw.write("];" + "\n");
            bw.write("PL = ");
            bw.write("[");
            for (int i = 0; i < lectores.size(); i++) {
                if(i != lectores.size()-1){
                    bw.write(lectores.get(i));
                    bw.write(",");
                }else{
                    bw.write(lectores.get(i));
                }
            }
            bw.write("];" + "\n");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("n = " + numero + ";" + "\n");
            bw.write("L = " + limite + ";" + "\n");
            bw.write("LI = ");
            bw.write("[");
            for (int i = 0; i < minimos.size(); i++) {
                if(i != minimos.size()-1){
                    bw.write(minimos.get(i));
                    bw.write(",");
                }else{
                    bw.write(minimos.get(i));
                }
            }
            bw.write("];" + "\n");
            bw.write("LS = ");
            bw.write("[");
            for (int i = 0; i < maximos.size(); i++) {
                if(i != maximos.size()-1){
                    bw.write(maximos.get(i));
                    bw.write(",");
                }else{
                    bw.write(maximos.get(i));
                }
            }
            bw.write("];" + "\n");
            bw.write("NT = ");
            bw.write("[");
            for (int i = 0; i < topics.size(); i++) {
                if(i != topics.size()-1){
                    bw.write('"');
                    bw.write(topics.get(i));
                    bw.write('"');
                    bw.write(",");
                }else{
                    bw.write('"');
                    bw.write(topics.get(i));
                    bw.write('"');
                }
            }
            bw.write("];" + "\n");
            bw.write("PL = ");
            bw.write("[");
            for (int i = 0; i < lectores.size(); i++) {
                if(i != lectores.size()-1){
                    bw.write(lectores.get(i));
                    bw.write(",");
                }else{
                    bw.write(lectores.get(i));
                }
            }
            bw.write("];" + "\n");
            
        }
        bw.close();
    }
    
        Object[][] modelarTabla(BufferedReader reader) throws IOException {
        Object[][] datos = new Object[1000][4];
        String line;
        String[] nombres = new String[1000];
        String[] paginas = new String[1000];
        String[] lectores = new String[1000];
        String[] total = new String[1000];
        String[] nombre = null;
        int contador = 0;
        
        while ((line = reader.readLine()) != null) {
            if (!("Numero de paginas por topic: ".equals(line)) && !("----------".equals(line)) && !("==========".equals(line))) {
                nombre = line.split(";");
                
                nombres[contador] = nombre[0];
                paginas[contador] = nombre[1];
                lectores[contador] = nombre[2];
                total[contador] = nombre[3];
                contador ++;
            }       
        }
       
        for (int i = 0; i < nombres.length; i++) {
            if(nombres[i] != null){
                 datos[i][0] = nombres[i];
                  datos[i][1] = paginas[i];
                   datos[i][2] = lectores[i];
                    datos[i][3] = total[i];
            }
              
         }
        return datos;
    }
}
