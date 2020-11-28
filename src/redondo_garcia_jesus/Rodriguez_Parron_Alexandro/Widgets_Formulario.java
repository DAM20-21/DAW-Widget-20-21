
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

    //Atributos que se necesitaran en el JDialog
    private JPanel panel;
    private JLabel texto1, texto2, texto3, texto4, texto5;
    private JTextField campo1, campo2, campo3, campo4, campo5;
    private JButton guardar, borrar;
    final static int TAMANIO_CAMPO_NOMBRE = 20;
    final static int TAMANIO_CAMPO_APELLIDO = 40;
    final static int TAMANIO_CAMPO_DNI = 9;
    final static int TAMANIO_CAMPO_EMAIL = 40;
    final static int TAMANIO_CAMPO_COMENTARIO = 150;
    final static int TAMANIO_CAMPOS = 150;



    /**
     * Constructor Parametrizado
     * @param ventana :Usaremos ventana para posicionar el JDialg en la posicion de la ventana pricipal
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
     * Método añadirElementos
     * Este método creará la interfaz del JDialog, colocando los distintos componentes que hay.
     */
    private void anadirElementos(){
        guardar = new JButton();
        borrar = new JButton();
        panel = new JPanel();
        texto1 = new JLabel();
        texto2 = new JLabel();
        texto3 = new JLabel();
        texto4 = new JLabel();
        texto5 = new JLabel();
        campo1 = new JTextField(TAMANIO_CAMPO_NOMBRE);
        campo2 = new JTextField(TAMANIO_CAMPO_APELLIDO);
        campo3 = new JTextField(TAMANIO_CAMPO_DNI);
        campo4 = new JTextField(TAMANIO_CAMPO_EMAIL);
        campo5 = new JTextField(TAMANIO_CAMPO_COMENTARIO);
        GridBagConstraints gbc = new GridBagConstraints();

        this.setLayout(new GridLayout());
        panel.setBackground(Color.CYAN);
        panel.setBorder(BorderFactory.createTitledBorder("Formulario"));
        this.add(panel);
        panel.setLayout(new GridBagLayout());

        texto1.setText("Nombre: ");
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new InsetsUIResource(0, 0, 40, 0);
        panel.add(texto1, gbc);

        gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.ipadx = TAMANIO_CAMPOS;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new InsetsUIResource(0, 0, 40, 0);
        panel.add(campo1, gbc);

        texto2.setText("Apellidos: ");
        gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new InsetsUIResource(0, 0, 40, 0);
        panel.add(texto2, gbc);

        gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.ipadx = TAMANIO_CAMPOS;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new InsetsUIResource(0, 0, 40, 0);
        panel.add(campo2, gbc);

        texto3.setText("DNI: ");
        gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.insets = new InsetsUIResource(0, 0, 40, 0);
        panel.add(texto3, gbc);

        gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.ipadx = TAMANIO_CAMPOS;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new InsetsUIResource(0, 0, 40, 0);
        panel.add(campo3, gbc);

        texto4.setText("Email: ");
        gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.insets = new InsetsUIResource(0, 0, 40, 0);
        panel.add(texto4, gbc);

        gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.ipadx = TAMANIO_CAMPOS;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new InsetsUIResource(0, 0, 40, 0);
        panel.add(campo4, gbc);

        texto5.setText("Comentario: ");
        gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 4;
        panel.add(texto5, gbc);

        gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 2;
            gbc.ipadx = TAMANIO_CAMPOS;
            gbc.ipady = 100;
            gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(campo5, gbc);

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
     * Método añadirListener
     * Este método inicializa los botones con las operaciones que tienen que realizar
     * Boton Borrar: Borra los campos, es decir los pone vacios de nuevo.
     * Boton Guardar: Guarda el texto de los campos en un fichero, y pone los campos vacios para volver a escribir.
     */
    private void anadirListeners(){
        borrar.addActionListener(e->{
            campo1.setText("");
            campo2.setText("");
            campo3.setText("");
            campo4.setText("");
            campo5.setText("");
        });

        guardar.addActionListener(e->{
            try {
                BufferedWriter br = new BufferedWriter(new FileWriter("Opiniones.txt", true));
                    br.write("Nombre: "+campo1.getText());
                    br.newLine();
                    br.write("Apellidos: "+campo2.getText());
                    br.newLine();
                    br.write("DNI: "+campo3.getText());
                    br.newLine();
                    br.write("Email: "+campo4.getText());
                    br.newLine();
                    br.write("Comentario: "+campo5.getText());
                    br.newLine();
                    br.newLine();
                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            campo1.setText("");
            campo2.setText("");
            campo3.setText("");
            campo4.setText("");
            campo5.setText("");
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
