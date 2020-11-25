package gil_martin_ivan;
import java.awt.EventQueue;
/**
 * Main para probar el Widget Temporizador
 * @author Iván Gil Martín
 */
public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				//VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				//ventanaPrincipal.inicializarVentana();
				IvanTemporizador temp = new IvanTemporizador();
				temp.probar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});	
	}
}