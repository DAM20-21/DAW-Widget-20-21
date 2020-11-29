package nofuentes_mendez_elena;

import javax.swing.JFrame;
import java.awt.*;

/**
 * Ventana principal. Clase base que inicializa el programa, en ella se
 * reproduciran los videos.
 * 
 * @author Elena Nofuentes
 * @since 25-11-2020
 * @version 1.0
 * @link {@link Dialogo}
 * 
 */

public class VentanaPrincipal {
    /** Atributos de la clase */
    private JFrame ventana;
    private Dialogo dialogo;

    /** Constructor por defecto */
    public VentanaPrincipal() {
        ventana = new JFrame("Reproductor de vídeo");
        ventana.setBounds(100, 100, 500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());
        dialogo = new Dialogo(ventana, this);
    }

    /**
     * Método para inicializar el programa. Hacemos visibles los componentes.
     */
    public void inicializar() {
        ventana.setVisible(true);
        dialogo.setVisible(true);
    }

    /**
     * Método que devuelve el JFrame de la ventana
     * 
     * @return JFrame de la ventanaPrincipal
     */
    public JFrame getVentana() {
        return ventana;
    }
}
