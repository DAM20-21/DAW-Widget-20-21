package luis_calero_alberto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import javax.swing.JComboBox;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Alberto Luis Calero Haremos conversiones entre volumenes con los
 *         datos del usuario
 */
public class Volumen implements KeyListener, ActionListener {

    JPanel panel;

    JComboBox<String> medidaInicial;
    JComboBox<String> medidaFinal;

    int seleccionInicial;
    int seleccionFinal;
    /**
     * Conversiones de unas medidas a otras
     */
    Double[] conversionDeMetrosA = { 1.0, 1000., 1000000. };
    Double[] conversionaMetros = { 1.0, 0.001, 0.000001 };
    /**
     * Medidas entre las que podemos convertir
     */
    String[] medidas = { "Metros^3", "litros", "Mililitros" };

    Double volumenInicial = 0.;
    Double volumenEnMetros = 0.;// Aqui guardaremos el paso intermedio
    Double volumenFinal = 0.;

    JTextField numeroInicial;

    JTextField textoResultado;

    JTextField numeroResultado;

    public Volumen(JPanel panel) {
        this.panel = panel;
        anadirElementoVolumen();
    }

    /**
     * Inicializamos y anadimos los elementos
     */
    public void anadirElementoVolumen() {
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
                volumenInicial = Double.parseDouble(numeroInicial.getText());
            } catch (NumberFormatException n) {
                ;
            }

            DecimalFormat df = new DecimalFormat("#.00000000");// Formateamos el numero para que solo nos muestre unos
                                                               // cuantos decimales
            numeroResultado.setText(df.format(calcularResultado()));
            DecimalFormat dfTexto = new DecimalFormat("#.0000");
            textoResultado.setText(volumenInicial + " " + medidas[seleccionInicial] + " son "
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
        textoResultado.setText(volumenInicial + " " + medidas[seleccionInicial] + " son "
                + dfTexto.format(calcularResultado()) + " " + medidas[seleccionFinal]);
    }

    /**
     * Calcula la conversion primero convierte a metros y despues a la medida
     * seleccionada
     * 
     * @return double que mostraremos como resultado
     */
    public double calcularResultado() {
        volumenEnMetros = volumenInicial * conversionaMetros[seleccionInicial];
        volumenFinal = volumenEnMetros * conversionDeMetrosA[seleccionFinal];
        return volumenFinal;
    }
}
