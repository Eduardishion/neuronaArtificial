/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redneuronalartifical;
import java.util.ArrayList;
import java.util.Random;
import metodosUtiles.metodos;
import neuronas.claseEntrada;
import neuronas.claseNeurona;


/**
 * Implementacion Red neuronal Artificial 
 * @author Eduardo Izquierdo Rojas
 */
public class RedNeuronalArtifical {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
            //ejecutarFuncionesBasicas();
            //System.out.println("----------------------------------------------");
            //ejecutarFuncionesBasicas();
            ArrayList<Double> valoresDeEntradas = new ArrayList<>();
            valoresDeEntradas.add(-1.0);
            valoresDeEntradas.add(-1.0);
    
          
            //para generar un perseptron monocapa
            //claseNeurona neurona = new claseNeurona();
            //neurona.ejecutarFuncionesBasicasPerseptron(valoresDeEntradas.size(),valoresDeEntradas);
            
            
            ArrayList<claseNeurona> capaEntrada = new ArrayList<>(); 
            int numeroNeuronas = 10;
            //para usar alguna funcion de activacion elegir cualquierea de las siguientes  aun darle una checada a las funciones 
            //identidad elegir                     lin        1
            //escalon ---- escalon binario         hardlim    2
            //escalon ---- escalon bipolar         sgn        3
            //sigmoidea ---- logaritmo sigmoidal   sigl       4
            //sigmoidea ---- tangente sigmoidal    sigt       5
            //sigmoidea ---- tangente hipervolica  tahn       6
            //NOT                                             9 
            //aND                                             10
            //OR                                              11
            ////sigmoidea    por default           sig        4  
            
