package gil_esteban_ivan;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Ventana Principal para probar el widget de censura
 * 
 * @author Iván Gil Esteban
 *   
 * @version 1.0 
 * @since 1.0 
 */
public class VentanaPrincipal {

	// La ventana principal, en este caso, guarda todos los componentes:
	private JFrame ventana;
	private JButton botonCensura;
	private JPanel panelTexto;
	private JTextArea texto;
	private WidgetIvan dialog;

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
	public void inicializarComponentes() {

		// Definimos el layout:
		ventana.setLayout(new GridBagLayout());

		texto = new JTextArea();
		texto.setLineWrap(true);

		botonCensura = new JButton("Configurar Censura");
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.insets = new Insets(20, 0, 0, 0);
		ventana.add(botonCensura, settings);

		panelTexto = new JPanel();
		panelTexto.setLayout(new GridLayout());
		panelTexto.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		panelTexto.add(texto);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 6;
		settings.weighty = 6;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelTexto, settings);

	}

	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners() {
		botonCensura.addActionListener(e -> {
			if (!texto.getText().isEmpty()) {
				dialog = new WidgetIvan(botonCensura, texto);
				dialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(ventana, "Debes introducir al menos 1 caracter", "Texto vacio", JOptionPane.WARNING_MESSAGE);
			}
		});

	}

	/**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana
	 * correctamente.
	 */
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
}