package fuentes_santiago_javier;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VisorImagen extends JDialog implements MouseListener {

    private static final long serialVersionUID = 4999851937545225852L;
    JLabel fondo;
    ImageIcon imagen;

    public VisorImagen(JFrame ventana, ImageIcon imagen) {
        super();
        this.setBounds(0, 0, imagen.getIconWidth(), imagen.getIconHeight());
        this.setLocationRelativeTo(ventana);
        this.imagen = imagen;
        inicializarComponentes();
        this.addMouseListener(this);
    }

    public void inicializarComponentes() {
        this.setLayout(new GridLayout());

        fondo = new JLabel();

        fondo.setIcon(imagen);

        this.add(fondo);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            this.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
