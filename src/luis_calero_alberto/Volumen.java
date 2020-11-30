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
    String[] medidas = { "Metros^3", "litro", "Mililitro" };

    Double volumenInicial = 0.;
    Double volumenEnMetros = 0.;// Aqui guardaremos el paso intermedio
    Double volumenFinal = 0.;

    JTextField numeroInicial;

    JTextField textoResultado;

    JTextField numeroResultado;

    public Volumen(JPanel panel) {
        this.panel = panel;
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
        textoResultado.setEditable(false);
        textoResultado.setBorder(null);
        numeroResultado = new JTextField();
        // Colocamos los elementos
        panel.setLayout(new GridBagLayout());
        GridBagConstraints settings;

        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 1;

        settings.insets = new Insets(20, 20, 20, 00);
        panel.add(medidaInicial, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 1;
        settings.insets = new Insets(20, 20, 20, 00);
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.weightx = 1;
        panel.add(numeroInicial, settings);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 2;
        settings.insets = new Insets(20, 20, 20, 00);

        panel.add(medidaFinal, settings);
        JTextField vacio = new JTextField();
        vacio.setBorder(null);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 2;
        settings.insets = new Insets(20, 20, 20, 00);
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
        settings.insets = new Insets(20, 20, 20, 0);
        settings.weightx = 1;
        settings.gridwidth = 2;
        settings.ipadx = 200;
        settings.fill = GridBagConstraints.HORIZONTAL;
        panel.add(numeroResultado, settings);
        // Quitamos el textfield que no usamos
        vacio.setEditable(false);
        vacio.setBackground(panel.getBackground());

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
