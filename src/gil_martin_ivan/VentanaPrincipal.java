package gil_martin_ivan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Ventana Principal para probar el widget Temporizador
 * @author Iván Gil Martín
 */
public class VentanaPrincipal extends Thread implements ActionListener{

	/**
	 * Atributos que utilizaremos tanto para mostrar la ventana como para controlar el tiempo del temporizador
	 */
	JFrame ventana;
	JButton botonEmpezar, botonIniciar;
	JLabel tiempo;
	int minutos, segundos;
	boolean iniciaHilo = true, ejecutando = false;
	
	/**
	 * Constructor de VentanaPrincipal
	 */
	public VentanaPrincipal() {
		ventana = new JFrame("Trabajo temporizador Iván Gil Martín");
		ventana.setBounds(100, 50, 400, 200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	/**
	 * Metodo que inicializa la ventana con sus componentes y sus listeners
	 */
    public void inicializarVentana(){
		ventana.setVisible(true);
		inicializarComponentes();		
		inicializarListeners();
	}
	
	/**
	 * Metodo que inicializa los componentes de una ventana
	 */
	public void inicializarComponentes(){
		//Establecemos el layout de la ventana
		ventana.setLayout(new GridLayout(1,3));
		
		//Boton para establecer el tiempo del temporizador
		botonEmpezar = new JButton("Esatablecer tiempo: ");
		ventana.add(botonEmpezar);
	
		//Label que muestra el tiempo establecido
        tiempo = new JLabel("00:00");
        tiempo.setHorizontalAlignment(JLabel.CENTER);
		ventana.add(tiempo);

		//Boton que inicia el temporizador
		botonIniciar = new JButton("Inciar temporizador");
		botonIniciar.setEnabled(false);
		ventana.add(botonIniciar);
	}

	/**
	 * Metodo que inicializa los listeners de la ventana
	 */
	public void inicializarListeners(){
		botonEmpezar.addActionListener(this);
		botonIniciar.addActionListener(this);
	}

	/**
	 * Metodo que llama al metodo run para correr el hilo del temporizador
	 */
	public void iniciarHiloTemporizador(){
		if (iniciaHilo){
			start();
		}
	}

	/**
	 * Metodo que actualiza el label cada segundo que se vaya durmiendo el hilo
	 * @param minutos
	 * @param segundos
	 */
	public void actualizarLabel(int minutos, int segundos){
		if (segundos >= 0){
			if (minutos >= 10 && segundos >= 10){
				tiempo.setText(minutos+":"+segundos);
			}
			else{
				if (minutos <= 9 && segundos >= 10){
					tiempo.setText("0"+minutos+":"+segundos);
				}
				else{
					if (minutos >= 10 && segundos <= 9){
						tiempo.setText(minutos+":0"+segundos);
					}
					else{
						tiempo.setText("0"+minutos+":0"+segundos);
					}
				}
			}
		}
		else{
			tiempo.setText("Se acabo el tiempo");
			iniciaHilo = false;
		}
	}

	/**
	 * Metodo run que corre el hilo del temporizador
	 */
	@Override
	public void run(){
		try{
			while(iniciaHilo){
				sleep(1000);
				if (segundos >= 0){
					segundos--;
				}
				else{
					if (minutos >= 0){
						minutos--;
						segundos = 59;
					}
				}
				//Llamamos al metodo actualizarLabel cada vez que se duerme
				actualizarLabel(minutos, segundos);
			}
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	/**
	 * Listener de los botones que hace diferentes acciones segun el boton que le hayas pulsado
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonEmpezar){
			IvanTemporizador temporizador = new IvanTemporizador();
			temporizador.setVisible(true);

			minutos = temporizador.barraMinutos.getValue();
			segundos = temporizador.barraSegundos.getValue();

			actualizarLabel(minutos, segundos);

			botonIniciar.setEnabled(true);
		}
		else{
			if (!ejecutando){
				iniciaHilo = true;
				ejecutando = true; 
				iniciarHiloTemporizador();
			}
		}
	}
}