package martin_garcia_ricardo;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.font.*;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WidgetRicardo extends JDialog {

    final static public int SOL = 1;
    final static public int NUBE = 2;
    final static public int LLUVIA = 3;
    final static public int NIEVE = 4;

    JLabel hora;
    JPanel imagen;
    JLabel labelImagen;
    JLabel tiempoQhace;
    JLabel temperaturas;
    JButton botonSalir;
    int seleccion;

    public WidgetRicardo(int seleccion) {
        super();
        setModal(true);
        setBounds(0, 0, 400, 600);
        this.seleccion = seleccion;

        hora = new JLabel("00:00");
        labelImagen = new JLabel();
        hora.setFont(new Font("Serif", Font.PLAIN, 64));
        imagen = new JPanel();
        tiempoQhace = new JLabel("TIMEPO_Q_HACE");
        tiempoQhace.setFont(new Font("Serif", Font.PLAIN, 24));
        temperaturas = new JLabel("TEMPERATURAS");
        botonSalir = new JButton("Salir");
        setLayout(new GridBagLayout());
        añadirComponentes();
        ponerListener();
        ponerImagen();

    }

    private void añadirComponentes() {
        // Ponemos el marcador de la hora;
        GridBagConstraints ajustes = new GridBagConstraints();
        ajustes.gridx = 0;
        ajustes.gridy = 0;
        ajustes.insets = new Insets(20,20,20,20);
        add(hora, ajustes);
        // Ponemos el panel de la imagen
        ajustes.gridy = 1;
        imagen.setLayout(new GridLayout(1,1));
        
        imagen.add(labelImagen);

        add(imagen, ajustes);
        // Ponemos el JLabel de el timepo que hace
        ajustes.gridy = 2;
        add(tiempoQhace, ajustes);
        ajustes.gridy = 3;
        add(temperaturas, ajustes);
        // Poner botón de salir
        ajustes.gridy = 4;
        add(botonSalir, ajustes);

    }


    public void ponerListener() {
        botonSalir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();

            }
        
    });
    
}

    public void ponerImagen(){
        ImageIcon imageIco ;
        switch(seleccion){
            case 1:{
                imageIco = new ImageIcon("img\sol.png");
                labelImagen.setIcon(imageIco);

            }
        }

    }

   


    
}
