package crespo_cobos_alejandro;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ventana Principal para probar el widget Selector de Color
 * @author Jesús Redondo García
 */
public class VentanaPrincipal {

	
	//La ventana principal, en este caso, guarda todos los componentes:
    private JFrame ventana;
    
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
		ventana.setBounds(300, 150, 500, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
        
        
	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes(){
		
        //Definimos el layout:
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints opc = new GridBagConstraints();
        ventana.getContentPane().setLayout(gbl);

        //Panel info
        panelInfo = new JPanel(new GridLayout(1,1));
        opc.gridx = 0;
        opc.gridy = 0;
        /* opc.weightx = 1;
        opc.weighty = 1;
        opc.fill = GridBagConstraints.BOTH; */
        

        //text Field Ciudad (Panel info)
        opc = new GridBagConstraints();
        ciudad = new JTextField("BUSCA LA CIUDAD");
        ciudad.setOpaque(true);
        ciudad.setEditable(true);
        ciudad.setEditable(true);
        opc.gridx = 0;
        opc.gridy = 0;
       
       /*  opc.weighty = 4;
        opc.weightx = 1; */
        /* opc.fill = GridBagConstraints.HORIZONTAL; */
        panelInfo.add(ciudad, opc);

        //BOTON BUscar ( Panel info)
        opc = new GridBagConstraints();
        botonBuscar = new JButton("BUSCAR");
        opc.gridx = 1;
        opc.gridy = 0;
        panelInfo.add(botonBuscar, opc);
        //añado todos mis cambios a la ventana
        ventana.getContentPane().add(panelInfo, opc); 

/*         //Panel de ciudades 
        opc = new GridBagConstraints();
        panelCiudades = new JPanel(new GridLayout(1,1));
        opc.gridx = 0;
        opc.gridy = 1;
        opc.weightx = 2;
        opc.weighty = 2;
        opc.fill = GridBagConstraints.BOTH; */

        //TExto de cuidades y caracteristas del dia
        /* opc = new GridBagConstraints();
        informacion = new JTextField("BUSCA LA CIUDAD");
        informacion.setOpaque(true);
        informacion.setEnabled(true);
        informacion.setEditable(false);
       
        opc.gridx = 0;
        opc.gridy = 1;
        opc.fill = GridBagConstraints.HORIZONTAL;
        panelCiudades.setBorder(BorderFactory.createEmptyBorder(80, 30, 80, 30));
        panelCiudades.add(informacion, opc);
        ventana.getContentPane().add(panelCiudades, opc);

        
        opc = new GridBagConstraints();
        panelImagenes = new JPanel(new GridLayout(1,1));
        opc.gridx = 1;
        opc.gridy = 1;
        opc.weightx = 2;
        opc.weighty = 2;
        opc.fill = GridBagConstraints.BOTH;

        opc = new GridBagConstraints();
        imagenes = new JLabel(new ImageIcon("src/imagenes/sol.png"));
        opc.gridx= 1;
        opc.gridy = 1;
        
        
        panelImagenes.add(imagenes, opc);
        ventana.getContentPane().add(panelImagenes, opc);
 */



        

		
	}
	
	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners(){
		
		
	}
	

	/**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana correctamente.
	 */
	public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();	
		//inicializarListeners();		
	}
}