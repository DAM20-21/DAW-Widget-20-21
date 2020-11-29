package corrales_santos_sara;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;


/**
 * Clase que inicia la venta principal
 *@author Sara Corrales Santos 
 */
public class VentanaPrincipal {

    //Atributos
    private JFrame ventana;
    private JPanel JPpantalla;
    private WidgetToDo widgetToDo;
    private WidgetPomodoro widgetPomodoro;
    

    /**
     * Constrictor
     */
    public VentanaPrincipal() {
        this.ventana = new JFrame();
        ventana.setBounds(20, 20, 500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Método que inicia los elementos de la ventana en este caso los elementos del WidgetPomodoro y los de widgetToDo
     */
    public void iniciarElementos(){
        JPpantalla = new JPanel();
        widgetToDo = new WidgetToDo(ventana);
        widgetPomodoro = new WidgetPomodoro();
        //PANTALLA
        JPpantalla.setLayout(new GridBagLayout());

        //POMODORO
        GridBagConstraints setting = new GridBagConstraints();
        setting.gridx = 0;
        setting.gridy = 0;
        setting.weightx = 1;
        setting.weighty = 1;
        setting.fill = GridBagConstraints.BOTH;
        JPpantalla.add(widgetPomodoro, setting);

        //TO-DO
        widgetToDo = new WidgetToDo(ventana);
        setting = new GridBagConstraints();
        setting.gridx = 0;
        setting.gridy = 1;
        setting.weightx = 7;
        setting.weighty = 7;
        setting.fill = GridBagConstraints.BOTH;
        JPpantalla.add(widgetToDo, setting);
        
        //VENTANA
        ventana.add(JPpantalla);
    }

    /**
     * Método que pone la ventana visible e inicia los elementos
     */
    public void iniciar(){
        ventana.setVisible(true);
        iniciarElementos();
    }

}
