package corrales_santos_sara;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class VentanaPrincipal {

    private JFrame ventana;
    private JPanel JPTiempo, JPNota, JPpantalla, JPtexto, JPbotones;
    private JLabel JLtiempo;
    private JButton JBinciar, JBpausar, JBreiniciar, JBaniadir;
    private JCheckBox JCheck;
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
        JPpantalla.setLayout(new GridLayout(3,1));
        //POMODORO
        JPTiempo.setBackground(Color.BLUE);
        JPTiempo.setLayout(new GridLayout(1,2));
        JLtiempo = new JLabel("00:00");
        JPTiempo.add(JLtiempo);
        //BOTONES
        JPbotones = new JPanel(new GridLayout(3,1));
        JBinciar = new JButton("Iniciar");
        JBpausar = new JButton("Pausa");
        JBreiniciar = new JButton("Reiniciar");
        JPbotones.add(JBinciar);
        JPbotones.add(JBpausar);
        JPbotones.add(JBreiniciar);
        JPTiempo.add(JPbotones);
        JPpantalla.add(JPTiempo);

        //NOTA
        JPNota.setBackground(Color.GREEN);
        JPpantalla.add(JPNota);

        //TEXTO
        JPtexto.setLayout(new GridLayout(1,2));
        JPtexto.setBackground(Color.PINK);
        JTNota = new JTextField();
        JPtexto.add(JTNota);
        JBaniadir =new JButton("añadir");
        JPtexto.add(JBaniadir);
        JPpantalla.add(JPtexto);

        ventana.add(JPpantalla);
    }

    public void iniciarListeners(){

    }

    public void iniciar(){
        ventana.setVisible(true);
        iniciarElementos();
    }

}
