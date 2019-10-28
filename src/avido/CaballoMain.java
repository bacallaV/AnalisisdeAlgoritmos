/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avido;

/**
 *
 * @author Valdo
 */
public class CaballoMain {
    public static void main(String args[]){
        Caballo c = new Caballo(new Coordenada(0,0), 3);
        System.out.println(c.solucion());
    }
}
