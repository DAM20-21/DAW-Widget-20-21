package nofuentes_mendez_elena;

import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Clase Diálogo que extiende de JDialog, la cual nos mostrará las opciones para
 * poder reproducir un vídeo.
 * 
 * Cuando esté abierto las demás ventanas estarán bloqueadas.
 * 
 * @author Elena Nofuentes
 * @since 26-11-2020
 * @version 1.1
 * 
 */

public class Dialogo extends JDialog {
    /** Atributos de la clase */
    private static final long serialVersionUID = 1L;
    private JLabel text1, text2;
    private JTextField jt1;
    private JButton buttonArchivo;
    private JFileChooser selector;
    private JButton buttonURL;
    private Dialogo dialogo;
    private VentanaPrincipal ventana;
    private WidgetVideoElena w;

    /** Constructor parametrizado */
    public Dialogo(JFrame frame, VentanaPrincipal ventana) {
        super(frame);
        setModal(true);
        setBounds(100, 100, 300, 200);
        text1 = new JLabel();
        text2 = new JLabel();
        jt1 = new JTextField();
        buttonArchivo = new JButton(" Archivo ");
        buttonURL = new JButton(" Reproducir enlace");
        selector = new JFileChooser();
        dialogo = this;
        this.ventana = ventana;
        w = new WidgetVideoElena(ventana.getVentana());
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
        add(buttonURL);
    }

    /**
     * Método para añadir los listener a los botones del diálogo para que hagan la
     * acción correspondiente.
     * 
     * buttonArchivo -> Abre el selector de archivos y trabaja con el archivo
     * seleccionado. buttonURL -> Oculta el dialogo y en el panel de la ventana
     * principal reproduce el vídeo.
     */
    public void aListenert() {
        buttonArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w.fichero();
                ventana.getVentana().repaint();
                ventana.getVentana().revalidate();
            }
        });

        buttonURL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dialogo.setVisible(false);
                // widgetVideoElena = new WidgetVideoElena();
                // String url = jt1.getText().toString();
                // String[] splitUrl = url.split("=");
                // ventana.getVentana().add(widgetVideoElena
                // .getBrowserPanel("https://www.youtube.com/embed/" + splitUrl[1] +
                // "?rel=0&amp;autoplay=1"));
                // ventana.getVentana().add(widgetVideoElena.getBrowserPanel(url));
                // ventana.getVentana().revalidate();
                // ventana.getVentana().repaint();
                // widgetVideoElena = null;
            }

        });
    }
}