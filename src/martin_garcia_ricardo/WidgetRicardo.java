package martin_garcia_ricardo;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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
import java.awt.color.*;
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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.JSlider;

import javax.swing.event.*;

import java.applet.*;
import java.util.Calendar;
import     java.util.Date ;
import java.util.GregorianCalendar;
import java.awt.*;

import java.util.Hashtable;


public class WidgetRicardo extends JDialog {

    final static public int SOL = 1;
    final static public int NUBE = 2;
    final static public int LLUVIA = 3;
    final static public int NIEVE = 4;

    JLabel fecha;
    JPanel imagen;
    JLabel labelImagen;
    JLabel tiempoQhace;
    JLabel temperaturas;
    JButton botonSalir;
    int seleccion;
    double temperaturaMAX;
    double temperaturaMIN;
    JPanel panelPrincipal;


    public WidgetRicardo(int seleccion,double tempMAX,double tempMIN) {
        super();
        setModal(false);
        setBounds(0, 0, 400, 700);
        this.seleccion = seleccion;
        temperaturaMAX = tempMAX;
        temperaturaMIN = tempMIN;
        fecha = new JLabel();
        labelImagen = new JLabel();
        panelPrincipal = new JPanel();
        this.add(panelPrincipal);
        tiempoQhace = new JLabel("TIMEPO_Q_HACE");
        temperaturas = new JLabel("TEMPERATURAS");
       
        imagen = new JPanel();
        temperaturas = new JLabel("TEMPERATURAS");
        botonSalir = new JButton("Salir");

        temperaturas.setFont(new Font("Serif", Font.PLAIN, 20));
        fecha.setFont(new Font("Serif", Font.PLAIN, 55));
        tiempoQhace.setFont(new Font("Serif", Font.PLAIN, 24));
         panelPrincipal.setLayout(new GridBagLayout());
        añadirComponentes();
        ponerListener();
        ponerImagen();
        ponerTemperaturas();
        ponerFecha();

    }

   
//Ponemos la fecha
    private void ponerFecha() {
        int mesAux;

        Calendar c = new GregorianCalendar();
        String dia = Integer.toString(c.get(Calendar.DATE));
        mesAux = c.get(Calendar.MONTH);
        String año = Integer.toString(c.get(Calendar.YEAR));
        //Sumamos una al mes por que enero es 0
        mesAux = mesAux+1;
        fecha.setText(dia+"/"+mesAux+"/"+año);


    }

    private void añadirComponentes() {
        // Ponemos el marcador de la hora;
        GridBagConstraints ajustes = new GridBagConstraints();
        ajustes.gridx = 0;
        ajustes.gridy = 0;
        ajustes.insets = new Insets(20,20,20,20);
        panelPrincipal.add(fecha, ajustes);
        // Ponemos el panel de la imagen
        ajustes.gridy = 1;
        imagen.setLayout(new GridLayout(1,1));
        
        imagen.add(labelImagen);

        panelPrincipal.add(imagen, ajustes);
        // Ponemos el JLabel de el timepo que hace
        ajustes.gridy = 2;
        panelPrincipal. add(tiempoQhace, ajustes);
        ajustes.gridy = 3;
        panelPrincipal. add(temperaturas, ajustes);
        // Poner botón de salir
        ajustes.gridy = 4;
        panelPrincipal.add(botonSalir, ajustes);

    }

    //Ponemos listener al boton de salir 
    public void ponerListener() {
        botonSalir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();

            }
        
    });
    
}
//Ponemos la imagen adecuada y el fondo

    public void ponerImagen(){
        ImageIcon imageIco ;
        Color cl = new Color(0,0,0);
        switch(seleccion){
            case 1:{
                imageIco = new ImageIcon("img/sol.png");
                labelImagen.setIcon(imageIco);
                tiempoQhace.setText("SOL");
                cl = new Color(58, 131, 204);
                panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.ORANGE,10));
                
                break;
            }
            case 2:{
                imageIco = new ImageIcon("img/nube.png");
                labelImagen.setIcon(imageIco);
                tiempoQhace.setText("NUBLADO");
                cl = new Color(20, 77, 133);
                panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,10));

                

                break;

            }
            case 3:{
                imageIco = new ImageIcon("img/lluvia.png");
                labelImagen.setIcon(imageIco);
                tiempoQhace.setText("LLUVIA");
                cl = new Color(3, 58, 130);
                panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK,10));

                break;

            }
            case 4:{
                imageIco = new ImageIcon("img/nieve.png");
                labelImagen.setIcon(imageIco);
                tiempoQhace.setText("NIEVE");
                cl = new Color(134, 177, 219);
                panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.CYAN,10));



                break;

            }
        }

                panelPrincipal.setBackground(cl);
                imagen.setBackground(cl);
    }
    //Ponemos temperaturas y calculamos media 
    private void ponerTemperaturas() {
      

        double media =(temperaturaMAX+temperaturaMIN)/2;
        if(seleccion == LLUVIA||seleccion==NUBE){
            temperaturas.setForeground(Color.WHITE);
            fecha.setForeground(Color.WHITE);
            tiempoQhace.setForeground(Color.WHITE);

            

        }
        temperaturas.setText("Max: "+ temperaturaMAX+"°C Min: " +temperaturaMIN+"°C Media: "+ media+"");

        
        
    }

    

   


    
}
