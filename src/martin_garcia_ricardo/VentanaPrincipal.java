package martin_garcia_ricardo;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

public class VentanaPrincipal {

    JFrame ventana;
    JButton prueba1;
    JButton prueba2;
    JButton prueba3;
    JButton prueba4;

    public VentanaPrincipal() {
        ventana = new JFrame();
        ventana.setBounds(0, 0, 400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prueba1 = new JButton("Prueba SOL 30,25");
        prueba2 = new JButton("Prueba NUBE 23,12");
        prueba3 = new JButton("Prueba LLUVIA 15,5");
        prueba4 = new JButton("Prueba NIEVE 10,-3");

    }

    public void inicializar() {
        ventana.setVisible(true);
        ventana.setLayout(new GridLayout(2, 2));
        ventana.add(prueba1);
        ventana.add(prueba2);
        ventana.add(prueba3);
        ventana.add(prueba4);
        ponerListener();

    }

    public void ponerListener() {
        prueba1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WidgetRicardo wr = new WidgetRicardo(WidgetRicardo.SOL, 30, 25);
                wr.setVisible(true);

            }
            
        });
        prueba2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WidgetRicardo wr = new WidgetRicardo(WidgetRicardo.NUBE, 23,12);
                wr.setVisible(true);


            }
            
        });
        prueba3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WidgetRicardo wr = new WidgetRicardo(WidgetRicardo.LLUVIA, 15,5);
                wr.setVisible(true);


            }
            
        });
        prueba4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WidgetRicardo wr = new WidgetRicardo(WidgetRicardo.NIEVE, 10,-3);
                wr.setVisible(true);


            }
            
        });

    }
    

    
}
