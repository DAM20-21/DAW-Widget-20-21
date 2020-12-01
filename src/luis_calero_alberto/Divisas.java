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
 *         Haremos conversiones entre diferentes monedas del mundo
 */
public class Divisas implements KeyListener, ActionListener {
    JPanel panel;

    JComboBox<String> medidaInicial;
    JComboBox<String> medidaFinal;
    /**
     * Guardaremos la opcion de los JComboBox
     */
    int seleccionInicial;
    int seleccionFinal;
    Double[] conversionAEuros = { 1., 0.006024, 0.84, 1.11, 0.042, 0.92, 14369.41 };
    Double[] conversionDeEurosA = { 1., 166.0, 1.2, 0.90, 23.97, 1.08, 0.00007 };
    /**
     * Divisas disponibles para convertir
     */
    String[] medidas = { "Euros", "Pesetas", "Dolares estadounidenses", "Libras esterlinas", "Peso mexicano",
            "Franco suizo", "Bitcoin" };

    Double divisaInicial = 0.;
    Double divisaEnEuros = 0.;// Aqui guardaremos el paso intermedio
    Double divisaFinal = 0.;

    JTextField numeroInicial;

    JTextField textoResultado;

    JTextField numeroResultado;

    public Divisas(JPanel panel) {
        this.panel = panel;

    }

    /**
     * Inicializamos y anadimos elementos
     */
    public void anadirElementoDivisas() {
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
        vacio.setEditable(false);
        vacio.setBackground(panel.getBackground());
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

        if (!(numeroInicial.getText().isEmpty()) && numeroInicial.getText().matches("[0-9\\.]*")) {
            try {
                divisaInicial = Double.parseDouble(numeroInicial.getText());
            } catch (NumberFormatException N) {
                ;
            }
            DecimalFormat df = new DecimalFormat("#.000000000000");// Formateamos el numero para que solo nos muestre
                                                                   // unos
            // cuantos decimales
            numeroResultado.setText("" + df.format(calcularResultado()));
            DecimalFormat dfTexto = new DecimalFormat("#.000");
            textoResultado.setText(divisaInicial + " " + medidas[seleccionInicial] + " son "
                    + dfTexto.format(calcularResultado()) + " " + medidas[seleccionFinal]);

        }

    }

    /**
     * Accion para los JCombobox
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        seleccionInicial = medidaInicial.getSelectedIndex();// Recogemos la posicion que se ha registrado
        seleccionFinal = medidaFinal.getSelectedIndex();
        DecimalFormat df = new DecimalFormat("#.0000000000000");
        numeroResultado.setText("" + df.format(calcularResultado()));
        DecimalFormat dfTexto = new DecimalFormat("#.000");
        textoResultado.setText(divisaInicial + " " + medidas[seleccionInicial] + " son "
                + dfTexto.format(calcularResultado()) + " " + medidas[seleccionFinal]);
    }

    /**
     * Cada vez que cambiemos el JComboBox actualizaremos el texto
     */

    /**
     * Calcula la conversion primero convierte a euros y despues a la medida
     * seleccionada
     * 
     * @return double que mostraremos como resultado
     */
    public double calcularResultado() {
        divisaEnEuros = divisaInicial * conversionAEuros[seleccionInicial];
        divisaFinal = divisaEnEuros * conversionDeEurosA[seleccionFinal];
        return divisaFinal;
    }
}
