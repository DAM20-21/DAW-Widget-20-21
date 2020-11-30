package luis_calero_alberto;

import java.awt.EventQueue;

/**
 * @author Alberto Luis Calero
 * 
 *         Clase principal que solo tiene el metodo main
 */
public class App {
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPrincipal ventana = new VentanaPrincipal();
                    ventana.inicializar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
