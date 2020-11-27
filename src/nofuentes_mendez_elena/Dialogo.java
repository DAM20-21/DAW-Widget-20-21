package nofuentes_mendez_elena;

import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Clase Diálogo que extiende de JDialog
 * 
 * @author Elena Nofuentes
 * @since 26-11-2020
 * @version 1.0
 * 
 */

public class Dialogo extends JDialog {

    private static final long serialVersionUID = 1L;
    private JLabel text1, text2;
    private JTextField jt1;
    private JButton buttonArchivo;
    private JFileChooser selector;
    private Dialogo dialogo;

    /** Constructor */
    public Dialogo(JFrame frame) {
        super(frame);
        setModal(true);
        setBounds(100, 100, 300, 200);
        text1 = new JLabel();
        text2 = new JLabel();
        jt1 = new JTextField();
        buttonArchivo = new JButton(" Archivo ");
        selector = new JFileChooser();
        dialogo = this;
        aElementos();
        aListenert();
    }

    public void aElementos() {
        setLayout(new GridLayout(0, 1));
        text1.setText(" Elija el medio de reproducción: ");
        add(text1);
        add(buttonArchivo);
        text2.setText(" --- URL ");
        add(text2);
        add(jt1);
    }

    public void aListenert() {
        buttonArchivo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrimos el dialogo
                int opcion = selector.showOpenDialog(dialogo);
                // Comprobamos que se ha pulsado en el botón aceptar
                if (opcion == JFileChooser.APPROVE_OPTION) {
                    File fich = selector.getSelectedFile();
                    String ruta = fich.getAbsolutePath();

                }
            }
        });
    }
}
