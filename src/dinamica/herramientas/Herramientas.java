/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinamica.herramientas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author CRUZLEIJA
 */
public class Herramientas {
    
    public static ArrayList<Item> leerDatos(){
     ArrayList<Item> instancias = new ArrayList<>();
     String texto, aux;
     LinkedList<String> lista = new LinkedList();
        
        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    int costo = Integer.parseInt(lista2.get(0));
                    int beneficio = Integer.parseInt(lista2.get(1));

                    // a la coleccion de patrones se agrega un nuevo patron
                    instancias.add(new Item(costo, beneficio));
                   // patrones.add();
                    lista2.clear();

                }
          
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            
        }
       
       return instancias;
     
    }
    
    public static void guardar (ArrayList<Item> items){
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        JFileChooser guardar= new JFileChooser();
        guardar.setApproveButtonText("Guardar");
        guardar.showSaveDialog(null);
    
        try{
            f=new File(guardar.getSelectedFile()+".txt");
            w=new FileWriter(f);
            bw=new BufferedWriter (w);
            wr=new PrintWriter(bw);
            String peso=null;
            String valor=null;
            for (int x=0;x<items.size();x++){
                peso=String.valueOf(items.get(x).getCosto());
                valor=String.valueOf(items.get(x).getBeneficio());
                wr.append(peso+","+valor+"\n");
            }
            wr.close();
            bw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ha sucedido un error"+ e);
        } 
        
    }
    
    public static ArrayList<Item> generarArticulos(int n, int limC, int limB) {
        Random ran = new Random();
        ArrayList<Item> instancias = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            instancias.add(new Item(ran.nextInt(limC)+1, ran.nextInt(limB)+1));
        }
        return instancias;
    }
    
}
