package torres_gracia_mario;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class PanelesAnimales extends JPanel{
    private JPanel panelGrandeSonidos;
    private JTextField panelTextoSonidos;
    private Font fuente;
    private JButton[][] arrayBoton;
    ImageIcon imagen;
    String[][] nombreImagen;
    public PanelesAnimales(String[][] imagenAnimal) {
        super();
        setLayout(new GridBagLayout());
        nombreImagen = imagenAnimal;
        setBackground(Color.RED);
		inicializarPaneles();
        crearBotonesAnimales();
    }

    public void inicializarPaneles(){
        GridBagConstraints settingsObjeto = new GridBagConstraints();
        panelTextoSonidos = new JTextField("Sonidos de Animales");
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
        add(panelTextoSonidos, settingsObjeto);

        settingsObjeto = new GridBagConstraints();
        panelGrandeSonidos = new JPanel(new GridLayout(3, 3, 3, 3));
        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 1;
        settingsObjeto.weighty = 4;
        settingsObjeto.weightx = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
       add(panelGrandeSonidos, settingsObjeto);
    }

    public void crearBotonesAnimales(){
        arrayBoton = new JButton[3][3];
		for (int i = 0; i < arrayBoton.length; i++) {
			for (int j = 0; j < arrayBoton[i].length; j++) {
                arrayBoton[i][j] = new JButton();
                imagen = new ImageIcon(nombreImagen[i][j]);
                arrayBoton[i][j].setBackground(Color.WHITE);
                arrayBoton[i][j].setIcon(imagen);
                arrayBoton[i][j].setHorizontalAlignment(JButton.CENTER);
                panelGrandeSonidos.add(arrayBoton[i][j]);
            }
        }
    }
}