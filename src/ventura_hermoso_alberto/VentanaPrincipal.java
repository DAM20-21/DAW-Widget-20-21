package ventura_hermoso_alberto;

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class VentanaPrincipal {
    private JFrame ventana;
    private JPanel panel_imagen;
    private JPanel panel_botones;
    private JButton[] botones_acciones;

    public VentanaPrincipal() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 300, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void inicializarComnponentes() {
        ventana.setLayout(new GridBagLayout());
        panel_imagen = new JPanel();
        panel_botones = new JPanel();
        panel_botones.setLayout(new GridLayout(1, 4));
        botones_acciones = new JButton[4];
        panel_imagen.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        panel_botones.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        GridBagConstraints settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 0;
        settings.weightx = 1;
        settings.weighty = 1;
        settings.fill = GridBagConstraints.BOTH;
        ventana.add(panel_imagen, settings);

        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 1;
        settings.weightx = 1;
        settings.weighty = 1;
        settings.fill = GridBagConstraints.BOTH;
        ventana.add(panel_botones, settings);

    }

    public void inicializar() {
        ventana.setVisible(true);
        inicializarComnponentes();
    }
}
