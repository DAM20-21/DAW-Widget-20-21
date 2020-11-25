import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author Mario Gracia
 */

// Interfaz simulada a un juego buscaminas,implementa 4 paneles y botones
public class VentanaPrincipal {

    // Componentes de la interfaz del juego
    private JFrame ventana;
    private JPanel panelGrandeSonidos;
    private JTextField panelTextoSonidos;
    private Font fuente;
    private JButton botonLeon,botonLobo,botonRana,botonOrca,botonKomodo,botonElefante,botonVaca,botonRinoceronte,botonCuervo;
    JLabel imagen1,imagen2,imagen3,imagen4,imagen5,imagen6,imagen7,imagen8,imagen9;

    // Constructor parametrizado
    public VentanaPrincipal() {
        ventana = new JFrame("Sonidos de animales");
        ventana.setBounds(50, 50, 800, 800);
        ventana.getContentPane();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void inicializarComponentes() {

        ventana.setLayout(new GridBagLayout());
        GridBagConstraints settingsObjeto = new GridBagConstraints();

        // TextField,con borde grosor negro,no editable y texto centrado
        panelTextoSonidos = new JTextField("Sonidos de Animales");
        settingsObjeto = new GridBagConstraints();
        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 0;
        settingsObjeto.weighty = 1;
        settingsObjeto.weightx = 1;
        panelTextoSonidos.setEditable(false);
        panelTextoSonidos.setHorizontalAlignment(JTextField.CENTER);
        panelTextoSonidos.setBackground(Color.CYAN);
        panelTextoSonidos.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        panelTextoSonidos.setForeground(Color.BLACK);
        panelTextoSonidos.setFont(new Font("Arial", Font.BOLD, 25));
        settingsObjeto.fill = GridBagConstraints.BOTH;
        ventana.getContentPane().add(panelTextoSonidos, settingsObjeto);

        panelGrandeSonidos = new JPanel(new GridLayout(3, 3, 3, 3));
        settingsObjeto = new GridBagConstraints();
        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 1;
        settingsObjeto.gridheight = 2;
        settingsObjeto.gridwidth = 2;
        settingsObjeto.weighty = 4;
        settingsObjeto.weightx = 4;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        ventana.add(panelGrandeSonidos, settingsObjeto);

        // Matriz de botones de 10 filas y 10 columnas añadiendolos en el panel del
        // juego
  
                botonLeon = new JButton();
                botonLeon.setBackground(Color.WHITE);
                JLabel imagen1 = new JLabel();
                GridBagConstraints settingsBotones = new GridBagConstraints();
                settingsBotones.gridx = 0;
                settingsBotones.gridy = 0;
                settingsObjeto.weighty = 1;
                settingsObjeto.weightx = 1;
                imagen1.setIcon(new ImageIcon("img/leon.jpg"));
		        botonLeon.add(imagen1);
                settingsObjeto.fill = GridBagConstraints.BOTH;
                panelGrandeSonidos.add(botonLeon, settingsBotones);
                

                botonLobo = new JButton();
                botonLobo.setBackground(Color.WHITE);
                JLabel imagen2 = new JLabel();
                settingsBotones.gridx = 1;
                settingsBotones.gridy = 0;
                settingsObjeto.weighty = 1;
                settingsObjeto.weightx = 1;
                imagen2.setIcon(new ImageIcon("img/lobo.jpg"));
		        botonLobo.add(imagen2);
                settingsObjeto.fill = GridBagConstraints.BOTH;
                panelGrandeSonidos.add(botonLobo, settingsBotones);

                botonRana = new JButton();
                botonRana.setBackground(Color.WHITE);
                JLabel imagen3 = new JLabel();
                settingsBotones.gridx = 2;
                settingsBotones.gridy = 0;
                settingsObjeto.weighty = 1;
                settingsObjeto.weightx = 1;
                imagen3.setIcon(new ImageIcon("img/rana.jpg"));
		        botonRana.add(imagen3);
                settingsObjeto.fill = GridBagConstraints.BOTH;
                panelGrandeSonidos.add(botonRana, settingsBotones);

                botonOrca = new JButton();
                botonOrca.setBackground(Color.WHITE);
                JLabel imagen4 = new JLabel();
                settingsBotones.gridx = 0;
                settingsBotones.gridy = 1;
                settingsObjeto.weighty = 1;
                settingsObjeto.weightx = 1;
                imagen4.setIcon(new ImageIcon("img/orca.jpg"));
		        botonOrca.add(imagen4);
                settingsObjeto.fill = GridBagConstraints.BOTH;
                panelGrandeSonidos.add(botonOrca, settingsBotones);
                

                botonKomodo = new JButton();
                botonKomodo.setBackground(Color.WHITE);
                JLabel imagen5 = new JLabel();
                settingsBotones.gridx = 1;
                settingsBotones.gridy = 1;
                settingsObjeto.weighty = 1;
                settingsObjeto.weightx = 1;
                imagen5.setIcon(new ImageIcon("img/komodo.jpg"));
		        botonKomodo.add(imagen5);
                settingsObjeto.fill = GridBagConstraints.BOTH;
                panelGrandeSonidos.add(botonKomodo, settingsBotones);

                botonElefante = new JButton();
                botonElefante.setBackground(Color.WHITE);
                JLabel imagen6 = new JLabel();
                settingsBotones.gridx = 2;
                settingsBotones.gridy = 1;
                settingsObjeto.weighty = 1;
                settingsObjeto.weightx = 1;
                imagen6.setIcon(new ImageIcon("img/elefante.jpg"));
		        botonElefante.add(imagen6);
                settingsObjeto.fill = GridBagConstraints.BOTH;
                panelGrandeSonidos.add(botonElefante, settingsBotones);

                botonVaca = new JButton();
                botonVaca.setBackground(Color.WHITE);
                JLabel imagen7 = new JLabel();
                settingsBotones.gridx = 0;
                settingsBotones.gridy = 2;
                settingsObjeto.weighty = 1;
                settingsObjeto.weightx = 1;
                imagen7.setIcon(new ImageIcon("img/vaca.jpg"));
		        botonVaca.add(imagen7);
                settingsObjeto.fill = GridBagConstraints.BOTH;
                panelGrandeSonidos.add(botonVaca, settingsBotones);
                

                botonRinoceronte= new JButton();
                botonRinoceronte.setBackground(Color.WHITE);
                JLabel imagen8 = new JLabel();
                settingsBotones.gridx = 1;
                settingsBotones.gridy = 2;
                settingsObjeto.weighty = 1;
                settingsObjeto.weightx = 1;
                imagen8.setIcon(new ImageIcon("img/rinoceronte.jpg"));
		        botonRinoceronte.add(imagen8);
                settingsObjeto.fill = GridBagConstraints.BOTH;
                panelGrandeSonidos.add(botonRinoceronte, settingsBotones);

                botonCuervo = new JButton();
                botonCuervo.setBackground(Color.WHITE);
                JLabel imagen9 = new JLabel();
                settingsBotones.gridx = 2;
                settingsBotones.gridy = 2;
                settingsObjeto.weighty = 1;
                settingsObjeto.weightx = 1;
                imagen9.setIcon(new ImageIcon("img/cuervo.jpg"));
		        botonCuervo.add(imagen9);
                settingsObjeto.fill = GridBagConstraints.BOTH;
                panelGrandeSonidos.add(botonCuervo, settingsBotones);
   
    }

    public void inicializar() {
        ventana.setVisible(true);
        inicializarComponentes();
    }

}
