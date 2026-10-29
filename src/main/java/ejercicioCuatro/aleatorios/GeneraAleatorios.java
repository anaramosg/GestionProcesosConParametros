package ejercicioCuatro.aleatorios;

import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GeneraAleatorios {
    public static void main(String[] args) {
        try {
            String clase = "ejercicioCuatro.aleatorios.Aleatorios";
            String classpath = System.getProperty("java.class.path");

            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", classpath, clase
            );

            Process proceso = pb.start();

            BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));

            BufferedReader lector = new BufferedReader( new InputStreamReader(proceso.getInputStream()));

            String peticion = "";

            while (!peticion.equals("fin")) {
                System.out.print("Escribe una petición (fin para terminar):");
                peticion = Entrada.cadena();

                escritor.write(peticion);
                escritor.newLine();
                escritor.flush();

                if (!peticion.equals("fin")) {
                    System.out.println(lector.readLine());
                }
            }

            escritor.close();
            proceso.waitFor();
            lector.close();

        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El proceso fue interrumpido.");
        }
    }
}
