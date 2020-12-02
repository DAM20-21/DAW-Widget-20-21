import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ActionBoton implements ActionListener{
	/**
	 * {@link VentanaPrincipal} que recibirá por parámetros para acceder al 
	 */
	VentanaPrincipalWidget ventana;
	int i;
	int tipoBoton;
	
	/**
	 * Constructor que recibe las variables
	 * @param vPrincipal
	 * @param i
	 */
	public ActionBoton(VentanaPrincipalWidget vPrincipal,int i,int tipo) {
		this.ventana = vPrincipal;
		this.i = i;
		this.tipoBoton = tipo;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
		Fichero f = ventana.listaFICHEROS.get(i);
		File fich = ventana.listaFICHEROS.get(i).getDir();  
		switch(tipoBoton){
			case 1:{ 
				fich.delete();
				f.mostrarFichero();
				f.anadirCarpeta(); 
				break;
			}
			case 2:{
				fich.delete(); 
				ventana.repintar();
				break;
			}
		}
		
	}
}

