package gil_martin_ivan;

import javax.swing.*;
import java.awt.*;
/**
 * Ventana Principal para probar el widget Temporizador
 * @author Iván Gil Martín
 */
public class VentanaPrincipal {
    
	JFrame ventana;
	JButton botonEmpezar;
	JTextField tiempo;
	
	public VentanaPrincipal() {
		ventana = new JFrame("Trabajo temporizador Iván Gil Martín");
		ventana.setBounds(100, 50, 400, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void inicializarVentana(){
		ventana.setVisible(true);
		inicializarComponentes();			
	}
	
	public void inicializarComponentes(){
		ventana.setLayout(new GridLayout(1,2));
		
		botonEmpezar = new JButton("Establece el tiempo: ");
		ventana.add(botonEmpezar);
	
        tiempo = new JTextField("00:00");
        tiempo.setEditable(false);
        tiempo.setHorizontalAlignment(JTextField.CENTER);
		ventana.add(tiempo);
	}
}