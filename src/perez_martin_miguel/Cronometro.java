package perez_martin_miguel;

import java.awt.Color;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cronometro extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;

    /**
     * atributos
     */
    JLabel contador; // contador que cambiara cada segundo.
    int segundos; // numero para disminuir los segundos
    Thread hilo = null; // hilo que funciona como lanzador para empezar a contar el tiempo.
    boolean contando = false; // si es verdadero seguiremos actualizando el tiempo y la pantalla.

    /**
     * constructor donde inicializamos los atributos, hacemos un poco vistoso el
     * panel y añadimos los objetos necesarios.
     */
    public Cronometro() {
        super();
        setBackground(Color.CYAN);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        setLayout(new GridBagLayout());
        contador = new JLabel();
        add(contador);
        contador.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 100));

        segundos = 60;
    }

    // metodo que retorna los segundos
    public int getSegundos() {
        return this.segundos;
    }

    /**
     * metodo que llamaremos para que se lance el hilo y empiece nuestro
     * temporizador.
     */
    public void comenzar() {
        if (hilo == null) {
            hilo = new Thread(this);
            hilo.start();
        }
    }

    // metodo que pone contando a falso para que el temporizador deje de
    // actualizarse.
    public void parar() {
        contando = false;
    }

    /**
     * metodo que se ejecuta mientras contando sea true (de 60 a 0) con un retardo
     * de 1 segundo para actualizar el tiempo y la pantalla.
     */
    @Override
    public void run() {
        contando = true;
        while (contando) {
            // esperamos 1 segundo.
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // actualizamos los segundos.
            calcularTiempoTranscurrido();
            // actualizamos la pantalla.
            actualizarPantalla();
        }
        hilo = null;
    }

    /**
     * metodo que actualiza los segundos.
     */
    private void calcularTiempoTranscurrido() {
        /**
         * si los segundos son 0 dejamos de contar al poner contado a falso, si no son 0
         * restamos un segundo.
         */
        if (segundos <= 0) {
            contando = false;
        } else {
            segundos--;
        }
    }

    /**
     * actualizamos la pantalla pasando los segundo a cadena cambiando el texto del
     * contador.
     */
    private void actualizarPantalla() {
        contador.setText(Integer.toString(segundos));
    }

}
