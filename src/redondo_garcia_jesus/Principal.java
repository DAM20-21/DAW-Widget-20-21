package redondo_garcia_jesus;
import java.awt.EventQueue;

/**
 * Main para probar el Widget Selector de Color
 * @author Jesús Redondo García
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