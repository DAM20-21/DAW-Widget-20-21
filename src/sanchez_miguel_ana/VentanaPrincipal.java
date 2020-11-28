package sanchez_miguel_ana;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.InsetsUIResource;

public class VentanaPrincipal {

	// La ventana principal, en este caso, guarda todos los componentes:
	private JFrame ventana;
	private JFrame ventanaDialog;
	private JPanel panel;
	private JButton iniciarSesion;
	private JLabel usuario;
	private JLabel contraseña;
	private JTextField insertarUsuario;
	private JTextField insertarContra;
	private JButton enviar;
	// private JPanel panelColor;

	/**
	 * Constructor, marca el tamaño y el cierre del frame
	 */
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 400, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana
	 * correctamente.
	 */
	public void inicializar() {
		inicializarComponentes();
		ventana.setVisible(true);
		inicializarListeners();
	}

	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes() {
		GridBagConstraints settingsOptions = new GridBagConstraints();

		// Definimos el layout:
		ventana.setLayout(new GridBagLayout());
		ventana.setBackground(Color.BLUE);

		// Boton iniciar sesion:
		iniciarSesion = new JButton("Pulsa para iniciar sesión");
		settingsOptions = new GridBagConstraints();

		settingsOptions.gridx = 0;
		settingsOptions.gridy = 0;
		settingsOptions.weightx = 10;
		settingsOptions.weighty = 10;
		iniciarSesion.setSize(50, 50);
		ventana.add(iniciarSesion, settingsOptions);

	}

	public void inicializarListeners() {

		iniciarSesion.addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GridBagConstraints settingsOptions = new GridBagConstraints();

				ventanaDialog = new JFrame();
				ventanaDialog.setLayout(new GridBagLayout());

				settingsOptions = new GridBagConstraints();
				settingsOptions.gridy = 0;
				usuario = new JLabel();
				usuario.setText("Introduce usuario: ");

				ventanaDialog.add(usuario, settingsOptions);

				settingsOptions = new GridBagConstraints();
				settingsOptions.gridy = 1;
				settingsOptions.insets = new Insets(5, 0, 0, 0);

				settingsOptions.fill = GridBagConstraints.HORIZONTAL;
				insertarUsuario = new JTextField();
				ventanaDialog.add(insertarUsuario, settingsOptions);

				settingsOptions = new GridBagConstraints();
				settingsOptions.gridy = 2;
				settingsOptions.insets = new Insets(5, 0, 0, 0);

				contraseña = new JLabel();
				contraseña.setText("Introduce la contraseña: ");
				ventanaDialog.add(contraseña, settingsOptions);

				settingsOptions = new GridBagConstraints();
				settingsOptions.gridy = 3;
				settingsOptions.fill = GridBagConstraints.HORIZONTAL;
				settingsOptions.insets = new Insets(5, 0, 0, 0);

				insertarContra = new JTextField();
				
				ventanaDialog.add(insertarContra, settingsOptions);

				ventanaDialog.setVisible(true);
				ventanaDialog.setBounds(100, 100, 400, 400);

				settingsOptions = new GridBagConstraints();
				settingsOptions.gridy = 4;
				settingsOptions.insets = new Insets(60, 0, 0, 0);
				enviar = new JButton();
				enviar.setText("Enviar");

				ventanaDialog.add(enviar, settingsOptions);
			}
		});
	}
}