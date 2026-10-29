package ejercicioDos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransformadorTxt {

    public static void main(String[] args) {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        String linea;

        try {
            while ((linea = lector.readLine()) != null && !linea.equals("fin")) {
                System.out.println(linea.toUpperCase());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}