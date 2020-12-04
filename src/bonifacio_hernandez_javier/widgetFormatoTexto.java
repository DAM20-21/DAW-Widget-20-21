package bonifacio_hernandez_javier;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

/**
 * 
 * @author Javier Bonifacio Hernandez
 * @version 1.0
 */
public class widgetFormatoTexto extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;

    /*
     * StyledText text = new StyledText(shell, SWT.BORDER);
     * text.setText("0123456789 ABCDEFGHIJKLM NOPQRSTUVWXYZ");
     * appear underlined StyleRange style1 = new StyleRange(); style1.start = 0;
     * style1.length = 10; style1.underline = true; text.setStyleRange(style1);
     */

    private VentanaPrincipal ventana;
    private Font fuenteBotonB = new FontUIResource("", Font.BOLD, 14);
    private Font fuenteBotonI = new FontUIResource("", Font.ITALIC, 14);
    private Font fuenteBotonS = new FontUIResource("", Font.PLAIN, 14);
    private int tamaño;
    private int letra;
    private int aling;
    private JButton bAceptar;
    private JPanel panelTamaño;
    private JButton[] vBotonesFuente;
    private JPanel panelNegrita;
    private JPanel panelAlineacion;
    private JLabel titulo;
    private JLabel lTamanio;
    private JLabel lFormato;
    private JLabel lAlineacion;
    private Color color = Color.decode("#FAFFFF");
    private JPanel panelColor;
    private JLabel labelColor;
    private Miboton botonColor;

    // private Icon iIzquierda = new
    // ImageIcon(getClass().getResource("img/bonifacio_hernandez_javier/izquierda.ico"));
    // private Icon iCentro = new
    // ImageIcon(getClass().getResource("img/bonifacio_hernandez_javier/centro.ico"));
    // private Icon iDerecha = new
    // ImageIcon(getClass().getResource("img/bonifacio_hernandez_javier/derecha.ico"));

    public widgetFormatoTexto(JComponent componente, Color colorInicial, VentanaPrincipal ventana) {
        super();
        setModal(true); // PARA HACERLO MODAL
        setBounds((int) componente.getLocationOnScreen().getX(), (int) componente.getLocationOnScreen().getY(), 300,
                500); // Dónde empieza el Dialog y qué tamaño tiene
        this.color = colorInicial;
        anadirElementos();
        anadirListeners();
        this.ventana = ventana;

    }

    /**
     * Método que añade todos los elementos al Dialog. Se codifica como un JFrame
     */
    private void anadirElementos() {
        int contTamaño = 10;
        vBotonesFuente = new JButton[11];

        this.setLayout(new GridBagLayout());
        this.setBackground(color);

        // PANEL PRINCIPAL
        // Titulo
        titulo = new JLabel("Selecciona el Formato del Texto");
        GridBagConstraints settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 0;
        settings.insets = new Insets(20, 0, 50, 0);
        add(titulo, settings);

        // Tamaño
        lTamanio = new JLabel("Tamaño del Texto");
        lTamanio.setLayout(new GridLayout(1, 5));
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 1;
        add(lTamanio, settings);

        panelTamaño = new JPanel();
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 2;
        add(panelTamaño, settings);

        for (int i = 0; i < 5; i++) {
            vBotonesFuente[i] = new JButton(Integer.toString(contTamaño));
            vBotonesFuente[i].setName("" + i);
            panelTamaño.add(vBotonesFuente[i]);
            contTamaño += 4;
        }

        // formato del texto
        lFormato = new JLabel("Formato");
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 3;
        add(lFormato, settings);

        panelNegrita = new JPanel();
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 4;
        add(panelNegrita, settings);

        vBotonesFuente[5] = new JButton("B");
        vBotonesFuente[5].setName("5");
        vBotonesFuente[5].setFont(fuenteBotonB);
        panelNegrita.add(vBotonesFuente[5]);
        vBotonesFuente[6] = new JButton("I");
        vBotonesFuente[6].setName("6");
        vBotonesFuente[6].setFont(fuenteBotonI);
        panelNegrita.add(vBotonesFuente[6]);
        vBotonesFuente[7] = new JButton("S");
        vBotonesFuente[7].setName("7");
        vBotonesFuente[7].setFont(fuenteBotonS);
        vBotonesFuente[7].setEnabled(false);
        panelNegrita.add(vBotonesFuente[7]);

        // Alineacion del texto
        lAlineacion = new JLabel("Alineacion del texto");
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 5;
        add(lAlineacion, settings);

        panelAlineacion = new JPanel();
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 6;
        add(panelAlineacion, settings);

        vBotonesFuente[8] = new JButton("Izquierda");
        vBotonesFuente[8].setName("8");
        panelAlineacion.add(vBotonesFuente[8]);
        vBotonesFuente[9] = new JButton("Centro");
        vBotonesFuente[9].setName("9");
        panelAlineacion.add(vBotonesFuente[9]);
        vBotonesFuente[10] = new JButton("Derecha");
        vBotonesFuente[10].setName("10");
        panelAlineacion.add(vBotonesFuente[10]);

        // Boton color
        labelColor = new JLabel("Color del texto");
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 8;
        add(labelColor, settings);

        panelColor = new JPanel();
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 9;
        add(panelColor, settings);

        botonColor = new Miboton("Selecciona el color");
        botonColor.setName("9");
        panelColor.add(botonColor);

        // bAceptar
        settings = new GridBagConstraints();
        bAceptar = new JButton("Aceptar");
        bAceptar.setName("Aceptar");
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 10;
        settings.insets = new Insets(20, 0, 20, 0);
        add(bAceptar, settings);
    }

    /**
     * Método que añade todos los listeners al Dialog
     */
    private void anadirListeners() {
        // fuente
        for (int i = 0; i < vBotonesFuente.length; i++) {
            vBotonesFuente[i].addActionListener(this);
        }

        // Botón Aceptar:
        bAceptar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        switch (b.getName()) {
            case "Aceptar": {
                ventana.cambioFormato(tamaño, letra, aling, botonColor.getColor());
                this.dispose();
                break;
            }
            case "0": {
                tamaño = 10;
                break;
            }
            case "1": {
                tamaño = 14;
                break;
            }
            case "2": {
                tamaño = 18;
                break;
            }
            case "3": {
                tamaño = 22;
                break;
            }
            case "4": {
                tamaño = 26;
                break;
            }
            case "5": {
                letra = 0;
                break;
            }
            case "6": {
                letra = 1;
                break;
            }
            case "7": {
                letra = 2;
                break;
            }
            case "8": {
                aling = 0;
                break;
            }
            case "9": {
                aling = 1;
                break;
            }
            case "10": {
                aling = 2;
                break;
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
