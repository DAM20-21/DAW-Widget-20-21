package nofuentes_mendez_elena;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.File;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.web.WebView;

/**
 * Clase WidgetVideoElena, permite reproducir vídeos desde los archivos locales
 * y desde los enlaces de youtube. Permite alternar la reprodución entre los
 * mismos sin problema. Podemos reproducir un Archivo y a la mitad de este
 * mandar reproducir un enlace y viceversa.
 * 
 * @author Elena Nofuentes
 * @since 25-11-2020
 * @version 1.0 {@link Dialogo#aListenert()}
 * 
 */
public class WidgetVideoElena {
    /** Atributos de la clase */
    private JFXPanel panelFx;
    private JFXPanel panelYt;
    private File ruta;
    private JFileChooser selector;
    private JFrame frame;
    private WebView webview;
    private MediaPlayer mp;

    /**
     * Constructor parametrizado.
     * 
     * @param frame, JFrame de la ventana.
     */
    WidgetVideoElena(JFrame frame) {
        this.frame = frame;
        selector = new JFileChooser();
        panelFx = new JFXPanel();
        panelYt = new JFXPanel();
        panelYt.setVisible(false);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webview = new WebView();
            }
        });
        frame.add(panelYt);
    }

    /**
     * Método escrito en JavaFx para reproducir los videos mediante un enlace.
     * Comprobamos la visibilidad de los paneles y los estados del MediaPlayer para
     * controlar que no tengamos errores de acople de video, sonido y/o
     * reproducción.
     * 
     * @param url , String con el enlace introducido en las opciones del diálogo.
     */

    public void reproducirEnlace(String url) {
        if (!panelYt.isVisible()) { // Si el panel de youtube no está visible, estamos reproduciendo desde archivo.
            panelYt.setVisible(true);
            frame.add(panelYt);
        }
        if (panelFx.isVisible()) {
            panelFx.setVisible(false);
            // Comprobamos los estamos por si hay otro vídeo reproduciendose, eliminarlo.
            if (mp != null) {
                if (mp.getStatus() == Status.PLAYING || mp.getStatus() == Status.STALLED
                        || mp.getStatus() == Status.PAUSED) {
                    mp.stop();
                    mp.dispose();
                }
            }
        }
        // Formmamos el enlace de youtube.
        String[] splitUrl = url.split("=");
        String enlace = "https://www.youtube.com/embed/" + splitUrl[1] + "?rel=0&amp;autoplay=1";

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // Cargamos el vídeo
                webview.getEngine().load(enlace);
                webview.setPrefSize(500, 300);
                panelYt.setScene(new Scene(new Group(webview)));
                panelYt.updateUI();
                panelYt.repaint();
            }
        });
    }

    /**
     * Método fichero, abre el selector de archivos y se asegura de que hayamos
     * seleccionado uno para agregar el panel al frame y llamar al método crear
     * escena.
     */
    public void fichero() {
        // Abrimos el dialogo y comprobamos que se ha seleccionado un archivo.
        if (selector.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            ruta = selector.getSelectedFile();
            frame.add(panelFx);
            crearEscena();
        }
    }

    /**
     * Método estrico en JavaFx, usado para la reprodución de vídeos desde los
     * archivos. Para controlar que no se mezclen dos vídeos trabajamos con la
     * visibilidad de los paneles en los que se reproducen.
     */
    public void crearEscena() {
        if (panelYt.isVisible()) {
            panelYt.setVisible(false);
            Platform.runLater(new Runnable() {
                // Entre la carga de un vídeo y otro, metenemos una página en blanco para
                // controlar los errores de acople de sonido e imagen.
                @Override
                public void run() {
                    webview.getEngine().load("about:blank");
                }
            });

        }
        if (!panelFx.isVisible()) {
            panelFx.setVisible(true);
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                mp = new MediaPlayer(new Media(ruta.toURI().toString()));
                // Comprobamos lo estados del MediaPlayer para controlar que no se esté
                // reproduciendo otro vídeo.
                if (mp.getStatus() == Status.PLAYING || mp.getStatus() == Status.STALLED
                        || mp.getStatus() == Status.PAUSED) {
                    mp.stop();
                    mp.dispose();
                }
                // Creamos la escena y la ponemos en el panel.
                panelFx.setScene(new Scene(new Group(new MediaView(mp))));
                mp.setVolume(0.7);
                // Lanzamos la reproducción del vídeo.
                mp.play();
                panelFx.updateUI();
                panelFx.repaint();
            }
        });
    }
}