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
import java.util.ArrayList;

public class MiniEnciclopedia extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JPanel panelPrincipal;
    JComboBox<String> comboBoxDinosaurios;
    JPanel panel1, panel2;
    ArrayList<Dinosaurio> lista = new ArrayList<Dinosaurio>();
    Dinosaurio[] iniciales = {
            new Dinosaurio("Tyrannosaurus", "Lagarto Tirano", "Cretácico Superior", 12.5, 4.5, 6500.0, "Carnívoro",
                    "Sí (Gran tamaño y ferocidad, dieta carnívora, mordisco potente)"),
            new Dinosaurio("Maiasaura", "Lagarto Buena Madre", "Cretácico Superior", 9.0, 4.0, 4000, "Herbívoro", "No"),
            new Dinosaurio("Pachycephalosaurus", "Lagarto de Cabeza Gruesa", "Cretácico Superior", 4.5, 1.2, 450.0,
                    "Omnívoro", "Sí (Alta agresividad)"),
            new Dinosaurio("Procompsognathus", "Predecesor a la mandíbula elegante", "Triásico Superior", 1.2, 0.25,
                    2.0, "Carnívoro", "Sí (Carácter gregario, dieta carnívora, venenoso)"),
            new Dinosaurio("Apatosaurus", "Lagarto Engañoso", "Jurásico Superior", 23, 6, 30000, "Herbívoro", "No"),
            new Dinosaurio("Stegosaurus", "Lagarto de Tejas", "Jurásico Superior", 8.5, 4, 3500.0, "Herbívoro",
                    "Sí (Gran tamaño, escasa inteligencia, cola armada con púas)"),
            new Dinosaurio("Parasaurolophus", "Paralelo al Lagarto Crestado", "Cretácico Superior", 9.5, 4.0, 3500.0,
                    "Herbívoro", "No"),
            new Dinosaurio("Triceratops", "Cara con Tres Cuernos", "Cretácico Superior", 9, 3.5, 8000.0, "Herbívoro",
                    "Sí (Carácter gregario, cuernos afilados, alta agresividad)"),
            new Dinosaurio("Velociraptor", "Ladrón veloz", "Cretácico Superior", 3.5, 1.5, 75.0, "Carnívoro",
                    "Sí (Carácter gregario, gran velocidad, extrema ferocidad, dieta carnívora, gran inteligencia)"),
            new Dinosaurio("Carnotaurus", "Toro carnívoro", "Cretácico Superior", 7.5, 2.3, 1000.0, "Carnívoro",
                    "Sí (Gran tamaño, dieta carnívora, camuflaje)"),
            new Dinosaurio("Ornitholestes", "Ladrón de aves", "Jurásico Superior", 2.5, 1.5, 30.0, "Carnívoro",
                    "Sí (Dieta carnívora)"),
            new Dinosaurio("Gallimimus", "Imitador de gallina", "Cretácico Superior", 6.5, 3, 300.0, "Omnívoro", "No"),
            new Dinosaurio("Mussaurus", "Lagarto Ratón", "Triásico Superior", 1.5, 0.45, 3.0, "Herbívoro", "No"),
            new Dinosaurio("Dryosaurus", "Lagarto Roble", "Jurásico Superior", 4.5, 1.75, 200.0, "Herbívoro", "No"),
            new Dinosaurio("Microceratus", "Cuernos diminutos", "Cretácico Superior", 1.0, 0.45, 2.5, "Herbívoro",
                    "No") };
    String[] dinosaurios = new String[iniciales.length+1];
    JTextField nombre, significado, periodo, longitud, altura, peso, dieta, peligroso;
    JLabel labelNombre, labelSign, labelPeriod, labelLong, labelAlt, labelPeso, labelDieta, labelPel;

    public MiniEnciclopedia() {
        super();
        lista.add(0, null);
        dinosaurios[0]="-Elija un dinosaurio-";
        for (int i = 1; i <= iniciales.length; i++) {
            lista.add(i, iniciales[i - 1]);
            dinosaurios[i]=iniciales[i-1].getNombre();
        }
        crearElementos();
        crearListeners();
    }

    private void crearListeners() {
        comboBoxDinosaurios.addActionListener((e) -> {
            int pos = comboBoxDinosaurios.getSelectedIndex();
            if (pos != 0) {
                nombre.setText(lista.get(pos).getNombre());
                significado.setText(lista.get(pos).getSignificado());
                periodo.setText(lista.get(pos).getPeriodo());
                longitud.setText(lista.get(pos).getLongitud()+" m");
                altura.setText(lista.get(pos).getAltura()+" m");
                peso.setText(lista.get(pos).getPeso()+" kg");
                dieta.setText(lista.get(pos).getDieta());
                peligroso.setText(lista.get(pos).getPeligroso());
            } else {
                nombre.setText(null);
                significado.setText(null);
                periodo.setText(null);
                longitud.setText(null);
                altura.setText(null);
                peso.setText(null);
                dieta.setText(null);
                peligroso.setText(null);
            }
        });
    }

    private void crearElementos() {
        setLayout(new GridBagLayout());

        GridBagConstraints settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 0;
        settingsObjeto.gridy = 0;
        settingsObjeto.gridwidth = 3;
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
        settingsObjeto.gridwidth = 2;
        settingsObjeto.ipadx = 200;
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

        settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 1;
        settingsObjeto.gridy = 2;
        settingsObjeto.gridwidth = 2;
        settingsObjeto.ipadx = 200;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        significado = new JTextField();
        significado.setEditable(false);
        significado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        significado.setHorizontalAlignment(SwingConstants.CENTER);
        add(significado, settingsObjeto);

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

        settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 1;
        settingsObjeto.gridy = 3;
        settingsObjeto.gridwidth = 2;
        settingsObjeto.ipadx = 200;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        periodo = new JTextField();
        periodo.setEditable(false);
        periodo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        periodo.setHorizontalAlignment(SwingConstants.CENTER);
        add(periodo, settingsObjeto);

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

        settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 1;
        settingsObjeto.gridy = 4;
        settingsObjeto.gridwidth = 2;
        settingsObjeto.ipadx = 200;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        altura = new JTextField();
        altura.setEditable(false);
        altura.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        altura.setHorizontalAlignment(SwingConstants.CENTER);
        add(altura, settingsObjeto);

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

        settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 1;
        settingsObjeto.gridy = 5;
        settingsObjeto.gridwidth = 2;
        settingsObjeto.ipadx = 200;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        longitud = new JTextField();
        longitud.setEditable(false);
        longitud.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        longitud.setHorizontalAlignment(SwingConstants.CENTER);
        add(longitud, settingsObjeto);

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

        settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 1;
        settingsObjeto.gridy = 6;
        settingsObjeto.gridwidth = 2;
        settingsObjeto.ipadx = 200;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        peso = new JTextField();
        peso.setEditable(false);
        peso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        peso.setHorizontalAlignment(SwingConstants.CENTER);
        add(peso, settingsObjeto);

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

        settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 1;
        settingsObjeto.gridy = 7;
        settingsObjeto.gridwidth = 2;
        settingsObjeto.ipadx = 200;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        dieta = new JTextField();
        dieta.setEditable(false);
        dieta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        dieta.setHorizontalAlignment(SwingConstants.CENTER);
        add(dieta, settingsObjeto);

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

        settingsObjeto = new GridBagConstraints();

        settingsObjeto.gridx = 1;
        settingsObjeto.gridy = 8;
        settingsObjeto.gridwidth = 2;
        settingsObjeto.ipadx = 200;
        settingsObjeto.weighty = 1;
        settingsObjeto.fill = GridBagConstraints.BOTH;
        peligroso = new JTextField();
        peligroso.setEditable(false);
        peligroso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        peligroso.setHorizontalAlignment(SwingConstants.CENTER);
        add(peligroso, settingsObjeto);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}