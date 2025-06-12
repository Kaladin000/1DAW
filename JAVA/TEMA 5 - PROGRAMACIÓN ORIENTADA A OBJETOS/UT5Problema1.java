/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut5problema1;

/**
 *
 * @author David García Valero
 */
public class UT5Problema1 {
    
    public static class Fracción {
        
        // ATRIBUTOS
        
        private int numerador;
        private int denominador;
        
        // CONSTRUCTORES
        
        public Fracción() {
            this.numerador = 0;
            this.denominador = 1;
        }
        
        public Fracción(int nuevoNumerador) {
            this.numerador = nuevoNumerador;
            this.denominador = 1;
        }
        
        public Fracción(int nuevoNumerador, int nuevoDenominador) {
            this.numerador = nuevoNumerador;
            this.denominador = nuevoDenominador;
        }
        
        public Fracción(Fracción fracciónCopiar) {
            this.numerador = fracciónCopiar.numerador;
            this.denominador = fracciónCopiar.denominador;
        }
        
        public Fracción(double fracciónDouble) {
            String stringDouble = String.valueOf(fracciónDouble);
            boolean esDecimal = stringDouble.contains(".");
            if (esDecimal == true) {
                int indexPunto = stringDouble.indexOf(".");
                indexPunto++;
                int tamañoString = stringDouble.length();
                int numDieces = tamañoString-indexPunto;
                double numeradorDouble = fracciónDouble*Math.pow(10, numDieces);
                double denominadorDouble = Math.pow(10, numDieces);
                int numeradorInt = (int)numeradorDouble;
                int denominadorInt = (int)denominadorDouble;
                this.numerador = numeradorInt;
                this.denominador = denominadorInt;
            }
        }
        
        // MÉTODOS DE INSTANCIA
        
        public double toDouble() {
            double numeradorDouble = numerador;
            double denominadorDouble = denominador;
            double fracciónDouble = numeradorDouble/denominadorDouble;
            return fracciónDouble;
        }
        
        public Fracción más(Fracción fracciónMás) {
            int numeradorResultado = (numerador*fracciónMás.denominador)+(denominador*fracciónMás.numerador);
            int denominadorResultado = fracciónMás.denominador*denominador;
            return new Fracción(numeradorResultado,denominadorResultado);
        }
        
        public Fracción más(double númeroMás) {
            Fracción fracciónMás = new Fracción(numerador,denominador);
            double fracciónDouble = fracciónMás.toDouble();
            double sumatorio = fracciónDouble+númeroMás;
            return new Fracción(sumatorio); // Utiliza el constructor de Math.pow(10, numDieces)
        }
        
        public Fracción menos(Fracción fracciónMenos) {
            int numeradorResultado = (numerador*fracciónMenos.denominador)-(denominador*fracciónMenos.numerador);
            int denominadorResultado = fracciónMenos.denominador*denominador;
            return new Fracción(numeradorResultado,denominadorResultado);
        }
        
        public Fracción menos(double númeroMenos) {
            Fracción fracciónMenos = new Fracción(numerador,denominador);
            double fracciónDouble = fracciónMenos.toDouble();
            double resta = fracciónDouble-númeroMenos;
            return new Fracción(resta); // Utiliza el constructor de Math.pow(10, numDieces)
        }
        
        public Fracción por(Fracción fracciónPor) {
            int numeradorResultado = numerador*fracciónPor.numerador;
            int denominadorResultado = denominador*fracciónPor.denominador;
            return new Fracción(numeradorResultado,denominadorResultado);
        }
        
        public Fracción entre(Fracción fracciónEntre) {
            int numeradorResultado = numerador*fracciónEntre.denominador;
            int denominadorResultado = denominador*fracciónEntre.numerador;
            return new Fracción(numeradorResultado,denominadorResultado);
        }
        
        public Fracción invertir() {
            return new Fracción(denominador,numerador);
        }
        
