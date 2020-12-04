package ventura_hermoso_alberto;

import java.io.File;

import javax.swing.JFileChooser;

/**
 * Clase que contiene las acciones de los botones
 * 
 * @author Alberto Ventura Hermoso
 */
public class Acciones_Botones {
    private File fichero;// Archivo que se reproducirá
    JFileChooser selector;// Elemento que permite elejir el archivo
    private Widget_audio ventana;// Elemento de la interfaz del widget
    private Reproduccion music;// Elemento que nos permite reproducir el archivo

    /**
     * Método que permite a traves de un JFilechooser elejir el archivo que queremos
     * reproducir
     */
    public void selecionFichero() {
        ventana = new Widget_audio();
        int seleccion;
        selector = new JFileChooser("./sonidos");
        selector.setFileFilter(new Filtro_archivos(".mp3"));
        seleccion = selector.showOpenDialog(ventana.getVentana());
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            fichero = selector.getSelectedFile();
        }
        play();
    }

    /**
     * Metodo que comienza e reproducir
     */
    public void play() {
        music = new Reproduccion(fichero);
        music.start();
    }

    /**
     * Metodo para pausar
     */
    public void pause() {
        music.setPause(true);

    }

    // GETTERS Y SETTERS
    public File getFichero() {
        return this.fichero;
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }

    public JFileChooser getSelector() {
        return this.selector;
    }

    public void setSelector(JFileChooser selector) {
        this.selector = selector;
    }

    public Widget_audio getVentana() {
        return this.ventana;
    }

    public void setVentana(Widget_audio ventana) {
        this.ventana = ventana;
    }

    public Reproduccion getMusic() {
        return this.music;
    }

    public void setMusic(Reproduccion music) {
        this.music = music;
    }

}
