package corrales_santos_sara;

import java.awt.Color;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WidgetSara extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = -7290161983422258611L;
	// TODO: Hacer el cronómetro de pomodoros, MIRAR APINTES DEL EJERCICIO
	// CRONÓMETRO
	VentanaPrincipal ventana;

	private JTextField JTNota;
	private ArrayList<JCheckBox> JCheck = new ArrayList<>();

	public WidgetSara() {
		setLayout((LayoutManager) new GridLayout(JCheck.size(), 1));
        setBackground(new Color(166, 247, 203));
	}
	

	public void borrarCheckBox(JCheckBox checkBoxBorrar){
		checkBoxBorrar.addActionListener((e)->{
			if (checkBoxBorrar.isSelected()) {
				checkBoxBorrar.setText("null");
			}
			
		});


	}

	public void aniadirCheckBox(){
		String nota = JTNota.getText();
            JCheckBox nuevoCheck =new JCheckBox(nota);
            nuevoCheck.setBackground(new Color(166, 247, 203));
            JCheck.add(nuevoCheck);
            this.add(JCheck.get(JCheck.size()-1));
	}
}
