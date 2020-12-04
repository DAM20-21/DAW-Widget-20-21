package luis_calero_alberto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @author Alberto Luis Calero
 * 
 *         En esta clase haremos las conversiones entre dos medidas de masa
 */
public class Masa implements KeyListener, ActionListener {
    JPanel panel;

    JComboBox<String> medidaInicial;
    JComboBox<String> medidaFinal;

    int seleccionInicial;
    int seleccionFinal;
    /**
     * Conversiones de unas medidas a otras
     */
    Double[] conversionAGramos = { 1000., 1.0, 1E6, 0.001, 28.3495, 453.59 };
    Double[] conversionDeGramosA = { 0.001, 1.0, 1E-6, 1000., 0.03527, 0.002204 };
    /**
     * Medidas entre las que podemos convertir
     */
    String[] medidas = { "Kilogramos", "Gramos", "Toneladas", "miligramos", "onzas", "Libras" };

    Double masaInicial = 0.;
    Double masaEnGramos = 0.;// Aqui guardaremos el paso intermedio
    Double masaFinal = 0.;

    JTextField numeroInicial;

    JTextField textoResultado;

    JTextField numeroResultado;

    public Masa(JPanel panel) {
        this.panel = panel;

    }

    /**
     * Inicializamos y anadimos los elementos
     */
    public void anadirElementoMasa() {
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
            try {
                masaInicial = Double.parseDouble(numeroInicial.getText());
            } catch (NumberFormatException n) {
                ;
            }
            DecimalFormat df = new DecimalFormat("#.00000000");// Formateamos el numero para que solo nos muestre unos
                                                               // cuantos decimales
            numeroResultado.setText(df.format(calcularResultado()));
            DecimalFormat dfTexto = new DecimalFormat("#.000");
            textoResultado.setText(masaInicial + " " + medidas[seleccionInicial] + " son "
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
        DecimalFormat df = new DecimalFormat("#.0000000");
        numeroResultado.setText(df.format(calcularResultado()));
        DecimalFormat dfTexto = new DecimalFormat("#.000");
        textoResultado.setText(masaInicial + " " + medidas[seleccionInicial] + " son "
                + dfTexto.format(calcularResultado()) + " " + medidas[seleccionFinal]);
    }

    /**
     * Calcula la conversion primero convierte a metros y despues a la medida
     * seleccionada
     * 
     * @return double que mostraremos como resultado
     */
    public double calcularResultado() {
        masaEnGramos = masaInicial * conversionAGramos[seleccionInicial];
        masaFinal = masaEnGramos * conversionDeGramosA[seleccionFinal];
        return masaFinal;
    }
}
