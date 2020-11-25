package martin_garcia_ricardo;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;

public class WidgetRicardo extends JDialog {

    final static private int SOL = 1;
    final static private int NUBE = 2;
    final static private int LLUVIA = 3;
    final static private int NIEBLA = 4;

    JLabel hora;
    JPanel imagen;
    JLabel tiempoQhace;
    JLabel temperaturas;

public WidgetRicardo(){
    super();
    setModal(true);
    setBounds(0,0,400,600);
    hora = new JLabel("00:00");
    imagen = new JPanel();
    tiempoQhace = new JLabel("TIMEPO_Q_HACE");
    temperaturas = new JLabel("TEMPERATURAS");
    setLayout(new GridBagLayout());
    añadirComponentes();

}

private void añadirComponentes() {
    //Ponemos el marcador de la hora;
    GridBagConstraints ajustes = new GridBagConstraints();
    ajustes.gridx = 0;
    ajustes.gridy = 0;
    add(hora,ajustes);
    //Ponemos el panel de la imagen 
    ajustes.gridy = 1;
    imagen.setBackground(Color.BLUE);
    add(imagen,ajustes);

}


    
}
