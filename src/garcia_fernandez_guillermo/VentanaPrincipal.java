package garcia_fernandez_guillermo;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {
    
    private JFrame ventana;
    
    private JButton botonTraducir;
    private JButton botonDialogo;

    private JPanel panelTexto;
    private JPanel panelBotones;

    private JTextField introducirPalabra;
    private JTextField texto;
    private JTextField obtenerResultado;
    private JTextField resultado;
	
	/**
     * Constructor, marca el tamaño y el cierre del frame
     */
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 400, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void inicializarComponentes(){
		
		//Definimos el layout:
        ventana.setLayout(new GridLayout(1,2));

        //Panel de la izquierda de la venta junto con todos sus componentes
        panelTexto = new JPanel(new GridLayout(4,1));
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

        //Panel de la derecha de la ventana junto con todos sus componentes
        panelBotones = new JPanel(new GridLayout(2,1));
        ventana.add(panelBotones);

        botonTraducir = new JButton("Español - Inglés");
        panelBotones.add(botonTraducir);

		botonDialogo = new JButton("Palabras disponibles");
		panelBotones.add(botonDialogo);
	
    }
    
    /**
     * Método que realiza todas las llamadas necesarias para inicializar la ventana
     */
    public void inicializar(){
        ventana.setVisible(true);
        inicializarComponentes();
    }
}
