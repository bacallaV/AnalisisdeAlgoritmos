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
public class Caballo {
    private int tablero[][];
    private int numSalto;
    private Coordenada posicion;
    private Coordenada saltoP;
    private boolean solucion;
    
    public Caballo(Coordenada posicionInicial, int tamanioTablero){
        this.tablero = new int[tamanioTablero][tamanioTablero];
        this.numSalto = 1;
        this.posicion = posicionInicial;
        this.tablero[posicionInicial.getX()][posicionInicial.getY()] = 1;
        this.saltoP = new Coordenada(0,0);
    }
    
    //Nos dira si tiene solucion el problema
    public boolean solucion(){
        int minPosibilidades = 8;
        Coordenada salto = new Coordenada(0,0);
        
        while(existeSalto()){
            for(int i=1; i<=8; i++){
                if(saltoCaballo(i, this.posicion, true) && dobleSaltoCaballo(this.saltoP)<=minPosibilidades){
                    minPosibilidades=dobleSaltoCaballo(this.saltoP);
                    salto = saltoP;
                }
            }
            this.posicion = salto;
            this.numSalto++;
            this.tablero[salto.getX()][salto.getY()] = numSalto;
            minPosibilidades = 8;
        }
        
        if(numSalto==tablero.length*tablero.length){
            solucion = true;
        }else{
            solucion = false;
        }
        
        System.out.println(this);
        System.out.println(numSalto);
        
        return solucion;
    }
    
    private boolean existeSalto() {
        for(int i=1; i<=8; i++){
        if(saltoCaballo(i, this.posicion, false))
            return true;
        }
        return false;
    }
    
    //Indica si hay un posible salto conforme a la i posibilidad
    //Existen como maximo 8 posibles casillas donde un caballo puede saltar
    private boolean saltoCaballo(int i, Coordenada posicionActual, boolean cambioSaltoP){
        Coordenada pos = new Coordenada(0,0);
        
        switch (i){
            case 1:
                pos.setX(posicionActual.getX()-1);
                pos.setY(posicionActual.getY()-2);
                break;
            case 2:
                pos.setX(posicionActual.getX()-2);
                pos.setY(posicionActual.getY()-1);
                break;
            case 3:
                pos.setX(posicionActual.getX()-2);
                pos.setY(posicionActual.getY()+1);
                break;
            case 4:
                pos.setX(posicionActual.getX()-1);
                pos.setY(posicionActual.getY()+2);
                break;
            case 5:
                pos.setX(posicionActual.getX()+1);
                pos.setY(posicionActual.getY()+2);
                break;
            case 6:
                pos.setX(posicionActual.getX()+2);
                pos.setY(posicionActual.getY()+1);
                break;
            case 7:
                pos.setX(posicionActual.getX()+2);
                pos.setY(posicionActual.getY()-1);
                break;
            case 8:
                pos.setX(posicionActual.getX()+1);
                pos.setY(posicionActual.getY()-2);
                break;
        }
        //Si la posicion del tablero existe y esta disponible se guarda un posible salto
        if(posicionDisponibleTablero(pos)){
            if(cambioSaltoP)
                this.saltoP = pos;
            return true;
        }
        
        return false;
    }
    
    //Cuenta las posibilidades que tiene un segundo salto
    private int dobleSaltoCaballo(Coordenada salto){
        int cont = 0;
        
        for(int i=1; i<=8; i++){
            if(saltoCaballo(i, salto, false))
                cont++;
        }
        
        return cont;
    }

    //Indica si la posicion recibida existe y esta disponible para un salto en el tablero
    private boolean posicionDisponibleTablero(Coordenada pos) {
        if(pos.getX()>=0 && pos.getY()>=0 && pos.getX()<tablero.length &&
                pos.getY()<tablero.length && tablero[pos.getX()][pos.getY()]==0)
            return true;
        return false;
    }
    
    @Override
    public String toString(){
        String aux = "";
        for(int x=0; x<tablero.length; x++){
            for(int y=0; y<tablero.length; y++){
                aux+=tablero[x][y]+" \t";
            }
            aux+="\n";
        }
        return aux;
    }

    
}
