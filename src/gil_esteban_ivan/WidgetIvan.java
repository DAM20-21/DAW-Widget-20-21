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
 * Clase que representa un diálogo selector de color.
 * Para utilizar esta clase crea un listener del estilo:
 * {@code  DialogSelectorColor dialog = new DialogSelectorColor(bDialogo, panelColor.getBackground());
			dialog.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent arg0) {
					System.out.println(dialog.getColor());
				}
			});	}
 * La clase está preparada para que pueda funcionar sobre cualquier componente.
 * @author Jesus Redondo García
 *
 */
public class WidgetIvan extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//Referencia al selectorColor:	
	
	JLabel titulo;

	//Sliders:
	JSlider sliderNivel;

	//BotonAceptar
	JButton bAceptar;
	
	//MostradorColor:
	JTextArea mostradorCensura;

	public WidgetIvan(JComponent componente, Color colorInicial ) {
		super();
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
		add(sliderNivel,settings);
		
		//MostradorColor:
		mostradorCensura = new JTextArea();
		mostradorCensura.setEditable(false);
		mostradorCensura.setLineWrap(true);
		mostradorCensura.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 2;
		settings.insets = new Insets(20, 0, 20, 0);
		settings.fill = GridBagConstraints.BOTH;
		add(mostradorCensura,settings);
		
		//bAceptar
		bAceptar = new JButton("Aplicar Cambios");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 3;
		settings.insets = new Insets(20, 0, 20, 0);
		add(bAceptar,settings);
		
	}
	
	/**
	 * Método que añade todos los listeners al Dialog
	 */
	private void anadirListeners(){
		ChangeListener listenerSliders = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				mostradorCensura.setText(" ");
			}
	    };
	    sliderNivel.addChangeListener(listenerSliders);
	    //Botón Aceptar:
	    bAceptar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}
}