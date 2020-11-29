package bonifacio_hernandez_javier;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

/**
 * Ventana Principal para probar el widget Selector de Formato de Texto
 * @author Javier Bonifacio Hernandez
 */
public class VentanaPrincipal {

	private final static String TEXTO="Cambiame el formato";
	
	//La ventana principal, en este caso, guarda todos los componentes:
	private JFrame ventana;
	private int tamañoFuente;
    private int alineacion;
	private int colorLetra;

	public JFrame getVentana() {
		return this.ventana;
	}

	public void setVentana(JFrame ventana) {
		this.ventana = ventana;
	}

	public int getTamañoFuente() {
		return this.tamañoFuente;
	}

	public void setTamañoFuente(int tamañoFuente) {
		this.tamañoFuente = tamañoFuente;
	}

	public int getAlineacion() {
		return this.alineacion;
	}

	public void setAlineacion(int alineacion) {
		this.alineacion = alineacion;
	}

	public int getColorLetra() {
		return this.colorLetra;
	}

	public void setColorLetra(int colorLetra) {
		this.colorLetra = colorLetra;
	}

	public JButton getBDialogo() {
		return this.bDialogo;
	}

	public void setBDialogo(JButton bDialogo) {
		this.bDialogo = bDialogo;
	}

	public JPanel getPanelFuente() {
		return this.panelFuente;
	}

	public void setPanelFuente(JPanel panelFuente) {
		this.panelFuente = panelFuente;
	}

	public JLabel getJLabelFuente() {
		return this.jLabelFuente;
	}

	public void setJLabelFuente(JLabel jLabelFuente) {
		this.jLabelFuente = jLabelFuente;
	}
	
	private JButton bDialogo;
    private JPanel panelFuente;
    private JLabel jLabelFuente;
	
	/**
     * Constructor, marca el tamaño y el cierre del frame
     */
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 400, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes(){
		
		//Definimos el layout:
		ventana.setLayout(new GridLayout(1,2));
		
        bDialogo = new JButton("Selecciona la Fuente");
		ventana.add(bDialogo);
	
		panelFuente = new JPanel(new GridLayout(1,1));
        panelFuente.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        ventana.add(panelFuente);

        jLabelFuente=new JLabel(TEXTO,SwingConstants.CENTER);
        panelFuente.add(jLabelFuente);
		
	}
	
	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners(){
		bDialogo.addActionListener(e->{
			widgetFormatoTexto dialog = new widgetFormatoTexto(bDialogo, panelFuente.getBackground());
			dialog.setVisible(true);
				
		});

		cambioFormato();
		
	}
	

	private void cambioFormato() {
		//jLabelFuente.setFont(new FontUIResource(TEXTO,Font.BOLD,tamañoFuente));
	}

	/**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana
	 * correctamente.
	 */
	public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();	
		inicializarListeners();		
	}
}