package luis_calero_alberto;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alberto Luis Calero
 * 
 *         Ventana principal donde se añadiran los elementos que necesitemos ,
 *         en este caso solo se añade el Widget ,un JPanelConversor
 */
public class VentanaPrincipal {
    private JFrame ventana;
    private JPanelConversor panel;

    public VentanaPrincipal() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Inicializamos y anadimos el PanelConversor
     */
    public void inicializarComponentes() {
        panel = new JPanelConversor();
        ventana.setLayout(new GridLayout(1, 1));
        ventana.add(panel);

    }

    public void inicializar() {
        ventana.setVisible(true);
        inicializarComponentes();

    }

}
