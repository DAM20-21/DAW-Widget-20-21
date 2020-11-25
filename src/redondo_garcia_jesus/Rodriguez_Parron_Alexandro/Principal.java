package redondo_garcia_jesus.Rodriguez_Parron_Alexandro;

import java.awt.EventQueue;

/**
 * Principal
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