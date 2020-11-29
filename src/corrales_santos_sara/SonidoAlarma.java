package corrales_santos_sara;

public class SonidoAlarma extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
