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

import chrriis.dj.nativeswing.swtimpl.components.JVLCPlayer;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.DefaultVLCPlayerDecorator.VLCDecoratorComponentType;

/**
 * Clase Diálogo que extiende de JDialog
 * 
 * @author Elena Nofuentes
 * @since 26-11-2020
 * @version 1.0
 * 
 */

public class Dialogo extends JDialog {

    private static final long serialVersionUID = 1L;
    private JLabel text1, text2;
    private JTextField jt1;
    private JButton buttonArchivo;
    private JFileChooser selector;
    private JButton buttonYt;
    private Dialogo dialogo;

    private WidgetVideoElena widgetVideoElena;
    private VentanaPrincipal ventana;

    /** Constructor */
    public Dialogo(JFrame frame, VentanaPrincipal ventana) {
        super(frame);
        setModal(true);
        setBounds(100, 100, 300, 200);
        text1 = new JLabel();
        text2 = new JLabel();
        jt1 = new JTextField();
        buttonArchivo = new JButton(" Archivo ");
        buttonYt = new JButton(" PLAY ");
        selector = new JFileChooser();
        dialogo = this;
        this.ventana = ventana;
        aElementos();
        aListenert();
    }

    public void aElementos() {
        setLayout(new GridLayout(0, 1));
        text1.setText(" Elija el medio de reproducción: ");
        add(text1);
        add(buttonArchivo);
        text2.setText(" --- URL ");
        add(text2);
        add(jt1);
        add(buttonYt);
    }

    public void aListenert() {
        buttonArchivo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrimos el dialogo
                int opcion = selector.showOpenDialog(dialogo);
                // Comprobamos que se ha pulsado en el botón aceptar
                if (opcion == JFileChooser.APPROVE_OPTION) {
                    dialogo.setVisible(false);
                    File fich = selector.getSelectedFile();
                    String ruta = fich.getAbsolutePath();
                    JVLCPlayer player = new JVLCPlayer();
                    player.setControlBarVisible(true);
                    Runnable loadPlayerFileRunnable = new Runnable() {
                        public void run() {
                            player.load(
                                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
                        }
                    };
                    ventana.getVentana().add(player);
                    ventana.getVentana().revalidate();
                    ventana.getVentana().repaint();
                    loadPlayerFileRunnable.run();
                }
            }
        });

        buttonYt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialogo.setVisible(false);
                widgetVideoElena = new WidgetVideoElena();
                String url = jt1.getText().toString();
                String[] splitUrl = url.split("=");
                ventana.getVentana().add(widgetVideoElena
                        .getBrowserPanel("https://www.youtube.com/embed/" + splitUrl[1] + "?rel=0&amp;autoplay=1"));
                // ventana.getVentana().add(widgetVideoElena.getBrowserPanel(url));
                ventana.getVentana().revalidate();
                ventana.getVentana().repaint();
            }
        });
    }
}
