package perez_martin_miguel;

import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Widget_miguel extends JDialog{
    
    private static final long serialVersionUID = 1L;

    private Cronometro crono;
    private JButton botonPalabras;

    public Widget_miguel() {
        super();
        setModal(true);
        setBounds(0, 0, 300, 300);
        anadirElemento();
        
    }

    public void anadirElemento() {
        // fondo
        setBackground(Color.GREEN);

        setLayout(new GridBagLayout());

        // temporizador
        crono = new Cronometro();
        crono.comenzar();
        GridBagConstraints ajuste = new GridBagConstraints();
        ajuste.gridx = 0;
        ajuste.gridy = 0;
        ajuste.fill = ajuste.BOTH;
        this.add(crono, ajuste);

        // boton de palabras
        botonPalabras = new JButton("Palabras aleatorias");
        GridBagConstraints ajusteBoton = new GridBagConstraints();
        ajusteBoton.gridx = 0;
        ajusteBoton.gridy = 1;
        this.add(botonPalabras, ajusteBoton);
    }

    public void inicializarListener() {
        
    }

}