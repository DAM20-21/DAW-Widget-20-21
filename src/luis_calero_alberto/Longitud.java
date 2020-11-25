package calero_luis_alberto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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

    JDialog dialogo;
    JButton volver;
    JComboBox<String> medidaInicial;
    JComboBox<String> medidaFinal;

    int seleccionInicial;
    int seleccionFinal;

    Double[] conversion = { 1.0, 1000.0, 0.1, 0.01, 0.001, 1852.00, 0.91, 1609.34 };

    String[] medidas = { "Metros", "Kilometros", "Decimetros", "Centimetros", "Milimetros", "Millas nauticas", "Yardas",
            "Millas" };

    Double distanciaInicial = 0.;
    Double distanciaenMetros = 0.;// Aqui guardaremos el paso intermedio
    Double distanciaFinal = 0.;

    JTextField numeroInicial;

    JTextField textoResultado;

    JTextField numeroResultado;

    public Longitud(JDialog dialogo, JButton volver) {
        this.dialogo = dialogo;
        this.volver = volver;
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
        dialogo.setLayout(new GridBagLayout());
        GridBagConstraints settings = new GridBagConstraints();
        settings.gridx = 1;
        settings.gridy = 0;
        settings.insets = new Insets(20, 20, 20, 20);
        dialogo.add(volver, settings);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 1;

        settings.insets = new Insets(20, 20, 20, 20);
        dialogo.add(medidaInicial, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 1;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.weightx = 1;
        dialogo.add(numeroInicial, settings);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 2;
        settings.insets = new Insets(20, 20, 20, 20);

        dialogo.add(medidaFinal, settings);
        JTextField vacio = new JTextField();
        vacio.setBorder(null);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 2;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.weightx = 1;
        dialogo.add(vacio, settings);//
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 3;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.ipadx = 200;
        dialogo.add(textoResultado, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 3;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.weightx = 1;
        settings.ipadx = 150;
        settings.fill = GridBagConstraints.HORIZONTAL;
        dialogo.add(numeroResultado, settings);

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
        distanciaenMetros = distanciaInicial * conversion[seleccionInicial];
        distanciaFinal = distanciaenMetros / conversion[seleccionFinal];
        return distanciaFinal;
    }
}
