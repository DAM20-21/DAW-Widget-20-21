package fuentes_santiago_javier;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
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
	JScrollPane panelIzq;
	JScrollPane panelDer;
	JFrame ventana;
	JPanel galeria;
	VisorImagen visualizar;
	ArrayList<Object[]> imagenes;
	Object[] datos;
	DimensionUIResource dimensionesLabel;
	String rutaImagen = "img/";

	/**
	 * Constructor, marca el tamaño y el cierre del frame
	 */
	public VentanaPrincipal() {
		ventana = new JFrame("Galería");
		ventana.setBounds(0, 0, 1500, 750);
		//ventana.setExtendedState(Frame.MAXIMIZED_BOTH);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Inicializa todos los componentes del frame
	 */
	public void inicializarComponentes() {
		ventana.setLayout(new GridBagLayout());

		panelIzq = new JScrollPane();

		GridBagConstraints opc = new GridBagConstraints();

		opc.gridx = 0;
		opc.gridy = 0;
		opc.weighty = 1;
		opc.weightx = 1;
		opc.fill = GridBagConstraints.BOTH;
		ventana.add(panelIzq, opc);
		panelIzq.setBorder(BorderFactory.createTitledBorder("Galería"));

		galeria = new JPanel(new GridBagLayout());
		
		panelIzq.setViewportView(galeria);
		
		imagenes = new ArrayList<>();

		dimensionesLabel = new DimensionUIResource(150,150);

		addImagen("ardilla.jpg");
		addImagen("buho.jpg");
		addImagen("cebra.jpg");
		addImagen("foca.jpg");
		addImagen("gato.jpg");
		addImagen("gorila.jpg");
		addImagen("monos.jpg");
		addImagen("perro.jpg");

		insertarImagenesEnPanel();

		panelDer = new JScrollPane();

		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 0;
		opc.weighty = 1;
		opc.weightx = 8;
		opc.fill = GridBagConstraints.BOTH;

		ventana.add(panelDer, opc);

		visualizar = new VisorImagen();

		panelDer.setBorder(BorderFactory.createTitledBorder("Visualización"));

		panelDer.setViewportView(visualizar);

	}

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
			galeria.add((JLabel) datos[1],opc);
		}
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
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(marco.getWidth(), marco.getHeight(), Image.SCALE_DEFAULT));
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

			imagen.addMouseListener( new MouseInputAdapter(){
				@Override
				public void mouseClicked(MouseEvent e) {
					
					visualizar.cambiarImagen(imagenReal);
					//refrescarPantalla();
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