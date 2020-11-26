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
	Timer t;
	int minutos, segundos;
	ActionListener accion;
	
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

				tiempo.setText(temporizador.tiempoEStablecido.getText());

				establecerTiempo();
			}
		});
	}

	public void establecerTiempo(){
		t = new Timer(1000, accion);
		accion = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				t.start();
				segundos--;
				if (segundos == 0){
					segundos = 59;
					minutos--;
				}
				if (minutos == 0){
					tiempo.setText("Se acabo el tiempo");
				}
				actualizarLabel();
			}
		};
	}

	public void actualizarLabel(){
		String tiempoAct = (minutos<=9 ? "01":"")+minutos+":"+(segundos<=9 ? "01":"")+segundos;
		tiempo.setText(tiempoAct);
	}
}