package canalo_dominguez_angel;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniEnciclopedia extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JPanel panelPrincipal;
    JComboBox<String> comboBoxDinosaurios;
    String[] dinosaurios = { "-Elige un dinosaurio-", "Tyrannosaurus", "Maiasaura", "Pachycephalosaurus",
            "Procompsognathus", "Apatosaurus", "Stegosaurus", "Parasaurolophus", "Triceratops", "Velociraptor",
            "Carnotaurus" };
    JTextField nombre;
    JLabel labelNombre;

    public MiniEnciclopedia() {
        super();
        crearElementos();
        crearListeners();
    }

    private void crearListeners() {
        comboBoxDinosaurios.addActionListener((e) -> {
            if (comboBoxDinosaurios.getSelectedIndex() != 0) {
                nombre.setText(comboBoxDinosaurios.getSelectedItem().toString());
            } else {
                nombre.setText("");
            }
        });
    }

    private void crearElementos() {
        setLayout(new GridBagLayout());

        GridBagConstraints settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 0;
        settingsObjeto.gridwidth=2;
        settingsObjeto.weightx=2;
        settingsObjeto.insets=new Insets(10,0,10,0);
        settingsObjeto.fill=GridBagConstraints.BOTH;
        comboBoxDinosaurios = new JComboBox<String>(dinosaurios);
        ((JLabel)comboBoxDinosaurios.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        add(comboBoxDinosaurios, settingsObjeto);

        settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 1;
        settingsObjeto.gridwidth=1;
        settingsObjeto.weightx=1;
        settingsObjeto.fill=GridBagConstraints.BOTH;
        labelNombre = new JLabel("Nombre");
        labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(labelNombre, settingsObjeto);

        settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 1;
        settingsObjeto.gridy = 1;
        settingsObjeto.gridwidth=1;
        settingsObjeto.weightx=1;
        settingsObjeto.fill=GridBagConstraints.BOTH;
        nombre = new JTextField();
        nombre.setEditable(false);
        nombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        add(nombre, settingsObjeto);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}