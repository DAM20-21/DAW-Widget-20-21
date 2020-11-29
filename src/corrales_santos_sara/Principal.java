package corrales_santos_sara;

import java.awt.EventQueue; 

/**
 * Main para probar el widget pomodoro con lista To-do
 * @author Sara Corrales Santos
 * @since 1.0
 */

public class Principal {
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                try {
                    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                    ventanaPrincipal.iniciar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
     }
}
