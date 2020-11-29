package corrales_santos_sara;

import java.awt.Color;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Pomodoro extends JPanel implements Runnable{

    /**
     *
     */
    private static final long serialVersionUID = -7903239454597057956L;
    JLabel contador;
    double minutos = 0;
    double segundos;
    double tiempoTranscurrido;
    double tiempoOriginal;
    double tiempo;
    Thread hilo = null;
    boolean contando;
    String minutosTexto, segundosTexto;

    public Pomodoro() {
        super();
        setLayout(new GridLayout(1, 1));
        setBackground(new Color(110, 197, 255));
        contador = new JLabel(0+""+0+":"+0+""+0);
        contador.setFont(new Font("Arial", Font.BOLD, 80));
        contador.setHorizontalAlignment(SwingConstants.CENTER);
        minutos = 0;
        segundos = 0;
        add(contador);
    }


    @Override
    public void run() {
        while (contando) {
            actualizarTiempo();
            try {
                hilo.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void iniciar(){
        if (!contando) {
            contando = true;
            hilo = new Thread(this);
            hilo.start();
            tiempoOriginal = System.nanoTime();
        }
    }

    public void pausar(){
        contando = false;
    }

    public void reiniciar(){
        tiempoOriginal = System.nanoTime();
        minutos = 0;
        segundos = 0;
        actualizarTiempo();
        
    }
    
    public void actualizarTiempo(){
        tiempoTranscurrido = System.nanoTime();
        tiempo = (tiempoTranscurrido - tiempoOriginal) / 1000000000;

        minutos = tiempo / 60;
        if (minutos < 10) {
            minutosTexto = "0"+(int) minutos;
        } else{
            minutosTexto = ""+(int) minutos;
        }

        segundos = tiempo % 60;
        if (segundos < 10) {
            segundosTexto = "0"+(int) segundos;
        } else{
            segundosTexto = ""+(int) segundos;
        }

        finPomodoro();

        contador.setText(minutosTexto+":"+segundosTexto);
    }

    public void finPomodoro(){
        if (minutosTexto.equals("25")) {
            reiniciar();
            pausar();
            SonidoAlarma sonidoAlarma = new SonidoAlarma();
            sonidoAlarma.start();
        }
    }

}
