package perez_martin_miguel;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;

public class VentanaPrincipal {
    private JFrame ventana;
    private JButton boton;

    public VentanaPrincipal() {
        this.ventana = new JFrame("Diccionario Dinamico");
        ventana.setBounds(0, 0, 500, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.boton = new JButton("Ver palabras");
    }

    public void inicializar() {
        ventana.setVisible(true);
        anadirComponentes();
        inicializarListener();
    }

    public void anadirComponentes() {
        ventana.setLayout(new GridBagLayout());

        // insertamos un boton para poder probar nuestra nueva ventana.
        GridBagConstraints ajuste = new GridBagConstraints();
        ajuste.gridx = 0;
        ajuste.gridy = 0;
        ventana.add(boton, ajuste);

    }

    public void inicializarListener() {
        // al dar clik al boton se abre nuestra nueva ventana.
        boton.addActionListener(e -> {
            Widget_miguel diccionario = new Widget_miguel();
            diccionario.setVisible(true);
        });
    }

}
