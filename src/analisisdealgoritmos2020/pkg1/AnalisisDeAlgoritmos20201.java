/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisdealgoritmos2020.pkg1;

import java.util.ArrayList;
import ordenamiento.Burbuja;
import ordenamiento.Grafica;
import ordenamiento.Herramientas;
import ordenamiento.AlgoritmoOrdenamiento;
import ordenamiento.BurbujaOptimizado;
import ordenamiento.Insercion;
import ordenamiento.Manager;
import ordenamiento.MergeSort;
import ordenamiento.QuickSort;

/**
 *
 * @author CRUZLEIJA
 */
public class AnalisisDeAlgoritmos20201 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Burbuja  b = new Burbuja();
        BurbujaOptimizado  bo = new BurbujaOptimizado();
        Insercion i = new Insercion();
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();
//        double original [] =  Herramientas.generarArregloAleatorio(200000, 500);
//        double original2 [] =  Herramientas.generarArregloMejorCaso(20000);
        ArrayList<AlgoritmoOrdenamiento> metodos = new ArrayList<>();
//        metodos.add(b);
//        metodos.add(bo);
//        metodos.add(i);
        metodos.add(ms);
        metodos.add(qs);
        Manager m = new Manager(metodos);
        m.ejecutarPrueba(35000, 3, 1000, true);
        System.out.println("");
        
    }
    
}
