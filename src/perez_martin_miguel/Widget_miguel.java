package perez_martin_miguel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.InsetsUIResource;

public class Widget_miguel extends JDialog {

    private static final long serialVersionUID = 1L;

    /**
     * atributos
     */
    private Cronometro crono; // temporizador de 60 a 0.
    private JButton botonPalabras; // boton donde se colocaran las palabras.
    private JButton botonMasPalabras; // boton para poder añadir palabras al fichero.
    private Leer_Excribir palabras; // atributo que permite hacer referencia "al fichero" a traves de los atributos
                                    // de diche clase.
    private int posicion; // posicion aleatoria para colocar las palabras.
    private int[] ale; // array de posiciones de palabras aleatorio.
    private boolean contando; // para saber si puedo seguir generando palaabras, o de lo contrario el usuario
                              // quiere ver su significado.
    private int contador; // con este contador contaremos los segundos para generar las palabras.

    private JPanel panelArriba, panelCentro, panelAbajo; // paneles para colocar nuestros obejtos adecuadamente en la
                                                         // ventana.
    private JPanel panelArriba_Der, panelArriba_Izq; // paneles auxiliares para colocar color y el boton de añadir
                                                     // palabras.
    private JLabel significadoPalabra; // atributo en el cual alamcenara el significado de la palabra.
    private JButton botonReanudar = new JButton(); // boton que reanudara el temporizador y dejara cambiar las palabras.

    /**
     * constructor
     */
    public Widget_miguel() {
        // creamos la nueva ventana y le colocamos sus objetos.
        super();
        setModal(true);

        // sacamos la resolucion de la pantalla aproximadamente para hacer nuestra
        // ventana lo mas grande posible.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) screenSize.getWidth();
        int y = (int) (screenSize.getHeight() - 50);

        setBounds(0, 0, x, y);
        setLocationRelativeTo(null);
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

        // inicializamos el componente donde mostraremos el significado de la palabra.
        significadoPalabra = new JLabel();

        // llamada al metodo que fabricara el array de posiciones aleatorias.
        iniciarArray();
        // llamada al metodo el cual pondra una palabra en el boton cada 5 segundos.
        palabrasCincoSeg();

    }

    /**
     * colocamos en la ventana cada objeto.
     */
    public void anadirElemento() {

        setLayout(new GridLayout(3, 1));

        // paneles
        panelArriba = new JPanel();
        panelCentro = new JPanel();
        panelAbajo = new JPanel();

        // panel de arriba
        panelArriba.setBackground(Color.BLACK);
        this.add(panelArriba);

        // le dividimos en 3 columnas.
        panelArriba.setLayout(new GridLayout(1, 3));

        // primera columna con color negro.
        panelArriba_Izq = new JPanel();
        panelArriba_Izq.setBackground(Color.BLACK);

        // tercera columna con color negro.
        panelArriba_Der = new JPanel();
        panelArriba_Der.setBackground(Color.BLACK);

        // añadimos la primera columna.
        panelArriba.add(panelArriba_Izq);

        // añadimos el temporizador (segunda columna).
        crono = new Cronometro();
        crono.comenzar();
        panelArriba.add(crono);

        // añadimos tercera columna.
        panelArriba.add(panelArriba_Der);
        // inicializamos el boton para añadir palabras al fichero y le colocamos en el
        // panel auxiliar a la derecha
        botonMasPalabras = new JButton("Añadir palabras");

        panelArriba_Der.setLayout(new GridBagLayout());
        GridBagConstraints ajusteBotonMas = new GridBagConstraints();
        ajusteBotonMas.gridx = 0;
        ajusteBotonMas.gridy = 0;
        ajusteBotonMas.ipadx = 20;
        ajusteBotonMas.ipady = 20;
        panelArriba_Der.add(botonMasPalabras, ajusteBotonMas);
        botonMasPalabras.setFont(new Font("Arial", Font.BOLD, 15));

        ////////////////////////////////////////////////////////////////////////////////

        // panel del centro.
        this.add(panelCentro);

        panelCentro.setLayout(new GridBagLayout());
        // boton de palabras
        botonPalabras = new JButton();
        GridBagConstraints ajusteBoton = new GridBagConstraints();
        ajusteBoton.gridx = 0;
        ajusteBoton.gridy = 0;
        ajusteBoton.ipadx = 50;
        ajusteBoton.weighty = 1;
        ajusteBoton.fill = GridBagConstraints.BOTH;
        panelCentro.add(botonPalabras, ajusteBoton);
        botonPalabras.setFont(new Font("Comic Sans Ms", Font.ITALIC, 50));

        ////////////////////////////////////////////////////////////////////////////////

        // panel de abajo.
        panelAbajo.setVisible(false);
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(panelAbajo);
        this.add(scroll);
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

        /**
         * al pulsar reanudar empieza a contar el tiempo, contando es verdadero para
         * generar mas palabras, hacemos el panel donde se muestra el significado
         * invisible y quitamos el texto a los JLabel usados para mostrar el
         * significado.
         */
        botonReanudar.addActionListener(e -> {
            crono.comenzar();
            contando = true;
            panelAbajo.setVisible(false);

            significadoPalabra.setText("");
        });

        botonMasPalabras.addActionListener(e -> {
            // paramos el temporizador.
            crono.parar();
            // contando es falso para que no genere mas palabras
            contando = false;
            // llamada a un metodo que pregunta la palabra y su significado.
            añadirNuevaPalabra();
        });
    }

