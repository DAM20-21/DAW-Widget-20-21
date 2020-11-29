package nofuentes_mendez_elena;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.web.WebView;

/**
 * WidgetVideoElena
 * 
 * @author Elena Nofuentes
 * @since 25-11-2020
 * @version 1.0
 * 
 */
public class WidgetVideoElena {
    /** Atributos de la clase */
    private JPanel panel;
    private JWebBrowser web;
    private JFXPanel panelFx;
    private JFXPanel panelYt;
    private File ruta;
    private JFileChooser selector;
    private JFrame frame;
    private WebView webview;
    private MediaPlayer mp;

    /**
     * Constructor parametrizado Usado para reproducir videos desde archivos.
     * 
     * 
     */
    WidgetVideoElena(JFrame frame) {
        this.frame = frame;
        panel = new JPanel();
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
     * Método creado para la reproduccion de enlaces.
     * 
     * Para que no se reproduzcan dos vídeos a la vez, al principio del método
     * comprobamos el contenido, si hay algdún vídeo, lo eliminamos y recargamos la
     * página.
     * 
     */
    public JPanel getBrowserPanel(String url) {
        /**
         * if (web != null) { panel.remove(web); web.disposeNativePeer();
         * web.reloadPage(); } web = new
         * JWebBrowser(JWebBrowser.destroyOnFinalization()); panel.setLayout(new
         * BorderLayout()); web.setBarsVisible(false); web.navigate(url);
         * panel.add(web); panel.revalidate(); panel.repaint();
         * 
         * return panel;
         */

        Group grupo = new Group();
        Media enlace = new Media(url);
        MediaPlayer mp = new MediaPlayer(enlace);
        mp.play();
        MediaView mv = new MediaView(mp);
        // panel.add();
        return panel;

    }

    public void prueba(String url) {
        if (!panelYt.isVisible()) {
            panelYt.setVisible(true);
            frame.add(panelYt);
        }
        if (panelFx.isVisible()) {
            panelFx.setVisible(false);
            if (mp != null) {
                if (mp.getStatus() == Status.PLAYING || mp.getStatus() == Status.STALLED
                        || mp.getStatus() == Status.PAUSED) {
                    mp.stop();
                    mp.dispose();
                }
            }
        }
        String[] splitUrl = url.split("=");
        String enlace = "https://www.youtube.com/embed/" + splitUrl[1] + "?rel=0&amp;autoplay=1";

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webview.getEngine().load(enlace);
                webview.setPrefSize(640, 390);

                panelYt.setScene(new Scene(new Group(webview)));

                panelYt.updateUI();
                panelYt.repaint();

            }

        });

    }

    public void fichero() {
        // Abrimos el dialogo
        // Comprobamos que se ha seleccionado un archivo.
        if (selector.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            ruta = selector.getSelectedFile();
            frame.add(panelFx);
            createScene();
        }
    }

    /**
     * Método usado para la reprodución de vídeos desde los archivos. Escrito con
     * JavaFX.
     */
    public void createScene() {
        if (panelYt.isVisible()) {
            panelYt.setVisible(false);
            Platform.runLater(new Runnable() {

                @Override
                public void run() {
                    webview.getEngine().load("about:blank");
                }

            });

        }
        if (!panelFx.isVisible())
            panelFx.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                mp = new MediaPlayer(new Media(ruta.toURI().toString()));
                if (mp.getStatus() == Status.PLAYING || mp.getStatus() == Status.STALLED
                        || mp.getStatus() == Status.PAUSED) {
                    mp.stop();
                    mp.dispose();
                }
                // Añadimos el video al JFxPanel
                panelFx.setScene(new Scene(new Group(new MediaView(mp))));
                mp.setVolume(0.7);
                mp.play();
                panelFx.updateUI();
                panelFx.repaint();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JFXPanel getPanelFx() {
        return panelFx;
    }

    public void setPanelFx(JFXPanel panelFx) {
        this.panelFx = panelFx;
    }

    public JWebBrowser getWeb() {
        return web;
    }

    public void setWeb(JWebBrowser web) {
        this.web = web;
    }

}