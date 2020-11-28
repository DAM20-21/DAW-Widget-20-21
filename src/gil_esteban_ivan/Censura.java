package gil_esteban_ivan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Censura {

    final static String[] NOM_FICH = { "censura1.txt", "censura2.txt", "censura3.txt" };

    public Censura() {
    }

    public String leerMostrarTabu(int num) {
        String linea = null;
        String guardar = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("ficheros/" + NOM_FICH[num])));
            while ((linea = br.readLine()) != null) {
                guardar += linea + "\n";
            }
            br.close();
        } catch (IOException io) {
            System.out.println("Error en la E/S: " + io.getMessage());
        }
        return guardar;
    }

    public void leerPrevisualizar(int num) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("ficeros/" + NOM_FICH[num])));
            String linea;
            while ((linea = br.readLine()) != null) // lee una línea del fichero

                br.close();
        } catch (IOException io) {
            System.out.println("Error en la E/S: " + io.getMessage());
        }
    }

}
