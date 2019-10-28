/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinamica.herramientas;

/**
 *
 * @author Valdo
 */
public class Item {
    private int costo;
    private int beneficio;

    public Item(int costo, int beneficio) {
        this.costo = costo;
        this.beneficio = beneficio;
    }

    public int getCosto() {
        return costo;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }
    
    @Override
    public String toString(){
        return "Costo: "+this.getCosto()+"\tBeneficio: "+this.getBeneficio()+"\n";
    }
    
    
    
}
