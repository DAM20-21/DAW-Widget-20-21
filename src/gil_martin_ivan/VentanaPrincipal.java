package gil_martin_ivan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Ventana Principal para probar el widget Temporizador
 * @author Iván Gil Martín
 */
public class VentanaPrincipal {
    
	JFrame ventana;
	JButton botonEmpezar;
	JLabel tiempo;
	
	public VentanaPrincipal() {
		ventana = new JFrame("Trabajo temporizador Iván Gil Martín");
		ventana.setBounds(100, 50, 400, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void inicializarVentana(){
		ventana.setVisible(true);
		inicializarComponentes();		
		inicializarListeners();
	}
	
	public void inicializarComponentes(){
		ventana.setLayout(new GridLayout(1,2));
		
		botonEmpezar = new JButton("Establece el tiempo: ");
		ventana.add(botonEmpezar);
	
        tiempo = new JLabel("00:00");
        tiempo.setHorizontalAlignment(JLabel.CENTER);
		ventana.add(tiempo);
	}

	public void inicializarListeners(){
		botonEmpezar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				IvanTemporizador temporizador = new IvanTemporizador();
				temporizador.setVisible(true);
			}
		});
	}
}