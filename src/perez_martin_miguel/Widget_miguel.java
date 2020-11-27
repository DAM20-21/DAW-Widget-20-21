package perez_martin_miguel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;

public class Widget_miguel extends JDialog {

    private static final long serialVersionUID = 1L;

    /**
     * atributos
     */
    private Cronometro crono; // temporizador de 60 a 0.
    private JButton botonPalabras; // boton donde se colocaran las palabras.
    private Leer_Excribir palabras; // atributo que permite hacer referencia "al fichero" a traves de los atributos
                                    // de diche clase.
    private int posicion; // posicion aleatoria para colocar las palabras.
    private int[] ale; // array de posiciones de palabras aleatorio.

    /**
     * constructor
     */
    public Widget_miguel() {
        // creamos la nueva ventana y le colocamos sus objetos.
        super();
        setModal(true);
        setBounds(0, 0, 300, 300);
        anadirElemento();

        // inicializamos el atributo que nos permitira poder hacer referencia a la lista
        // creada a partir del fichero
        palabras = new Leer_Excribir();
        palabras.lectura();

        // una posicion para colocar una palabra al azar en el boton.
        posicion = 0;

        // llamada al metodo que fabricara el array de posiciones aleatorias.
        iniciarArray();
        // llamada al metodo el cual pondra una palabra en el boton cada 5 segundos.
        palabrasCincoSeg();

    }

    /**
     * colocamos en la ventana cada objeto.
     */
    public void anadirElemento() {
        // fondo
        getContentPane().setBackground(Color.GREEN);

        setLayout(new GridBagLayout());

        // temporizador
        crono = new Cronometro();
        crono.comenzar();
        GridBagConstraints ajuste = new GridBagConstraints();
        ajuste.gridx = 0;
        ajuste.gridy = 0;
        ajuste.fill = ajuste.BOTH;
        this.add(crono, ajuste);

        // boton de palabras
        botonPalabras = new JButton();
        GridBagConstraints ajusteBoton = new GridBagConstraints();
        ajusteBoton.gridx = 0;
        ajusteBoton.gridy = 1;
        this.add(botonPalabras, ajusteBoton);
    }

    /**
     * 
     */
    public void inicializarListener() {
        botonPalabras.addActionListener(e -> {

        });
    }

    /**
     * metodo que crea un array con posiciones totalemnte aleatorias y sin repetir
     * para, mas tarde sacar una palabra y ponerla en el boton.
     */
    public void iniciarArray() {
        // a este metodo le mandamos el tamaño total del array creado a partir de un
        // fichero.
        ale = Utilidad.aleatorio(palabras.getPalabras());
    }

    /**
     * metodo que coloca una palabra en el boton.
     */
    public void palabrasBoton() {

        // tenemos un array de palabras generado de la lectura de un fichero.
        ArrayList<String> palabrasAux = palabras.getPalabras();
        // colocamos la palabra en el boton, la palabra es una palabra de la lista
        // anterior y su posicion es aleatoria gracias a un array.
        botonPalabras.setText(palabrasAux.get(ale[posicion]));

        // sumamos la posicion con la que sacaremos la palabra del array(creado
        // anteriormente con posiciones aleatorias).
        posicion++;

    }

    /**
     * metodo que lo que hace es cada 5 segundos aproximadamente colocar una nueva
     * palabra en el boton. cuando el contador llega a 0 cierra la ventana.
     */
    public void palabrasCincoSeg() {

        TimerTask timerTask = new TimerTask() {
            public void run() {
                // si posicion llega al final del array de aleatorios, cierra la ventana, sino,
                // sigue cambiando la palabra.
                if (posicion == ale.length) {
                    dispose();
                } else {
                    palabrasBoton();
                }
            }
        };
        // Aquí se pone en marcha el timer cada segundo.
        Timer timer = new Timer();
        // Dentro de 0 milisegundos avísame cada 5050 milisegundos
        timer.scheduleAtFixedRate(timerTask, 0, 5050);

    }

}