    import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionBoton implements ActionListener{
	/**
	 * {@link VentanaPrincipal} que recibirá por parámetros para acceder al control
	 * de juego
	 */
	VentanaPrincipalWidget ventana;
	int i;
	
	/**
	 * Constructor que recibe las variables
	 * @param vPrincipal
	 * @param i
	 */
	public ActionBoton(VentanaPrincipalWidget vPrincipal,int i) {
		this.ventana = vPrincipal;
		this.i = i;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        ventana.listaFICHEROS.get(i).mostrarFichero();
    }
}

