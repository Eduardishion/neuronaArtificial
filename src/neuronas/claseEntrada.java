/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronas;

/**
 *
 * @author Eduardo Izquierdo Rojas 
 */
public class claseEntrada {
    /**
     * e es la entrada  
     * w es el peso de la entrada
     */
    private double e;
    private double w;

    public claseEntrada() {
    }

    public claseEntrada(double e, double w) {
        this.e = e;
        this.w = w;
    }
    
    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }
    
    
}
