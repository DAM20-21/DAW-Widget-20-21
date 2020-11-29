package crespo_cobos_alejandro;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ventana Principal para probar el widget Selector de Color
 * 
 * @author Jesús Redondo García
 */
public class VentanaPrincipal {

        // La ventana principal, en este caso, guarda todos los componentes:
        private JFrame ventana;
        TornaWeather tornaWidget = new TornaWeather();

        private JButton botonBuscar;
        private ImageIcon imagenIcono;

        private JTextField ciudad;
        private JTextField informacion;
        private JLabel imagenes;

        private JPanel panelInfo;
        private JPanel panelImagenes;
        private JPanel panelCiudades;

        

        /**
         * Constructor, marca el tamaño y el cierre del frame
         */
        public VentanaPrincipal() {
                ventana = new JFrame();
                ventana.setBounds(300, 150, 500, 300);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        /**
         * Método que inicializa todos los componentes de la ventana
         */
        public void inicializarComponentes() {

                

                // Definimos el layout:
                GridBagLayout gbl = new GridBagLayout();
                GridBagConstraints opc = new GridBagConstraints();
                ventana.getContentPane().setLayout(gbl);

                // Panel info
                panelInfo = new JPanel();
                opc.gridx = 0;
                opc.gridy = 0;
                opc.anchor = GridBagConstraints.NORTH;
                opc.weightx= 1;
                opc.weighty= 1;

                opc.fill = GridBagConstraints.BOTH;
                panelInfo.setBorder(BorderFactory.createTitledBorder("Buscador"));
                ventana.getContentPane().add(panelInfo, opc);

                // text Field Ciudad (Panel info)
                opc = new GridBagConstraints();
                ciudad = new JTextField();
                ciudad.setSize(105, 30);
                ciudad.setText("Busca un pueblo del Valle del Jerte");
                ciudad.setOpaque(true);
                ciudad.setEditable(true);
                ciudad.setEditable(true);
                opc.gridx = 0;
                opc.gridy = 0;
                opc.fill = GridBagConstraints.HORIZONTAL;
                panelInfo.add(ciudad, opc);

                // BOTON BUscar ( Panel info)
                opc = new GridBagConstraints();
                botonBuscar = new JButton(new ImageIcon("img/lupa.png"));
                opc.gridx = 1;
                opc.gridy = 0;
                panelInfo.add(botonBuscar, opc);
                // añado todos mis cambios a la ventana

                opc = new GridBagConstraints();
                opc.gridx = 0;
                opc.gridy = 1;
                opc.weightx = 5;
                opc.weighty = 5;
                opc.fill = GridBagConstraints.BOTH;
                tornaWidget.setBorder(BorderFactory.createTitledBorder("TornaWeather"));
                ventana.getContentPane().add(tornaWidget, opc);
        }
        

        
    

        /**
         * Método que inicializa todos los listeners del programa.
         */
        public void inicializarListeners() {
                botonBuscar.addActionListener((e) -> {
                        tornaWidget.comprobarPueblos(ciudad);
                        tornaWidget.comprobarImagen(ciudad);
                        refrescarPantalla();
                        
                });
        }

        /**
         * Metodo reutilizado
         */
        public void refrescarPantalla() {
		ventana.revalidate();
		ventana.repaint();
	}

        /**
         * Método que realiza todas las llamadas necesarias para inicializar la ventana
         * correctamente.
         */
        public void inicializar() {
                ventana.setVisible(true);
                tornaWidget.CrearObjetosTiempo();
                tornaWidget.anadirImagenes();
                inicializarComponentes();
                inicializarListeners();        
        }
}