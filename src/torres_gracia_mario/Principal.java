

import java.awt.EventQueue;

/**
 * Main para probar el Widget Panel de Sonidos de Animales
 * @author Mario Gracia Torres
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