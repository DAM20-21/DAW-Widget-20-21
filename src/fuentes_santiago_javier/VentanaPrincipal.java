package fuentes_santiago_javier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.DimensionUIResource;

/**
 * Ventana Principal
 * 
 * @author Javier Fuentes
 */
public class VentanaPrincipal {
	/** Frame principal */
	JFrame ventana;
	/** Panel con scroll de la izquierda */
	JScrollPane panelIzq;
	/** Panel con scroll de la derecha */
	JScrollPane panelDer;
	/** Panel que almacenará JLabel con las imágenes */
	JPanel galeria;
	/** Panel de la calse {@link VisorImagen} que mostrará la imagen a tamño real */
	VisorImagen visualizar;
	/**
	 * Array que guardará la imagen a tamaño real y un JLabel con la imagen escalada
	 */
	Object[] datos;
	/** ArrayList que guardará todos los {@link #datos} */
	ArrayList<Object[]> imagenes;
	/** Dimensiones que tendrán los JLabel de {@link #galeria} */
	DimensionUIResource dimensionesLabel;
	/** Carpeta donde se encuentran las imágenes. */
	File carpetaImagenes = new File("img/");
	/** Dimensiones de la pantalla */
	Dimension tamanioPantalla = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Constructor, marca el tamaño y el cierre del frame
	 */
	public VentanaPrincipal() {
		int width = (int) (tamanioPantalla.getWidth() * 0.9); // 90% de la pantalla
 		int height = (int) (tamanioPantalla.getHeight() * 0.9); // 90% de la pantalla
		ventana = new JFrame("Album de Fotos");
		ventana.setBounds(0, 0, width, height);
		ventana.setLocationRelativeTo(null); // Se centra el frame
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Inicializa todos los componentes del frame
	 */
	public void inicializarComponentes() {
		/** Inicializar Frame */
		ventana.setLayout(new GridBagLayout());
		/** Inicializar Panel de la Izquierda */
		GridBagConstraints opc = new GridBagConstraints();
		panelIzq = new JScrollPane();
		opc.gridx = 0;
		opc.gridy = 0;
		opc.weighty = 1;
		opc.weightx = 1;
		opc.fill = GridBagConstraints.BOTH;
		ventana.add(panelIzq, opc);
		/** Inicializar Galería de Fotos */
		galeria = new JPanel(new GridBagLayout());
		/** Inicializa la dimensión que tendrás las imagenes en la galería */
		dimensionesLabel = new DimensionUIResource(100, 100);
		/** Inicializar el ArrayList de Imágenes */
		imagenes = new ArrayList<>();
		/** Añade las imagenes al Array */
		imagenes();
		/** Añade el Array de Imágenes en la galería */
		insertarImagenesEnPanel();
		/** Inicializar Panel de la Derecha */
		panelDer = new JScrollPane();
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 0;
		opc.weighty = 1;
		opc.weightx = 10;
		opc.fill = GridBagConstraints.BOTH;
		ventana.add(panelDer, opc);
		/** Inicializa el Panel que mostará las imágenes en grande */
		visualizar = new VisorImagen();
		/** Añadir bordes a los paneles con scroll */
		panelIzq.setBorder(BorderFactory.createTitledBorder("Galería"));
		panelDer.setBorder(BorderFactory.createTitledBorder("Visualización"));
		/** Añade los Paneles a sus respectivos ScrollPanels */
		panelIzq.setViewportView(galeria);
		panelDer.setViewportView(visualizar);
	}

	/**
	 * Método que enviará a {@link #addImagen(String)} el nombre de las imágenes de
	 * la carpeta {@link #carpetaImagenes} para crear su {@link #datos}
	 */
	public void imagenes() {
		/** Array que guarda los ficheros de todas las imágenes */
		File[] imagenes = carpetaImagenes.listFiles();
		for (int i = 1; i < imagenes.length; i++) {// Empieza en la 1 para que no pille el .gitikeep
			addImagen(imagenes[i].getPath());
		}
	}

	/**
	 * Inicializa un nuevo {@link #datos} y guarada la imagen real y el label con la
	 * imagen escalada.
	 * 
	 * @param ruta de la imagen que se quiere añadir
	 */
	private void addImagen(String ruta) {
		/** Label que se añadirá a {@link #galeria} */
		JLabel marco;
		/** Imagen que se enviará a {@link #visualizar} */
		ImageIcon imagen;

		datos = new Object[2];
		imagen = new ImageIcon(ruta);
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
	 * Añade los labels de {@link #datos} al panel {@link #galeria} con sus
	 * {@link GridBagConstraints}
	 */
	private void insertarImagenesEnPanel() {
		GridBagConstraints opc;
		for (int i = 0; i < imagenes.size(); i++) {
			Object[] datos = imagenes.get(i);
			opc = new GridBagConstraints();
			opc.gridx = 0;
			opc.gridy = i;
			opc.weighty = 1;
			opc.weightx = 1;
			opc.fill = GridBagConstraints.VERTICAL;
			galeria.add((JLabel) datos[1], opc);
		}
	}

	/**
	 * Inicializa los lísteners de los {@link JLabel} de {@link #galeria}
	 */
	public void inicializarListeners() {
		for (int i = 0; i < imagenes.size(); i++) {
			// Recoge los datos del ArrayList de Imágenes
			Object[] datos = imagenes.get(i);
			// Parsea los datos recibidos para trabajar con ellos
			ImageIcon imagenReal = (ImageIcon) datos[0];
			JLabel imagen = (JLabel) datos[1];
			// MouseListener de cada JLabel
			imagen.addMouseListener(new MouseInputAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					visualizar.cambiarImagen(imagenReal); // Envía la imagen a tamaño real al panel de visualización
				}
			});
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