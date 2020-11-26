package torres_gracia_mario;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class PanelesAnimales extends JPanel{
    private JFrame frame;
    private JPanel panelGrandeSonidos;
    private JTextField panelTextoSonidos;
    private Font fuente;
    private JButton[][] arrayBoton;
    JPanel panel;
    JLabel imagen;
    String[][] nombreImagen = {{"img/leon.jpg","img/lobo.jpg","img/rana.jpg"},{"img/orca.jpg","img/komodo.jpg","img/elefante.jpg"},{"img/vaca.jpg","img/rinoceronte.jpg","img/cuervo.jpg"}};
    
    public PanelesAnimales(JFrame ventana) {
        frame = ventana;
    }

    public void inicializarPaneles(){
        panelTextoSonidos = new JTextField("Sonidos de Animales");
        GridBagConstraints settingsObjeto = new GridBagConstraints();
        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 0;
        settingsObjeto.weighty = 1;
        settingsObjeto.weightx = 1;
        panelTextoSonidos.setEditable(false);
        panelTextoSonidos.setHorizontalAlignment(JTextField.CENTER);
        panelTextoSonidos.setBackground(Color.CYAN);
        panelTextoSonidos.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        panelTextoSonidos.setForeground(Color.BLACK);
        panelTextoSonidos.setFont(new Font("Arial", Font.BOLD, 25));
        settingsObjeto.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(panelTextoSonidos, settingsObjeto);

        panelGrandeSonidos = new JPanel(new GridLayout(3, 3, 3, 3));
        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 1;
        settingsObjeto.gridheight = 2;
        settingsObjeto.gridwidth = 2;
        settingsObjeto.weighty = 4;
        settingsObjeto.weightx = 4;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        frame.add(panelGrandeSonidos, settingsObjeto);
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
                panelGrandeSonidos.add(arrayBoton[i][j], settingsBotones);
            }
        }
    }
}