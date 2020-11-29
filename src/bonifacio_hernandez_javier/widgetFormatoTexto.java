package bonifacio_hernandez_javier;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que representa un diálogo selector de color. Para utilizar esta clase
 * crea un listener del estilo:
 * {@code  DialogSelectorColor dialog = new DialogSelectorColor(bDialogo, panelColor.getBackground());
			dialog.addWindowListener(new WindowAdapter() { @Override public void
 * windowClosed(WindowEvent arg0) { System.out.println(dialog.getColor()); } });
 * } La clase está preparada para que pueda funcionar sobre cualquier
 * componente.
 * 
 * @author Javier Bonifacio Hernandez
 *
 */
public class widgetFormatoTexto extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;

    private VentanaPrincipal ventana;
    private int cont;
    private int tamañoFuente;
    private int alineacion;
    private int formatoLetra;

    private JButton bAceptar;
    private JPanel panelTamaño;
    private JButton[] vBotonesTamaño;
    private JPanel panelNegrita;
    private JButton[] vBotonesNegrita;
    private JPanel panelAlineacion;
    private JButton[] vBotonesAlineacion;

    JLabel titulo;
    JLabel lTamanio;
    JLabel lColor;
    JLabel lAlineacion;

    // ColorInicial:
    Color color = Color.BLUE;

    public widgetFormatoTexto(JComponent componente, Color colorInicial) {
        super();
        setModal(true); // PARA HACERLO MODAL
        setBounds((int) componente.getLocationOnScreen().getX(), (int) componente.getLocationOnScreen().getY(), 300,
                500); // Dónde empieza el Dialog y qué tamaño tiene
        this.color = colorInicial;
        anadirElementos();
        anadirListeners();
    }

    /**
     * Método que añade todos los elementos al Dialog. Se codifica como un JFrame
     */
    private void anadirElementos() {
        int contTamaño = 10;

        this.setLayout(new GridBagLayout());

        // PANEL PRINCIPAL
        // Titulo
        titulo = new JLabel("Selecciona el Formato del Texto:");
        GridBagConstraints settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 0;
        settings.insets = new Insets(20, 0, 50, 0);
        add(titulo, settings);

        // Tamaño
        lTamanio = new JLabel("Tamaño del Texto:");
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

        vBotonesTamaño = new JButton[5];
        for (int i = 0; i < vBotonesTamaño.length; i++) {
            vBotonesTamaño[i] = new JButton(Integer.toString(contTamaño));
            panelTamaño.add(vBotonesTamaño[i]);
            contTamaño += 4;
        }

        // Color del texto
        lColor = new JLabel("Formato:");
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 3;
        add(lColor, settings);

        panelNegrita = new JPanel();
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 4;
        add(panelNegrita, settings);

        vBotonesNegrita = new JButton[3];
        vBotonesNegrita[0] = new JButton("Negrita");
        panelNegrita.add(vBotonesNegrita[0]);
        vBotonesNegrita[1] = new JButton("Italica");
        panelNegrita.add(vBotonesNegrita[1]);
        vBotonesNegrita[2] = new JButton("Subrayado");
        panelNegrita.add(vBotonesNegrita[2]);

        // Alineacion del texto
        lAlineacion = new JLabel("Alineacion del texto:");
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 5;
        add(lAlineacion, settings);

        panelAlineacion = new JPanel();
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 6;
        add(panelAlineacion, settings);

        vBotonesAlineacion = new JButton[3];
        vBotonesAlineacion[0] = new JButton("Izquierda");
        panelAlineacion.add(vBotonesAlineacion[0]);
        vBotonesAlineacion[1] = new JButton("Centro");
        panelAlineacion.add(vBotonesAlineacion[1]);
        vBotonesAlineacion[2] = new JButton("Derecha");
        panelAlineacion.add(vBotonesAlineacion[2]);

        // bAceptar
        settings = new GridBagConstraints();
        bAceptar = new JButton("Aceptar");
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 8;
        settings.insets = new Insets(20, 0, 20, 0);
        add(bAceptar, settings);

    }

    /**
     * Método que añade todos los listeners al Dialog
     */
    private void anadirListeners() {
        cont=6;

        // Tamaño
        for (int i = 0; i < vBotonesTamaño.length; i++) {
            cont=cont+4;
            vBotonesTamaño[i].addActionListener(e -> {
                tamañoFuente = cont;
    
            });
        }

        // Formato
        cont=0;
        for (int i = 0; i < vBotonesNegrita.length; i++) {
            vBotonesNegrita[cont].addActionListener(e -> {
                formatoLetra=cont;
    
            });
            cont++;
        }

        // Alineacion
        cont=0;
        for (int i = 0; i < vBotonesAlineacion.length; i++) {
            vBotonesAlineacion[cont].addActionListener(e -> {
                alineacion=cont;
    
            });
            cont++;
        }
        
        // Botón Aceptar:
        bAceptar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
       // ventana.setTamañoFuente(tamañoFuente);
        
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
