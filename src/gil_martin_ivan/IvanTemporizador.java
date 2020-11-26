package gil_martin_ivan;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Clase en la que haremos nuestro widget Temporizador
 * 
 * @author Iván Gil Martín
 */
public class IvanTemporizador extends JDialog implements ChangeListener {
    private static final long serialVersionUID = -4571795828445399258L;

    JSlider barraMinutos, barraSegundos;
    JLabel tiempoEStablecido;
    JButton botonAceptar;

    public IvanTemporizador() {
        super();
        setModal(true);
        setBounds(300, 500, 300, 500);
        inicializarElementos();
        inicializarListeners();
    }

    public void inicializarElementos() {
        this.setLayout(new GridBagLayout());

        GridBagConstraints ajustes = new GridBagConstraints();
        ajustes.gridx = 0;
        ajustes.gridy = 0;
        ajustes.insets = new Insets(0, 0, 50, 0);
        this.add(new JLabel("Establece el tiempo"), ajustes);

        ajustes = new GridBagConstraints();
        ajustes.gridy = 1;
        this.add(new JLabel("Dime el numero de minutos"), ajustes);

        ajustes = new GridBagConstraints();
        ajustes.gridy = 2;
        barraMinutos = new JSlider(JSlider.HORIZONTAL, 0, 59, 0);
        barraMinutos.setInverted(false);
        barraMinutos.setPaintTicks(true);
        barraMinutos.setMinorTickSpacing(1);
        barraMinutos.setMajorTickSpacing(59);
        barraMinutos.setPaintLabels(true);
        this.add(barraMinutos, ajustes);

        ajustes = new GridBagConstraints();
        ajustes.gridy = 3;
        this.add(new JLabel("Dime el numero de segundos"), ajustes);

        ajustes = new GridBagConstraints();
        ajustes.gridy = 4;
        barraSegundos = new JSlider(JSlider.HORIZONTAL, 0, 59, 0);
        barraSegundos.setInverted(false);
        barraSegundos.setPaintTicks(true);
        barraSegundos.setMinorTickSpacing(1);
        barraSegundos.setMajorTickSpacing(59);
        barraSegundos.setPaintLabels(true);
        this.add(barraSegundos, ajustes);

        ajustes = new GridBagConstraints();
        ajustes.gridy = 5;
        ajustes.insets = new Insets(20, 0, 20, 0);
        tiempoEStablecido = new JLabel("00:00");
        this.add(tiempoEStablecido, ajustes);

        ajustes = new GridBagConstraints();
        ajustes.gridy = 6;
        botonAceptar = new JButton("Establecer");
        ajustes.insets = new Insets(20, 0, 0, 0);
        ajustes.fill = GridBagConstraints.BOTH;
        this.add(botonAceptar, ajustes);
    }

    public void inicializarListeners() {
        barraMinutos.addChangeListener(this);
        barraSegundos.addChangeListener(this);
        botonAceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
        });
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int minutos = barraMinutos.getValue();
        int segundos = barraSegundos.getValue();

        if (minutos >= 10 && segundos >= 10){
            tiempoEStablecido.setText(minutos+":"+segundos);
        }
        else{
            if (minutos <= 9 && segundos >= 10){
                tiempoEStablecido.setText("0"+minutos+":"+segundos);
            }
            else{
                if (minutos >= 10 && segundos <= 9){
                    tiempoEStablecido.setText(minutos+":0"+segundos);
                }
                else{
                    tiempoEStablecido.setText("0"+minutos+":0"+segundos);
                }
            }
        }
    }
}