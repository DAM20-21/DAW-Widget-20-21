package gil_esteban_ivan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class Censura {

    final static String[] NOM_FICH = { "censura1.txt", "censura2.txt", "censura3.txt" };
    
    private int num;
    private JTextArea previsualizar;
    private JTextArea palabrasCensura;

    public Censura(JTextArea previsualizar, JTextArea palabrasCensura) {
        this.previsualizar = previsualizar;
        this.palabrasCensura = palabrasCensura;
        num = 0;
    }


    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public JTextArea getPrevisualizar() {
        return this.previsualizar;
    }

    public void setPrevisualizar(JTextArea previsualizar) {
        this.previsualizar = previsualizar;
    }

    public JTextArea getPalabrasCensura() {
        return this.palabrasCensura;
    }

    public void setPalabrasCensura(JTextArea palabrasCensura) {
        this.palabrasCensura = palabrasCensura;
    }


    public void leerMostrarTabu() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(NOM_FICH[num])));
            String linea;
            while ((linea = br.readLine()) != null) // lee una línea del fichero
                
            

            br.close();
        } catch (IOException io) {
            System.out.println("Error en la E/S: " + io.getMessage());
        }
    }

    public void leerPrevisualizar() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(NOM_FICH[num])));
            String linea;
            while ((linea = br.readLine()) != null) // lee una línea del fichero
                
            

            br.close();
        } catch (IOException io) {
            System.out.println("Error en la E/S: " + io.getMessage());
        }
    }

}
