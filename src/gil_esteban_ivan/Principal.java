package gil_esteban_ivan;

import java.awt.EventQueue;

/**
 * Main para probar el Widget de censura
 * 
 * @author Iván Gil Esteban
 */
public class Principal {

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