import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import java.awt.*;
import java.util.ArrayList;

public class VentanaNota extends JDialog{
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
        super();
        this.setBounds(1000, 100, 200, 300);
        incializar();
    }
    public void anadirComponentes() {
        GridBagLayout gb = new GridBagLayout();
        this.setLayout(gb); 
        
        tTitulo  = new JTextField();
        pTitulo = new JPanel();
        tTexto  = new JTextField();
        pTexto = new JPanel();
        

        GridBagConstraints sTitulo = new GridBagConstraints();
        sTitulo.gridx = 0;
        sTitulo.gridy = 0;
        sTitulo.weighty = 1;
        sTitulo.weightx = 1;
        sTitulo.fill = GridBagConstraints.BOTH;
        TitledBorder bTitulo = new TitledBorder("Tìtulo");
        pTitulo.setBorder(bTitulo);

        GridBagConstraints sTexto = new GridBagConstraints();
        sTexto.gridx = 0;
        sTexto.gridy = 1;
        sTexto.weighty = 9;
        sTexto.weightx = 1;
        sTexto.fill = GridBagConstraints.BOTH;
        TitledBorder bTexto = new TitledBorder("Texto");
        pTexto.setBorder(bTexto);

        this.add(pTitulo,sTitulo);
        this.add(pTexto,sTexto);
    }

    public void incializar() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        anadirComponentes();
        /* inicializarListteners(); */
        this.setVisible(true);

    }  

}