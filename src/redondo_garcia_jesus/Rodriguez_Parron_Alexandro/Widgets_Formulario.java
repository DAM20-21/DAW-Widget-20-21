package redondo_garcia_jesus.Rodriguez_Parron_Alexandro;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.InsetsUIResource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Widgets_Formulario extends JDialog implements ActionListener {

    private JPanel panel;
    private JLabel texto1, texto2, texto3, texto4, texto5;
    private JTextField campo1, campo2, campo3, campo4, campo5;
    final static int TAMANIO_CAMPO_NOMBRE = 150;


    public Widgets_Formulario(JComponent componente, JFrame ventana) {

        super();
		setModal(true);
        setBounds((int) componente.getLocationOnScreen().getX(), (int) componente.getLocationOnScreen().getX(), 500, 500);
        this.setLocationRelativeTo(ventana);
		anadirElementos();
        anadirListeners();
        
    }

    private void anadirElementos(){
        panel = new JPanel();
        texto1 = new JLabel();
        texto2 = new JLabel();
        texto3 = new JLabel();
        texto4 = new JLabel();
        texto5 = new JLabel();
        campo1 = new JTextField();
        campo2 = new JTextField();
        campo3 = new JTextField();
        campo4 = new JTextField();
        campo5 = new JTextField();
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
            gbc.ipadx = TAMANIO_CAMPO_NOMBRE;
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
            gbc.ipadx = TAMANIO_CAMPO_NOMBRE;
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
            gbc.ipadx = TAMANIO_CAMPO_NOMBRE;
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
            gbc.ipadx = TAMANIO_CAMPO_NOMBRE;
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
            gbc.ipadx = TAMANIO_CAMPO_NOMBRE;
            gbc.ipady = 100;
            gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(campo5, gbc);
    }
    private void anadirListeners(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();

    }
}
