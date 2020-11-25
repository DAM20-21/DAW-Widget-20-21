package fuentes_santiago_javier;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

/**
 * Ventana Principal
 * 
 * @author Javier Fuentes
 */
public class VentanaPrincipal {

	JFrame ventana;
	JPanel galeria;
	ArrayList<Object[]> imagenes;
	Object[] datos;
	DimensionUIResource dimensionesLabel;
	String rutaImagen = "img/";

	/**
	 * Constructor, marca el tamaño y el cierre del frame
	 */
	public VentanaPrincipal() {
		ventana = new JFrame("Galería");
		ventana.setBounds(0, 0, 1000, 500);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Inicializa todos los componentes del frame
	 */
	public void inicializarComponentes() {
		ventana.setLayout(new GridLayout());
		galeria = new JPanel(new GridLayout(2, 4));
		galeria.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		imagenes = new ArrayList<>();

		dimensionesLabel = new DimensionUIResource(ventana.getContentPane().getWidth() / 4,
				ventana.getContentPane().getHeight() / 2);

		addImagen("ardilla.jpg");
		addImagen("buho.jpg");
		addImagen("cebra.jpg");
		addImagen("foca.jpg");
		addImagen("gato.jpg");
		addImagen("gorila.jpg");
		addImagen("monos.jpg");
		addImagen("perro.jpg");

		for (int i = 0; i < imagenes.size(); i++) {

			Object[] datos = imagenes.get(i);
			galeria.add((JLabel) datos[1]);
		}

		ventana.add(galeria);

	}

	/**
	 * 
	 * @param nombre de la imagen que se quiere añadir
	 */
	private void addImagen(String nombre) {
		JLabel marco;
		ImageIcon imagen;

		datos = new Object[2];
		imagen = new ImageIcon(rutaImagen + nombre);
		datos[0] = imagen;

		marco = new JLabel();
		marco.setSize(dimensionesLabel);
		imagen = new ImageIcon(
				imagen.getImage().getScaledInstance(marco.getWidth(), marco.getHeight(), Image.SCALE_DEFAULT));
		marco.setIcon(imagen);
		datos[1] = marco;

		marco.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		imagenes.add(datos);
	}

	/**
	 * Inicializa todos los lísteners del frame
	 */
	public void inicializarListeners() {
		for (int i = 0; i < imagenes.size(); i++) {
			Object[] datos = imagenes.get(i);

			ImageIcon imagenReal = (ImageIcon) datos[0];
			JLabel imagen = (JLabel) datos[1];

			imagen.addMouseListener(new VisorImagen(ventana, imagenReal));
		}
	}

	/**
	 * Inicialización
	 */
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
}