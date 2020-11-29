package nofuentes_mendez_elena;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer.Status;

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
    private File ruta;
    private JFileChooser selector;
    private JFrame frame;

    /**
     * Constructor por defecto Usado para reproducir videos por URL
     */
    // WidgetVideoElena() {
    // panel = new JPanel();
    // web = new JWebBrowser();
    // panelFx = new JFXPanel();
    // }

    /**
     * Constructor parametrizado Usado para reproducir videos desde archivos.
     * 
     * @param file, fichero seleccionado.
     */
    WidgetVideoElena(JFrame frame) {
        this.frame = frame;
        selector = new JFileChooser();
        web = new JWebBrowser();
        panelFx = new JFXPanel();
    }

    /**
     * Método creado para la reproduccion de enlaces
     * 
     */
    public JPanel getBrowserPanel(String url) {
        panel.setLayout(new GridLayout(1, 1));
        web.setBarsVisible(false);
        web.navigate(url);
        panel.add(web);
        panel.revalidate();
        panel.repaint();

        return panel;
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
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MediaPlayer mp = new MediaPlayer(new Media(ruta.toURI().toString()));
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
}