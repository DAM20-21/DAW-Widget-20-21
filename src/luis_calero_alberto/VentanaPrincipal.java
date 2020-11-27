package luis_calero_alberto;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {
    private JFrame ventana;
    private JPanelConversor panel;

    public VentanaPrincipal() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 900, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void inicializarComponentes() {
        panel = new JPanelConversor();
        ventana.setLayout(new GridLayout(1, 1));
        ventana.add(panel);

    }

    public void inicializar() {
        ventana.setVisible(true);
        inicializarComponentes();

    }

}