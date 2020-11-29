package nofuentes_mendez_elena;

import java.awt.EventQueue;

/**
 * Clase principal del reproductor de vídeo.
 * 
 * @author Elena Nofuentes
 * @since 25-11-2020
 * @version 1.3
 * 
 */

public class Principal {
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                    ventanaPrincipal.inicializar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}