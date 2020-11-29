package corrales_santos_sara;

import java.awt.Color;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Clase que implementa la inteface Runnable y extiende de la clase JPanel para la creacion de temporizador de pomodoros
 *@author Sara Corrales Santos 
 */
public class Pomodoro extends JPanel implements Runnable{

    //Atributos de la clase
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

    /**
     * Constructor que inicializa el panel donde irá el temporizador de pomodoros
     */
    public Pomodoro() {
        super();
        setLayout(new GridLayout(1, 1));
        setBackground(new Color(110, 197, 255));
        contador = new JLabel(0 + "" + 0 + ":" + 0 + "" + 0);
        contador.setFont(new Font("Arial", Font.BOLD, 80));
        contador.setHorizontalAlignment(SwingConstants.CENTER);
        minutos = 0;
        segundos = 0;
        add(contador);
    }

    /**
     * Método que se sobreescribe de la clase Thread para iniciar el hilo
     */
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

    /**
     * Método que inicia el temporizador
     */
    public void iniciar() {
        if (!contando) {
            contando = true;
            hilo = new Thread(this);
            hilo.start();
            tiempoOriginal = System.nanoTime();
        }
    }

    /**
     * Método que pausa el temporizador
     */
    public void pausar() {
        contando = false;
    }

    /**
     * Método que reinicia el temporizador poniendolo a 0 de nuevo
     */
    public void reiniciar() {
        contando = false;
        tiempoOriginal = System.nanoTime();
        minutos = 0;
        segundos = 0;
        actualizarTiempo();

    }

    /**
     * Método que actualiza los minutos y segundos del temporizador
     */
    public void actualizarTiempo() {
        tiempoTranscurrido = System.nanoTime();
        tiempo = (tiempoTranscurrido - tiempoOriginal) / 1000000000;

        minutos = tiempo / 60;
        if (minutos < 10) {
            minutosTexto = "0" + (int) minutos;
        } else {
            minutosTexto = "" + (int) minutos;
        }

        segundos = tiempo % 60;
        if (segundos < 10) {
            segundosTexto = "0" + (int) segundos;
        } else {
            segundosTexto = "" + (int) segundos;
        }

        finPomodoro();

        contador.setText(minutosTexto + ":" + segundosTexto);
    }

    /**
     * Método que hace que al llegar los minutos a 25 reinicia el temporizador y hace que suene una alarma para avisar al usuario
     */
    public void finPomodoro() {
        if (minutosTexto.equals("01")) {
            reiniciar();
            SonidoAlarma sonidoAlarma = new SonidoAlarma();
            sonidoAlarma.start();
        }
    }
}
