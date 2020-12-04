package ventura_hermoso_alberto;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * Clase hija de FileFilter que nos permite filtrar los archivos del
 * JFileChooser
 * 
 * @author Alberto Ventura Hermoso
 */
public class Filtro_archivos extends FileFilter {
    private String extension;

    /**
     * Contrustor de la clase
     * 
     * @param extension
     */
    public Filtro_archivos(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File file) {
        // TODO Auto-generated method stub
        return obtenerExtension(file);
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean obtenerExtension(File file) {
        return file.getName().endsWith(extension);

    }

}
