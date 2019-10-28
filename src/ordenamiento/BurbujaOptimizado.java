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
public class BurbujaOptimizado implements AlgoritmoOrdenamiento, Runnable {
    
    private double[] arreglo;
    private double tt;
    private boolean thread;
    
    public BurbujaOptimizado() {
        this.arreglo = null;
        this.thread = false;
    }
    
    public BurbujaOptimizado(boolean thread) {
        this.thread = thread;
        this.arreglo = null;
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
        
        for(int i=arreglo.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arreglo[j]>arreglo[j+1]){
                    double temp=arreglo[j];
                    arreglo[j]=arreglo[j+1];
                    arreglo[j+1]=temp;
                }
            }
        }
        // calculamos el tiempo cuando termina 
        double tf = System.currentTimeMillis();
        this.tt = tf - ti;
    }
    
    public double getTt() {
        return tt;
    }
    
}
