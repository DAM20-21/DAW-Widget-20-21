package perez_martin_miguel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Leer_Excribir {

    /**
     * 2 listas como atributos.
     */
    private ArrayList<String> palabras, significado;

    /**
     * constructor donde inicializamos nuestros atributos.
     */
    public Leer_Excribir() {
        this.palabras = new ArrayList<>();
        this.significado = new ArrayList<>();
    }

    /**
     * getters y setters
     */
    public ArrayList<String> getPalabras() {
        return this.palabras;
    }

    public void setPalabras(ArrayList<String> palabras) {
        this.palabras = palabras;
    }

    public ArrayList<String> getSignificado() {
        return this.significado;
    }

    public void setSignificado(ArrayList<String> significado) {
        this.significado = significado;
    }

    /**
     * metodo en el cual leemos un fichero que contiene palabras y su significado. y
     * vamos añadiendo los datos a nuestras listas.
     */
    public void lectura() {
        // ruta del fichero.
        File fich = new File("ficheros/palabras_miguel.txt");

        try {
            // flujo de lectura.
            BufferedReader br = new BufferedReader(new FileReader(fich));
            // aqui se almacenara cada linea.
            String linea;
            // con este array separamos la palabra de su significado para usarlo por
            // separado
            String[] aux;

            // leemos mientras la linea no este vacia.
            while ((linea = br.readLine()) != null) {
                // separamos la linea por los :, en la parte 0 de array esta la palabra y en la
                // parte 1 se encuentra su significado.
                aux = linea.split(":");
                palabras.add(aux[0]);
                significado.add(aux[1]);
            }
            // cerramos el flujo de lectura.
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * metodo el cual nos permitira añadir una linea nueva a nuestro fichero con la
     * palabra y su significado.
     */
    public void escritura(String nuevaPalabra, String significadoNuevaPalabra) {
        // ruta del fichero.
        File fich = new File("ficheros/palabras_miguel.txt");

        try {
            // flujo de lectura.
            BufferedWriter bw = new BufferedWriter(new FileWriter(fich, true));
            // aqui se almacenara la nueva linea.
            String linea;

            linea = nuevaPalabra + ": " + significadoNuevaPalabra;

            // creamos una nueva linea de despues escribimos la linea correspondiente.
            bw.newLine();
            bw.write(linea);

            // cerramos el flujo de lectura.
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
