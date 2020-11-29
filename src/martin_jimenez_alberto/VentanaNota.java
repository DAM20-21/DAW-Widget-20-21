import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import java.awt.*;
import java.util.ArrayList;

public class VentanaNota {
    ArrayList<Fichero> listaFICHEROS ;//Lista que guarda Objetos Fichero
    int nFICHEROS;
    JFrame f;
    
    JPanel pTitulo;
    JTextField tTitulo;

    JPanel pTexto;
    JTextField tTexto;

    JButton bGuardar;
    JButton bEliminar;

    VentanaNota() {
        f = new JFrame();
        f.setBounds(1000, 100, 200, 300);
    }
    public void anadirComponentes() {
        GridBagLayout gb = new GridBagLayout();
        f.setLayout(gb); 
        
        tTitulo  = new JTextField();
        pTitulo = new JPanel();
        tTexto  = new JTextField();
        pTexto = new JPanel();
        

        GridBagConstraints sTitulo = new GridBagConstraints();
        sTitulo.gridx = 0;
        sTitulo.gridy = 0;
        sTitulo.gridx = 1;
        sTitulo.fill = GridBagConstraints.BOTH;
        TitledBorder bTitulo = new TitledBorder("Tìtulo");
        pTitulo.setBorder(bTitulo);

        GridBagConstraints sTexto = new GridBagConstraints();
        sTexto.gridx = 0;
        sTexto.gridy = 1;
        sTexto.gridx = 1;
        sTexto.fill = GridBagConstraints.BOTH;
        TitledBorder bTexto = new TitledBorder("Texto");
        pTexto.setBorder(bTexto);
    }

    public void incializar() {
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        anadirComponentes();
        /* inicializarListteners(); */
        f.setVisible(true);

    }  

}