package gil_esteban_ivan;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 * Clase que representa un diálogo selector del tipo de censura que queremos
 * aplicar y la visualiza antes de que apliquemos los cambios.
 * 
 * @author Iván Gil Esteban
 * 
 * @version 1.0 
 * @since 1.0 
 */
public class WidgetIvan extends JDialog {

	private static final long serialVersionUID = 1L;

	// Objeto de la clase censura
	Censura censura;

	// JLabel en el que mostramos mensaje al usuario
	JLabel titulo;

	// Slider para elegir censura
	JSlider sliderNivel;

	// BotonAceptar
	JButton bAplicar;

	// BotonPrevisualizar
	JButton bPrevisualizar;

	// Previsualizador de la censura
	JTextArea mostradorPrevisualizar, palabrasTabu;

	// Sera el texto que recibimos para censurar
	JTextArea texto;

	//Constructor de nuestro widget, recibe un componente sobre el que abrimos nuestro dialogo y un texto para censurar
	public WidgetIvan(JComponent componente, JComponent texto) {
		super();
		this.texto = (JTextArea) texto;
		censura = new Censura();
		setModal(true); // PARA HACERLO MODAL
		setBounds((int) componente.getLocationOnScreen().getX(), (int) componente.getLocationOnScreen().getY(), 500,
				700); // Dónde empieza el Dialog y qué tamaño tiene
		anadirElementos();
		anadirListeners();
	}

	/**
	 * Método que añade todos los elementos al Dialog. Se codifica como un JFrame
	 */
	private void anadirElementos() {
		this.setLayout(new GridBagLayout());

		// Titulo
		titulo = new JLabel("Selecciona el nivel de censura:");
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.gridwidth = 2;
		settings.insets = new Insets(20, 0, 50, 0);
		add(titulo, settings);

		sliderNivel = new JSlider(JSlider.HORIZONTAL, 0, 2, 1);
		sliderNivel.setMinorTickSpacing(0);
		sliderNivel.setMajorTickSpacing(1);
		sliderNivel.setPaintTicks(true);
		sliderNivel.setPaintLabels(true);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.gridwidth = 2;
		add(sliderNivel, settings);

		// Mostrador de previsualización de la censura
		mostradorPrevisualizar = new JTextArea();
		mostradorPrevisualizar.setText(texto.getText());
		mostradorPrevisualizar.setEditable(false);
		mostradorPrevisualizar.setLineWrap(true);
		mostradorPrevisualizar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 4;
		settings.gridwidth = 2;
		settings.insets = new Insets(20, 0, 20, 0);
		settings.fill = GridBagConstraints.BOTH;
		add(mostradorPrevisualizar, settings);

		// MostradorPalabasTabu
		palabrasTabu = new JTextArea();
		palabrasTabu.setText(censura.leerMostrarTabu(sliderNivel.getValue()));
		palabrasTabu.setEditable(false);
		palabrasTabu.setLineWrap(true);
		palabrasTabu.setBorder(BorderFactory.createLineBorder(Color.RED));
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 2;
		settings.gridwidth = 2;
		settings.insets = new Insets(20, 0, 20, 0);
		settings.fill = GridBagConstraints.BOTH;
		add(palabrasTabu, settings);

		// bAceptar
		bAplicar = new JButton("Aplicar Cambios");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 3;
		settings.insets = new Insets(20, 0, 20, 5);
		add(bAplicar, settings);

		// bPrevisualizar
		bPrevisualizar = new JButton("Previsualizar");
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 3;
		settings.insets = new Insets(20, 0, 20, 0);
		add(bPrevisualizar, settings);

	}

	/**
	 * Método que añade todos los listeners al Dialogo
	 */
	private void anadirListeners() {
		sliderNivel.addChangeListener(e -> {
			palabrasTabu.setText(censura.leerMostrarTabu(sliderNivel.getValue()));
		});

		bAplicar.addActionListener((e) -> {
			texto.setText(censura.leerPrevisualizar(sliderNivel.getValue(),texto.getText()));
			this.dispose();
		});


		bPrevisualizar.addActionListener((e) -> {
			mostradorPrevisualizar.setText(censura.leerPrevisualizar(sliderNivel.getValue(),texto.getText()));
		});
	}

}