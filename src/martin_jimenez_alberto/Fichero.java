import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {
    private String titulo;
    private String texto;
    private VentanaNota ventNot;

    Fichero(String titulo,String texto,VentanaNota vn){
        this.titulo = titulo;
        this.texto = texto;
        this.ventNot = vn;
        anadirCarpeta();
    }

    public VentanaNota getVentNot() {
        return this.ventNot;
    }

    public void setVentNot(VentanaNota ventNot) {
        this.ventNot = ventNot;
    }
    
    /**
     * Crea un fichero con los parámetros dados
     */
    private void anadirCarpeta() {
        String direccion = "DAW-Widget-20-21/ficheros/Ficheros/";
        direccion += titulo;
        direccion += ".txt";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(direccion));
            bw.write(texto);
            bw.close();
        }catch (IOException io) {
            System.out.println("Error en la E/S: " + io.getMessage());
        }
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public static String  getTexto(String lec) {
    String texto = null;
    lec = "DAW-Widget-20-21/ficheros/Ficheros/".concat(lec);
    lec += "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(lec));
            String linea;
            while ((linea = br.readLine()) != null) {
                texto += linea;
            }
            br.close();

        } catch (IOException io) {
            System.out.println("Error en la E/S: " + io.getMessage());
        }
        return texto;
    }

    public void mostrarFichero(){
        String titulor = getTitulo();
        titulor += ".txt";
        String textor = getTexto(titulor);
        try{
            VentanaNota vn = new VentanaNota(ventNot.vp,titulor,textor);
            vn.incializar();
        }catch(Exception ex){
            ex.printStackTrace(); 
        }
    }
}
