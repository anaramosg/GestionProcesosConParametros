package ejercicioTres;

import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaVisualizador {
    public static void main(String[] args) {
        System.out.print("Introduce una cadena:");
        String cadena = Entrada.cadena();

        try {
            String clase = "ejercicioTres.Visualizador";
            String classpath = System.getProperty("java.class.path");

            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", classpath, clase, cadena, "5"
            );

            Process proceso = pb.start();

            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            int codigoSalida = proceso.waitFor();
            System.out.println("Valor de salida: " + codigoSalida);

            if (codigoSalida == 0) {
                System.out.println("Final Correcto");
            } else {
                System.out.println("Final Incorrecto");
            }

        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El proceso fue interrumpido.");
        }
    }
}
