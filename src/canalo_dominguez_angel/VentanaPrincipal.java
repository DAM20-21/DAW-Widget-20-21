package canalo_dominguez_angel;

import javax.swing.JFrame;
import java.awt.*;

public class VentanaPrincipal {

	JFrame ventana;
	MiniEnciclopedia miniEnciclopedia;
	
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 400, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();	
		//inicializarListeners();		
	}

	private void inicializarComponentes() {
		ventana.setLayout(new GridLayout(1,1,0,0));
		miniEnciclopedia=new MiniEnciclopedia();
		ventana.add(miniEnciclopedia);
	}

	
    
}
