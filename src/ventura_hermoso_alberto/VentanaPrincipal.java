package ventura_hermoso_alberto;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.image.*;
import java.awt.GridLayout;

public class VentanaPrincipal {
    private JFrame ventana;
    private JPanel panel_imagen;
    private JPanel panel_botones;
    private JButton[] botones_acciones;

    public VentanaPrincipal() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 100, 100);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void inicializarComnponentes() {
        ventana.setLayout(new GridLayout(2, 1));
        panel_imagen = new JPanel();
    }
}
