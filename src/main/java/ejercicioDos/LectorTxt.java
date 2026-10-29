package ejercicioDos;

import org.iesalandalus.programacion.utilidades.Entrada;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LectorTxt {
    public static void main(String[] args) {
        try {
            String clase = "ejercicioDos.TransformadorTxt";
            String classpath = System.getProperty("java.class.path");

            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", classpath, clase
            );

            Process proceso = pb.start();

            BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));

            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea = "";

            while (!linea.equals("fin")) {
                System.out.print("Escribe una línea (fin para terminar):");
                linea = Entrada.cadena();

                if (!linea.equals("fin")) {
                    escritor.write(linea);
                    escritor.newLine();
                    escritor.flush();

                    System.out.println(lector.readLine());
                }
            }

            escritor.close();
            proceso.waitFor();

        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El proceso fue interrumpido.");
        }
    }
}