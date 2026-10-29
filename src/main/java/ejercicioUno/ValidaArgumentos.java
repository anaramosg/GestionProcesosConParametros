package ejercicioUno;

public class ValidaArgumentos {

    public static void main(String[] args) {

        // 1: Si el número de argumentos es <1.
        if(args.length < 1){
            System.exit(1);
        }

        // 2: Si el argumento es una cadena.
        try {
            Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.exit(2);
        }

        // 3: Si el argumento es un número entero menor que 0.
        // 4: En cualquier otra situación.
        int numero = Integer.parseInt(args[0]);

        if (numero < 0) {
            System.exit(3);
        } else {
            System.exit(4);
        }
    }
}
