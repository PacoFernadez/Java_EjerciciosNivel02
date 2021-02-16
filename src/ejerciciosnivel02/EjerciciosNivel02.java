/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosnivel02;

/**
 *
 * @author Paco2
 */
public class EjerciciosNivel02 {

    
    public boolean esEscaleraDePalabras(char[][] listaPalabras){  //si pones listaPalabras.length te da el numero de filas
        int contador1 = 0;
        
        for(int i = 0; i < listaPalabras.length - 1; i++){  //listaPalabras[0].length te da el número de columnas
            //el bucle que procesa todas las filas
            contador1 = 0; //inicializo el contador de diferencias antes de empezar bucle interno
            for(int j = 0; j < listaPalabras[0].length; j++){
                if(listaPalabras[i][j] == listaPalabras[i + 1][j]){    
                    System.out.println("Son IGUALES");
                }    
                else{
                    System.out.println("Son DISTINTOS");
                    contador1++; //hay una diferencia
                }
            }
            System.out.println("" + contador1);
            if(contador1 != 1){ //si en algún momento las palabras se diferencian en más de 1 no es escalera
                return false;
            } 
        }
   
        
        return true;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EjerciciosNivel02 ejercicio = new EjerciciosNivel02();
        
        char[][]listaPalabras = {
           {'P', 'A', 'T', 'A'},
           {'R', 'A', 'T', 'O'},
           {'R', 'A', 'T', 'O'},
           {'R', 'A', 'M', 'O'},
           {'G', 'A', 'M', 'O'},
           {'G', 'A', 'T', 'O'},
           {'M', 'A', 'T', 'O'},
        };
        
        System.out.println(ejercicio.esEscaleraDePalabras(listaPalabras)); 
    }
    
}
