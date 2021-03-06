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
    
    public String quitaAcentos(String cadena){
        //pájaro
        //pajaro
        cadena = cadena.replace('á', 'a');
        cadena = cadena.replace('é', 'e');
        cadena = cadena.replace('í', 'i');
        cadena = cadena.replace('ó', 'o');
        cadena = cadena.replace('ú', 'u');
        cadena = cadena.replace('ü', 'u');
        cadena = cadena.replace('Á', 'A');
        cadena = cadena.replace('É', 'E');
        cadena = cadena.replace('Í', 'I');
        cadena = cadena.replace('Ó', 'O');
        cadena = cadena.replace('Ú', 'U');
        cadena = cadena.replace('Ü', 'U');    
        
        return cadena;
    }    

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

    public int costeErroresADN(String uno, String dos){
        int contador = 0;
        
        for(int i = 0; i < uno.length(); i++){
            if(uno.charAt(i) == '-' && dos.charAt(i) == '-'){
                contador = contador + 2;
            }
            if(uno.charAt(i) == '-' && dos.charAt(i) != '-'){
                contador = contador + 2;
            }
            if(dos.charAt(i) == '-' && uno.charAt(i) != '-'){
                contador = contador + 2;
            }
            if(uno.charAt(i) == 'A' && dos.charAt(i) != 'T' && dos.charAt(i) != '-'){
                contador++;
            }
            if(uno.charAt(i) == 'T' && dos.charAt(i) != 'A' && dos.charAt(i) != '-'){
                contador++;
            }
            if(uno.charAt(i) == 'C' && dos.charAt(i) != 'G' && dos.charAt(i) != '-'){
                contador++;
            }
            if(uno.charAt(i) == 'G' && dos.charAt(i) != 'C' && dos.charAt(i) != '-'){
                contador++;
            }
        }
        
        return contador;
    }
    public int costeErroresADN_Jorge(String uno, String dos){
        int coste = 0;
        
        for(int i = 0; i < uno.length(); i++){
            //letra G
            if(uno.charAt(i) == 'G'){
                if(dos.charAt(i) != 'C'){
                    if(dos.charAt(i) == '-'){
                        coste = coste + 2;
                    }
                    else{
                        coste++;
                    }
                }
            }
            //letra C
            if(uno.charAt(i) == 'C'){
                if(dos.charAt(i) != 'G'){
                    if(dos.charAt(i) == '-'){
                        coste = coste + 2;
                    }
                    else{
                        coste++;
                    }
                }
            }
            //letra A
            if(uno.charAt(i) == 'A'){
                if(dos.charAt(i) != 'T'){
                    if(dos.charAt(i) == '-'){
                        coste = coste + 2;
                    }
                    else{
                        coste++;
                    }
                }
            }
            //letra T
            if(uno.charAt(i) == 'T'){
                if(dos.charAt(i) != 'A'){
                    if(dos.charAt(i) == '-'){
                        coste = coste + 2;
                    }
                    else{
                        coste++;
                    }
                }
            } 
            //si es -
            if(uno.charAt(i) == '-'){
                coste = coste + 2;
            }            
        }
        
        return coste;
    }
    
    /**
     * Encuentra el número que está duplicado en una lista de ints
     * usando el algoritmo de Floyd
     * @param listaNumeros
     * @return 
     */
    public int findDuplicate(int[] listaNumeros){
        int tortuga = listaNumeros[0];
        int liebre = listaNumeros[0];
        boolean iguales = false;
        while(!iguales){
            tortuga = listaNumeros[tortuga];
            liebre = listaNumeros[listaNumeros[liebre]];
            if(tortuga == liebre){
                iguales = true;
            }
        }
        int auxiliar1 = listaNumeros[0];
        int auxiliar2 = tortuga;
        while(auxiliar1 != auxiliar2){
            auxiliar1 = listaNumeros[auxiliar1];
            auxiliar2 = listaNumeros[auxiliar2];
        }
        return auxiliar1;
    }
       
    public int strstr(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        str1 = quitaAcentos(str1);
        str2 = quitaAcentos(str2);
        
        int posicion = -1;
        //suponemos que no hay acentos y que todo es minúsculas
        for(int i = 0; i<str1.length(); i++){
            if(str1.charAt(i) == str2.charAt(0)){
                posicion = i;
                int j = 0; //indice para buscar el str2
                
                while((j < str2.length() && i < str1.length()) && str1.charAt(i) == str2.charAt(j)){
                    j++;
                    i++;
                }
                //el while ha terminado y puede haber salido por varias razones
                //la primera, que alguno de los dos length se haya terminado
                //la segunda, que alguna letra sea distinta
                
                if(j >= str2.length()){
                    //si ha salido del while porque ya no tenía más letras el str2, significa
                    //que el str2 está dentro del str1, y además su posición está guardada
                    //en posición
                    return posicion;
                }
                
                if(i >= str1.length()){
                    //si ha salido del while porque ya no tenía más letras el str1, signfica
                    //que el str2 no está dentro del str1.
                    return -1;
                }
                
                if(str1.charAt(i) != str2.charAt(j)){
                    i = posicion; //para que vuelva a chequear a partir de la siguiente letra
                    posicion = -1;
                }
            }
        }
        return posicion;
    }
    
    public String calculadoraRPN( String [] entrada){
    
        String [] pila  = new String [100];
        int posicionPila = 0; //indica el sitio de la pila en el que toca insertar o leer
        
        for (int i=0; i< entrada.length; i++){
            
            if (entrada[i] != "+" && entrada[i] != "-" &&entrada[i] != "*" &&entrada[i] != "/" ){
                //System.out.print(entrada[i] + " ");
                //es un operando, tengo que meterlo en la pila
                pila[posicionPila] = entrada[i];
                posicionPila++;
            }
            else{ //es una operación
                if (posicionPila - 2 >= 0){
                    Double operando1 = Double.valueOf(pila[posicionPila - 1]);
                    Double operando2 = Double.valueOf(pila[posicionPila - 2]);
                    if (entrada[i] == "+"){
                        operando1 = operando1 + operando2;
                    }
                    if (entrada[i] == "*"){
                        operando1 = operando1 * operando2;
                    }
                    if (entrada[i] == "-"){
                        operando1 = operando1 - operando2;
                    }
                    if (entrada[i] == "/"){
                        if(operando2 == 0){
                            return "No se puede dividir entre cero, imbécil";
                        }
                        else{
                            operando1 = operando1 / operando2;
                        }    
                    }
                    posicionPila = posicionPila - 2;
                    pila[posicionPila] = operando1+"";  //guardo el resultado en la casilla correspondiente
                    posicionPila++;
                }
                else{
                    return "ERROR";
                }
            }
            
        }
        
        
        
        
        return pila[0];
    }    
            
            
     
    
    
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EjerciciosNivel02 ejercicio = new EjerciciosNivel02();
        
        /*char[][]listaPalabras = {
           {'P', 'A', 'T', 'A'},
           {'R', 'A', 'T', 'O'},
           {'R', 'A', 'T', 'O'},
           {'R', 'A', 'M', 'O'},
           {'G', 'A', 'M', 'O'},
           {'G', 'A', 'T', 'O'},
           {'M', 'A', 'T', 'O'},
        };
        
        System.out.println(ejercicio.esEscaleraDePalabras(listaPalabras)); */
 
        /*System.out.println(ejercicio.costeErroresADN_Jorge("ACGT", "TGCA"));
        System.out.println("");
        System.out.println(ejercicio.costeErroresADN_Jorge("A-C-G-T-ACGT", "TTGGCCAATGCA"));
        System.out.println("");
        System.out.println(ejercicio.costeErroresADN_Jorge("AAAAAAAA", "TTTATTTT"));
        System.out.println("");
        System.out.println(ejercicio.costeErroresADN_Jorge("GATTACA", "CTATT-T"));
        System.out.println("");
        System.out.println(ejercicio.costeErroresADN_Jorge("CAT-TAG-ACT", "GTATATCCAAA"));
        System.out.println("");
        System.out.println(ejercicio.costeErroresADN_Jorge("--------", "ACGTACGT"));
        System.out.println("");
        System.out.println(ejercicio.costeErroresADN_Jorge("TAATAA", "ATTATT"));
        System.out.println("");
        System.out.println(ejercicio.costeErroresADN_Jorge("GGGA-GAATATCTGGACT", "CCCTACTTA-AGACCGGT"));
        System.out.println("");
        System.out.println(ejercicio.costeErroresADN_Jorge("-ATG", "-TAC"));*/
        
        /*System.out.println(ejercicio.findDuplicate(new int[]{3,2,3,4,1}));
        System.out.println(ejercicio.findDuplicate(new int[]{4,2,3,4,1}));
        System.out.println(ejercicio.findDuplicate(new int[]{1,1,3,4,1}));*/
        
        /*System.out.println(ejercicio.strstr("hola Helios", "el"));
        System.out.println(ejercicio.strstr("hola mundo", "mun"));
        System.out.println(ejercicio.strstr("hola mynmu", "mun"));
        System.out.println(ejercicio.strstr("hola mmunn", "mun"));
        System.out.println(ejercicio.strstr("Mun", "Mun"));
        System.out.println(ejercicio.strstr("Mumn", "Mun"));*/
        
        ejercicio.calculadoraRPN( new String[]{"4", "2", "/", "5", "*"} );
    }
    
}
