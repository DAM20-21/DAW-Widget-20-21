package perez_martin_miguel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class Fondo extends JPanel {

    private static final long serialVersionUID = 1L;

    public Fondo() {
        super();
        
    }

   @Override
    public void paintComponent(Graphics g) {
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/img/imagen1_miguel.jpg"));
        g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }

}
