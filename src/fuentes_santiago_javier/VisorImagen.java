package fuentes_santiago_javier;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VisorImagen extends JPanel implements MouseListener {

    private static final long serialVersionUID = 4999851937545225852L;
    VentanaPrincipal ventana;
    JLabel fondo;
    ImageIcon imagen;

    public VisorImagen(VentanaPrincipal ventana, ImageIcon imagen) {
        super();
        this.imagen = imagen;
        this.ventana = ventana;
        inicializarComponentes();
        this.addMouseListener(this);
    }

    public void inicializarComponentes() {

        fondo = new JLabel();

        fondo.setIcon(imagen);

        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            ventana.visualizar.removeAll();
            ventana.visualizar.add(fondo);
            ventana.refrescarPantalla();

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
