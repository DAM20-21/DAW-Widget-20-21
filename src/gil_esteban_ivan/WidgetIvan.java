package gil_esteban_ivan;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Clase que representa un diálogo selector del tipo de censura que queremos aplicar
 * y la visualiza antes de que apliquemos los cambios.
 * 
 * @author Iván Gil Esteban
 *
 */
public class WidgetIvan extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	//Objeto de la clase censura
	Censura censura;
	
	//Mensaje que le da al usuario
	JLabel titulo;

	//Sliders:
	JSlider sliderNivel;

	//BotonAceptar
	JButton bAplicar;
	
	//BotonPrevisualizar
	JButton bPrevisualizar;

	//Previsualizador de la censura
	JTextArea mostradorCensura, palabrasTabu;

	//Sera el texto que recibimos para censurar
	JTextArea texto;

	public WidgetIvan(JComponent componente,JComponent texto, Color colorInicial ) {
		super();
		this.texto = (JTextArea) texto;
		setModal(true); // PARA HACERLO MODAL
		setBounds((int)componente.getLocationOnScreen().getX(),(int)componente.getLocationOnScreen().getY(), 300, 500); //Dónde empieza el Dialog y qué tamaño tiene
		anadirElementos();
		anadirListeners();
	}
	
	/**
	 * Método que añade todos los elementos al Dialog. Se codifica como un JFrame
	 */
	private void anadirElementos(){
		this.setLayout(new GridBagLayout());
		
		//PANEL PRINCIPAL
		//Titulo
		titulo = new JLabel("Selecciona el nivel de censura:");
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.gridwidth = 2;
		settings.insets = new Insets(20, 0, 50, 0);
		add(titulo,settings);
		
		sliderNivel = new JSlider(JSlider.HORIZONTAL, 0, 3,1);
		sliderNivel.setMinorTickSpacing(1);
		sliderNivel.setMajorTickSpacing(3);
		sliderNivel.setPaintTicks(true);
		sliderNivel.setPaintLabels(true);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.gridwidth = 2;
		add(sliderNivel,settings);
		
		//MostradorColor:
		mostradorCensura = new JTextArea();
		mostradorCensura.setEditable(false);
		mostradorCensura.setLineWrap(true);
		mostradorCensura.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 4;
		settings.gridwidth = 2;
		settings.insets = new Insets(20, 0, 20, 0);
		settings.fill = GridBagConstraints.BOTH;
		add(mostradorCensura,settings);

		//MostradorPalabasTabu
		mostradorCensura = new JTextArea();
		mostradorCensura.setEditable(false);
		mostradorCensura.setLineWrap(true);
		mostradorCensura.setBorder(BorderFactory.createLineBorder(Color.RED));
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 2;
		settings.gridwidth = 2;
		settings.insets = new Insets(20, 0, 20, 0);
		settings.fill = GridBagConstraints.BOTH;
		add(mostradorCensura,settings);
		
		//bAceptar
		bAplicar = new JButton("Aplicar Cambios");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 3;
		settings.insets = new Insets(20, 0, 20, 5);
		add(bAplicar,settings);

		//bAceptar
		bPrevisualizar = new JButton("Previsualizar");
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 3;
		settings.insets = new Insets(20, 0, 20, 0);
		add(bPrevisualizar,settings);
		
	}
	
	/**
	 * Método que añade todos los listeners al Dialog
	 */
	private void anadirListeners(){
		ChangeListener listenerSliders = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				mostradorCensura.setText(" Como estarias que tal estas en la historia que tenemos un problema con android  ");
			}
	    };
	    sliderNivel.addChangeListener(listenerSliders);
	    //Botón Aceptar:
	    bAplicar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		texto.setText("Hola que tal");
		this.dispose();
	}
}