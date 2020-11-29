package fuentes_santiago_javier;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Clase que extiende de JPanel que mostrará una imagen que reciba.
 * @author Javier Fuentes
 */
public class VisorImagen extends JPanel {

    private static final long serialVersionUID = 4999851937545225852L;
    /** Label que será el que vaya cambiando su icono por la imagén que reciba */
    private JLabel fondo;

    public VisorImagen() {
        // Se crea GridLayout para que el label ocupe todo el espacio disponible
        super(new GridLayout());
        inicializarComponentes();
    }

    /**
     * Inicializa el Panel y el label
     */
    public void inicializarComponentes() {
        fondo = new JLabel();
        fondo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(fondo);
    }

    /**
     * Recibe una imagén por parametros y se le asigna al {@link #fondo}. Previamente
     * se habrá borrado el {@link #fondo} anterior del panel Despues de volver a
     * introducir el {@link #fondo} en el panel se refrescará el panel para que
     * aparezcan las modificaciones
     * 
     * @param imagenEnviada que será el nuevo icono del {@link #fondo}
     */
    public void cambiarImagen(ImageIcon imagenEnviada) {
        this.removeAll();
        fondo.setIcon(imagenEnviada);
        this.add(fondo);
        this.revalidate();
        this.repaint();
    }
}
