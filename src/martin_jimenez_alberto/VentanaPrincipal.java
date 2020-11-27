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
        
        for(int i=0 ; i<nFICHEROS ; i++){//Añadir la vista de los ficheros a f
            /* previewTexto =  */
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
  

    public void guardarFicheros(){
        listaFICHEROS = new ArrayList<>();
        File carpeta = new File("DAW-Widget-20-21/ficheros/Ficheros"); 
        File[] lista = carpeta.listFiles();
        String titulo;
        String texto;
        String[] aux;

        for(int i=0 ; i<lista.length; i++){
            titulo = lista[i].getName();
            if(titulo.contains("/Ficheros")){
                aux = titulo.split("/Ficheros");
                titulo = aux[1];
                aux = titulo.split(".");
                titulo = aux[0];
            }else{
                System.out.println("MAL GUARDADO el fichero"+titulo);
            }
        }
    }
}