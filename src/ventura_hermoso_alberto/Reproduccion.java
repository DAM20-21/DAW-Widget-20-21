package ventura_hermoso_alberto;

import java.io.*;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * Esta es la clase que nos permite reproducir el archivo elejido
 * 
 * @author Alberto Ventura Hermoso
 */
public class Reproduccion extends Thread {
    private File fichero;// El archivo que queremos reproducir
    private boolean pause;// Booleano para saber si esta pausada la reproduccion
    private Player music;// Objeto Player de Javazoom

    /**
     * Constructor de la clase
     * 
     * @param fichero
     */
    public Reproduccion(File fichero) {
        this.fichero = fichero;
        pause = false;
        try {
            music = new Player(new FileInputStream(fichero));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException i) {
            i.printStackTrace();
        }
    }

    /**
     * Hilo que reproduce el archivo
     */
    @Override
    public void run() {
        try {
            while (true) {
                if (!pause) {
                    if (!music.play(1)) {
                    }
                }
            }
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    // GETTERS Y SETTERS
    public File getFichero() {
        return this.fichero;
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }

    public boolean getPause() {
        return this.pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public Player getMusic() {
        return this.music;
    }

    public void setMusic(Player music) {
        this.music = music;
    }

    /**
     * Metodo que indica si el la reproduccion esta pausada
     * 
     * @return
     */
    public boolean isPause() {
        return this.pause;
    }
}
