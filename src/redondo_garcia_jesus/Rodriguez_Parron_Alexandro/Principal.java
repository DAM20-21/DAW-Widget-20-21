
import java.awt.EventQueue;


/**
 * @author Alexandro Rodríguez Parrón
 * @version 1.0
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