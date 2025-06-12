/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.util.Arrays;
import java.util.Scanner;

public class AhorcadoExamen {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Método principal.
     *
     * @param args
     */
    public static void main(String[] args) {
        AhorcadoExamen ahorcado = new AhorcadoExamen();
        ahorcado.inicio();
    }

    /**
     * Método inicial
     */
    public void inicio() {
        System.out.println(" Bienvenidos al ahorcado : \n");
        String palabra = configurarPartida();
        iniciarJuego(palabra);
    }

    //---------------------- Métodos de nivel 3 ------------------
    /**
     * Pide una letra. Si se introduce más de un carácter se volverá a pedir el
     * dato de nuevo.
     *
     * @return La letra leída por teclado
     */
    public char pedirLetra() {
        System.out.println("Dime una letra");
        String caracterString = scanner.nextLine();
        while (caracterString.length() > 1) {
            System.out.println("ERROR. Has introducido más de un carácter. Vuelve a intentarlo.");
            caracterString = scanner.nextLine();
        }
        char caracter = caracterString.charAt(0);
        return caracter;
    }

    /**
     * Compara si una string y un array de caracteres contienen la misma
     * información
     *
     * @param palabra La string proporcionada
     * @param palabraHuecos El array de caracteres proporcionado
     * @return True si el contenido de ambos datos proporcionados coincide,
     * false en caso contrario
     */
    public boolean sonIguales(String palabra, char[] palabraHuecos) {
        boolean salida = false;
        char palabraArray[] = new char[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            palabraArray[i] = palabra.charAt(i);
        }
        for (int i = 0; i < palabra.length(); i++) {
            if (palabraHuecos[i] == palabraArray[i] && i == 0) {
                salida = true;
            } else if (palabraHuecos[i] != palabraArray[i] && i == 0) {
                salida = false;
            }
            
            if (palabraHuecos[i] == palabraArray[i] && i != 0 && salida == true) {
                salida = true;
            } else if (palabraHuecos[i] != palabraArray[i] && i != 0) {
                salida = false;
            }
        }
        return salida;
    }

    /**
     * MÉTODO YA IMPLEMENTADO: Lo debes invocar en la implementación del método
     * pedirLetrasParaEncontrarPalabra (PARTE 2 del examen)
     *
     * Obtiene las indices (empezando desde 1) del caracter en la string
     *
     * @param texto El texto que se pasa como dato para saber las indices del
     * carácter dado
     * @param caracter El carácter que se utilizará para determinar las indices
     * @return El array de indices donde el caracter se encuentra en la string
     *
     * Ejemplo: int [] indices = buscaIndicesCaracterEnString("pepe", 'e'); El
     * array indices contendrá la información: [2, 4]
     */
    public int[] buscaIndicesCaracterEnString(String texto, char caracter) {

        int[] indices = new int[0];

        for (int i = 0; i < texto.length(); i++) {
            if (caracter == texto.charAt(i)) {
                indices = Arrays.copyOf(indices, indices.length + 1);
                indices[indices.length - 1] = i;
            }
        }

        return indices;
    }

