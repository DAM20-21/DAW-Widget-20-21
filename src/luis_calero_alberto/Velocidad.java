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

public class Velocidad implements KeyListener, ActionListener {
    JPanel panel;

    JComboBox<String> medidaInicial;
    JComboBox<String> medidaFinal;

    int seleccionInicial;
    int seleccionFinal;
    /**
     * Conversiones de unas medidas a otras
     */
    Double[] conversionaMetros = { 1.0, 0.277, 0.514, 0.447, 0.304 };
    Double[] conversiondeMetrosA = { 1.0, 3.6, 1.94, 2.23, 3.28 };
    /**
     * Medidas entre las que elegir
     */
    String[] medidas = { "Metros / segundo", "Kilometros/hora", "Nudo", "Milla/hora", "Pie/segundo" };

    Double distanciaInicial = 0.;
    Double distanciaenMetros = 0.;// Aqui guardaremos el paso intermedio
    Double distanciaFinal = 0.;

    JTextField numeroInicial;

    JTextField textoResultado;

    JTextField numeroResultado;

    public Velocidad(JPanel panel) {
        this.panel = panel;

    }

    /**
     * Inicializaremos y anadiremos los elementos de la interfaz
     */
    public void anadirElementoVelocidad() {
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
            DecimalFormat dfTexto = new DecimalFormat("#.000");
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
        DecimalFormat df = new DecimalFormat("#.0000000");
        numeroResultado.setText(df.format(calcularResultado()));
        DecimalFormat dfTexto = new DecimalFormat("#.000");
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
