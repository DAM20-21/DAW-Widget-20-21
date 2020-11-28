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

    public String leerPrevisualizar(int num, String a) {
        int cont = 0;
        String texto = a;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("ficheros/" + NOM_FICH[num])));
            String censurado;
            while ((censurado = br.readLine()) != null) {
                if (cont > 0) {
                    texto = texto.replace(censurado.split(":")[0], censurado.split(":")[1]);
                }
                cont++;
            }
            br.close();
        } catch (IOException io) {
            System.out.println("Error en la E/S: " + io.getMessage());
        }
        return texto;
    }

}
