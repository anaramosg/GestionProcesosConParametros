package ejercicioCuatro.aleatorios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aleatorios {
    public static void main(String[] args) {
        BufferedReader lector =
                new BufferedReader(new InputStreamReader(System.in));

        String peticion;

        try {
            while ((peticion = lector.readLine()) != null && !peticion.equals("fin")) {
                int numero = (int) (Math.random() * 11);
                System.out.println(numero);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}