package luis_calero_alberto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alberto Luis Calero En esta clase convertiremos una medida en otra ,
 *         como referencia usaremos el metro , es decir cuando introduzcan una
 *         medida la pasaremos siempre a metros , y despues la pasaremos a a la
 *         unidad solicitada Por ejemplo nos piden que pasemos 10 centimetros a
 *         kilometros el proceso seria 10cm son 0.1 metros y 0.1 metros son
 *         0.0001 km
 * 
 */
public class Longitud implements KeyListener, ActionListener {

    JPanel panel;

    JComboBox<String> medidaInicial;
    JComboBox<String> medidaFinal;

    int seleccionInicial;
    int seleccionFinal;
    /**
     * Conversiones con las que calcularemos los resultados
     */
    Double[] conversionaMetros = { 1.0, 1000.0, 0.1, 0.01, 0.001, 1852.00, 0.91, 1609.34 };
    Double[] conversiondeMetrosA = { 1.0, 0.001, 10., 100., 1000., 0.000539957, 1.09361, 0.000621 };
    /**
     * Medidas de los JComBoBox
     */
    String[] medidas = { "Metros", "Kilometros", "Decimetros", "Centimetros", "Milimetros", "Millas nauticas", "Yardas",
            "Millas" };
    /**
     * 
     */
    Double distanciaInicial = 0.;
    Double distanciaenMetros = 0.;// Aqui guardaremos el paso intermedio
    Double distanciaFinal = 0.;

    JTextField numeroInicial;

    JTextField textoResultado;

    JTextField numeroResultado;

    /**
     * Contructor de la clase
     * 
     * @param panel en este panel anadiremos la interfaz
     */
    public Longitud(JPanel panel) {
        this.panel = panel;

    }

    /**
     * inicializar elementos y anadirlos al panel
     */
    public void anadirElementoLongitud() {
        // Inicializamos los elementos
        medidaInicial = new JComboBox<>(new DefaultComboBoxModel<>(medidas));
        medidaFinal = new JComboBox<>(new DefaultComboBoxModel<>(medidas));
        numeroInicial = new JTextField("0");
        textoResultado = new JTextField();
        numeroResultado = new JTextField();
        // Colocamos los elementos
        Utilidades.colocarElementos(panel, medidaInicial, medidaFinal, numeroInicial, textoResultado, numeroResultado);

        medidaInicial.addActionListener(this);
        medidaFinal.addActionListener(this);

        numeroInicial.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    /**
     * Cuando cambiemos el texto cambiara el resultado final
     */
    @Override
    public void keyReleased(KeyEvent e) {

        if (!(numeroInicial.getText().isEmpty()) && numeroInicial.getText().matches("[0-9\\.]*")) {
            try {// try por si el usuario nos pone mas de un punto
                distanciaInicial = Double.parseDouble(numeroInicial.getText());
            } catch (NumberFormatException n) {
                ;
            }
            DecimalFormat df = new DecimalFormat("#.00000000");// Formateamos el numero para que solo nos muestre unos
                                                               // cuantos decimales
            numeroResultado.setText(df.format(calcularResultado()));
            DecimalFormat dfTexto = new DecimalFormat("#.0000");
            textoResultado.setText(distanciaInicial + " " + medidas[seleccionInicial] + " son "
                    + dfTexto.format(calcularResultado()) + " " + medidas[seleccionFinal]);

        }

    }

    /**
     * Cada vez que cambiemos el JComboBox actualizaremos el texto
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        seleccionInicial = medidaInicial.getSelectedIndex();// Recogemos la posicion que se ha registrado
        seleccionFinal = medidaFinal.getSelectedIndex();
        DecimalFormat df = new DecimalFormat("#.00000000");
        numeroResultado.setText(df.format(calcularResultado()));
        DecimalFormat dfTexto = new DecimalFormat("#.0000");
        textoResultado.setText(distanciaInicial + " " + medidas[seleccionInicial] + " son "
                + dfTexto.format(calcularResultado()) + " " + medidas[seleccionFinal]);
    }

    /**
     * Calcula la conversion primero convierte a metros y despues a la medida
     * seleccionada
     * 
     * @return double que mostraremos como resultado
     */
    public double calcularResultado() {
        distanciaenMetros = distanciaInicial * conversionaMetros[seleccionInicial];
        distanciaFinal = distanciaenMetros * conversiondeMetrosA[seleccionFinal];
        return distanciaFinal;
    }
}
