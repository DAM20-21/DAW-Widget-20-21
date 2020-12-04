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
     * Paneles donde iran los conversores
     */
    JPanel[] panelesCalculadora;

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
        panelesCalculadora = new JPanel[9];
        // TabbedPane en el que iran todas las opciones
        tabbedPane = new JTabbedPane();
        for (int i = 0; i < nombres.length; i++) {
            panelesCalculadora[i] = new JPanel();
            tabbedPane.addTab(nombres[i], panelesCalculadora[i]);
        }
        // Creamos nuestros conversores
        Porcentaje porcentaje = new Porcentaje(panelesCalculadora[0]);
        Descuento descuento = new Descuento(panelesCalculadora[1]);
        Longitud longitud = new Longitud(panelesCalculadora[2]);
        Area area = new Area(panelesCalculadora[3]);
        Volumen volumen = new Volumen(panelesCalculadora[4]);
        Divisas divisas = new Divisas(panelesCalculadora[5]);
        Velocidad velocidad = new Velocidad(panelesCalculadora[6]);
        Tiempo tiempo = new Tiempo(panelesCalculadora[7]);
        Masa masa = new Masa(panelesCalculadora[8]);
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
