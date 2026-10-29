package ejercicioTres;

public class Visualizador {
    public static void main(String[] args) {
        String cadena = args[0];
        int repeticiones = Integer.parseInt(args[1]);

        if (cadena.isEmpty()) {
            System.out.println("Cadena introducida vacía");
            System.exit(1);
        }

        for (int i = 1; i <= repeticiones; i++) {
            System.out.println(i + ". " + cadena);
        }

        System.exit(0);
    }
}
