/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author Valdo
 */
public class QuickSort implements AlgoritmoOrdenamiento {
    private double[] arreglo;
    private double tt;
    
    public QuickSort() {
        this.arreglo = null;
    }
    
    @Override
    public void definirDatos(double arreglo[]){
        this.arreglo = arreglo;
    }
    
    @Override
    public void ordenarDatos(){
        // calcular cuando empieza 
        double ti = System.currentTimeMillis();
        
        quickSort(arreglo,0,arreglo.length-1);
        
        // calculamos el tiempo cuando termina 
        double tf = System.currentTimeMillis();
        this.tt = tf - ti;
        // calculamos el tiempo total
    }
    
    public static void quickSort(double A[], int izq, int der) {
        if(A.length!=0){
            
        double pivote = A[izq]; // tomamos primer elemento como pivote
        int i=izq; // i realiza la búsqueda de izquierda a derecha
        int j=der; // j realiza la búsqueda de derecha a izquierda
        double aux;

        while(i<j){            // mientras no se crucen las búsquedas
           while(A[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
           while(A[j]>pivote) j--;         // busca elemento menor que pivote
           if (i<j) {                      // si no se han cruzado                      
               aux= A[i];                  // los intercambia
               A[i]=A[j];
               A[j]=aux;
           }
         }
         A[izq]=A[j]; // se coloca el pivote en su lugar de forma que tendremos
         A[j]=pivote; // los menores a su izquierda y los mayores a su derecha
         if(izq<j-1)
            quickSort(A,izq,j-1); // ordenamos subarray izquierdo
        if(j+1 <der)
            quickSort(A,j+1,der); // ordenamos subarray derecho
        }
    }

    @Override
    public double getTt() {
        return tt;
    }
    
    
}
