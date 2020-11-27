package perez_martin_miguel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

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
    private boolean contando; // para saber si puedo seguir generando palaabras, o de lo contrario el usuario
                              // quiere ver su significado.
    private int contador; // con este contador contaremos los segundos para generar las palabras.

    /**
     * constructor
     */
    public Widget_miguel() {
        // creamos la nueva ventana y le colocamos sus objetos.
        super();
        setModal(true);
        setBounds(0, 0, 300, 300);
        anadirElemento();
        inicializarListener();

        // inicializamos el atributo que nos permitira poder hacer referencia a la lista
        // creada a partir del fichero
        palabras = new Leer_Excribir();
        palabras.lectura();

        // una posicion para colocar una palabra al azar en el boton.
        posicion = 0;
        // contador empieza en 0.
        contador = 0;
        // contando empieza en false.
        contando = false;

        // llamada al metodo que fabricara el array de posiciones aleatorias.
        iniciarArray();
        // llamada al metodo el cual pondra una palabra en el boton cada 5 segundos.
        palabrasCincoSeg();

    }

    /**
     * colocamos en la ventana cada objeto.
     */
    public void anadirElemento() {

        setLayout(new GridBagLayout());

        // fondo
        getContentPane().setBackground(Color.GREEN);

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
     * metodo nos indica que hacer cuando se pulsa el boton.
     */
    public void inicializarListener() {
        botonPalabras.addActionListener(e -> {
            // paramos el temporizador.
            crono.parar();
            // contando es falso para que no genere mas palabras
            contando = false;
            // llamada a un metodo para saber el significado de la palabra
            significado();
        });
    }

    /**
     * metodo que rellena las cadenas de la palabra y su significado.
     */
    public void significado() {
        // cadenas que mandaremos al metodo encargado de escribirlas
        String cadenaPalabra = "";
        String cadenaSignificado = "";

        // lista auxiliar para con la posicion rellenar la palabra en la que hemos
        // pinchado.
        ArrayList<String> palabrasAux = palabras.getPalabras();
        cadenaPalabra += palabrasAux.get(ale[posicion - 1]);

        // lista auxiliar para que con la posicion rellenar el significado de la palabra
        // que hemos pulsado.
        ArrayList<String> significadoAux = palabras.getSignificado();
        cadenaSignificado += significadoAux.get(ale[posicion - 1]);

        verSignificado(cadenaPalabra, cadenaSignificado);
    }

    /**
     * muestra una ventana con un mensaje de la palabra y su significado.
     */
    public void verSignificado(String palabra, String significado) {
        String cadena = "";
        cadena += "Palabra: " + palabra + "\n";
        cadena += "Significado: " + significado + "\n";

        JOptionPane.showMessageDialog(this, cadena, "Informacion", JOptionPane.INFORMATION_MESSAGE);

        crono.comenzar();
        contando = true;
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
        // generamos la primera palabra.
        palabrasBoton();

        // ponemos contando a true para empezar.
        contando = true;

        TimerTask timerTask = new TimerTask() {
            public void run() {
                // si contando es verdadero.
                if (contando) {
                    // si los segundos son 0 se cierra la ventana
                    // sigue cambiando la palabra.
                    if (crono.getSegundos() == 0) {
                        dispose();
                    } else {
                        // si contador es 5 significa que han pasado 5 segundos entonces ponemos
                        // contador a 0 para volver a contar hasta 5.
                        // y generamos otra nueva palabra.
                        if (contador == 5) {
                            contador = 0;
                            palabrasBoton();
                        } else {
                            // si contador no es 5 aumentamos el contador cada 1 segundo.
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            contador++;
                        }
                    }

                }

            }
        };

        // Aquí se pone en marcha el timer cada segundo.
        Timer timer = new Timer();

        // Dentro de 0 milisegundos avísame cada 50 milisegundos para que el fallo de
        // sincronizacion sea poco.
        timer.scheduleAtFixedRate(timerTask, 0, 50);

    }

}