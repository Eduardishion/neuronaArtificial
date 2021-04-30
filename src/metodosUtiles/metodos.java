/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosUtiles;

import java.util.ArrayList;
import neuronas.claseEntrada;

/**
 *
 * @author Eduardo Izquierdo Rojas
 */
public class metodos {
    
    public metodos(){
        
    }
    
    /*
        funciones para obtener y inicializar el vector de entradas   
    */ 
    public  ArrayList<claseEntrada> obtenerVectorDeEntradas(int numeroEntradas){        //el parametro que se paso como entero despues pueden ser los archivos
         
                //X es el vector de entradas 
                //vector de entradas a evaliar
                //int vectorEntradas[]={1,2,3,4,5,6,7};
                //aqui deben recibirse los lista de lista de valores que se desean evaluar
                //en esta caso evaluaremos somo un vector
                ArrayList<claseEntrada> vectorEntradasTemporal = new ArrayList<>();
                //variable temporal para insertar datos al vector de entrada
                claseEntrada valorDeEntradaTemporal = null;                             //declaracion de entradas temporales 

                //el for es para determinar el numero N de estradas a ingresar ya sea 1 hasta N
                for (int i = 0; i < numeroEntradas; i++) {
                    valorDeEntradaTemporal = new claseEntrada();
                    
                    valorDeEntradaTemporal.setE(1.0);                                   //el vector que se agrega es aleatorio 
                    vectorEntradasTemporal.add(valorDeEntradaTemporal);

                    valorDeEntradaTemporal = null;                                      //se va limpiando los valores pemporales
                }
                
                /**
                    solo para mostrar que si se estan llenando las entradas
                    System.out.println(""+vectorEntradasTemporal.size());

                    for (int i = 0; i < vectorEntradasTemporal.size(); i++) {
                        System.out.println(""+vectorEntradasTemporal.get(i).getE());
                    } 
                 */
                        
                return vectorEntradasTemporal;
                
    }
    
    
    public ArrayList<claseEntrada> lecturaDeArchivosYconvercionAArraylist(){
        ArrayList<claseEntrada> arreglo=null;
        return arreglo;
    }
    
        
}
