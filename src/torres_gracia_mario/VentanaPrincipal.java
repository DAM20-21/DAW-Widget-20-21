
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
    Paneles panel;
   
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

       
        panelTextoSonidos = new JTextField("Sonidos de Animales");
        settingsObjeto = new GridBagConstraints();
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
        ventana.getContentPane().add(panelTextoSonidos, settingsObjeto);

        panelGrandeSonidos = new JPanel(new GridLayout(3, 3, 3, 3));
        settingsObjeto = new GridBagConstraints();
        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 1;
        settingsObjeto.gridheight = 2;
        settingsObjeto.gridwidth = 2;
        settingsObjeto.weighty = 4;
        settingsObjeto.weightx = 4;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        ventana.add(panelGrandeSonidos, settingsObjeto);

        Paneles panel = new Paneles(panelGrandeSonidos);
        panel.crearBotonesAnimales();
        
        ventana.add(panel);
			
		
    }

    public void inicializar() {
        ventana.setVisible(true);
        inicializarComponentes();
    }

}
