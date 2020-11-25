
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Paneles extends JPanel{
    private JButton[][] arrayBoton;
    JPanel panelAnimal;
     JLabel imagen;
     String[][] nombreImagen = {{"img/leon.jpg","img/lobo.jpg","img/rana.jpg"},{"img/orca.jpg","img/komodo.jpg","img/elefante.jpg"},{"img/vaca.jpg","img/rinoceronte.jpg","img/cuervo.jpg"}};
    

    public Paneles(JPanel componente) {
        panelAnimal = componente;
    }

    public void crearBotonesAnimales(){
        arrayBoton = new JButton[3][3];
		for (int i = 0; i < arrayBoton.length; i++) {
			for (int j = 0; j < arrayBoton[i].length; j++) {
                arrayBoton[i][j] = new JButton();
                imagen = new JLabel();
                arrayBoton[i][j].setBackground(Color.WHITE);
                GridBagConstraints settingsBotones = new GridBagConstraints();
                settingsBotones.gridx = i;
                settingsBotones.gridy = j;
                settingsBotones.weighty = 1;
                settingsBotones.weightx = 1;
                imagen.setIcon(new ImageIcon(nombreImagen[i][j]));
                arrayBoton[i][j].add(imagen);
                settingsBotones.fill = GridBagConstraints.BOTH;	
                panelAnimal.add(arrayBoton[i][j], settingsBotones);
            }
        }
    }
}