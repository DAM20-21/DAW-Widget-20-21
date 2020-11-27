package nofuentes_mendez_elena;

import java.awt.EventQueue;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

/**
 * Clase principal del reproductor de vídeo.
 * 
 * @author Elena Nofuentes
 * @since 25-11-2020
 * @version 1.0
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
    }
}