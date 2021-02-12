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

    
    public boolean esEscaleraDePalabras(int[][] listaPalabras){
        
        for(int i = 0; i < listaPalabras[0].length - 1; i++){
            if(listaPalabras[i][0] == listaPalabras[i + 1][0]){    
                System.out.println("Son IGUALES");
            }    
            else{
                System.out.println("Son DISTINTOS");
            }
        }
        
        
        return true;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
