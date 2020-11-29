package garcia_fernandez_guillermo;

import java.awt.EventQueue;

/**
 * Clase principal del traductor
 * @author Guillermo García Fernández
 * @version 1.0
 */
public class Principal {
	
	/**
	 * Método main
	 * @param args : Cadenas de parámetros del main
	 */
    public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.inicializar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});	
	}
}
