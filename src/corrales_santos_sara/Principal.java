package corrales_santos_sara;

import java.awt.EventQueue; 

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
