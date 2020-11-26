package fuentes_santiago_javier;

import java.awt.EventQueue;

/**
 * Main para probar el Widget Visor de Imágenes
 * @author Javier Fuentes
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