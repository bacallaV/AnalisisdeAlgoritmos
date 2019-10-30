/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinamica;

import dinamica.herramientas.Herramientas;
import dinamica.herramientas.Item;
import java.util.ArrayList;
import ordenamiento.Grafica;

/**
 *
 * @author Valdo
 */
public class DinamicaMain {
    public static void main(String args[]){
        // FIBONACCIS
//        int n = 50;
//        double t1 [] = new double[n];
//        double t2 [] = new double[n];
//        double t3 [] = new double[n];
//        double t4 [] = new double[n];
//        
//        for(int i=0; i<n; i++){
//            t1[i] = Fibonaccis.fibonacciIterativo(i+1);
//            t2[i] = Fibonaccis.fibonacciRecursivo(i+1);
//            t3[i] = Fibonaccis.fibonacciDinamicoIterativo(i+1);
//            t4[i] = Fibonaccis.fibonacciDinamicoRecursivo(i+1);
//            System.out.println("Numero: "+i);
//        }
//        Grafica g = new Grafica("nf", "Tiempos", "Tiempos ");
//        g.agregarSerie(t1, "fIterativo");
//        g.agregarSerie(t2, "fRecursivo");
//        g.agregarSerie(t3, "fDinamicoIterativo");
//        g.agregarSerie(t4, "fDinamicoRecursivo");
//        g.crearMostrarGrafica();

    Mochila m = new Mochila(20);
    ArrayList<Item> items = new ArrayList<>();
    items = Herramientas.generarArticulos(10, 20, 100);
    m.buscarSolucion(items);
    System.out.println(m);
    }
}
