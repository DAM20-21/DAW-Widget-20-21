
/**
 * @author Alexandro Rodríguez Parrón
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.InsetsUIResource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Widgets_Formulario extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;

    // Atributos que se necesitaran en el JDialog
    private JPanel panel;
    private String[] nombre_Texto = { "Nombre", "Apellidos", "DNI", "Email", "Comentario" };
    private JLabel[] texto;
    private JTextField[] campo;
    private JLabel textoComentario;
    private JTextField campoComentario;
    private JButton guardar, borrar;
    final static int TAMANIO_CAMPOS = 150;

    /**
     * Constructor Parametrizado
     * 
     * @param ventana :Usaremos ventana para posicionar el JDialg en la posicion de
     *                la ventana pricipal
     */
    public Widgets_Formulario(JFrame ventana) {

        super();
        setModal(true);
        setBounds(0, 0, 400, 600);
        this.setLocationRelativeTo(ventana);
        anadirElementos();
        anadirListeners();

    }

    /**
     * Método añadirElementos Este método creará la interfaz del JDialog, colocando
     * los distintos componentes que hay.
     */
    private void anadirElementos() {

        texto = new JLabel[nombre_Texto.length - 1];
        campo = new JTextField[nombre_Texto.length - 1];
        guardar = new JButton();
        borrar = new JButton();
        panel = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();

        this.setLayout(new GridLayout());
        panel.setBackground(Color.CYAN);
        panel.setBorder(BorderFactory.createTitledBorder("Formulario"));
        this.add(panel);
        panel.setLayout(new GridBagLayout());

        for (int i = 0; i < nombre_Texto.length - 1; i++) {
            texto[i] = new JLabel(nombre_Texto[i]);
            gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = i;
                gbc.insets = new InsetsUIResource(0, 0, 40, 0);
            panel.add(texto[i], gbc);

            campo[i] = new JTextField();
            gbc = new GridBagConstraints();
                gbc.gridx = 1;
                gbc.gridy = i;
                gbc.ipadx = TAMANIO_CAMPOS;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.insets = new InsetsUIResource(0, 0, 40, 0);
            panel.add(campo[i], gbc);

        }

        textoComentario = new JLabel(nombre_Texto[nombre_Texto.length - 1]);
        gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 4;
        panel.add(textoComentario, gbc);

        campoComentario = new JTextField();
        gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 2;
            gbc.ipadx = TAMANIO_CAMPOS;
            gbc.ipady = 100;
            gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(campoComentario, gbc);

        guardar.setText("GUARDAR");
        gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 6;
            gbc.anchor = gbc.EAST;
            gbc.insets = new InsetsUIResource(60, 0, 0, 0);
        panel.add(guardar, gbc);

        borrar.setText("BORRAR");
        gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.insets = new InsetsUIResource(60, 0, 0, 0);
        panel.add(borrar, gbc);

    }

    /**
     * Método añadirListener Este método inicializa los botones con las operaciones
     * que tienen que realizar Boton Borrar: Borra los campos, es decir los pone
     * vacios de nuevo. Boton Guardar: Guarda el texto de los campos en un fichero,
     * y pone los campos vacios para volver a escribir.
     */
    private void anadirListeners() {
        borrar.addActionListener(e -> {
            for (int i = 0; i < nombre_Texto.length - 1; i++) {
                campo[i].setText("");
            }
            campoComentario.setText("");
        });

        guardar.addActionListener(e -> {
            try {
                BufferedWriter br = new BufferedWriter(new FileWriter("Opiniones.txt", true));
                for (int i = 0; i < nombre_Texto.length - 1; i++) {
                    br.write(nombre_Texto[i] + ": " + campo[i].getText());
                    br.newLine();
                }
                br.write(nombre_Texto[nombre_Texto.length-1]+": " + campoComentario.getText());
                br.newLine();
                br.newLine();
                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            for (int i = 0; i < nombre_Texto.length - 1; i++) {
                campo[i].setText("");
            }
            campoComentario.setText("");
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
