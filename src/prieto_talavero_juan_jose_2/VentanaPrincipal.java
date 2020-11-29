package prieto_talavero_juan_jose_2;


import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * Ventana principal del programa
 * @author Juan José Prieto Talavero
 */
public class VentanaPrincipal {
    //La ventana principal, en este caso, guarda todos los componentes:
	private JFrame ventana;
	private WidgetJotaHoraActual widget;
	
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
		ventana.setLayout(new GridLayout(1,1));
        widget = new WidgetJotaHoraActual();
        ventana.add(widget);
	}
	
	/**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana correctamente.
	 */
	public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();			
	}
}

