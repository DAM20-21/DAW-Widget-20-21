package sanchez_miguel_ana;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.InsetsUIResource;

public class VentanaPrincipal {

	// La ventana principal, en este caso, guarda todos los componentes:
	private JFrame ventana;
	private JFrame ventanaDialog;
	private JButton iniciarSesion;
	private JLabel usuario;
	private JLabel contraseña;
	private JTextField insertarUsuario;
	private JTextField insertarContra;
	private JButton enviar;

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

		// Boton iniciar sesion:
		iniciarSesion = new JButton("Pulsa para iniciar sesión");
		settingsOptions = new GridBagConstraints();

		settingsOptions.gridx = 0;
		settingsOptions.gridy = 0;
		iniciarSesion.setSize(50, 50);
		ventana.add(iniciarSesion, settingsOptions);

	}

	/**
	 * Método que inicializa los Listeners.
	 */

	public void inicializarListeners() {

		iniciarSesion.addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GridBagConstraints settingsOptions = new GridBagConstraints();

				// CREAMOS LA NUEVA VENTANA DE INTRODUCIR EL LOG-IN
				ventanaDialog = new JFrame();
				ventanaDialog.setLayout(new GridBagLayout());

				settingsOptions = new GridBagConstraints();
				settingsOptions.gridy = 0;

				// CREAMOS EL TEXTO USUARIO
				usuario = new JLabel();
				usuario.setText("Introduce usuario: ");
				ventanaDialog.add(usuario, settingsOptions);

				// CREAMOS PARA INTRODUCIR EL USUARIO
				settingsOptions = new GridBagConstraints();
				settingsOptions.gridy = 1;
				settingsOptions.insets = new Insets(5, 0, 0, 0);

				settingsOptions.fill = GridBagConstraints.HORIZONTAL;
				insertarUsuario = new JTextField();
				ventanaDialog.add(insertarUsuario, settingsOptions);

				// CREAMOS EL TEXTO PARA LA CONTRASEÑA
				settingsOptions = new GridBagConstraints();
				settingsOptions.gridy = 2;
				settingsOptions.insets = new Insets(5, 0, 0, 0);

				contraseña = new JLabel();
				contraseña.setText("Introduce la contraseña: ");
				ventanaDialog.add(contraseña, settingsOptions);

				// CREAMOS PARA INTRODUCIR LA CONTRASEÑA
				settingsOptions = new GridBagConstraints();
				settingsOptions.gridy = 3;
				settingsOptions.fill = GridBagConstraints.HORIZONTAL;
				settingsOptions.insets = new Insets(5, 0, 0, 0);

				insertarContra = new JTextField();

				ventanaDialog.add(insertarContra, settingsOptions);

				// HACEMOS VISIBLE LA VENTANA Y LE DAMOS UN TAMAÑO
				ventanaDialog.setVisible(true);
				ventanaDialog.setBounds(100, 100, 400, 400);

				// INTRODUCIMOS UN BOTON PARA ENVIAR LOS DATOS
				settingsOptions = new GridBagConstraints();
				settingsOptions.gridy = 4;
				settingsOptions.insets = new Insets(60, 0, 0, 0);
				enviar = new JButton();
				enviar.setText("Enviar");

				enviar.addMouseListener(new MouseInputAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// ESTABLECEMOS LA CONEXIÓN

						Connection conexion = WidgetAna.getConexion("mysql");

						// SACAMOS DE LOS CUADROS DE TEXTO EL USUARIO Y LA CONTRASEÑA
						String usuarioIntroducido = insertarUsuario.getText();
						String pass = insertarContra.getText();

						// PREGUNTAMOS A LA BASE DE DATOS SI EXISTE EL USUARIO CUYO NOMBRE COINCIDE CON
						// EL INTRODUCIDO POR EL CUADRO
						String consulta = "SELECT * FROM USUARIO WHERE NOMBRE = '" + usuarioIntroducido + "'";

						// SENTENCIA SQL
						Statement st;

						try {
							st = conexion.createStatement();
							// EJECUTAMOS LA CONSULTA SQL
							ResultSet rs = st.executeQuery(consulta);

							// SI EL USUARIO EXISTE
							if (rs.next()) {
								// SE COMPRUEBA QUE COINCIDA LA CONTRASEÑA CON LA DEL USUARIO.
								if (pass.equalsIgnoreCase(rs.getString(2))) {
									JOptionPane.showMessageDialog(ventanaDialog, "Acceso concedido.",
											"Log-in correcto.", 1);
								} else {
									JOptionPane.showMessageDialog(ventanaDialog, "Acceso denegado.", "Log-in fallido.",
											1);
								}

							} else { // SI EL USUARIO NO EXISTE
								// SE CREA
								String insertar = "INSERT INTO USUARIO VALUES ( '" + usuarioIntroducido + "', '" + pass
										+ "')";

								// SE EJECUTA LA SENTENCIA
								st = conexion.createStatement();
								int filas = st.executeUpdate(insertar);
								JOptionPane.showMessageDialog(ventanaDialog,
										" Se ha creado el usuario: " + usuarioIntroducido, "El usuario no existía.", 1);
							}
							rs.close();
							st.close();
							conexion.close();
							ventanaDialog.dispose();

						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
				// AÑADIMOS A LA VENTANA DEL DIALIOG EL BOTON
				ventanaDialog.add(enviar, settingsOptions);
			}
		});
	}
}