        public Fracción simplificar() {          
            int numeradorResultado = Math.abs(numerador);
            int denominadorResultado = Math.abs(denominador);
            
            // CREO UN ARRAY PARA CADA LISTA DE DIVISORES
            
            int divisoresNumerador[] = new int[Math.abs(numerador)];
            int divisoresDenominador[] = new int[Math.abs(denominador)];
            int j = 1;
            
            // ESTABLEZCO LOS VALORES DE LOS DIVISORES
            
            for (int i = 0; i < Math.abs(numerador); i++) {
                if (numeradorResultado % j == 0) {
                    divisoresNumerador[i] = j;
                }
                if (numeradorResultado == j) {
                    break;
                } j++;
            }
            int k = 1;
            for (int i = 0; i < Math.abs(denominador); i++) {
                if (denominadorResultado % k == 0) {
                    divisoresDenominador[i] = k;
                }
                if (denominadorResultado == k) {
                    break;
                } k++;
            }
            
            // ENCUENTRO LOS NÚMEROS COINCIDENTES IGUALES E MÁXIMOS ENTRE LAS DOS LISTAS (MCD)
            
            int mcd = 0;
            for (int i = 0; i < divisoresDenominador.length; i++) {
                for (int l = 0; l < divisoresNumerador.length; l++) {
                    if (divisoresDenominador[i] == divisoresNumerador[l] && divisoresNumerador[l] >= mcd) {
                        mcd = divisoresNumerador[l];
                    }
                    
                }
            }
            for (int i = 0; i < divisoresNumerador.length; i++) {
                for (int l = 0; l < divisoresDenominador.length; l++) {
                    if (divisoresNumerador[i] == divisoresDenominador[l] && divisoresDenominador[l] >= mcd) {
                        mcd = divisoresDenominador[l];
                    }
                }
            }
            
            // PARA SIMPLIFICAR SE DIVIDEN LOS NÚMEROS A SIMPLIFICAR ENTRE SU MÁXIMO COMÚN DIVISOR
            
            if (mcd != 0) {
            numeradorResultado = numerador/mcd;
            denominadorResultado = denominador/mcd;
            }
            return new Fracción(numeradorResultado,denominadorResultado);
        }
        
        public Fracción clonar() {
            return new Fracción(this.numerador,this.denominador);
        }
        
        public String toString() {
            String fracciónString = String.valueOf(this.numerador);
            fracciónString = fracciónString.concat("/");
            fracciónString = fracciónString.concat(String.valueOf(this.denominador));
            return fracciónString;
        }
        
        public void imprimirMixto() {
            int cociente = this.numerador/this.denominador;
            int residuo = this.numerador%this.denominador;
            System.out.println(cociente + " + " + residuo + "/" + this.denominador);
        }
        
        // El método compara de izquierda a derecha, la primera Fracción, que es la que inicia el método, es mayor, menor o igual que la Fracción parámetro
        
        public String comparar(Fracción fracciónComparar) {
            Fracción fracciónPrimera = new Fracción(numerador,denominador);
            double fracciónDoublePrimera = fracciónPrimera.toDouble();
            Fracción fracciónSegunda = new Fracción(fracciónComparar.numerador,fracciónComparar.denominador);
            double fracciónDoubleSegunda = fracciónSegunda.toDouble();
            String comparación = null;
            if (fracciónDoublePrimera > fracciónDoubleSegunda) {
                comparación = "mayor";
            } else if (fracciónDoublePrimera < fracciónDoubleSegunda) {
                comparación = "menor";
            } else if (fracciónDoublePrimera == fracciónDoubleSegunda) {
                comparación = "igual";
            } return comparación;
        }
        
        // Método de clase para ordenar un array de menor a mayor
        
        public static void ordenarArray(Fracción[] arrayFracciones) {
            for (int i = 0; i < arrayFracciones.length-1; i++) {
                for (int j = 0; j < arrayFracciones.length-1; j++) {
                    if ((arrayFracciones[j].comparar(arrayFracciones[j+1])).equals("mayor")) {
                        Fracción fracciónTemporal = arrayFracciones[j];
                        arrayFracciones[j] = arrayFracciones[j+1];
                        arrayFracciones[j+1] = fracciónTemporal;
                    }
                }
            }
        }
        
        // MÉTODOS DE CLASE
        
        public static Fracción sumar(Fracción fracciónSumar1, Fracción fracciónSumar2) {
            Fracción fracciónSumada = fracciónSumar1.más(fracciónSumar2);
            return fracciónSumada;
        }
        
        public static Fracción restar(Fracción fracciónRestar1, Fracción fracciónRestar2) {
            Fracción fracciónRestada = fracciónRestar1.menos(fracciónRestar2);
            return fracciónRestada;
        }
        
        public static Fracción multiplicar(Fracción fracciónMultiplicar1, Fracción fracciónMultiplicar2) {
            Fracción fracciónMultiplicada = fracciónMultiplicar1.por(fracciónMultiplicar2);
            return fracciónMultiplicada;
        }
        
        public static Fracción dividir(Fracción fracciónDividir1, Fracción fracciónDividir2) {
            Fracción fracciónDividida = fracciónDividir1.entre(fracciónDividir2);
            return fracciónDividida;
        }
        
        
    }
    
    // TEST FRACCIÓN
    
    public static void main(String[] args) {
        Fracción[] fracciónArray = {new Fracción(3,2),new Fracción(1,4),new Fracción(1,2),new Fracción(1,8),new Fracción(1,2),new Fracción(1,6),new Fracción(1,7),new Fracción(1,9),};
        fracciónArray[0].imprimirMixto();
        Fracción.ordenarArray(fracciónArray);
        for (int i = 0; i < fracciónArray.length; i++) {
            System.out.println(fracciónArray[i].toString());
        }
        Fracción fracción2 = new Fracción(412,33212);
        System.out.println(fracción2.simplificar());
        
    }
}
