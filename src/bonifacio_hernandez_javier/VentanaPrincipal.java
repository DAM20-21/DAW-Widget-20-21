package bonifacio_hernandez_javier;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

/**
 * Ventana Principal para probar el widget Selector de Formato de Texto
 * 
 * @author Javier Bonifacio Hernandez
 */
public class VentanaPrincipal {

	private final static String TEXTO = "Ponme Bonito";

	// La ventana principal, en este caso, guarda todos los componentes:
	private JFrame ventana;
	private JButton bDialogo;
	private JPanel panelFuente;
	private JTextField jTextFuente;
	private Color color = Color.decode("#FAFFFF");

	/**
	 * Constructor, marca el tamaño y el cierre del frame
	 */
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 600, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bDialogo = new JButton("Selecciona la Fuente");
		panelFuente=new JPanel();
		jTextFuente = new JTextField(TEXTO);
	}

	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes() {

		// Definimos el layout:
		ventana.setLayout(new GridLayout(1,2));

		ventana.add(bDialogo);
		bDialogo.setFont(new FontUIResource("",Font.BOLD,20));
	
		ventana.add(panelFuente);
		panelFuente.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		panelFuente.setBackground(color);
		panelFuente.setLayout(new GridLayout(1,1));
		panelFuente.add(jTextFuente);
	}

	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners() {
		bDialogo.addActionListener(e -> {
			widgetFormatoTexto dialog = new widgetFormatoTexto(bDialogo, panelFuente.getBackground(), this);
			dialog.setVisible(true);

		});

	}

	/**
	 * Recibo los valores del formato y dependiendo de ellos cambio el formato del texto
	 * @param tamaño
	 * @param letra
	 * @param align
	 * @param color
	 */
	public void cambioFormato(int tamaño, int letra, int align,Color color) {
		switch (tamaño) {
			case 10: {
				if (letra == 0) {
					jTextFuente.setFont(new FontUIResource("", Font.BOLD, 10));
				} else {
					if (letra == 1) {
						jTextFuente.setFont(new FontUIResource("", Font.ITALIC, 10));
					} else {
						// Subrayado
					}
				}
				break;
			}
			case 14: {
				if (letra == 0) {
					jTextFuente.setFont(new FontUIResource("", Font.BOLD, 14));
				} else {
					if (letra == 1) {
						jTextFuente.setFont(new FontUIResource("", Font.ITALIC, 14));
					} else {
						// Subrayado
					}
				}
				break;
			}
			case 18: {
				if (letra == 0) {
					jTextFuente.setFont(new FontUIResource("", Font.BOLD, 18));
				} else {
					if (letra == 1) {
						jTextFuente.setFont(new FontUIResource("", Font.ITALIC, 18));
					} else {
						// Subrayado
					}
				}
				break;
			}
			case 22: {
				if (letra == 0) {
					jTextFuente.setFont(new FontUIResource("", Font.BOLD, 22));
				} else {
					if (letra == 1) {
						jTextFuente.setFont(new FontUIResource("", Font.ITALIC, 22));
					} else {
						// Subrayado
					}
				}
				break;
			}
			case 26: {
				if (letra == 0) {
					jTextFuente.setFont(new FontUIResource("", Font.BOLD, 26));
				} else {
					if (letra == 1) {
						jTextFuente.setFont(new FontUIResource("", Font.ITALIC, 26));
					} else {
						// Subrayado
					}
				}
				break;
			}
		}

		if (align == 0) {
			jTextFuente.setHorizontalAlignment(JTextField.LEFT);
		} else {
			if (align == 1) {
				jTextFuente.setHorizontalAlignment(JTextField.CENTER);
			} else {
				jTextFuente.setHorizontalAlignment(JTextField.RIGHT);
			}
		}

		jTextFuente.setForeground(color);
		jTextFuente.setText("!!GRACIAS¡¡");
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

	public JFrame getVentana() {
		return this.ventana;
	}

	public void setVentana(JFrame ventana) {
		this.ventana = ventana;
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

	public JTextField getJTextFuente() {
		return this.jTextFuente;
	}

	public void setJTextFuente(JTextField jTextFuente) {
		this.jTextFuente = jTextFuente;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}