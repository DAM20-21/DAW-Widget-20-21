package ventura_hermoso_alberto;

import java.awt.EventQueue;

public class Principal {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Widget_audio ventana = new Widget_audio();
                    ventana.inicializar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