            for (int i = 0; i < numeroNeuronas; i++) {
                claseNeurona neuronatmp = new claseNeurona();
                neuronatmp.ejecutarFuncionesBasicasPerseptron(valoresDeEntradas.size(),valoresDeEntradas,4);
                capaEntrada.add(neuronatmp);

            }
          
    }
   
    /**
     * funcion para hacer operaciones basicas de una neurona 
        como hacer la sumatoria ponderadas de las entradas por 
        los pesos y obtener el valor en estrada y hacer uso 
        de la funcion de activacion con las distintas funciones
        tangente hipervolica, sigmoidea, escalon, etc, y hacer 
        pruevas de una implementacion de neuronas como son las 
        de McCulloch-Pitts, toda la referencia usada y datos a 
        usar para ver el funcionamiento de la implementacion 
        se encuentra en el libro Redes Neuronales artificiales 
        un enfoque practico de isasi calvan que se uso mayormente
        para entender la teoria para poner en practica los ejemplos
        , para implementaciones sensillas de ejemplo hacer uso de 
        esos datos mostrados en ejemplos del libro data mining 
        theories, algorithms , and examples de NONG YE en la pagina 63 donde
        hace uso de datos sensillos para provar las funciones 
        de activacion, para provar las neriones de McCulloch-Pitts
        se usaron los datos de ejemplos del libro Redes Neuronales 
        artificiales un enfoque practico de isasi calvan en la pagina 
        23 donde trae las tablas de NOT, AND, OR. 
     */
    
    public static void ejecutarFuncionesBasicas(){
        //------------------------------------------------------------------
            //declaracion de variables y objetos necesarios
            
            //declaracion de lista de entradas a la neurona 
            ArrayList<claseEntrada> x =new ArrayList<>();
            //entradas temporrales
            //claseEntrada entradaETmp = new  claseEntrada();
            claseEntrada entradaTmp1 = new  claseEntrada();
            claseEntrada entradaTmp2 = new  claseEntrada();
            claseEntrada entradaTmp3 = new  claseEntrada();
            
            //asignacion de valores de entradas
            //entradaETmp.setE(1);
            entradaTmp1.setE(1.0);    //E es la entrada 
            entradaTmp1.setW(-1.2);    //W es el peso de la conexion 
            entradaTmp2.setE(5.0);
            entradaTmp2.setW(3.0);
            entradaTmp3.setE(-6.0);
            entradaTmp3.setW(2.0);
            
            //fomarmando lista de entradas
            //x.add(entradaETmp);
            x.add(entradaTmp1);
            x.add(entradaTmp2);
            x.add(entradaTmp3);
            
            //objeto para crear neuronas 
            claseNeurona neurona = new claseNeurona();
            //cargar de entradas a la neurona y pesos  
            neurona.setEntradas(x);
            neurona.setU(1);
            //obtener el valor de entrada 
            double valorEntrada = neurona.funcionEntrada2(neurona.getEntradas());
            //para usar alguna funcion de activacion elegir cualquierea de las siguientes  
            //identidad elegir                     lin        1
            //escalon ---- escalon binario         hardlim    2
            //escalon ---- escalon bipolar         sgn        3
            //sigmoidea ---- logaritmo sigmoidal   sigl       4
            //sigmoidea ---- tangente sigmoidal    sigt       5
            //sigmoidea ---- tangente hipervolica  tahn       6
            //NOT                                             9 
            //aND                                             10
            //OR                                              11
            ////sigmoidea    por default           sig        4  
            double valorSalida=neurona.funcionActivacion(valorEntrada,4);
            //valor obtenido 
            System.out.println("El valor de la obtenido de la neurona es:"+valorSalida);
    }
    
    /**
    funcion para implementar un perseptron simple y el algoritmo de aprensisaje 
    * del  cua se hace uso de la teria oresentada en el libro Redes Neuronales 
    * artificiales un enfoque practico de isasi calvan el cual recomiendo para entender 
    el modelo computacional de una neurona de un perseptron y sus elementos
    que la conforman 
    */
    
    public static void ejecutarFuncionesBasicasPerseptronYfunAprendije(){
         //para el ejemplo de principios basicos del perceptron se estan usando los datos 
         //que se presentan en el libro Redes Neuronales artificiales un enfoque practico de isasi calvan
         //de la pagina desde la pagina 26 a 34 que solo sirva para clasificacion binaria , 
         //perseptron se comporta como la compuerta AND para clasificar dos  clases A y B  
         //se usan dos entradas y dos pesos , el umbral y funcion de activacion escalon 
         //para hacer uso de ejemplo solo mover los valores de la entradas, los pesos no mover ni el umbral 
         //ya que son los valores que menciona el libro y con los cuales se puede comprobar su fucionamiento 
         //del preceptron que trabaja como compuerta AND, la siguiente tabla ilustra que ejemplos de entradas 
         //se denen de usar
         //patrones de entrada      x1   x2     AND
         //                         -1   -1     -1  que va a pertenecer a la clase A
         //                         +1   -1     -1  que va a pertenecer a la clase A
         //                         -1   +1     -1  que va a pertenecer a la clase A
         //                         +1   +1     +1  que va a pertenecer a la clase B
         //x1y x2 son los patrones de entrada
         
        //aun falta implementar el algoritmo de aprendisaje para que obtenga la ecuacion del hiperplano,
        //recordar que en algoritmo de aprendisaje los pesos W y el umbral son los que se generarn 
        //aleatoriamente en un rango de numeros de -1 a 1 para este ejemplo el umbral esta 0.5 como ejemplo solamnte 
        

            //declaracion de variables y objetos necesarios   
            //declaracion de lista de entradas a la neurona 
            ArrayList<claseEntrada> x =new ArrayList<>();
            //entradas temporrales
            //claseEntrada entradaETmp = new  claseEntrada();
            claseEntrada entradax1 = new  claseEntrada();
            claseEntrada entradax2 = new  claseEntrada();
            //claseEntrada entradaTmp3 = new  claseEntrada();
            
            //asignacion de valores de entradas
            //entradaETmp.setE(1);
            entradax1.setE(-1);                   //E es la entrada a la neurona
            entradax1.setW(1);    //W es el peso de la conexio el cual debe ser aleatorio de -1 a 1 como rango 
            entradax2.setE(1);                    //E es la entrada a la neurona
            entradax2.setW(1);    //W es el peso de la conexio el cual debe ser aleatorio de -1 a 1 como rango 
            //entradaTmp3.setE(-6);
            //entradaTmp3.setW(2);
            
            //fomarmando lista de entradas
            //x.add(entradaETmp);
            x.add(entradax1);
            x.add(entradax2);
            //x.add(entradaTmp3);
            
            //objeto para crear neuronas 
            claseNeurona neurona = new claseNeurona();
            //agregamos o cargamos las entradas a la neurona y sus rspectivos pesos obtenidos anteriormente  
            neurona.setEntradas(x);                              //asignacion de las entradas a la neurona 
            neurona.setU(0.5);                                      //asignacion del umbral a la neurona 
            //obtener el valor de entrada 
            //funcion para ontener la sumatoria ponderada la suma por pesos de todas las entradas
            //que como resultado se obtendra el ""valor de activacion"" de la celula 
            double valorEntrada = neurona.funcionEntrada3(neurona.getEntradas(),neurona.getU());                                                                                        
            //para usar alguna funcion de activacion elegir cualquierea de las siguientes  
            //identidad elegir                     lin        1
            //escalon ---- escalon binario         hardlim    2
            //escalon ---- escalon bipolar         sgn        3
            //sigmoidea ---- logaritmo sigmoidal   sigl       4
            //sigmoidea ---- tangente sigmoidal    sigt       5
            //sigmoidea ---- tangente hipervolica  tahn       6
            //NOT                                             9 
            //aND                                             10
            //OR                                              11
            ////sigmoidea    por default           sig        4  
            //funcion para obtener el valor de la funcion de activacion y elegir la funcion
            double valorSalida=neurona.funcionActivacion(valorEntrada,3);     //para el ejemplo usamos la funcion escalon
            //valor obtenido 
            
            int val=0;
            if(valorSalida > 0){
                val = 1;
            }else{
                val = -1;
            }
            System.out.println("El valor de la obtenido de la neurona es:"+val);
    }
}
