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
            "Carnotaurus", "Ornitholestes", "Gallimimus", "Mussaurus", "Dryosaurus", "Microceratus" };
    JTextField nombre;
    JLabel labelNombre, labelSign, labelPeriod, labelLong, labelAlt, labelPeso, labelDieta, labelPel;

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
        settingsObjeto.gridwidth = 2;
        settingsObjeto.weightx = 2;
        settingsObjeto.weighty = 0;
        settingsObjeto.insets = new Insets(10, 0, 10, 0);
        settingsObjeto.fill = GridBagConstraints.BOTH;
        comboBoxDinosaurios = new JComboBox<String>(dinosaurios);
        ((JLabel) comboBoxDinosaurios.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        add(comboBoxDinosaurios, settingsObjeto);

        settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 1;
        settingsObjeto.gridwidth = 1;
        settingsObjeto.weightx = 1;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        labelNombre = new JLabel("Nombre: ");
        labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(labelNombre, settingsObjeto);

        settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 1;
        settingsObjeto.gridy = 1;
        settingsObjeto.gridwidth = 1;
        settingsObjeto.weightx = 1;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        nombre = new JTextField();
        nombre.setEditable(false);
        nombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        add(nombre, settingsObjeto);

        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 2;
        settingsObjeto.gridwidth = 1;
        settingsObjeto.weightx = 1;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        labelSign = new JLabel("Significado: ");
        labelSign.setHorizontalAlignment(SwingConstants.CENTER);
        labelSign.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(labelSign, settingsObjeto);

        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 3;
        settingsObjeto.gridwidth = 1;
        settingsObjeto.weightx = 1;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        labelPeriod = new JLabel("Período: ");
        labelPeriod.setHorizontalAlignment(SwingConstants.CENTER);
        labelPeriod.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(labelPeriod, settingsObjeto);

        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 4;
        settingsObjeto.gridwidth = 1;
        settingsObjeto.weightx = 1;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        labelAlt = new JLabel("Altura: ");
        labelAlt.setHorizontalAlignment(SwingConstants.CENTER);
        labelAlt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(labelAlt, settingsObjeto);

        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 5;
        settingsObjeto.gridwidth = 1;
        settingsObjeto.weightx = 1;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        labelLong = new JLabel("Longitud: ");
        labelLong.setHorizontalAlignment(SwingConstants.CENTER);
        labelLong.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(labelLong, settingsObjeto);

        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 6;
        settingsObjeto.gridwidth = 1;
        settingsObjeto.weightx = 1;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        labelPeso = new JLabel("Peso: ");
        labelPeso.setHorizontalAlignment(SwingConstants.CENTER);
        labelPeso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(labelPeso, settingsObjeto);

        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 7;
        settingsObjeto.gridwidth = 1;
        settingsObjeto.weightx = 1;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        labelDieta = new JLabel("Dieta: ");
        labelDieta.setHorizontalAlignment(SwingConstants.CENTER);
        labelDieta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(labelDieta, settingsObjeto);

        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 8;
        settingsObjeto.gridwidth = 1;
        settingsObjeto.weightx = 1;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        labelPel = new JLabel("¿Es peligroso? ");
        labelPel.setHorizontalAlignment(SwingConstants.CENTER);
        labelPel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(labelPel, settingsObjeto);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}