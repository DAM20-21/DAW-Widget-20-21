package gil_martin_ivan;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Clase en la que haremos nuestro widget Temporizador
 * @author Iván Gil Martín
 */
public class IvanTemporizador extends JDialog implements ChangeListener {
    //Esto es necesario cada vez que tengamos que hacer una clase que extienda de JDialog
    private static final long serialVersionUID = -4571795828445399258L;

    /**
     * Atributos de la clase ivanTemporizador
     */
    JSlider barraMinutos, barraSegundos;
    JLabel tiempoEStablecido;
    JButton botonAceptar;

    /**
     * Constructor parametrizador que a su vez establece si el dialog sera modal o no y sus dimensiones a la vez que llama
     * a los elementos y los listeners necesarios
     */
    public IvanTemporizador() {
        super();
        setModal(true);
        setBounds(300, 500, 300, 500);
        inicializarElementos();
        inicializarListeners();
    }

    /**
     * Metodo que inicializa los componentes del JDialog
     */
    public void inicializarElementos() {
        //Establecemos el layout necesario
        this.setLayout(new GridBagLayout());

        //Creamos un GridBagConstraints para modificar algunos aspectos de los componentes del JDialog
        //JLabel que servira como titulo
        GridBagConstraints ajustes = new GridBagConstraints();
        ajustes.gridx = 0;
        ajustes.gridy = 0;
        ajustes.insets = new Insets(0, 0, 50, 0);
        this.add(new JLabel("Establece el tiempo"), ajustes);

        //JLabel que indicara que ese JSlider es la barra de minutos
        ajustes = new GridBagConstraints();
        ajustes.gridy = 1;
        this.add(new JLabel("Dime el numero de minutos"), ajustes);

        //barraMinutos
        ajustes = new GridBagConstraints();
        ajustes.gridy = 2;
        barraMinutos = new JSlider(JSlider.HORIZONTAL, 0, 59, 0);
        barraMinutos.setInverted(false);
        barraMinutos.setPaintTicks(true);
        barraMinutos.setMinorTickSpacing(1);
        barraMinutos.setMajorTickSpacing(59);
        barraMinutos.setPaintLabels(true);
        this.add(barraMinutos, ajustes);

        //JLabel que indicara que ese JSlider es la barra de segundos
        ajustes = new GridBagConstraints();
        ajustes.gridy = 3;
        this.add(new JLabel("Dime el numero de segundos"), ajustes);

        //barraSegundos
        ajustes = new GridBagConstraints();
        ajustes.gridy = 4;
        barraSegundos = new JSlider(JSlider.HORIZONTAL, 0, 59, 0);
        barraSegundos.setInverted(false);
        barraSegundos.setPaintTicks(true);
        barraSegundos.setMinorTickSpacing(1);
        barraSegundos.setMajorTickSpacing(59);
        barraSegundos.setPaintLabels(true);
        this.add(barraSegundos, ajustes);

        //tiempoEStablecido, que indicará los valores de los JSlider barraMinutos y barraSegundos
        ajustes = new GridBagConstraints();
        ajustes.gridy = 5;
        ajustes.insets = new Insets(20, 0, 20, 0);
        tiempoEStablecido = new JLabel("00:00");
        this.add(tiempoEStablecido, ajustes);

        //Boton que cerrará la ventana e insertará los elementos necesarios en VentanaPrincipal
        ajustes = new GridBagConstraints();
        ajustes.gridy = 6;
        botonAceptar = new JButton("Establecer");
        ajustes.insets = new Insets(20, 0, 0, 0);
        ajustes.fill = GridBagConstraints.BOTH;
        this.add(botonAceptar, ajustes);
    }

    /**
     * Metodo que inicializará los listeners de los JSlider y del boton
     */
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

    /**
     * Listeners de los JSlider que guardarán los valores de los mismos y cambiarán el JLabel tiempoEStablecido
     */
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