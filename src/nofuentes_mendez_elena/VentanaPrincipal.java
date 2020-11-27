package nofuentes_mendez_elena;

import javax.swing.JFrame;
import java.awt.*;

/**
 * Ventana principal.
 * 
 * @author Elena Nofuentes
 * @since 25-11-2020
 * @version 1.0
 * 
 */
public class VentanaPrincipal {
    /** Atributos de la clase */
    private JFrame ventana;
    private Dialogo dialogo;

    /**
     * Constructor por defecto. Marca el tamaño y el cierre del frame
     */
    public VentanaPrincipal() {
        ventana = new JFrame("Reproductor de vídeo");
        ventana.setBounds(100, 100, 600, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new GridLayout(1, 1));
    }

    /**
     * Método para inicializar el programa
     */
    public void inicializar() {
        ventana.setVisible(true);
        componentes();

    }

    public void componentes() {
        dialogo = new Dialogo(ventana);
        dialogo.setVisible(true);
    }

}
