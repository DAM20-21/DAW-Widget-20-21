package corrales_santos_sara;

import javax.swing.JCheckBox;

public class WidgetSara {
    //TODO: Hacer el cronómetro de pomodoros, MIRAR APINTES DEL EJERCICIO CRONÓMETRO


	public void borrarCheckBox(JCheckBox checkBoxBorrar){
		checkBoxBorrar.addActionListener((e)->{
			if (checkBoxBorrar.isSelected()) {
				checkBoxBorrar.setText("null");
			}
			
		});
	}
}
