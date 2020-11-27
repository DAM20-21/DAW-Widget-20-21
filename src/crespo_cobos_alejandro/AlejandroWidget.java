package crespo_cobos_alejandro;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlejandroWidget extends JPanel {

    private static final long serialVersionUID = 1L;

    private ImageIcon imagenIcono;

    private JTextField informacion;
    private JLabel imagenes;

    private JPanel panelImagenes;
    private JPanel panelCiudades;
    ArrayList<Tiempo> pueblos = new ArrayList<>();
    ArrayList <ImageIcon> imgs= new ArrayList<>();
    String [] climas = {"Soleado", "Lluvia", "Niebla", "Nieve", "Nubes y claros"};

    // Referencia al selectorColor:

    public AlejandroWidget() {
        super();
        anadirImagenes();
        anadirElementosAlex();

        
        
        

    }
    

    public void anadirElementosAlex() {

        // Definimos el layout:
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints opc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        // PANEL PRINCIPAL
        // Titulo
        // Panel de ciudades
        // Panel de ciudades
        opc = new GridBagConstraints();
        panelCiudades = new JPanel();
        panelCiudades.setBorder(BorderFactory.createTitledBorder("Ciudad"));
        panelCiudades.setBackground(Color.BLUE);

        opc.gridx = 0;
        opc.gridy = 0;
        opc.weightx = 5;
        opc.weighty = 5;
        opc.fill = GridBagConstraints.BOTH;
        this.add(panelCiudades, opc);

        // Panel CLima
        opc = new GridBagConstraints();
        panelImagenes = new JPanel();
        panelImagenes.setBorder(BorderFactory.createTitledBorder("Clima"));
        panelImagenes.setBackground(Color.GREEN);
        opc.gridx = 1;
        opc.gridy = 0;

        opc.weightx = 5;
        opc.weighty = 5;
        opc.fill = GridBagConstraints.BOTH;
        this.add(panelImagenes, opc);

        //Añado a mi panel Ciudades el JtextField que tendra la informacion de la ciudad
        opc = new GridBagConstraints();
        informacion = new JTextField("             ");
        
        informacion.setEditable(true);
        informacion.setBackground(Color.GRAY);
        informacion.setSize(100, 100);
        opc.gridx= 0;
        opc.gridy = 0;
        panelCiudades.add(informacion, opc);


        //Añado las imagenes a ver como se ven
        opc = new GridBagConstraints();
        imagenes = new JLabel();
        opc.gridx= 1; 
        opc.gridy = 1;
        panelImagenes.add(imagenes, opc);



        



        /*
         * //añado mi texto. opc = new GridBagConstraints(); informacion = new
         * JTextField("..............."); informacion.setEditable(true);
         * informacion.setSize(100, 100); opc.gridx= 0; opc.gridy = 0; opc.ipady= 400;
         * panelCiudades.add(informacion, opc);
         * 
         * 
         * //añado mi imagen al panel de clima. opc = new GridBagConstraints(); imagenes
         * = new JLabel(new ImageIcon("img/sol.png"));
         * 
         * opc.gridx= 1; opc.gridy = 1;
         * 
         * panelImagenes.add(imagenes, opc);
         */

    }

    public void CrearObjetosTiempo() {

        pueblos.add(new Tiempo("Tornavacas", 16, 4, "Soleado"));
        pueblos.add(new Tiempo("Jerte", 17, 10, "Soleado"));
        pueblos.add(new Tiempo("Cabezuela del Valle", 20, 12, "Lluvia"));
        pueblos.add(new Tiempo("Navaconcejo", 11, 8, "Soleado"));
        pueblos.add(new Tiempo("Rebollar", 16, 4, "Soleado"));
        pueblos.add(new Tiempo("Las Casas del Castañar", 10, 1, "Soleado"));
        pueblos.add(new Tiempo("El Torno", 21, 4, "Soleado"));
        pueblos.add(new Tiempo("Cabrero", 19, 2, "Niebla"));
        pueblos.add(new Tiempo("Piornal", 5, -4, "Nieve"));
        pueblos.add(new Tiempo("Valdastillas", 16, 4, "Soleado"));
        pueblos.add(new Tiempo("Barrado", 16, 4, "Soleado"));

        

    }

    public void comprobarPueblos(JTextField ciudad) {
        String texto = ciudad.getText();
        for (Tiempo tiempo : pueblos) {
            if (tiempo.getNombre().equalsIgnoreCase(texto)) {
                informacion.setText(tiempo.getNombre() + "\nTM: " + tiempo.getTemperaturaMax() + "  Tm: "
                        + tiempo.getTemperaturaMin() + "\nEl clima esta : " + tiempo.getClima());

            }
        }
    }

    /**
     * Añado las images a mi lista
     */
    public void anadirImagenes(){
        imgs.add(new ImageIcon("img/sol.png"));
        imgs.add(new ImageIcon("img/lluvia.png"));
        imgs.add(new ImageIcon("img/nieve.png"));
        imgs.add(new ImageIcon("img/nubesyclaros.png"));
        imgs.add(new ImageIcon("img/nubes.png"));
    }

   

    public void comprobarImagen(){
        for (Tiempo tiempo : pueblos) {
            if(tiempo.getClima().equalsIgnoreCase("Soleado")){
                imagenes.setIcon(imgs.get(0));
            } 
        }  
    }



}