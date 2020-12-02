package garcia_fernandez_guillermo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana principal del widget
 * @author Guillermo García Fernández
 * @version 1.0
 */
public class VentanaPrincipal {

    //Definimos todos los componentes de la ventana principal
    private JFrame ventana;
    private JPanel panelTexto;
    private JPanel panelBotones;
    private JTextField introducirPalabra;
    private JTextField texto;
    private JTextField obtenerResultado;
    private JTextField resultado;

    //Botones del widget
    private JButton botonTraducir;
    private JButton botonDialogo;

    //Objeto de la clase en la que se realiza la traduccion
    private WidgetGuillermo traductor;

    //Diálogo para mostrar las palabras disponibles para traducir
    private JTextArea textoPalDisponibles;
    private JScrollPane scrollPalabras;

    /**
     * Constructor, marca el tamaño y el cierre del frame
     */
    public VentanaPrincipal() {
        ventana = new JFrame();
        ventana.setBounds(100, 50, 400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void inicializarComponentes() {

        // Definimos el layout:
        ventana.setLayout(new GridLayout(1, 2));

        // Panel de la izquierda de la venta junto con todos sus componentes
        panelTexto = new JPanel(new GridLayout(4, 1));
        ventana.add(panelTexto);

        introducirPalabra = new JTextField("Introduzca la palabra a traducir: ");
        introducirPalabra.setEditable(false);
        panelTexto.add(introducirPalabra);

        texto = new JTextField();
        texto.setEditable(true);
        panelTexto.add(texto);

        obtenerResultado = new JTextField("Resultado: ");
        obtenerResultado.setEditable(false);
        panelTexto.add(obtenerResultado);

        resultado = new JTextField();
        resultado.setEditable(false);
        panelTexto.add(resultado);

        // Panel de la derecha de la ventana junto con todos sus componentes
        panelBotones = new JPanel(new GridLayout(2, 1));
        ventana.add(panelBotones);

        botonTraducir = new JButton("Español - Inglés");
        panelBotones.add(botonTraducir);

        botonDialogo = new JButton("Palabras disponibles");
        panelBotones.add(botonDialogo);

        // Dialogo con las palabras disponibles
        textoPalDisponibles = new JTextArea();
        scrollPalabras = new JScrollPane(textoPalDisponibles);
        textoPalDisponibles.setEditable(false);
        //textoPalDisponibles.setLineWrap(true);
        textoPalDisponibles.setWrapStyleWord(true);
        scrollPalabras.setPreferredSize(new Dimension(500,500));

        // Inicializamos un objeto de la clase WidgetGuillermmo para traducir
        traductor = new WidgetGuillermo(texto, resultado, textoPalDisponibles);
    }

    /**
     * Método que inicializa todos los listeners del programa
     */
    public void inicializarListeners() {
        botonTraducir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                traductor.traducirPalabras();
            }
        });

        botonDialogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                traductor.mostrarPalabrasDisponibles();
                JOptionPane.showMessageDialog(null, scrollPalabras, "Palabras disponibles", JOptionPane.DEFAULT_OPTION);
            }
        });
    }
    
    /**
     * Método que realiza todas las llamadas necesarias para inicializar la ventana
     */
    public void inicializar(){
        ventana.setVisible(true);
        inicializarComponentes();
        inicializarListeners();
    }

    //Getters para trabajar con los componentes en otras clases
    public JFrame getVentana() {
        return this.ventana;
    }

    public JButton getBotonTraducir() {
        return this.botonTraducir;
    }

    public JButton getBotonDialogo() {
        return this.botonDialogo;
    }

    public JPanel getPanelTexto() {
        return this.panelTexto;
    }

    public JPanel getPanelBotones() {
        return this.panelBotones;
    }

    public JTextField getIntroducirPalabra() {
        return this.introducirPalabra;
    }

    public JTextField getTexto() {
        return this.texto;
    }

    public JTextField getObtenerResultado() {
        return this.obtenerResultado;
    }

    public JTextField getResultado() {
        return this.resultado;
    }

    public WidgetGuillermo getTraductor() {
        return this.traductor;
    }

    public JTextArea getTextoPalDisponibles() {
        return this.textoPalDisponibles;
    }

    public JScrollPane getScrollPalabras() {
        return this.scrollPalabras;
    }

}
