package corrales_santos_sara;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

/**
 * Clase que crea el Widget Pomodoro
 *@author Sara Corrales Santos 
 */
public class WidgetPomodoro extends JPanel {

    /**
     * Atributos de la clase
     */
    private static final long serialVersionUID = -3115608094220620234L;
    private Pomodoro pomodoro;
    private JButton[] JBotones = { new JButton("Iniciar"), new JButton("Pausa"), new JButton("Reiniciar") };
    private JPanel JPbotones;

    /**
     * Constructor 
     */
    public WidgetPomodoro() {
        pomodoro = new Pomodoro();
        GridBagLayout gb = new GridBagLayout();
        setLayout(gb);
        iniciarElementos();
        iniciarListener();
    }

    /**
     * Método que inicia y coloca los elementos del widgetPomodoro
     */
    public void iniciarElementos(){
        //TEMPORIZADOR
        pomodoro.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        GridBagConstraints setting = new GridBagConstraints();
        setting.gridx = 0;
        setting.gridy = 0;
        setting.weightx = 7;
        setting.weighty = 1;
        setting.fill = GridBagConstraints.BOTH;
        this.add(pomodoro, setting);


        //BOTONES
        JPbotones = new JPanel(new GridLayout(3,1));
        for (int i = 0; i < JBotones.length; i++) {
            JPbotones.add(JBotones[i]);
        }

        setting = new GridBagConstraints();
        setting.gridx = 1;
        setting.gridy = 0;
        setting.weightx = 2;
        setting.weighty = 1;
        setting.fill = GridBagConstraints.BOTH;
        this.add(JPbotones, setting); 
    }

    /**
     * Método que inicia los listeners de los botones del pomodoro
     */
    public void iniciarListener(){
        JBotones[0].addActionListener((e)->{
            pomodoro.iniciar();
        });

        JBotones[1].addActionListener((e)->{
            pomodoro.pausar();
        });

        JBotones[2].addActionListener((e)->{
            pomodoro.reiniciar();
        });
    }

}
