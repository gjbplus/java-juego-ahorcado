import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        
        // clase scanner que nos permite que el usuario escriba
        Scanner scanner = new Scanner(System.in);

        //Declaraciones y asignaciones
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean estaAdivinada = false;

        //Arreglos

        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        
        //recorro el arreglo de letras y lo inicializo todo con el caracter _
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while (!estaAdivinada && intentos < intentosMaximos) {
            
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.println("Introduce una letra, por favor");
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if(letra == palabraSecreta.charAt(i)){
                    letraCorrecta = true;
                    letrasAdivinadas[i] = letra;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorecto!, te quedan " + (intentosMaximos - intentos) + " intentos." );
            }

            if(String.valueOf(letrasAdivinadas).equals(String.valueOf(palabraSecreta))){
                estaAdivinada = true;
                System.out.println("¡Felicidades!, Has adivinado la palabra: " + palabraSecreta);
            }

        }

        if(!estaAdivinada){
            System.out.println("Que pena!, te has quedado sin intentos, GAME OVER");
        }
        scanner.close();
    }
}