    /**
     * metodo que pregunta la palabra y su significado y se la manda a una clase que
     * escribira una nueva linea en el fichero con estos datos.
     */
    public void añadirNuevaPalabra() {
        String nuevaPalabra = "";
        String significadoNuevaPalabra = "";

        nuevaPalabra = JOptionPane.showInputDialog(this, "Palabra a introducir: ");

        significadoNuevaPalabra = JOptionPane.showInputDialog(this, " Significado de la palabra: ");

        if (!contando) {
            panelAbajo.setVisible(true);
            palabras.escritura(nuevaPalabra, significadoNuevaPalabra);
        }
    }

    /**
     * metodo que rellena las cadenas de la palabra y su significado.
     */
    public void significado() {
        // cadena que mandaremos al metodo encargado de escribirlas
        String cadenaSignificado = "";

        // lista auxiliar para que con la posicion rellenar el significado de la palabra
        // que hemos pulsado.
        ArrayList<String> significadoAux = palabras.getSignificado();
        cadenaSignificado += significadoAux.get(ale[posicion - 1]);

        // si contando es falso hacemos visible el panel de abajo y llamos al metodo que
        // nos dira el significado de la palabra.
        if (!contando) {
            panelAbajo.setVisible(true);
            verSignificado(cadenaSignificado);
        }
    }

    /**
     * muestra en un panel el nombre de la palabra y su significado.
     */
    public void verSignificado(String significado) {

        panelAbajo.setLayout(new GridBagLayout());

        // colocamos el significado.
        significadoPalabra.setText("Significado: " + significado);
        GridBagConstraints ajusteSignificado = new GridBagConstraints();
        ajusteSignificado.gridx = 0;
        ajusteSignificado.gridy = 0;
        ajusteSignificado.insets = new InsetsUIResource(40, 40, 40, 40);
        panelAbajo.add(significadoPalabra, ajusteSignificado);
        significadoPalabra.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        // colocamos el boton de reanudar.
        botonReanudar.setText("Reanudar");
        GridBagConstraints ajusteBotonReanudar = new GridBagConstraints();
        ajusteBotonReanudar.gridx = 0;
        ajusteBotonReanudar.gridy = 1;
        ajusteBotonReanudar.ipadx = 20;
        ajusteBotonReanudar.ipady = 20;
        ajusteSignificado.insets = new InsetsUIResource(40, 40, 40, 40);
        panelAbajo.add(botonReanudar, ajusteBotonReanudar);
        botonReanudar.setFont(new Font("Arial", Font.BOLD, 15));

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

        // utilizamos un random para que cuando se cambie la palabra tambien se cambie
        // el fondo del panel.
        Random rd = new Random();
        panelCentro.setBackground(new Color(rd.nextInt(254), rd.nextInt(254), rd.nextInt(254)));

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

        // Dentro de 0 milisegundos avísame cada 1 milisegundos para que el fallo de
        // sincronizacion sea lo menos posible.
        timer.scheduleAtFixedRate(timerTask, 0, 1);

    }

}