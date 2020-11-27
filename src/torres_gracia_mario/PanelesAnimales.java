
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/**
* @author Mario Gracia Torres
* @version 1.0
* @since   1.0
* @see Esta clase se encarga principalmente de
*       crear os componentes de la ventana,pasados por parametros
*       formando un widget y se añaden a si mismo los componentes
*/

public class PanelesAnimales extends JPanel implements ActionListener {

    //Componentes a añadir de la clas,hereda de Jpanel e implementa los Actions Listeners
    private static final long serialVersionUID = 1L;
    private JPanel panelGrandeSonidos;
    private JTextField panelTextoSonidos;
    private Font fuente;
    private JButton[][] arrayBoton;
    ImageIcon imagen;
    String[][] nombreImagen;
    String[][] sonidos;

    //Constructor de la clase,crea un GridBagLayout,recoge los parametros pasados
    //de VentanaPrincipal y llama a los metodos que crean los components
    public PanelesAnimales(String[][] imagenAnimal, String[][] sonidosAnimales) {
        super();
        setLayout(new GridBagLayout());
        nombreImagen = imagenAnimal;
        sonidos = sonidosAnimales;
        inicializarPaneles();
        crearBotonesAnimales();
        anadirListeners();
    }

    //Metodo que implementa dos paneles:
    //Uno se encarga como a modo de titulo
    //Otro implementa el conjunto de botones
    public void inicializarPaneles() {
        GridBagConstraints settingsObjeto = new GridBagConstraints();
        panelTextoSonidos = new JTextField("Sonidos de Animales");
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
        add(panelTextoSonidos, settingsObjeto);

        settingsObjeto = new GridBagConstraints();
        panelGrandeSonidos = new JPanel(new GridLayout(3, 3, 3, 3));
        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 1;
        settingsObjeto.weighty = 4;
        settingsObjeto.weightx = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        add(panelGrandeSonidos, settingsObjeto);
    }
    
    //Metodo que implementa los botones en 3 filas y 3 columnas
    //A cada boton se le va añadiendo una imagen a colocar alineada al centro.
    //finalmente se añade al panel correspondiente
    public void crearBotonesAnimales() {
        arrayBoton = new JButton[3][3];
        for (int i = 0; i < arrayBoton.length; i++) {
            for (int j = 0; j < arrayBoton[i].length; j++) {
                arrayBoton[i][j] = new JButton();
                imagen = new ImageIcon(nombreImagen[i][j]);
                arrayBoton[i][j].setBackground(Color.WHITE);
                arrayBoton[i][j].setIcon(imagen);
                arrayBoton[i][j].setHorizontalAlignment(JButton.CENTER);
                panelGrandeSonidos.add(arrayBoton[i][j]);
            }
        }
    }
    //Metodo que se encrga de emitir un fichero de sonido
    //Creando un AudioInputStream al fichero pasado por parametros
    //y creando un objeto Clip para emitirllo,se controla tambien las excepciones
    public void ReproducirSonido(String nombreSonido){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
    //Metodo que implementa los listeners
    //a los propios botones a si mismos
    private void anadirListeners() {
        for (int i = 0; i < arrayBoton.length; i++) {
            for (int j = 0; j < arrayBoton[i].length; j++) {
                arrayBoton[i][j].addActionListener(this);
            }
        }
    }

    //Metodo que cuando un boton de la tabla se pulsado
    //Este llamara al metodo ReproducirSonido()
    //pasandolo por parametros,para cuando un boton de un animal
    // sea pulsado, este sonara el sonido correspondiente del animal
    @Override
    public void actionPerformed(ActionEvent e) {
        String audio = "";
        for (int i = 0; i < arrayBoton.length; i++) {
            for (int j = 0; j < arrayBoton[i].length; j++) {
                if (e.getSource() == arrayBoton[i][j]) {
                    audio = sonidos[i][j];
                    ReproducirSonido(audio);
                }
            }
        }
    }
}
