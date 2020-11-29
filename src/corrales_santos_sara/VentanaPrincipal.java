package corrales_santos_sara;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.util.ArrayList;

public class VentanaPrincipal {

    private JFrame ventana;
    private JPanel JPTiempo, JPNota, JPpantalla, JPtexto, JPbotones, JPtemporizador, JPtextoNota, JPanaidir;
    private JLabel JLtiempo;
    private JButton[] JBotones = {new JButton("Iniciar"), new JButton("Pausa"), new JButton("Reiniciar")};
    private JButton JBaniadir;
    private ArrayList<JCheckBox> JCheck = new ArrayList<>();
    private JTextField JTNota;
    private ButtonGroup grupoNotas;
    private WidgetSara widgetSara;
    private Pomodoro pomodoro;
    
    public VentanaPrincipal() {
        this.ventana = new JFrame();
        ventana.setBounds(20, 20, 500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void iniciarElementos(){
        JPpantalla = new JPanel();
        JPTiempo = new JPanel(); 
        JPNota = new JPanel();
        JPtexto = new JPanel();

        //PANTALLA
        JPpantalla.setLayout(new GridBagLayout());

        //POMODORO
        GridBagLayout gb = new GridBagLayout();
        /* JPTiempo.setBackground(Color.BLUE); */
        JPTiempo.setLayout(gb);
        GridBagConstraints setting = new GridBagConstraints();
        setting.gridx = 0;
        setting.gridy = 0;
        setting.weightx = 1;
        setting.weighty = 1;
        setting.fill = GridBagConstraints.BOTH;
        JPpantalla.add(JPTiempo, setting);

        //TEMPORIZADOR
        /* JPtemporizador = new JPanel();
        JPtemporizador.setLayout(new GridLayout(1, 1));
        JLtiempo = new JLabel("00:00");
        JLtiempo.setFont(new Font("Arial", Font.BOLD, 100));
        JLtiempo.setHorizontalAlignment(SwingConstants.CENTER);
        JPtemporizador.add(JLtiempo);  */
        pomodoro = new Pomodoro();
        //pomodoro.hilo.start();
        setting.gridx = 0;
        setting.gridy = 0;
        setting.weightx = 7;
        setting.weighty = 1;
        setting.fill = GridBagConstraints.BOTH;
        JPTiempo.add(pomodoro, setting);
        
       

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
        JPTiempo.add(JPbotones, setting);

        //NOTA
        /* JPNota.setBackground(Color.GREEN); */
        JPNota.setLayout(new GridLayout(JCheck.size(), 1));
        JPNota.setBackground(new Color(246, 216, 83));
        setting = new GridBagConstraints();
        setting.gridx = 0;
        setting.gridy = 1;
        setting.weightx = 7;
        setting.weighty = 7;
        setting.fill = GridBagConstraints.BOTH;

        JScrollPane scroll = new JScrollPane();
        scroll.add(JPNota);  
        JPNota.setPreferredSize(new Dimension(300, 300));
        JPpantalla.add(JPNota, setting);


        
        // TEXTO
        JPtexto.setLayout(new GridBagLayout());
        /* JPtexto.setBackground(Color.PINK); */
        setting = new GridBagConstraints();
        setting.gridx = 0;
        setting.gridy = 2;
        setting.weightx = 1;
        setting.weighty = 1;
        setting.gridwidth = 2;
        setting.fill = GridBagConstraints.BOTH;

        JPpantalla.add(JPtexto, setting);

        //NOTA TEXTO
        JTNota = new JTextField("Hola");
        JPtextoNota = new JPanel(new GridLayout(1,1));
        JPtextoNota.add(JTNota); 
        setting = new GridBagConstraints();
        setting.gridx = 0;
        setting.gridy = 2;
        setting.weightx = 5;
        setting.weighty = 1;
        setting.fill = GridBagConstraints.BOTH; 
        JPtexto.add(JPtextoNota, setting); 

        //AÑADIR
        JBaniadir =new JButton("Añadir");
        JPanaidir = new JPanel(new GridLayout(1,1));
        JPanaidir.add(JBaniadir); 
        setting = new GridBagConstraints();
        setting.gridx = 1;
        setting.gridy = 2;
        setting.weightx = 1;
        setting.weighty = 1;
        setting.fill = GridBagConstraints.BOTH; 
        JPtexto.add(JPanaidir, setting); 
        
        //VENTANA
        ventana.add(JPpantalla);
    }

    public void iniciarListeners(){//TODO: seguir haciendo el añador los checkbox para que salga uno de bajo del otro.
        JBaniadir.addActionListener((e)->{
            String nota = JTNota.getText();
            JCheckBox nuevoCheck =new JCheckBox(nota);
            nuevoCheck.setBackground(new Color(246, 216, 83 ));
            JCheck.add(nuevoCheck);
            JPNota.add(JCheck.get(JCheck.size()-1));

            JPpantalla.revalidate();
            JPpantalla.repaint();
        });


        /* for (int i = 0; i < JCheck.size(); i++) {
            widgetSara.borrarCheckBox(JCheck.get(i));
            refrescarPantalla();
        } */

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

    public void refrescarPantalla(){
		ventana.revalidate(); 
		ventana.repaint();
	}

    public void iniciar(){
        ventana.setVisible(true);
        iniciarElementos();
        iniciarListeners();
    }

}
