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
public class Coordenada {
    private int x;
    private int y;
    
    public Coordenada(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object obj){
        Coordenada coordenada = (Coordenada)obj;
        if(this.x == coordenada.getX() && this.y == coordenada.getY())
            return true;
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
