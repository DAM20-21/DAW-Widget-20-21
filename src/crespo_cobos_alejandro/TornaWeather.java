package crespo_cobos_alejandro;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TornaWeather extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextArea municipio;

    private JLabel imagenes;

    private Boolean aviso = false;

    private JPanel panelImagenes;
    private JPanel panelCiudades;
    ArrayList<Tiempo> pueblos = new ArrayList<>();
    ArrayList<ImageIcon> imgs = new ArrayList<>();
    // String [] climas = {"Soleado", "Lluvia", "Niebla", "Nieve", "Nubes y
    // claros"};

    // Referencia al Widget:

    public TornaWeather() {
        super();
        anadirElementosAlex();

    }

    public void anadirElementosAlex() {

        // Definimos el layout:
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints opc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        

        // PANEL Wiget

        // Panel de ciudades
        opc = new GridBagConstraints();
        panelCiudades = new JPanel();
        panelCiudades.setBorder(BorderFactory.createTitledBorder("Ciudad"));
        panelCiudades.setBackground(Color.CYAN);
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
        panelImagenes.setBackground(Color.MAGENTA);
        opc.gridx = 1;
        opc.gridy = 0;
        opc.weightx = 5;
        opc.weighty = 5;
        opc.fill = GridBagConstraints.BOTH;
        this.add(panelImagenes, opc);

        // Añado a mi panel Ciudades el JtextField que tendra la informacion de la
        // ciudad
        opc = new GridBagConstraints();
        municipio = new JTextArea("");
        municipio.setBorder(BorderFactory.createTitledBorder("Municipio"));
        municipio.setEditable(false);
        opc.gridx = 0;
        opc.gridy = 0;
        panelCiudades.add(municipio, opc);

        /*
         * //TEMP MAXIMA opc = new GridBagConstraints(); tempM = new JTextField("");
         * tempM.setBorder(BorderFactory.createTitledBorder("Temperatura Maxima"));
         * tempM.setEditable(false); opc.gridx= 0; opc.gridy = 1;
         * panelCiudades.add(tempM, opc);
         * 
         * //TEMP MINIMA opc = new GridBagConstraints(); tempm = new JTextField("");
         * tempm.setBorder(BorderFactory.createTitledBorder("Temperatura Minima"));
         * tempm.setEditable(false); opc.gridx= 0; opc.gridy = 2;
         * panelCiudades.add(tempm, opc);
         * 
         * //CIELO opc = new GridBagConstraints(); cielo = new JTextField("");
         * cielo.setBorder(BorderFactory.createTitledBorder("Clima"));
         * cielo.setEditable(false); opc.gridx= 0; opc.gridy = 3;
         * panelCiudades.add(cielo, opc);
         */

        // Añado las imagenes
        opc = new GridBagConstraints();
        imagenes = new JLabel();
        opc.gridx = 1;
        opc.gridy = 1;
        panelImagenes.add(imagenes, opc);
    }

    /**
     * 
     */

    public void CrearObjetosTiempo() {

        pueblos.add(new Tiempo("Tornavacas", 16, 4, "Soleado"));
        pueblos.add(new Tiempo("Jerte", 17, 10, "Nubes y claros"));
        pueblos.add(new Tiempo("Cabezuela del Valle", 20, 12, "Lluvia"));
        pueblos.add(new Tiempo("Navaconcejo", 11, 8, "Nieve"));
        pueblos.add(new Tiempo("Rebollar", 16, 4, "Soleado"));
        pueblos.add(new Tiempo("Las Casas del Castañar", 10, 1, "Nubes y claros"));
        pueblos.add(new Tiempo("El Torno", 21, 4, "Lluvia"));
        pueblos.add(new Tiempo("Cabrero", 19, 2, "Niebla"));
        pueblos.add(new Tiempo("Piornal", 5, -4, "Nieve"));
        pueblos.add(new Tiempo("Valdastillas", 16, 4, "Soleado"));
        pueblos.add(new Tiempo("Barrado", 16, 4, "Nubes y claros"));
    }

    /**
     * Este metodo captura el valor que el usuario introduce y lo manda a otro
     * JtextField para que se muestre en la interfaz
     * 
     * Tengo un booleano para comprar el aviso que salta, si el municipio que has metido no esta dentro de los pueblos del valle jerte saldra un aviso
     * 
     * @param ciudad
     */
    public void comprobarPueblos(JTextField ciudad) {

        String texto = ciudad.getText();
        // Tiempo tiempo : pueblos
        for (int i = 0; i < pueblos.size(); i++) {
            if (pueblos.get(i).getNombre().equalsIgnoreCase(texto)) {
                municipio.setText(pueblos.get(i).getNombre() + "\nTemperatura Máxima: "
                        + pueblos.get(i).getTemperaturaMax() + "º\nTemperatura Mínima: "
                        + pueblos.get(i).getTemperaturaMin() + "º\n" + pueblos.get(i).getClima());
                aviso = true;
            }
            
                
        }
        if(!aviso){
            JOptionPane.showMessageDialog(this, "El municipio indicado no es correcto", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * Añado las images a mi lista
     */
    public void anadirImagenes() {

        imgs.add(new ImageIcon("img/sol.png"));
        imgs.add(new ImageIcon("img/lluvia.png"));
        imgs.add(new ImageIcon("img/nieve.png"));
        imgs.add(new ImageIcon("img/nubesyclaros.png"));
        imgs.add(new ImageIcon("img/nubes.png"));
    }

    public void comprobarImagen(JTextField ciudad) {

        String texto = ciudad.getText();

        for (int i = 0; i < pueblos.size(); i++) {
            if (pueblos.get(i).getNombre().equalsIgnoreCase(texto)
                    && pueblos.get(i).getClima().equalsIgnoreCase("Soleado")) {
                imagenes.setIcon(imgs.get(0));
            }
            if (pueblos.get(i).getNombre().equalsIgnoreCase(texto)
                    && pueblos.get(i).getClima().equalsIgnoreCase("Lluvia")) {
                imagenes.setIcon(imgs.get(1));
            }
            if (pueblos.get(i).getNombre().equalsIgnoreCase(texto)
                    && pueblos.get(i).getClima().equalsIgnoreCase("nieve")) {
                imagenes.setIcon(imgs.get(2));
            }
            if (pueblos.get(i).getNombre().equalsIgnoreCase(texto)
                    && pueblos.get(i).getClima().equalsIgnoreCase("Nubes y claros")) {
                imagenes.setIcon(imgs.get(3));
            }
            if (pueblos.get(i).getNombre().equalsIgnoreCase(texto)
                    && pueblos.get(i).getClima().equalsIgnoreCase("Nubes")) {
                imagenes.setIcon(imgs.get(4));
            }

        }
    }
}