package luis_calero_alberto;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.*;

/**
 * @author Alberto Luis Calero
 * 
 *         En esta clase se introduciran dos paneles , uno con las diferentes
 *         opciones para convertir y otro en el que cambiaremos de interfaz
 *         segun el tipo de conversion que queramos hacer
 */
public class JPanelConversor extends JPanel {
    /**
     * Numero Serial
     */
    private static final long serialVersionUID = 1L;
    /**
     * Paneles donde iran los distintos conversores
     */
    JPanel[] panelesCalculadora = { new Porcentaje(), new Descuento(), new Longitud(), new Area(), new Volumen(),
            new Divisas(), new Velocidad(), new Tiempo(), new Masa() };

    JTabbedPane tabbedPane;

    public JPanelConversor() {
        super();
        anadirElementoPrincipal();
        anadirListener();

    }

    /**
     * Anadimos los elementos para la interfaz
     */
    private void anadirElementoPrincipal() {
        this.setLayout(new GridLayout(1, 1));
        String[] nombres = { "Porcentaje", "Descuento", "Longitud", "Area", "Volumen", "Divisas", "Velocidad", "Tiempo",
                "Masa" };

        // TabbedPane en el que iran todas las opciones
        tabbedPane = new JTabbedPane();
        for (int i = 0; i < nombres.length; i++) {
            tabbedPane.addTab(nombres[i], panelesCalculadora[i]);
        }
        this.add(tabbedPane);

        refrescarPantalla();

    }

    /**
     * Anadimos los listeners a los botones
     */
    private void anadirListener() {

    }

    /**
     * Método para refrescar la pantalla
     */
    public void refrescarPantalla() {
        this.revalidate();
        this.repaint();
    }

}
