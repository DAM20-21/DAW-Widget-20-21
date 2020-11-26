package torres_gracia_mario;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author Mario Gracia
 */

public class VentanaPrincipal {
    private JFrame ventana;
    private JPanel panelGrandeSonidos;
    private JTextField panelTextoSonidos;
    private Font fuente;
    PanelesAnimales panel;
   
    private JButton[][] arrayBoton;
    private JLabel imagen;
    private String[][] nombreImagen = {{"img/leon.jpg","img/lobo.jpg","img/rana.jpg"},{"img/orca.jpg","img/komodo.jpg","img/elefante.jpg"},{"img/vaca.jpg","img/rinoceronte.jpg","img/cuervo.jpg"}};
   
    public VentanaPrincipal() {
        ventana = new JFrame("Sonidos de animales");
        ventana.setBounds(50, 50, 800, 800);
        ventana.getContentPane();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void inicializarComponentes() {

        ventana.setLayout(new GridBagLayout());
        GridBagConstraints settingsObjeto = new GridBagConstraints();

        PanelesAnimales panel = new PanelesAnimales(ventana);
        panel.inicializarPaneles();
        panel.crearBotonesAnimales();
        
        ventana.add(panel);
			
		
    }

    public void inicializar() {
        ventana.setVisible(true);
        inicializarComponentes();
    }

}
