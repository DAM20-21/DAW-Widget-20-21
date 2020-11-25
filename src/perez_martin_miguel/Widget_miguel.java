package perez_martin_miguel;

import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Widget_miguel extends JDialog{
    
    private static final long serialVersionUID = 1L;

    JLabel fondo;

    public Widget_miguel() {
        super();
        setModal(true);
        setBounds(0, 0, 300, 300);
        anadirElemento();
    }

    public void anadirElemento() {
        // fondo
        
    }

}