
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * Esta clase se encarga de crear la interfaz principal del panel de
 * los animales,solo se encarga de implementar el frame y el widget
 * que dirige otra clase
 * 
 * {@link #inicializar()} //Este metodo se encarga de crear la ventana principal 
 * y del resto de componentes creados por el widgets
 *  
 * 
 * {@code
    public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();	
	} }
 * 
 * @author Mario Gracia Torres
 * @version 1.0
 * @since   1.0
 * @see Esta clase VentanaPrincipal esta unida a la clase
 *      PanelesAnimales,creando un atributo para que el resto de los componentes
 *      del panel se unen,pasandoselos por parametros
 * 
 */

public class VentanaPrincipal {

    //Se crea el frame principal con las medidas tomadas
    private JFrame ventana;
    public VentanaPrincipal() {
        ventana = new JFrame("Sonidos de animales");
        ventana.setBounds(60, 60, 800, 900);
        ventana.getContentPane();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Se le crea un gridLayout a ventana,se crea el atributo de la clase PanelAnimales
    //Y por parametros se le van pasando a la clase PanelesAnimales para que esta 
    //Pueda ir creando los componentes aparte
    public void inicializarComponentes() {
        ventana.setLayout(new GridLayout(1,1));
        String[][]  imagenAnimal = {{"img/leon.jpg","img/lobo.jpg","img/zorro.jpg"},{"img/ciervo.jpg","img/orca.jpg","img/komodo.jpg"},{"img/elefante.jpg","img/oso.jpg","img/vaca.jpg"}};  
        String[][] sonidosAnimales ={{"sonidos/leon.wav","sonidos/lobo.wav","sonidos/zorro.wav"},{"sonidos/ciervo.wav","sonidos/orca.wav","sonidos/komodo.wav"},{"sonidos/elefante.wav","sonidos/oso.wav","sonidos/vaca.wav"}};
        PanelesAnimales panel = new PanelesAnimales(imagenAnimal,sonidosAnimales);
        ventana.add(panel);	
    }

    

    public void inicializar() {
        ventana.setVisible(true);
        inicializarComponentes();
    }

}
