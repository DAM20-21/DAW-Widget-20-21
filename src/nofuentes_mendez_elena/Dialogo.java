package nofuentes_mendez_elena;

import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Clase Diálogo que extiende de JDialog, la cual nos mostrará las opciones para
 * poder reproducir un vídeo.
 * 
 * @author Elena Nofuentes
 * @since 26-11-2020
 * @version 1.2
 * @see WidgetVideoElena
 */

public class Dialogo extends JDialog {
    /** Atributos de la clase */
    private static final long serialVersionUID = 1L;
    private JLabel text1, text2;
    private JTextField jt1;
    private JButton buttonArchivo;
    private JButton buttonURL;
    private VentanaPrincipal ventana;
    private WidgetVideoElena widgetVideoElena;

    /**
     * Constructor parametrizado
     * 
     * @param frame,   Jframe de la ventana principal.
     * @param ventana, Objeto de la ventana principal.
     */
    public Dialogo(JFrame frame, VentanaPrincipal ventana) {
        super(frame);
        setBounds(100, 100, 200, 150);
        setTitle(" Opciones ");
        text1 = new JLabel();
        text2 = new JLabel();
        jt1 = new JTextField();
        buttonArchivo = new JButton(" Archivo ");
        buttonURL = new JButton(" Reproducir enlace ");
        this.ventana = ventana;
        widgetVideoElena = new WidgetVideoElena(ventana.getVentana());
        aElementos();
        aListenert();
    }

    /**
     * Método que crear y añade los elementos del diálogo
     */
    public void aElementos() {
        setLayout(new GridLayout(0, 1));

        text1.setText(" Elija el medio de reproducción: ");
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        add(text1);
        buttonArchivo.setFocusable(false);
        add(buttonArchivo);
        text2.setText(" URL ");
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        add(text2);
        add(jt1);
        buttonURL.setFocusable(false);
        add(buttonURL);
    }

    /**
     * Método para añadir los listener a los botones del diálogo para que hagan la
     * acción correspondiente.
     * 
     * buttonArchivo -> Llama al método fichero del Widget buttonURL -> Llama al
     * método reproducirEnlace del Widget
     * 
     * {@link WidgetVideoElena}
     */
    public void aListenert() {
        buttonArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                widgetVideoElena.fichero();
                ventana.getVentana().repaint();
                ventana.getVentana().revalidate();
            }
        });

        buttonURL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = jt1.getText().toString();
                widgetVideoElena.reproducirEnlace(url);
                ventana.getVentana().repaint();
                ventana.getVentana().revalidate();
            }
        });
    }
}