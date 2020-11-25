package redondo_garcia_jesus.Rodriguez_Parron_Alexandro;

import javax.swing.JComponent;
import javax.swing.JDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;

public class Widgets_Formulario extends JDialog implements ActionListener {

    public Widgets_Formulario(JComponent componente) {

        super();
		setModal(true); // PARA HACERLO MODAL
		setBounds((int)componente.getLocationOnScreen().getX(),(int)componente.getLocationOnScreen().getY(), 300, 500); //Dónde empieza el Dialog y qué tamaño tiene
		anadirElementos();
        anadirListeners();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();

    }
    private void anadirElementos(){
        this.setLayout(new GridBagLayout());
    }
    private void anadirListeners(){

    }
}
