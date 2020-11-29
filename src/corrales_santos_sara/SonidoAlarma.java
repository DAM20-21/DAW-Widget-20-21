package corrales_santos_sara;


 /**
  * Clase que extiende de la clase Thread y que crea un hilo que hace que suene una alerta 5 veces
 *@author Sara Corrales Santos 
 */
 
public class SonidoAlarma extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