    /**
     * Inserta en el array de caracteres el caracter dado según los índices
     * proporcionados Si alguno de los índices dados es superior al tamaño del
     * array, no se insertará el carácter en ese índice, pero en el resto sí.
     *
     * @param array El array de caracteres donde se introducirá el carácter dado
     * según los índices dados
     * @param indices Los indices del array de caracteres donde se insertará el
     * caracter dado
     * @param caracter El caracter a insertar en el array de caracteres
     */
    public void insertaCaracterEnArraySegunIndices(char[] array, int[] indices, char caracter) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < indices.length; j++) {
                if (indices[j] < array.length) {
                    array[indices[j]] = caracter;
                }
            }
        }
    }

    /**
     * Imprime por pantalla la lista de indices dados. Al final se imprime un
     * salto de línea.
     *
     * @param indicesLetra El array de indices que se imprimirá
     */
    public void imprimeListaDeIndices(int[] indicesLetra) {
        for (int i = 0; i < indicesLetra.length; i++) {
                if (indicesLetra.length == 1 && i == 0) {
                    System.out.println(indicesLetra[i]);
                } else if (indicesLetra.length > 1 && i == 0) {
                    System.out.print(indicesLetra[i]);
                }
                if (indicesLetra.length != 1 && i != 0 && i != indicesLetra.length-1) {
                    System.out.print(", " + indicesLetra[i]);
                }
                if (indicesLetra.length != 1 && i == indicesLetra.length-1) {
                    System.out.print(" y " + indicesLetra[i] + "\n");
                }
        }
    }

    /**
     * MÉTODO YA IMPLEMENTADO
     *
     * Imprime por pantalla el array de caracteres dado. Se imprime un carácter
     * al lado del otro, y al final un salto de línea.
     *
     * @param arrayCaracteres El array de caracteres a imprimir
     */
    public void imprimeArrayCaracteres(char[] arrayCaracteres) {
        for (int i = 0; i < arrayCaracteres.length; i++) {
            System.out.print(arrayCaracteres[i]);
        }
        System.out.println();
    }

    // -----------------   Métodos de nivel 2 ----------------
    /**
     * Pide el número máximo de letras que puede tener la palabra a adivinar.
     * Debe ser un valor entre 3 y 15. En cualquier otro caso, se volverá a
     * pedir el dato.
     *
     * @return el número máximo de letras
     */
    public int pedirNumeroMaximoLetras() {
        System.out.println("Introduce el número máximo de letras");
        int numMax;
        while (!scanner.hasNextInt()) {
            System.out.println("ERROR. Has introducido un número no entero. Vuelve a intentarlo.");
            scanner.next();
        } numMax = scanner.nextInt();
        while (numMax < 3 || numMax > 15) {
            System.out.println("ERROR. Has introducido un número menor a 3 o mayor a 15. Vuelve a intentarlo.");
            while (!scanner.hasNextInt()) {
                System.out.println("ERROR. Has introducido un número no entero. Vuelve a intentarlo.");
                scanner.next();
            }
            numMax = scanner.nextInt();
        }
        return numMax;
    }

    /**
     * MÉTODO YA IMPLEMENTADO
     * 
     * Pide la palabra a adivinar. Debe ser de un tamaño menor o igual que
     * maximoLetras.
     *
     * Se volverá a pedir el dato si no se cumplen la premisa anterior.
     *
     * @param maximoLetras
     * @return La palabra leída
     */
    public String pedirPalabraDeTamanyoAdecuado(int maximoLetras) {
        String palabra;
        do {
            System.out.print("Introduce la palabra a adivinar: ");
            palabra = scanner.nextLine();
        } while (palabra.length() > maximoLetras);

        return palabra;
    }

    /**
     * Crea e inicializa un array de caracteres del tamaño que marca el
     * parámetro “tamanyoPalabraHuecos”. El valor de inicialización de cada
     * celda del array será el carácter ‘_’ (barra baja).
     *
     * @param tamanyoPalabraHuecos
     * @return El array creado e inicializado con el carácter '_' (barra baja)
     */
    public char[] creaPalabraHuecos(int tamanyoPalabraHuecos) {
        char arrayChar[] = new char[tamanyoPalabraHuecos];
        for (int i = 0; i < tamanyoPalabraHuecos; i++) {
            arrayChar[i] = '_';
        }
        return arrayChar;
    }

    /**
     * MÉTODO YA IMPLEMENTADO: Lo debes invocar en la implementación del método
     * pedirLetrasParaEncontrarPalabra (PARTE 2 del examen) Informa al usuario
     * del estado actual de la partida
     *
     * @param intentosRestantes
     * @param palabraHuecos
     */
    public void informarDeEstadoPartida(int intentosRestantes, char[] palabraHuecos) {

        Dibujos.dibujar(intentosRestantes);
        imprimeArrayCaracteres(palabraHuecos);
        System.out.println("Te quedan " + intentosRestantes + " intentos \n");
    }

    /**
     * Va pidiendo letras hasta bien agotar el máximo de intentos o bien acertar
     * la palabra secreta
     *
     * @param palabra La palabra a adivinar
     * @param palabraHuecos La palabra con los huecos
     * @param maxIntentos El número máximo de intentos
     * @return El número de intentos restantes
     */
    public int pedirLetrasParaEncontrarPalabra(String palabra, char[] palabraHuecos, int maxIntentos) {
    scanner.nextLine(); // Creo que la palabra no se introduce, entonces el código adelante en sí no funciona, pero tengo la certeza de que lo he escrito bien y debería funcionar, solo necesita la palabra, que con el código ya implementado, por alguna razón, no se establece.
    int intentosRestantes = maxIntentos;
    for (int j = 0; j < maxIntentos; j++) {
        boolean partidaAcabada = false;
        boolean letraEncontrada = false;
        char letra = pedirLetra();
        int indiceLetra[] = new int[1];
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                letraEncontrada = true;
                indiceLetra[0] = i;
                insertaCaracterEnArraySegunIndices(palabraHuecos , indiceLetra, letra);
            } else if (i == palabra.length()-1 && letraEncontrada == false) {
                intentosRestantes--;
                System.out.println("La letra no está");
                informarDeEstadoPartida(intentosRestantes, palabraHuecos);
            }
        }
        boolean iguales = sonIguales(palabra, palabraHuecos);
        if (iguales == true) {
            partidaAcabada = true;
        } else if (iguales == false && letraEncontrada == true) {
            System.out.println("La letra está");
            informarDeEstadoPartida(intentosRestantes, palabraHuecos);
        }
    }
        return intentosRestantes;
    }

    /**
     * MÉTODO YA IMPLEMENTADO Informa al usuario de cómo quedó la partida en
     * función de los intentos que han quedado por utilizar.
     *
     * @param intentosRestantes
     * @param maxIntentos El número máximo de intentos
     */
    public void evaluarIntentosGastados(int intentosRestantes, int maxIntentos) {

        if (intentosRestantes > 0) {
            System.out.println(" ----------------------------------------- ");
            System.out.println(" -¡¡ H A S  G A N A D O!! - ");
            System.out.println(" ----------------------------------------- ");
            System.out.println(" Numero de intentos restantes : " + intentosRestantes);
        } else {
            System.out.println(" ----------------------------------------- ");
            System.out.println(" - G A M E O V E R =) - ");
            System.out.println(" ----------------------------------------- ");
        }
    }

    // ------------------- Métodos de nivel 1 ----------------------
    /**
     * MÉTODO YA IMPLEMENTADO
     *
     * @return
     */
    public String configurarPartida() {

        System.out.println(" 1) Configuración de partida \n");
        int maximoLetras = pedirNumeroMaximoLetras();
        return pedirPalabraDeTamanyoAdecuado(maximoLetras);
    }

    /**
     * MÉTODO YA IMPLEMENTADO
     *
     * @param palabra
     */
    public void iniciarJuego(String palabra) {
        System.out.println(" 2) Comienza la partida \n");
        int maxIntentos = 6;
        char[] palabraHuecos = creaPalabraHuecos(palabra.length());

        int intentosGastados = pedirLetrasParaEncontrarPalabra(palabra, palabraHuecos, maxIntentos);
        evaluarIntentosGastados(intentosGastados, maxIntentos);
    }
}
