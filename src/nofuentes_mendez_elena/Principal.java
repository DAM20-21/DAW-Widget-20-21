package nofuentes_mendez_elena;

import java.awt.EventQueue;
import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

/**
 * Clase principal del reproductor de vídeo.
 * 
 * - Native Interface es un mecanismo que nos permite interactuar con
 * aplicaciones nativas desde un programa escrito en Java.
 * 
 * @author Elena Nofuentes
 * @since 25-11-2020
 * @version 1.2
 *
 */

public class Principal {
    public static void main(String[] args) throws Exception {
        NativeInterface.open();
        UIUtils.setPreferredLookAndFeel();
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
        NativeInterface.runEventPump();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                NativeInterface.close();
            }
        }));
    }
}