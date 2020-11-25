package luis_calero_alberto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import java.awt.*;

public class Porcentaje implements KeyListener {

    JDialog dialogo;
    JButton volver;

    JTextField porciento;

    JTextField numeroPorciento;

    JTextField mensajeTotal;

    JTextField numeroTotal;

    JTextField mensajeResultado;

    JTextField resultado;

    Double porcentaje = 0.;
    Double total = 0.;
    Double numeroResultado = 0.;

    Porcentaje(JDialog dialogo, JButton volver) {
        this.dialogo = dialogo;
        this.volver = volver;
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
        dialogo.add(porciento, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 1;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.weightx = 1;
        dialogo.add(numeroPorciento, settings);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 2;
        settings.insets = new Insets(20, 20, 20, 20);
        dialogo.add(mensajeTotal, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 2;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.weightx = 1;
        dialogo.add(numeroTotal, settings);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 3;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.ipadx = 150;
        dialogo.add(mensajeResultado, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 3;
        settings.insets = new Insets(20, 20, 20, 20);
        settings.weightx = 1;
        settings.ipadx = 100;
        settings.fill = GridBagConstraints.HORIZONTAL;
        dialogo.add(resultado, settings);

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
