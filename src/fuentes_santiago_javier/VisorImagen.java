package fuentes_santiago_javier;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VisorImagen extends JPanel{

    private static final long serialVersionUID = 4999851937545225852L;
    private JLabel fondo;

    public VisorImagen() {
        super(new GridLayout());
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        fondo = new JLabel();
        fondo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(fondo);
    }

    public void cambiarImagen(ImageIcon imagenEnviada){
        this.removeAll();
        fondo.setIcon(imagenEnviada);
        this.add(fondo);
        this.revalidate();
        this.repaint();
    }
}
