package crespo_cobos_alejandro;

import java.awt.EventQueue;

/**
 * Main para comprobar el tiempo en el valle del jerte.
 * @author Alejandro Crespo Cobos
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