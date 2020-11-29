import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Fichero {
    private String titulo;
    private String texto;

    Fichero(String t,String texto){
        titulo = t;
        this.texto = texto;
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

	public static void nuevaNota() {
                try{
                    VentanaNota vn = new VentanaNota();
                    vn.incializar();
                }catch(Exception e){
                    e.printStackTrace(); 
                }
                
	}

}
