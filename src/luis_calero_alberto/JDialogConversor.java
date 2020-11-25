package calero_luis_alberto;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.*;

public class JDialogConversor extends JDialog {

    /**
     * Numero Serial
     */
    private static final long serialVersionUID = 1L;

    JButton[] opcionesIniciales;
    JButton volver;

    public JDialogConversor(JFrame padre) {
        super();
        setModal(true);
        setBounds(100, 100, 500, 700);
        volver = new JButton("<---Volver");// El boton volver es el mismo para todas las interfaces por lo que lo
                                           // creamos una vez y le damos el listener
        anadirElementoPrincipal();
        anadirListener();

    }

    private void anadirElementoPrincipal() {
        this.getContentPane().removeAll();
        String[] nombres = { "Porcentaje", "Descuento", "Longitud", "Area", "Volumen", "Divisas", "Velocidad", "Tiempo",
                "Masa" };
        this.setLayout(new GridLayout(3, 3));
        opcionesIniciales = new JButton[9];
        for (int i = 0; i < opcionesIniciales.length; i++) {
            opcionesIniciales[i] = new JButton(nombres[i]);
            this.add(opcionesIniciales[i]);
        }
        refrescarPantalla();

    }

    private void anadirListener() {
        opcionesIniciales[0].addActionListener(e -> {
            Porcentaje porcentaje = new Porcentaje(this, volver);
            this.getContentPane().removeAll();
            porcentaje.anadirElementoPorcentaje();
            refrescarPantalla();
        });

        opcionesIniciales[1].addActionListener(e -> {
            Descuento descuento = new Descuento(this, volver);
            this.getContentPane().removeAll();
            descuento.anadirElementoDescuento();
            refrescarPantalla();
        });

        opcionesIniciales[2].addActionListener(e -> {
            Longitud longitud = new Longitud(this, volver);
            this.getContentPane().removeAll();
            longitud.anadirElementoLongitud();
            refrescarPantalla();
        });

        volver.addActionListener(e -> {
            anadirElementoPrincipal();
            anadirListener();
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
