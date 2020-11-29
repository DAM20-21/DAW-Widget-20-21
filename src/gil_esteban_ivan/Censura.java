package gil_esteban_ivan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase Censura donde vamos a trabajar con los ficheros de censura para poder
 * remplazar las palabras que son tabu por signos "*"
 * 
 * @author Iván Gil Esteban
 * 
 * @version 1.0
 * @since 1.0
 */
public class Censura {

    // Constante con el nombre de los distintos ficheros de censura.
    final static String[] NOM_FICH = { "censura1.txt", "censura2.txt", "censura3.txt" };

    /**
     * Método que recibe el valor del Slider del dialogo para escoger el fichero y
     * devuelve el contenido de ese fichero para mostrarlo en nuestro dialogo.
     * 
     * @param num numero que identifica el fichero que usamos
     * @return
     */
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

    /**
     * Método que recibe el valor del Slider del dialogo para escoger el fichero y
     * despues remplaza las palabras tabu en el textoRecibido de nuestro widget
     * 
     * @param num           numero que identifica el fichero que usamos
     * @param textoRecibido texto para censurar que recibimos del widget
     * @return
     */
    public String leerPrevisualizar(int num, String textoRecibido) {
        int cont = 0;
        String texto = textoRecibido.toLowerCase();
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
