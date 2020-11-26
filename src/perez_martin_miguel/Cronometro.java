package perez_martin_miguel;

import java.awt.Color;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cronometro extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;

    JLabel contador;
    int segundos;
    double tiempoTranscurrido;
    double tiempoOriginal;
    Thread hilo = null;
    boolean contando = false;

    public Cronometro() {
        super();
        setBackground(Color.CYAN);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        setLayout(new GridBagLayout());
        contador = new JLabel();
        add(contador);
        contador.setFont(new Font("Arial", Font.PLAIN, 50));

        segundos = 60;
    }

    public void comenzar() {
        if(hilo == null){
            hilo = new Thread(this);
            hilo.start();
        }
    }

    @Override
    public void run() {
        contando = true;
        while (contando) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            calcularTiempoTranscurrido();
            actualizarPantalla();
        }
        hilo = null;
    }

    private void calcularTiempoTranscurrido() {
        if(segundos <= 0){
            contando = false;
        }else{
            segundos--;
        }
        
    }

    private void actualizarPantalla() {
        contador.setText(Integer.toString(segundos));
    }
    
}
