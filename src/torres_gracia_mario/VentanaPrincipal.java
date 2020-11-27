

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author Mario Gracia
 */

public class VentanaPrincipal {
    private JFrame ventana;
    public VentanaPrincipal() {
        ventana = new JFrame("Sonidos de animales");
        ventana.setBounds(50, 50, 800, 800);
        ventana.getContentPane();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void inicializarComponentes() {
        ventana.setLayout(new GridLayout(1,1));
        String[][]  imagenAnimal = {{"img/leon.jpg","img/lobo.jpg","img/rana.jpg"},{"img/orca.jpg","img/komodo.jpg","img/elefante.jpg"},{"img/vaca.jpg","img/rinoceronte.jpg","img/cuervo.jpg"}};  
        String[][] sonidosAnimales ={{"sonidos/leon.wav","sonidos/lobo.wav","sonidos/rana.wav"},{"sonidos/orca.wav","sonidos/komodo.wav","sonidos/elefante.wav"},{"sonidos/vaca.wav","sonidos/rinoceronte.wav","sonidos/cuervo.wav"}};
        PanelesAnimales panel = new PanelesAnimales(imagenAnimal,sonidosAnimales);
        ventana.add(panel);	
    }

    

    public void inicializar() {
        ventana.setVisible(true);
        inicializarComponentes();
    }

}
