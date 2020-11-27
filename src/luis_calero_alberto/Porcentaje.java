package luis_calero_alberto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class Porcentaje implements KeyListener {

    JPanel panel;

    JTextField porciento;

    JTextField numeroPorciento;

    JTextField mensajeTotal;

    JTextField numeroTotal;

    JTextField mensajeResultado;

    JTextField resultado;

    Double porcentaje = 0.;
    Double total = 0.;
    Double numeroResultado = 0.;

    Porcentaje(JPanel panel) {
        this.panel = panel;

    }

    public void anadirElementoPorcentaje() {

        porciento = new JTextField("Porcentaje:");
        porciento.setEditable(false);
        numeroPorciento = new JTextField();

        mensajeTotal = new JTextField("Total:");
        mensajeTotal.setEditable(false);
        numeroTotal = new JTextField();

        mensajeResultado = new JTextField();
        mensajeResultado.setEditable(false);
        resultado = new JTextField();
        resultado.setEditable(false);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints settings = new GridBagConstraints();

        settings.gridx = 0;
        settings.gridy = 1;
        settings.insets = new Insets(5, 20, 20, 20);
        panel.add(porciento, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 1;
        settings.insets = new Insets(5, 20, 20, 20);
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.weightx = 1;
        panel.add(numeroPorciento, settings);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 2;
        settings.insets = new Insets(5, 20, 20, 20);
        panel.add(mensajeTotal, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 2;
        settings.insets = new Insets(5, 20, 20, 20);
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.weightx = 1;
        panel.add(numeroTotal, settings);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 3;
        settings.insets = new Insets(5, 20, 20, 20);
        settings.ipadx = 150;
        panel.add(mensajeResultado, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 3;
        settings.insets = new Insets(5, 20, 20, 20);
        settings.weightx = 1;
        settings.ipadx = 100;
        settings.fill = GridBagConstraints.HORIZONTAL;
        panel.add(resultado, settings);

        numeroPorciento.addKeyListener(this);
        numeroTotal.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!(numeroPorciento.getText().isEmpty()) && numeroPorciento.getText().matches("[0-9]*")) {
            porcentaje = Double.parseDouble(numeroPorciento.getText()) / 100;
            resultado.setText("" + (porcentaje * total));
            mensajeResultado.setText("El " + (numeroPorciento.getText()) + " % de " + total + " es ");
        }

        if (!(numeroTotal.getText().isEmpty()) && numeroTotal.getText().matches("[0-9]*")) {
            total = Double.parseDouble(numeroTotal.getText());
            resultado.setText("" + (porcentaje * total));
            mensajeResultado.setText("El " + (numeroPorciento.getText()) + " % de " + total + " es ");
        }

    }

}
