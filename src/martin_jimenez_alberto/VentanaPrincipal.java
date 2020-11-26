import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class VentanaPrincipal {
    ArrayList<Fichero> listaFICHEROS ;//Lista que guarda Objetos Fichero
    int nFICHEROS;

    JFrame f;
    JPanel previewTexto;
    JTextField titulo;

    VentanaPrincipal() {
        f = new JFrame();
        f.setBounds(1000, 100, 200, 300);
    }
    public void anadirComponentes() {
        nFICHEROS = listaFICHEROS.size();//Para tranajar con la misma variable en todos los métodos
        GridLayout gl;
        if(nFICHEROS<5){
            gl = new GridLayout(5,0);
        }else{
            gl = new GridLayout(nFICHEROS,0);
        }
        f.setLayout(gl); 
        
        for(int i=0 ; i<nFICHEROS ; i++){//Añadir los ficheros a f
            
        }

        
    }
    
    public void incializar() {
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guardarFicheros();
        anadirComponentes();
    }

    /**
     * Devuelve el número de ficheros que hay en la carpeta de los ficheros
     * @return nFich 
     */
    public int importarInfo() {
        int nFich;

        File carpeta = new File("src/martin_jimenez_alberto/Ficheros"); 
        File[] lista = carpeta.listFiles();
        nFich = lista.length;

        return nFich;
    }

    public void guardarFicheros(){
        listaFICHEROS = new ArrayList<>();

        for(int i=0 ; i<importarInfo() ; i++){

        }
    }
}