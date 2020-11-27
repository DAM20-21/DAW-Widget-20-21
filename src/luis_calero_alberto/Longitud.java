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
 * En esta clase convertiremos una medida en otra , como referencia usaremos el
 * metro , es decir cuando introduzcan una medida la pasaremos siempre a metros
 * , y despues la pasaremos a a la unidad solicitada Por ejemplo nos piden que
 * pasemos 10 centimetros a kilometros el proceso seria 10cm son 0.1 metros y
 * 0.1 metros son 0.0001 km
 * 
 */
public class Longitud implements KeyListener, ActionListener {

    JPanel panel;

    JComboBox<String> medidaInicial;
    JComboBox<String> medidaFinal;

    int seleccionInicial;
    int seleccionFinal;
    Double[] conversionaMetros = { 1.0, 1000.0, 0.1, 0.01, 0.001, 1852.00, 0.91, 1609.34 };
    Double[] conversiondeMetrosA = { 1.0, 0.001, 10., 100., 1000., 0.000539957, 1.09361, 0.000621 };

    String[] medidas = { "Metros", "Kilometros", "Decimetros", "Centimetros", "Milimetros", "Millas nauticas", "Yardas",
            "Millas" };

    Double distanciaInicial = 0.;
    Double distanciaenMetros = 0.;// Aqui guardaremos el paso intermedio
    Double distanciaFinal = 0.;

    JTextField numeroInicial;

    JTextField textoResultado;

    JTextField numeroResultado;

    public Longitud(JPanel panel) {
        this.panel = panel;

    }

    public void anadirElementoLongitud() {
        // Inicializamos los elementos
        medidaInicial = new JComboBox<>(new DefaultComboBoxModel<>(medidas));
        medidaFinal = new JComboBox<>(new DefaultComboBoxModel<>(medidas));

        numeroInicial = new JTextField("0");
        textoResultado = new JTextField();
        textoResultado.setEditable(false);
        textoResultado.setBorder(null);
        numeroResultado = new JTextField();
        // Colocamos los elementos
        panel.setLayout(new GridBagLayout());
        GridBagConstraints settings = new GridBagConstraints();

        settings.gridx = 0;
        settings.gridy = 1;

        settings.insets = new Insets(5, 20, 20, 5);
        panel.add(medidaInicial, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 1;
        settings.insets = new Insets(5, 20, 20, 5);
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.weightx = 1;
        panel.add(numeroInicial, settings);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 2;
        settings.insets = new Insets(5, 20, 20, 5);

        panel.add(medidaFinal, settings);
        JTextField vacio = new JTextField();
        vacio.setBorder(null);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 2;
        settings.insets = new Insets(5, 20, 20, 5);
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.weightx = 1;
        panel.add(vacio, settings);//
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 4;
        settings.insets = new Insets(5, 20, 20, 5);
        settings.gridwidth = 3;
        settings.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textoResultado, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 3;
        settings.insets = new Insets(05, 20, 20, 05);
        settings.weightx = 1;
        settings.gridwidth = 2;
        settings.ipadx = 200;
        settings.fill = GridBagConstraints.HORIZONTAL;
        panel.add(numeroResultado, settings);

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

        if (!(numeroInicial.getText().isEmpty()) && numeroInicial.getText().matches("[0-9]*")) {
            distanciaInicial = Double.parseDouble(numeroInicial.getText());
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
