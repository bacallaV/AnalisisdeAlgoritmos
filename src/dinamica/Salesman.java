/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesman;

import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class Salesman {
    private int matriz[][];
    private int ciudadInicial;
    private String camino;
    private int distancia;
    
    public Salesman(int matriz[][], int ciudadInicial){
        this.matriz = matriz;
        this.ciudadInicial = ciudadInicial;
    }
    
    public void calcularRutaAvida(){
        ArrayList<Integer> PRecorridos = new ArrayList<>();
        int aux, pos, fin=0, i=this.ciudadInicial;
        
        //Asignacion de un camino
        if(ciudadInicial==this.matriz.length-1){
            aux = this.matriz[this.ciudadInicial][this.ciudadInicial-1];
            pos=this.ciudadInicial-1;
        }
        else{
            aux = this.matriz[this.ciudadInicial][this.ciudadInicial+1];
            pos = this.ciudadInicial+1;
        }
        
        PRecorridos.add(i);
        
        while(fin<this.matriz.length){
            for(int j=0; j<this.matriz.length; j++){
                if(aux>this.matriz[i][j] && this.matriz[i][j]!=0 && !PRecorridos.contains(j)){
                    aux = this.matriz[i][j];
                    pos = j;
                }
            }
            if(fin==this.matriz.length-1){
                aux = this.matriz[i][this.ciudadInicial];
                pos = this.ciudadInicial;
            }
            distancia+=aux;
            camino+=pos+"\t";
            i=pos;
            fin++;
            PRecorridos.add(pos);
            
            aux = Integer.MAX_VALUE;
            pos=-1;
            
        }
    }

    public String getCamino() {
        return camino;
    }

    public int getDistancia() {
        return distancia;
    }
    
    
    
    public static void main(String[] args) {
        int matriz[][] = {{0,3,1,6},{3,0,4,12},{1,4,0,8},{6,12,8,0}};
        Salesman s = new Salesman(matriz, 1);
        
        s.calcularRutaAvida();
        System.out.println(s.getCamino()+"\n"+s.getDistancia());
    }
    
}
