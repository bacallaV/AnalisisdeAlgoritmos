/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinamica;

/**
 *
 * @author Valdo
 */
public class Fibonaccis {
    private static double l=0;
    
    
    public static double fibonacciIterativo(long n){
        double ti = System.currentTimeMillis();
        long a=1, b=1, r=1;
        
        for(long i=0; i<n-1; i++){
            b=a;
            a=r;
            r=a+b;
        }
        
        double tf = System.currentTimeMillis();
        
        
        return tf-ti;
    }
    
    public static double fibonacciRecursivo(long n){
        double ti = System.currentTimeMillis();
        fibonacci2Recursivo(n);
        double tf = System.currentTimeMillis();
        
        return tf - ti;
    }
    
    private static long fibonacci2Recursivo(long n){
        if(n==0 || n==1)
            return 1;
        return fibonacci2Recursivo(n-1)+fibonacci2Recursivo(n-2);
    }
    
    static double fibonacciDinamicoIterativo(int n){ 
        double ti = System.currentTimeMillis();
        /* Declare an array to store Fibonacci numbers. */
        long f[] = new long[n+2]; // 1 extra to handle case, n = 0 
        int i; 

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0; 
        f[1] = 1; 

        for (i = 2; i <= n; i++)
           /* Add the previous 2 numbers in the series 
             and store it */
            f[i] = f[i-1] + f[i-2];
        
        double tf = System.currentTimeMillis();
        
        return tf - ti; 
    }
    
    public static double fibonacciDinamicoRecursivo(int n){
        double ti = System.currentTimeMillis();
        if (n<=1){
            double tf = System.currentTimeMillis();
            
            return n;
        }else{
        long []arreglo = new long[n+1];
        arreglo[0] = 1;
        arreglo[1] = 1;
        
        long a = fibonacciLookUp(arreglo, n);
        
        double tf = System.currentTimeMillis();
        
        return tf - ti;
        }
    }
    
    private static long fibonacciLookUp(long arreglo[], int n){
        l++;
        if((n==0 || n ==1) || (arreglo[n]!=0 && n!=0))
            return arreglo[n];
        
        // si no se conoce entonces calcular
        arreglo[n]=fibonacciLookUp(arreglo, n-1)+fibonacciLookUp(arreglo, n-2);
        
        return arreglo[n];
    }
    
    
    
}
