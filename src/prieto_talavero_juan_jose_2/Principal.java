package prieto_talavero_juan_jose_2;
import java.awt.EventQueue;

/**
 * Main para probar el Widget
 * @author Juan José Prieto Talavero
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
