

/**
 * @author Alexandro Rodríguez Parrón
 * @version 1.0
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class VentanaPrincipal {
    

    private JFrame ventana;
	private JButton rellenarFormulario;
	
	/**
     * Constructor, marca el tamaño y el cierre del frame
     */
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(0, 0, 400, 200);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();	
		inicializarListeners();		
    }
	
	/**
	 * Método que crea un botón y lo añade a la ventana
	 */
    public void inicializarComponentes(){
        rellenarFormulario = new JButton("Rellenar Formulario");
        ventana.setLayout(new GridLayout());
        ventana.add(rellenarFormulario);
	}
	
	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners(){
        rellenarFormulario.addActionListener((e)->{
            Widgets_Formulario wF = new Widgets_Formulario(ventana);
            wF.setVisible(true);
        });
    }
		

}
