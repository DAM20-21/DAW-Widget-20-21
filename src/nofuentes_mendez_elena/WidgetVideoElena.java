package nofuentes_mendez_elena;

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

    /**
     * Constructor por defecto Usado para reproducir videos por URL
     */
    WidgetVideoElena() {
        panel = new JPanel();
        web = new JWebBrowser();
        panelFx = new JFXPanel();
    }

    /**
     * Constructor parametrizado Usado para reproducir videos desde archivos.
     * 
     * @param file, fichero seleccionado.
     */
    WidgetVideoElena(File file) {
        panel = new JPanel();
        web = new JWebBrowser();
        panelFx = new JFXPanel();
        ruta = file;
        createScene();
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

    /**
     * Método usado para la reprodución de vídeos desde los archivos. Escrito con
     * JavaFX.
     */
    public void createScene() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // Creamos el objecto MediaPlayer con la ruta del File que elegimos
                // anteriormente
                MediaPlayer oracleVid = new MediaPlayer(new Media(ruta.toURI().toString()));
                // Añadimos el video al JFxPanel
                panelFx.setScene(new Scene(new Group(new MediaView(oracleVid))));
                oracleVid.setVolume(0.7);
                // oracleVid.setCycleCount(MediaPlayer.INDEFINITE);// repite video
                oracleVid.play();
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