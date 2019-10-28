/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.util.ArrayList;

/**
 *
 * @author Valdo
 */
public class Manager {
    private ArrayList<AlgoritmoOrdenamiento> metodos;
    
    public Manager(){
        this.metodos = new ArrayList<>();
    }
    
    public Manager(ArrayList<AlgoritmoOrdenamiento> metodos){
        this.metodos = metodos;
    }
    
    public void ejecutarPrueba(double[] datos, boolean grafica){
        double tiempos [] = new double[this.metodos.size()];
        int p = 0;
        
        //recorremos la lista de algoritmos
        for(AlgoritmoOrdenamiento a:this.metodos){
            a.definirDatos(datos.clone());
            a.ordenarDatos();
            tiempos[p] = a.getTt();
            p++;
            System.out.println("Algoritmo: "+p+" completado");
        }
        
        if(grafica){
            Grafica g = new Grafica("id Algoritmos", "Tiempo", "Prueba Basica de Algoritmos");
            g.agregarSerie(tiempos, "x");
            g.crearMostrarGrafica();
        }
    }
    public void ejecutarPrueba(int pruebas, int rAumento, int rAleatorio, boolean grafica){
        ArrayList<double[]> tiemposTotales = new ArrayList<>();
        
        //Preparando a la memoria
        for(int j=0; j<this.metodos.size(); j++){
            tiemposTotales.add(new double[pruebas]);
        }
        
        //Lo mero bueno        
        for(int p=0; p<pruebas; p++){
            double[] datos = Herramientas.generarArregloAleatorio(p*rAumento, rAleatorio);
            
            for(int a=0; a<this.metodos.size(); a++){
                AlgoritmoOrdenamiento aux = this.metodos.get(a);
                aux.definirDatos(datos.clone());
                aux.ordenarDatos();
                tiemposTotales.get(a)[p]=aux.getTt();
            }
            System.out.println("Prueba: "+p);
        }
        
        if(grafica){
            Grafica g = new Grafica("id Algoritmos", "Tiempo", "Prueba de Algoritmos");
            for(int x=0; x<tiemposTotales.size(); x++){
                g.agregarSerie(tiemposTotales.get(x), String.valueOf(x));
            }
            g.crearMostrarGrafica();
        }
    }
}
