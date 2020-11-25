package gil_esteban_ivan;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Ventana Principal para probar el widget Selector de Color
 * @author Jesús Redondo García
 */
public class VentanaPrincipal {

	
	//La ventana principal, en este caso, guarda todos los componentes:
	private JFrame ventana;
	private JButton bDialogo;
	private JPanel panelColor;
	
	/**
     * Constructor, marca el tamaño y el cierre del frame
     */
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 400, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes(){
		
		//Definimos el layout:
		ventana.setLayout(new GridLayout(1,2));
		
		bDialogo = new JButton("Selecciona Color");
		ventana.add(bDialogo);
	
		panelColor = new JPanel();
		ventana.add(panelColor);
		
	}
	
	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners(){
		bDialogo.addActionListener(e->{
			WidgetIvan dialog = new WidgetIvan(bDialogo, panelColor.getBackground());
			dialog.setVisible(true);
			dialog.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent arg0) {
					
				}
			});	
		});
		
	}
	

	/**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana correctamente.
	 */
	public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();	
		inicializarListeners();		
	}
}