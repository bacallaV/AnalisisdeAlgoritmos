/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinamica;

import dinamica.herramientas.Herramientas;

/**
 *
 * @author Valdo
 */
public class Maina {
    public static void main(String args[]){
        //Herramientas.leerDatos();
        Herramientas.generarArticulos(2, 10, 300);
        //Herramientas.guardar(Herramientas.instancias);
        System.out.println(Herramientas.instancias);
    }
}
