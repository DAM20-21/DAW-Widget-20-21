package redondo_garcia_jesus;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Main para probar el Widget High Score
 *
 * @author Sergio Blanco Prieto
 */
public class Principal {
    
    private static File fich = new File("puntuaciones.dat");
    private static VentanaPrincipal ventanaPrincipal;
    private static String[] nombres = {"Juan", "Antonio", "Ana", "Pablo", "Jorge", "Clara", "Pedro", "Alberto", "Samuel", "Sara", "Francisco", "Miguel"};
    private static String [] pantalla;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ventanaPrincipal = new VentanaPrincipal();
                    ventanaPrincipal.inicializar();
                    escribirFich();
                    leerFich();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static void escribirFich() {
        try {
            int puntuacion;
            Random rd = new Random();
            FileOutputStream fos = new FileOutputStream(fich);
            DataOutputStream dos = new DataOutputStream(fos);
            for (int i = 0; i < nombres.length; i++) {
                puntuacion = rd.nextInt(100);
                dos.writeUTF("Nuevo jugador: " + nombres[i] + "\nEl jugador " + nombres[i] + " ha conseguido " + puntuacion + " puntos.");
                dos.writeInt(puntuacion);
            }
        } catch (IOException io) {
            System.out.println("Error en las operaciones de E/S: " + io.getMessage());
        }
    }
    
    public static void leerFich() throws IOException {
        DataInputStream dis = null;
        pantalla = new String[5];
        int puntuacion = 0;
        String m1, m2;
        try {
            FileInputStream fis = new FileInputStream(fich);
            dis = new DataInputStream(fis);
            ventanaPrincipal.mitad1.setText("HIGH SCORE -->" + puntuacion + "<--");
            int cont = 0;
            int puntos;
            while (true) {
                if (cont < 5) {
                    pantalla[cont] = dis.readUTF();
                    actualizarPantalla(cont);
                } else {
                    String t = dis.readUTF();
                    pantalla = annadirFinal(pantalla, t);
                    actualizarPantalla(5);
                }
                puntos = dis.readInt();
                if (puntos > puntuacion) {
                    puntuacion = puntos;
                    ventanaPrincipal.mitad1.setText("HIGH SCORE -->" + puntuacion + "<--");
                }
                Thread.sleep(800);
            }
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin del fichero");
        } catch (IOException io) {
            System.out.println("Error E/S");
        } finally {
            dis.close();
        }
    }
    
    public static String[] annadirFinal(String [] texto, String ultimo) {
        for (int i = 0; i < texto.length - 1; i++) {
            texto[i] = texto[i+1];
        }
        texto[texto.length-1] = ultimo;
        return texto;
    }
    
    public static void actualizarPantalla(int tope) {
        for (int i = 0; i < tope; i++) {
            ventanaPrincipal.mitad2.setText(ventanaPrincipal.mitad2.getText() + pantalla[i] + "\n");
        }
    }
}
