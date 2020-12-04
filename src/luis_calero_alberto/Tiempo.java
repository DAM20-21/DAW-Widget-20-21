package luis_calero_alberto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @author Alberto Luis Calero
 * 
 *         Convierte una medida de tiempo en otra que quiera el usuario
 */
public class Tiempo extends JPanel implements KeyListener, ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JComboBox<String> medidaInicial;
    JComboBox<String> medidaFinal;

    int seleccionInicial;
    int seleccionFinal;
    /**
     * Conversiones de unas medidas a otras
     */
    Double[] conversionAMinutos = { 1.0, 0.000016, 0.0166, 60., (24 * 60.), (7 * 60 * 24.), (30 * 60 * 24.),
            (365 * 7 * 60 * 24.), (3650 * 7 * 60 * 24.), (36500 * 7 * 60 * 24.) };
    Double[] conversionDeMinutosA = { 1.0, 60000., 60., 0.0166667, 0.0006944, 9.9206E-5, 2.2831E-5, 1.9026E-6,
            1.9026E-7, 1.9026E-8 };
    /**
     * Medidas entre las que haremos las conversiones
     */
    String[] medidas = { "Minutos", "Milisegundos", "Segundos", "Horas", "Dias", "Semanas", "Meses", "Años", "Decadas",
            "Siglos" };

    Double tiempoInicial = 0.;
    Double tiempoEnMinutos = 0.;// Aqui guardaremos el paso intermedio
    Double tiempoFinal = 0.;

    JTextField numeroInicial;

    JTextField textoResultado;

    JTextField numeroResultado;

    public Tiempo() {
        anadirElementoTiempo();
    }

    /**
     * Inicializamos y anadimos los elementos
     */
    public void anadirElementoTiempo() {
        // Inicializamos los elementos
        medidaInicial = new JComboBox<>(new DefaultComboBoxModel<>(medidas));
        medidaFinal = new JComboBox<>(new DefaultComboBoxModel<>(medidas));
        numeroInicial = new JTextField("0");
        textoResultado = new JTextField();
        numeroResultado = new JTextField();
        // Colocamos los elementos
        Utilidades.colocarElementos(this, medidaInicial, medidaFinal, numeroInicial, textoResultado, numeroResultado);

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
                tiempoInicial = Double.parseDouble(numeroInicial.getText());
            } catch (NumberFormatException n) {
                ;
            }
            DecimalFormat df = new DecimalFormat("#.00000000");// Formateamos el numero para que solo nos muestre unos
                                                               // cuantos decimales
            numeroResultado.setText(df.format(calcularResultado()));
            DecimalFormat dfTexto = new DecimalFormat("#.000");
            textoResultado.setText(tiempoInicial + " " + medidas[seleccionInicial] + " son "
                    + dfTexto.format(calcularResultado()) + " " + medidas[seleccionFinal]);

        }

    }

    /**
     * Accion que realizaran el JComboBox
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        seleccionInicial = medidaInicial.getSelectedIndex();// Recogemos la posicion que se ha registrado
        seleccionFinal = medidaFinal.getSelectedIndex();
        DecimalFormat df = new DecimalFormat("#.0000000");
        numeroResultado.setText(df.format(calcularResultado()));
        DecimalFormat dfTexto = new DecimalFormat("#.000");
        textoResultado.setText(tiempoInicial + " " + medidas[seleccionInicial] + " son "
                + dfTexto.format(calcularResultado()) + " " + medidas[seleccionFinal]);
    }

    /**
     * Cada vez que cambiemos el JComboBox actualizaremos el texto
     */

    /**
     * Calcula la conversion primero convierte a metros y despues a la medida
     * seleccionada
     * 
     * @return double que mostraremos como resultado
     */
    public double calcularResultado() {
        tiempoEnMinutos = tiempoInicial * conversionAMinutos[seleccionInicial];
        tiempoFinal = tiempoEnMinutos * conversionDeMinutosA[seleccionFinal];
        return tiempoFinal;
    }

}
