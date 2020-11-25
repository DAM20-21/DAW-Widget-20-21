package calero_luis_alberto;

import java.awt.EventQueue;

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
