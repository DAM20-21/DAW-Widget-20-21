package redondo_garcia_jesus;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Interfaz del Widget High Score
 *
 * @author Sergio Blanco Prieto
 */
public class VentanaPrincipal {
    JFrame ventana;
    JLabel mitad1;
    JLabel mitad2;

    public VentanaPrincipal() {
        ventana = new JFrame("High Score");
        ventana.setBounds(400, 300, 900, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new GridBagLayout());
    }
    
    public void inicializar() {
        ventana.setVisible(true);
        GridBagConstraints g1 = new GridBagConstraints();
        g1.weightx = 1;
        g1.weighty = 1;
        g1.fill = GridBagConstraints.BOTH;
        g1.gridx = 0;
        g1.gridy = 0;
        mitad1 = new JLabel("");
        mitad1.setHorizontalAlignment(SwingConstants.CENTER);
        mitad1.setVerticalAlignment(SwingConstants.CENTER);
        mitad1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ventana.add(mitad1, g1);
        GridBagConstraints g2 = new GridBagConstraints();
        g2.weightx = 1;
        g2.weighty = 10;
        g2.fill = GridBagConstraints.BOTH;
        g2.gridx = 0;
        g2.gridy = 1;
        mitad2 = new JLabel("");
        mitad2.setHorizontalAlignment(SwingConstants.CENTER);
        mitad2.setVerticalAlignment(SwingConstants.CENTER);
        mitad2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ventana.add(mitad2, g2);
    }
}
