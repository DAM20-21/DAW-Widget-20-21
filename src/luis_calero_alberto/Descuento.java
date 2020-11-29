package luis_calero_alberto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class Descuento implements KeyListener {

    JTextField textoPrecioOriginal;

    JTextField numeroPrecioInicial;

    JTextField textoDescuento;

    JTextField numeroDescuento;

    JTextField textoPrecioFinal;

    JTextField numeroPrecioFinal;

    JPanel panel;

    Double precioFinal = 0.;
    Double resta = 0.;
    Double porcentaje = 0.;
    Double precioInicial = 0.;

    public Descuento(JPanel panel) {
        this.panel = panel;

    }

    public void anadirElementoDescuento() {

        textoPrecioOriginal = new JTextField("Precio inicial :");
        textoPrecioOriginal.setEditable(false);
        numeroPrecioInicial = new JTextField("0");
        textoDescuento = new JTextField("Descuento en el precio :");
        textoDescuento.setEditable(false);
        numeroDescuento = new JTextField("0");
        textoPrecioFinal = new JTextField("El precio final es :");
        textoPrecioFinal.setEditable(false);
        numeroPrecioFinal = new JTextField();
        numeroPrecioFinal.setEditable(false);

        textoPrecioFinal.setBorder(null);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints settings = new GridBagConstraints();

        settings.gridx = 0;
        settings.gridy = 1;
        settings.ipadx = 150;
        settings.insets = new Insets(20, 20, 20, 20);
        panel.add(textoPrecioOriginal, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 1;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.weightx = 1;
        panel.add(numeroPrecioInicial, settings);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 2;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.ipadx = 150;
        panel.add(textoDescuento, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 2;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.weightx = 1;
        panel.add(numeroDescuento, settings);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 3;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.ipadx = 150;
        panel.add(textoPrecioFinal, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 3;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.weightx = 1;
        settings.ipadx = 100;
        settings.fill = GridBagConstraints.HORIZONTAL;
        panel.add(numeroPrecioFinal, settings);

        numeroPrecioInicial.addKeyListener(this);
        numeroDescuento.addKeyListener(this);

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
     * Segun vayamos cambiando el valor en los campos se actualizara el precio final
     */
    @Override
    public void keyReleased(KeyEvent e) {
        // Comprueba que no esta vacion y que es un numero
        if (!(numeroPrecioInicial.getText().isEmpty()) && numeroPrecioInicial.getText().matches("[0-9\\.]*")) {
            try {
                precioInicial = Double.parseDouble(numeroPrecioInicial.getText());// Recogemos el valor del campo
            } catch (NumberFormatException n) {
                ;
            }
            precioFinal = precioInicial - (precioInicial * porcentaje);
            numeroPrecioFinal.setText("" + precioFinal);// Actualizamos la cuenta
        }
        // Comprueba que no esta vacion y que es un numero
        if (!(numeroDescuento.getText().isEmpty()) && numeroDescuento.getText().matches("[0-9\\.]*")) {
            try {
                porcentaje = Double.parseDouble(numeroDescuento.getText()) / 100;
            } catch (NumberFormatException n) {
                ;
            }
            precioFinal = precioInicial - (precioInicial * porcentaje);
            numeroPrecioFinal.setText("" + precioFinal);
        }

    }
}
