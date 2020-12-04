package luis_calero_alberto;

import javax.swing.JButton;

import javax.swing.JPanel;

import java.awt.*;

/**
 * @author Alberto Luis Calero
 * 
 *         En esta clase se introduciran dos paneles , uno con las diferentes
 *         opciones para convertir y otro en el que cambiaremos de interfaz
 *         segun el tipo de conversion que queramos hacer
 */
public class JPanelConversor extends JPanel {
    JPanel opciones;
    JPanel calculadora;
    /**
     * Numero Serial
     */
    private static final long serialVersionUID = 1L;

    JButton[] opcionesIniciales;

    public JPanelConversor() {
        super();
        anadirElementoPrincipal();
        anadirListener();

    }

    /**
     * Anadimos los elementos para la interfaz
     */
    private void anadirElementoPrincipal() {
        this.setLayout(new GridLayout(1, 2));
        opciones = new JPanel();
        String[] nombres = { "Porcentaje", "Descuento", "Longitud", "Area", "Volumen", "Divisas", "Velocidad", "Tiempo",
                "Masa" };
        opciones.setLayout(new GridLayout(3, 3));
        opcionesIniciales = new JButton[9];
        for (int i = 0; i < opcionesIniciales.length; i++) {
            opcionesIniciales[i] = new JButton(nombres[i]);
            opciones.add(opcionesIniciales[i]);
        }

        calculadora = new JPanel();
        this.add(opciones);
        this.add(calculadora);
        refrescarPantalla();

    }

    /**
     * Anadimos los listeners a los botones
     */
    private void anadirListener() {
        opcionesIniciales[0].addActionListener(e -> {
            Porcentaje porcentaje = new Porcentaje(calculadora);
            calculadora.removeAll();
            porcentaje.anadirElementoPorcentaje();
            refrescarPantalla();
        });

        opcionesIniciales[1].addActionListener(e -> {
            Descuento descuento = new Descuento(calculadora);
            calculadora.removeAll();
            descuento.anadirElementoDescuento();
            refrescarPantalla();
        });

        opcionesIniciales[2].addActionListener(e -> {
            Longitud longitud = new Longitud(calculadora);
            calculadora.removeAll();
            longitud.anadirElementoLongitud();
            refrescarPantalla();
        });

        opcionesIniciales[3].addActionListener(e -> {
            Area area = new Area(calculadora);
            calculadora.removeAll();
            area.anadirElementoArea();
            refrescarPantalla();

        });

        opcionesIniciales[4].addActionListener(e -> {
            Volumen volumen = new Volumen(calculadora);
            calculadora.removeAll();
            volumen.anadirElementoVolumen();
            refrescarPantalla();
        });

        opcionesIniciales[5].addActionListener(e -> {
            Divisas divisas = new Divisas(calculadora);
            calculadora.removeAll();
            divisas.anadirElementoDivisas();
            refrescarPantalla();
        });

        opcionesIniciales[6].addActionListener(e -> {
            Velocidad velocidad = new Velocidad(calculadora);
            calculadora.removeAll();
            velocidad.anadirElementoVelocidad();
            refrescarPantalla();
        });

        opcionesIniciales[7].addActionListener(e -> {
            Tiempo tiempo = new Tiempo(calculadora);
            calculadora.removeAll();
            tiempo.anadirElementoTiempo();
            refrescarPantalla();
        });

        opcionesIniciales[8].addActionListener(e -> {
            Masa masa = new Masa(calculadora);
            calculadora.removeAll();
            masa.anadirElementoMasa();
            refrescarPantalla();
        });

    }

    /**
     * Método para refrescar la pantalla
     */
    public void refrescarPantalla() {
        this.revalidate();
        this.repaint();
    }

}
