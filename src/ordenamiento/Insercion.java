/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author Alumno
 */
public class Insercion implements AlgoritmoOrdenamiento, Runnable{
    
    private double[] arreglo;
    private double tt;
    private boolean thread;
    
    public Insercion() {
        this.arreglo = null;
        this.thread = false;
    }
     
    public Insercion(boolean thread) {
        this.arreglo = null;
        this.thread = thread;
    }
    
    public void definirDatos(double[] arreglo) 
    {
       this.arreglo = arreglo;
    }

    @Override
     public void ordenarDatos(){
     
         if (this.thread){
             Thread hilo = new Thread(this);
             hilo.start();
         
         }else{
             run();
         }
    }
    
    @Override
    public void run() 
    {
        // calcular cuando empieza 
        double ti = System.currentTimeMillis();
        // ordenamos
        double aux;
        int j;
        for(int i=1;i<arreglo.length;i++){
             aux = arreglo[i]; // el final, guardamos el elemento y
              j = i - 1; // empezamos a comprobar con el anterior
              while ((j >= 0) && (aux < arreglo[j])){ // mientras queden posiciones y el
                                                        // valor de aux sea menor que los
                arreglo[j + 1] = arreglo[j];       // de la izquierda, se desplaza a
                j--;                   // la derecha
              }
              arreglo[j + 1] = aux; // colocamos aux en su sitio
        }
        // calculamos el tiempo cuando termina 
        double tf = System.currentTimeMillis();
        this.tt = tf - ti;
    }
    
    public double getTt() {
        return tt;
    }
    
}
