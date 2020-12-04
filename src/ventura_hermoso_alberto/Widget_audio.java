package ventura_hermoso_alberto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que contiene la interfaz
 * 
 * @author Alberto Ventura Hermoso
 */
public class Widget_audio {
    private JFrame ventana;
    private JPanel panel_botones;
    private JButton boton_seleccion_archivo, boton_pausa, boton_play;
    private ImageIcon imagen_icono;
    private Acciones_Botones acciones;

    /**
     * Constructor de la clase
     */
    public Widget_audio() {
        ventana = new JFrame("Reproductor_Alberto");
        ventana.setBounds(100, 100, 550, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        acciones = new Acciones_Botones();
    }

    /**
     * Método para inicializar los componentes
     */
    public void inicializarComnponentes() {
        panel_botones = new JPanel();
        panel_botones.setLayout(new GridLayout(1, 3));
        boton_seleccion_archivo = new JButton();
        boton_pausa = new JButton();
        boton_play = new JButton();

        GridBagConstraints settings = null;

        // BOTON_SELECCION_ARCHIVO
        CrearBotones(0, 0, settings, boton_seleccion_archivo, "img/archivo.png");
        // BOTON_PAUSA
        CrearBotones(1, 0, settings, boton_pausa, "img/pause.png");
        // BOTON_PLAY
        CrearBotones(2, 0, settings, boton_play, "img/play.png");
        boton_play.setEnabled(false);
        boton_pausa.setEnabled(false);
        ventana.add(panel_botones);
    }

    /**
     * Metodo para inicializar los Listener
     */
    public void inicilalizarListener() {
        boton_seleccion_archivo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boton_play.setEnabled(false);
                acciones.selecionFichero();
                boton_seleccion_archivo.setEnabled(false);
                boton_pausa.setEnabled(true);
            }
        });

        boton_pausa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acciones.pause();
                boton_play.setEnabled(true);
                boton_pausa.setEnabled(false);
                boton_seleccion_archivo.setEnabled(true);
            }
        });

        boton_play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acciones.play();
                boton_play.setEnabled(false);
                boton_pausa.setEnabled(true);
                boton_seleccion_archivo.setEnabled(false);

            }
        });

    }

    /**
     * Método para inicializar los componentes y hacer visible la ventana
     */
    public void inicializar() {
        inicializarComnponentes();
        inicilalizarListener();
        ventana.setVisible(true);

    }

    /**
     * Método utilizado para crear los botones del reproductor
     * 
     * @param gridx
     * @param gridy
     * @param settings
     * @param boton
     * @param ruta_icono
     */
    public void CrearBotones(int gridx, int gridy, GridBagConstraints settings, JButton boton, String ruta_icono) {
        settings = new GridBagConstraints();
        settings.gridx = gridx;
        settings.gridy = gridy;
        imagen_icono = new ImageIcon(ruta_icono);
        boton.setIcon(imagen_icono);
        panel_botones.add(boton, settings);
    }

    // GETTERS Y SETTERS
    public JButton getBoton_pausa() {
        return this.boton_pausa;
    }

    public void setBoton_pausa(JButton boton_pausa) {
        this.boton_pausa = boton_pausa;
    }

    public JButton getBoton_play() {
        return this.boton_play;
    }

    public void setBoton_play(JButton boton_play) {
        this.boton_play = boton_play;
    }

    public JFrame getVentana() {
        return this.ventana;
    }

    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }

    public JButton getBoton_seleccion_archivo() {
        return this.boton_seleccion_archivo;
    }

    public void setBoton_seleccion_archivo(JButton boton_seleccion_archivo) {
        this.boton_seleccion_archivo = boton_seleccion_archivo;
    }

}
