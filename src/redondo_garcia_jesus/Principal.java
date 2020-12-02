package redondo_garcia_jesus;

import java.awt.EventQueue;
import java.io.DataOutputStream;
import java.io.File;
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

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ventanaPrincipal = new VentanaPrincipal();
                    ventanaPrincipal.inicializar();
                    escribirFich();
                    HiloLeer h = new HiloLeer(ventanaPrincipal);
                    h.start();
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
                dos.writeUTF("<html><body>Nuevo jugador: " + nombres[i] + "<br></br>El jugador " + nombres[i] + " ha conseguido " + puntuacion + " puntos.</body></html>");
                dos.writeInt(puntuacion);
            }
            dos.close();
        } catch (IOException io) {
            System.out.println("Error en las operaciones de E/S: " + io.getMessage());
        }
    }
}
