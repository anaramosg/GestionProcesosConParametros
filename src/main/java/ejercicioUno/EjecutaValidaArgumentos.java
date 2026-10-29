package ejercicioUno;
import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.IOException;

public class EjecutaValidaArgumentos {
    public static void main(String[] args) {

        //Guarda el argumento.
        System.out.print("Escribe un dato o pulsa Enter para no enviar ninguno:");
        String argumento = Entrada.cadena();

        try {
            // Para iniciar otra clase Java desde este proceso, indicamos
            // el nombre completo de la clase y la ruta donde están las clases compiladas.
            String clase = "ejercicioUno.ValidaArgumentos";
            String classpath = System.getProperty("java.class.path");

            ProcessBuilder pb;

            if (argumento.isEmpty()) {
                pb = new ProcessBuilder(
                        "java", "-cp", classpath, clase
                );
            } else {
                pb = new ProcessBuilder(
                        "java", "-cp", classpath, clase, argumento
                );
            }

            Process proceso = pb.start();
            int codigoSalida = proceso.waitFor();

            System.out.println("Valor de salida: " + codigoSalida);

            if (codigoSalida == 1) {
                System.out.println("No hay argumentos...");
            } else if (codigoSalida == 2) {
                System.out.println("Es una cadena...");
            } else if (codigoSalida == 3) {
                System.out.println("Número menor que 0...");
            } else if (codigoSalida == 4) {
                System.out.println("Número mayor o igual que 0...");
            }

        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El proceso fue interrumpido.");
        }
    }
}
