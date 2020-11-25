package gil_martin_ivan;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Clase en la que haremos nuestro widget Temporizador
 * @author Iván Gil Martín
 */
public class IvanTemporizador extends JDialog implements ActionListener {
    private static final long serialVersionUID = -4571795828445399258L;

    JLabel titulo, minutos, segundos, mostradorTemporizador;
    JSlider barraMinutos, barraSegundos;
    JButton botonAceptar;

    public IvanTemporizador(){
        super();
        setModal(true);
        setBounds(300, 500, 300, 500);
        probar();
    }

    public void probar(){
        setVisible(true);
        inicializarElementos();
        inicializarListeners();
    }

    public void inicializarElementos(){
        this.setLayout(new GridBagLayout());

        titulo = new JLabel("Establece el tiempo");
        GridBagConstraints ajustes = new GridBagConstraints();
        ajustes.gridx = 0;
        ajustes.gridy = 0;
        add(titulo, ajustes);
    }

    public void inicializarListeners(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}