package sanchez_miguel_ana;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class VentanaPrincipal {
   
	//La ventana principal, en este caso, guarda todos los componentes:
	private JFrame ventana;
	private JButton iniciarSesion;
	//private JPanel panelColor;
	
	/**
     * Constructor, marca el tamaño y el cierre del frame
     */
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 400, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana correctamente.
	 */
	public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();	
	//	inicializarListeners();		
	}
	
	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes(){
        GridBagConstraints settingsOptions = new GridBagConstraints();

		//Definimos el layout:
        ventana.setLayout(new GridLayout());
        
		// Boton iniciar sesion:
        iniciarSesion = new JButton("Pulsa para iniciar sesión");
        settingsOptions = new GridBagConstraints();

        settingsOptions.gridx = 0;
        settingsOptions.gridy = 0;
        settingsOptions.gridheight = 200;
        settingsOptions.gridwidth = 200;
        
		ventana.add(iniciarSesion, settingsOptions);
	
	//	panelColor = new JPanel();
	//	ventana.add(panelColor);
		
	}
	
}
