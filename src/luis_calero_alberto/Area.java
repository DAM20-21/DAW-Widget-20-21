package luis_calero_alberto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Area implements KeyListener, ActionListener {

    JPanel panel;
    JButton volver;
    JComboBox<String> medidaInicial;
    JComboBox<String> medidaFinal;

    int seleccionInicial;
    int seleccionFinal;

    Double[] conversion = { 1.0, 0.000001, 0.0001, 1000000., 10000., 1852.00, 0.91, 1609.34 };

    String[] medidas = { "Metros^2", "Kilometros^2", "Hectarea", "Milimetros^2", "Centimetros^2", "Yardas^2",
            "Millas^2" };

    Double distanciaInicial = 0.;
    Double distanciaenMetros = 0.;// Aqui guardaremos el paso intermedio
    Double distanciaFinal = 0.;

    JTextField numeroInicial;

    JTextField textoResultado;

    JTextField numeroResultado;

    public Area(JPanel panel) {
        this.panel = panel;
    }

    public void anadirElementoArea() {
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
        settings.gridy = 3;
        settings.insets = new Insets(20, 20, 20, 00);
        settings.ipadx = 200;
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
