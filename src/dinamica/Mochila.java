/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinamica;

import dinamica.herramientas.Item;
import java.util.ArrayList;

/**
 *
 * @author Valdo
 */
public class Mochila {
    private int capacidad;
    private ArrayList<Item> items;
    private ArrayList<Item> itemsSolucion;
    private int[][] beneficios;
    private int maxBeneficio;

    public Mochila(int capacidad) {
        this.capacidad = capacidad;
        this.itemsSolucion = new ArrayList<>();
    }
    
    public void buscarSolucion(ArrayList<Item> items){
        //Construimos los ultimos atributos
        this.items = items;
        construirMatrizBeneficios();
        
        //Buscamos la solucion
        //Contruimos la matriz de soluciones dinamica
        for(int i=1; i<=this.items.size(); i++){
            for(int c=1; c<=this.capacidad; c++){
                Item aux = this.items.get(i-1);
                if(aux.getCosto()<=c){
                    if (aux.getBeneficio()+this.beneficios[i-1][c-aux.getCosto()]>this.beneficios[i-1][c]){
                        this.beneficios[i][c]=aux.getBeneficio()+this.beneficios[i-1][c-aux.getCosto()];
                    }else{
                        this.beneficios[i][c]=this.beneficios[i-1][c];
                    }
                }else{
                    this.beneficios[i][c]=this.beneficios[i-1][c];
                }
            }
        }
        //Obtenemos el beneficio maximo para el problema
        this.maxBeneficio = this.beneficios[this.items.size()][this.capacidad];
        //Ahora, obtenemos la lista de items que fueron utilizados para obtener la solucion
        int i = this.items.size();
        int c = this.capacidad;
        
        while(i > 0 && c > 0){
            int auxx = this.beneficios[i][c];
            if( auxx != this.beneficios[i-1][c]){
                this.itemsSolucion.add(this.items.get(i-1));
                i--;
                c = c-this.items.get(i).getCosto();
            }else{
                i--;
            }
        }
        
    }

    private void construirMatrizBeneficios() {
        //Construimos la matriz acorde al tamaño de items y su capacidad maxima
        this.beneficios = new int[this.items.size()+1][this.capacidad+1];
        //Primera fila y columna con ceros
        for(int i=0; i<=this.capacidad; i++)
            this.beneficios[0][i] = 0;
        for(int j=0; j<=this.items.size(); j++)
            this.beneficios[j][0] = 0;
    }
    
    public String toString(){
        String aux = "";
        int pesoUtilizado=0;
        
        for(Item item: this.itemsSolucion){
            pesoUtilizado+=item.getCosto();
        }
        
        aux = "----------Mochila----------"+
                "\nCapacidad: "+this.capacidad+
                "\nItems: "+this.items+
                "\nItems en mochila: "+this.itemsSolucion+
                "\nBeneficio maximo obtenido: "+this.maxBeneficio+
                "\nCapacidad de la mochila utilizada: "+pesoUtilizado;
        
        return aux;
    }
    
}
