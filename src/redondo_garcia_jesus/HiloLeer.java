package redondo_garcia_jesus;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Clase que crea un hilo que lee el fichero
 *
 * @author Sergio Blanco Prieto
 */
public class HiloLeer extends Thread {
    private static File fich = new File("puntuaciones.dat");
    private static VentanaPrincipal ventanaPrincipal;
    private static int puntuacion;
    
    public HiloLeer (VentanaPrincipal v) {
        ventanaPrincipal = v;
    }
    
    @Override
    public void run() {
        try {
            leerFich();
        } catch (IOException io) {
            System.out.println("Error E/S");
        }
    }
    
    public static void leerFich() throws IOException {
        DataInputStream dis = null;
        puntuacion = 0;
        try {
            FileInputStream fis = new FileInputStream(fich);
            dis = new DataInputStream(fis);
            ventanaPrincipal.mitad1.setText("HIGH SCORE -->" + puntuacion + "<--");
            int puntos;
            while (true) {
                ventanaPrincipal.mitad2.setText(dis.readUTF());
                refrescarPantalla();
                puntos = dis.readInt();
                if (puntos > puntuacion) {
                    sleep(1500);
                    ventanaPrincipal.mitad2.setText("¡NUEVO RECORD!");
                    puntuacion = puntos;
                    ventanaPrincipal.mitad1.setText("HIGH SCORE -->" + puntuacion + "<--");
                }
                refrescarPantalla();
                sleep(1500);
            }
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin del fichero");
            ventanaPrincipal.mitad2.setText("<html><body>Fin de la lista de jugadores<br>Puntuación más alta: " + puntuacion + "</br></body></html>");
        } catch (IOException io) {
            System.out.println("Error E/S");
        } finally {
            dis.close();
        }
    }
    
    public static void refrescarPantalla() {
        ventanaPrincipal.ventana.revalidate();
        ventanaPrincipal.ventana.repaint();
    }
}
