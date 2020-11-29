package corrales_santos_sara;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Clase que crea el widget TO-DO
 *@author Sara Corrales Santos 
 */
public class WidgetToDo extends JPanel {

	//Atributos de la clase
	private static final long serialVersionUID = 1718291886205966612L;
	private ArrayList<JCheckBox> JCheck = new ArrayList<>();
	private JPanel JPtexto, JPtextoNota, JPaniadir, JPNotas, JPLimpiar; 
	private JTextField JTNota;
	private JButton JBaniadir, JBLimpiar;
	private JFrame ventana;

	/**
	 * Constructor
	 * @param ventana
	 */
	public WidgetToDo(JFrame ventana) {
		this.ventana = ventana;
		GridBagLayout gb = new GridBagLayout();
		setLayout(gb);
		iniciarElementos();
		iniciarListeners();

	}

	/**
	 * Método que inicia los elementos de la lista To-Do y los coloca
	 */
	public void iniciarElementos(){
		// PANEL NOTAS TO-DO
		JPNotas = new JPanel();
		JPNotas.setLayout((LayoutManager) new GridLayout(JCheck.size(), 1));
        JPNotas.setBackground(new Color(166, 247, 203));
        JPNotas.setPreferredSize(new Dimension(300, 300));
		GridBagConstraints setting = new GridBagConstraints();
        setting.gridx = 0;
        setting.gridy = 1;
        setting.weightx = 7;
        setting.weighty = 7;
        setting.fill = GridBagConstraints.BOTH;
		this.add(JPNotas, setting);

		//LIMPIAR
		JPLimpiar = new JPanel(new GridBagLayout());
		 JBLimpiar = new JButton("Limpiar notas");
		setting = new GridBagConstraints();
        setting.fill = GridBagConstraints.HORIZONTAL;
		JPLimpiar.add(JBLimpiar); 
		JPLimpiar.setBackground(new Color(166, 247, 203));
		this.add(JPLimpiar, setting);

		// TEXTO
		JPtexto = new JPanel();
		GridBagLayout gb = new GridBagLayout();
       	JPtexto.setLayout(gb);
        setting = new GridBagConstraints();
        setting.gridx = 0;
        setting.gridy = 2;
        setting.weightx = 1;
        setting.weighty = 1;
        setting.gridwidth = 2;
        setting.fill = GridBagConstraints.BOTH;
        this.add(JPtexto, setting);

        //NOTA TEXTO
        JTNota = new JTextField();
        JPtextoNota = new JPanel(new GridLayout(1,1));
        JPtextoNota.add(JTNota); 
        setting = new GridBagConstraints();
        setting.gridx = 0;
        setting.gridy = 2;
        setting.weightx = 5;
        setting.weighty = 1;
        setting.fill = GridBagConstraints.BOTH; 
        JPtexto.add(JPtextoNota, setting); 

        //AÑADIR
        JBaniadir =new JButton("Añadir");
        JPaniadir = new JPanel(new GridLayout(1,1));
        JPaniadir.add(JBaniadir); 
        setting = new GridBagConstraints();
        setting.gridx = 1;
        setting.gridy = 2;
        setting.weightx = 1;
        setting.weighty = 1;
        setting.fill = GridBagConstraints.BOTH; 
        JPtexto.add(JPaniadir, setting);
	}

	/**
	 * Método que inicia los listeners de los botones de añadir y limpiar notas
	 */
	public void iniciarListeners(){
		JBaniadir.addActionListener((e)->{
            String nota = JTNota.getText();
			JCheckBox nuevoCheck =new JCheckBox(nota);
            nuevoCheck.setBackground(new Color(166, 247, 203));
            JCheck.add(nuevoCheck);
            JPNotas.add(JCheck.get(JCheck.size()-1));
			refrescarPantalla();
            
		});

		JBLimpiar.addActionListener((e)->{
			for (int i = 0; i < JCheck.size(); i++) {
				if (JCheck.get(i).isSelected()) {
					JPNotas.remove(JCheck.get(i));
				}
			}
			refrescarPantalla();
		});
		
	}

	/**
	 * Método que refresca la ventana
	 */
	public void refrescarPantalla(){
		ventana.revalidate(); 
		ventana.repaint();
	}

	
}
