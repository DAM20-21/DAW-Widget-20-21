package corrales_santos_sara;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        JPTiempo.setBackground(Color.BLUE);
        JPTiempo.setLayout(gb);
        GridBagConstraints setting = new GridBagConstraints();
        setting.gridx = 0;
        setting.gridy = 0;
        setting.weightx = 1;
        setting.weighty = 1;
        setting.fill = GridBagConstraints.BOTH;
        JPpantalla.add(JPTiempo, setting);

        //TEMPORIZADOR
        JPtemporizador = new JPanel();
        JPtemporizador.setLayout(new GridLayout(1, 1));
        JLtiempo = new JLabel("00:00");
        JLtiempo.setFont(new Font("Arial", Font.BOLD, 100));
        JLtiempo.setHorizontalAlignment(SwingConstants.CENTER);
        JPtemporizador.add(JLtiempo); 
        setting.gridx = 0;
        setting.gridy = 0;
        setting.weightx = 7;
        setting.weighty = 1;
        setting.fill = GridBagConstraints.BOTH;
        JPTiempo.add(JPtemporizador, setting);
        
       

        //BOTONES
        JPbotones = new JPanel(new GridLayout(3,1));
        /* JBinciar = new JButton("Iniciar");
        JBpausar = new JButton("Pausa");
        JBreiniciar = new JButton("Reiniciar");
        JPbotones.add(JBinciar);
        JPbotones.add(JBpausar);
        JPbotones.add(JBreiniciar); */

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
        JPNota.setBackground(Color.GREEN);
        JPNota.setLayout(new GridBagLayout());
        setting = new GridBagConstraints();
        setting.gridx = 0;
        setting.gridy = 1;
        setting.weightx = 7;
        setting.weighty = 7;
        setting.fill = GridBagConstraints.BOTH;
        JPpantalla.add(JPNota, setting);


        
        // TEXTO
        JPtexto.setLayout(new GridBagLayout());
        JPtexto.setBackground(Color.PINK);
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

    public void iniciarListeners(){
        JBaniadir.addActionListener((e)->{
            String nota = JTNota.getText();
            JCheck.add(new JCheckBox(nota));
            JPNota.add(JCheck.get(JCheck.size()-1));
            
            JPpantalla.revalidate();
            JPpantalla.repaint();
        });
    }

    public void iniciar(){
        ventana.setVisible(true);
        iniciarElementos();
        iniciarListeners();
    }

}
