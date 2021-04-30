/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronas;
import java.util.ArrayList;
import java.util.Random;
import neuronas.claseEntrada;

/**
 *
 * @author Eduardo Izquierdo Rojas 
 */
public class claseNeurona {
    /**
     * entradas es el array de entradas a la neurona
     * u es el umbral de evaluacion y factor comparacion 
     * w es el peso de conexion a la masa
     * valorEntrada sera el resultado de entrada
     * valorSalida sera el resultado de salida
     */
    
    //atributos
    private ArrayList<claseEntrada>entradas;
    private double valorEntrada;
    private double valorSalida;
    private double u; 

    public claseNeurona() {
    }

    public claseNeurona(ArrayList<claseEntrada> entradas, double u, double valorEntrada, double valorSalida) {
        this.entradas = entradas;
        this.u = u;
        this.valorEntrada = valorEntrada;
        this.valorSalida = valorSalida;
    }

  
    public ArrayList<claseEntrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(ArrayList<claseEntrada> entradas) {
        this.entradas = entradas;
    }

    public double getU() {
        return u;
    }

    public void setU(double u) {
        this.u = u;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public double getValorSalida() {
        return valorSalida;
    }

    public void setValorSalida(double valorSalida) {
        this.valorSalida = valorSalida;
    }
    
    
    //metodos 
    /**
     * 
     * @param entradas es el array de las entradas
     * @param b es la conecxion a la masa 
     * @return un valor de entrada de tipo double
     */
    public double funcionEntrada(ArrayList<claseEntrada> entradas,double b, double w){
        double valorEntrada=0.0;
        double sumatoriaEntradas=0.0;
            //operaciones para obtener el valor de entrada
            for (int i = 0; i < entradas.size(); i++) {
                sumatoriaEntradas = sumatoriaEntradas + entradas.get(i).getE();
            }
            valorEntrada = ((sumatoriaEntradas * entradas.get(0).getW()) + b * w );
                
        return valorEntrada;
    }
    
    public double funcionEntrada2(ArrayList<claseEntrada> entradas){
        double valorEntrada=0.0;
        double sumatoriaEntradas=0.0;
            //operaciones para obtener el valor de entrada
            for (int i = 0; i < entradas.size(); i++) {
                sumatoriaEntradas = sumatoriaEntradas + entradas.get(i).getE() * entradas.get(i).getW();
            }
            valorEntrada = sumatoriaEntradas; 
        return valorEntrada;
    }
    
    /**
     * metodo que genera la sumatoria ponderada de las entradas por los pesos de las entradas mas ek umbral 
     * @param entradas son los patrones de enrrada a la neurona 
     * @param umbral es el umbral de la neurona 
     * @return valorEntrada que es el "valor de activacion" de la neurona 
     */
    public double funcionEntrada3(ArrayList<claseEntrada> entradas,double umbral){
        double valorEntrada=0.0;
        double sumatoriaEntradas=0.0;
            //operaciones para obtener el valor de entrada
            for (int i = 0; i < entradas.size(); i++) {
                sumatoriaEntradas = sumatoriaEntradas + entradas.get(i).getE() * entradas.get(i).getW();
                //System.out.println(": "+sumatoriaEntradas);
            }
            valorEntrada = sumatoriaEntradas + umbral; 
            //System.out.println(""+valorEntrada);
        return valorEntrada;
    }
    
    
    
    /**
     * @param op es una variable entera para elegir la opcion de la funcion de activacion
     * @param valorEntrada recive como paratro el valor de entrada resultado de la funcion de entrada
     * @return el valor de la salida obtenida de la funcion de activacion 
     */
    public double funcionActivacion(double valorEntrada,int op){
        double valorSalida=0.0;
        //operaciones para obtener el valor de entrada
        //las funiones disponibles como funcion de activacion son las siguientes 
        //identidad, escalon, sigmoidea, gaussiana, sinusoidal
       
        switch(op){
            case 1:
                //identidad
                valorSalida = valorEntrada;
            break;
            case 2:
                //escalon ----escalon binario
                if(valorEntrada > 0.0){
                    valorSalida=1.0; 
                }else{
                    valorSalida=0.0; 
                }
            break;
            case 3:
                //escalon ----escalon bipolar  funcion de activacion escalon para usar de ejemplo       
                if(valorEntrada > 0.0){
                    valorSalida=1.0; 
                }else{
                    valorSalida=-1.0; 
                }
            break;
            case 4:
                //sigmoidea ----logaritmo sigmoidal
//                System.out.println(""+valorEntrada);
//                double val = -valorEntrada;
//                System.out.println(""+val);
//                if(-valorEntrada < 0){
//                    System.out.println("si es menor");
//                }else{
//                    System.out.println("no es menor");
//                }
                //double val =Math.pow(Math.E, -valorEntrada);
                //System.out.println(">>>>>"+1.0/1.0+val);
                //valorSalida = 1.0/1.0+(Math.pow(Math.E, -valorEntrada));
                //segunda opcion
                valorSalida = 1.0/1.0+(Math.exp(-valorEntrada));
            break;
            case 5:
                //sigmoidea ----tangente sigmoidal
                valorSalida= 2.0/1.0+(Math.pow(Math.E, -valorEntrada));
            break;
            case 6:
                //sigmoidea ----tangente hipervolica
                valorSalida= ((Math.pow(Math.E, valorEntrada)) - ((Math.pow(Math.E,-valorEntrada)))) / ((Math.pow(Math.E,valorEntrada )) + ((Math.pow(Math.E, -valorEntrada))));   
            break;
            case 7:
                //gaussiana
                //valorSalida=4;
            break;
            case 8:
                //sinusoida
                //valorSalida=5;
            break;
            case 9:
                //ejemplo para not
                int umbral = -1;
                if(valorEntrada > umbral){
                    valorSalida = 1;
                }else{
                    valorSalida = 0;
                }
            break;
            case 10:
                //ejemplo para and
                int umbral2 = 1;
                if(valorEntrada > umbral2){
                    valorSalida = 1;
                }else{
                    valorSalida = 0;
                }
            break;
            case 11:
                //ejemplo para or
                int umbral3 = 0;
                if(valorEntrada > umbral3){
                    valorSalida = 1;
                }else{
                    valorSalida = 0;
                }
            break;
            default:
                //sigmoidea
                 valorSalida= 1.0/1.0+(Math.pow(Math.E, -valorEntrada));
                
        }
        
        return valorSalida;
    }
    
    public double funcionActivacionDerivada(double valorEntrada){
        double valorSalida=0.0;
        int op = 1;
        switch(op){
            case 1:
            break;
            case 2:
            break;
            case 3:
            break;
            case 4:
            break;
            default:
        }
        return valorSalida;
    }
    
    /**
     * 
     * @return numero aleatorio del umbral 
     */
    public double generarUmbral(){
        Random aleatorio = new Random();
            //double numAletorio =0.0;
            //numAletorio =  (aleatorio.nextDouble() * ((10)-1) +(-1));
            //double numero = (aleatorio.nextDouble() * ((1.0)-1) +(-1.0));
            //para aleatorios negativos de -1 a 0
            double inicio = -1.0;
            double fin = 1.0;
            //para aleatorios positivos de 0 a 1
            double inicio2 = 1.0;
            double fin2 = -1.0;
            
            double numero=0.0;
            
            //for (int i = 0; i < 10000; i++) {
                double auxAleatorio = aleatorio.nextDouble() * 1 + 0;
                if(auxAleatorio < 0.5){
                    numero = aleatorio.nextDouble() * fin + inicio;
                }else{
                    numero = aleatorio.nextDouble() * fin2 + inicio2;
                }
                //System.out.println(""+numero);
            //}
        return numero; 
    }
    
    /**
    
    funcion para implementar un perseptron simple del  cua se hace 
    uso de la teria oresentada en el libro Redes Neuronales artificiales 
    un enfoque practico de isasi calvan el cual recomiendo para entender 
    el modelo computacional de una neurona de un perseptron y sus elementos
    que la conforman
     * @param numEntradas es el total de entradas que entraran a la neurona 
     * @param entradas  es la lista de patrones que entraran a la neurona 
    */
    public void ejecutarFuncionesBasicasPerseptron(int numEntradas,ArrayList<Double> entradas,int funActiv){
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
         //x1y x2 son los patrones de entrada, la 
         //si ls red produce +1 pertenece a la categoria B
         //si la red produce -1 pertenece a la categoria A
         
        //aun falta implementar el algoritmo de aprendisaje para que obtenga la ecuacion del hiperplano,
        //recordar que en algoritmo de aprendisaje los pesos W y el umbral son los que se generarn 
        //aleatoriamente en un rango de numeros de -1 a 1 para este ejemplo el umbral esta 0.5 como ejemplo solamnte 
        

            //declaracion de variables y objetos necesarios   
            //declaracion de lista de entradas a la neurona 
            ArrayList<claseEntrada> x =new ArrayList<>();
            //entradas temporrales
            //claseEntrada entradaETmp = new  claseEntrada();
            for (int i = 0; i < numEntradas; i++) {
                 claseEntrada entradaTmp = new  claseEntrada();
                 entradaTmp.setE(entradas.get(i));              //E es la entrada a la neurona
                 entradaTmp.setW(generarUmbral());            //W es el peso de la conexio el cual debe ser aleatorio de -1 a 1 como rango 
                 x.add(entradaTmp);
            }
             
            //objeto para crear neuronas 
            claseNeurona neuronaTmp = new claseNeurona();
            //agregamos o cargamos las entradas a la neurona y sus rspectivos pesos obtenidos anteriormente  
            neuronaTmp.setEntradas(x);                              //asignacion de las entradas a la neurona 
            neuronaTmp.setU(generarUmbral());                                      //asignacion del umbral a la neurona 
            //obtener el valor de entrada 
            //funcion para ontener la sumatoria ponderada la suma por pesos de todas las entradas
            //que como resultado se obtendra el ""valor de activacion"" de la celula 
            double valorEntrada = neuronaTmp.funcionEntrada3(neuronaTmp.getEntradas(),neuronaTmp.getU());                                                                                        
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
            double valorSalida=neuronaTmp.funcionActivacion(valorEntrada,funActiv);     //para el ejemplo usamos la funcion escalon
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
