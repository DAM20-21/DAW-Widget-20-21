import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import java.awt.*;
import java.util.ArrayList;

public class VentanaNota extends JDialog{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    ArrayList<Fichero> listaFICHEROS;// Lista que guarda Objetos Fichero
    int nFICHEROS;
    VentanaPrincipalWidget vp;

    JButton botonGuardar;
    JPanel pTitulo;
    JTextField tTitulo;
    JPanel pTexto;
    JTextField tTexto;

    JButton bGuardar;
    JButton bEliminar;

    VentanaNota(VentanaPrincipalWidget vpr) {
        super();
        this.setBounds(1000, 100, 200, 300);
        this.vp = vpr;
        vp.incializar();
    }
    VentanaNota(VentanaPrincipalWidget vpr,String ti, String te) {
        super();
        this.setBounds(1000, 100, 200, 300);
        this.vp = vpr; 
        this.editorDeTexto(ti,te);
    }
    

    public void anadirComponentes() {
        GridBagLayout gb = new GridBagLayout();
        this.setLayout(gb); 
        
        botonGuardar = new JButton("Guardar");
        tTitulo = new JTextField();
        pTitulo = new JPanel(new GridBagLayout());
        tTexto = new JTextField();
        pTexto = new JPanel(new GridBagLayout());

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

        GridBagConstraints sBoton = new GridBagConstraints();
        sBoton.gridx = 0;
        sBoton.gridy = 2;
        sBoton.weighty = 1;
        sBoton.weightx = 1;
        sBoton.fill = GridBagConstraints.BOTH;
        
        pTitulo.add(tTitulo,sTitulo);
        this.add(pTitulo,sTitulo);

        pTexto.add(tTexto,sTitulo);
        this.add(pTexto,sTexto);

        this.add(botonGuardar,sBoton);
    }

    public void anadirComponentes(String ti, String te) {
        GridBagLayout gb = new GridBagLayout();
        this.setLayout(gb); 
        
        botonGuardar = new JButton("Guardar");
        tTitulo  = new JTextField();
        pTitulo = new JPanel(new GridBagLayout());
        tTexto  = new JTextField();
        pTexto = new JPanel(new GridBagLayout());

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

        GridBagConstraints sBoton = new GridBagConstraints();
        sBoton.gridx = 0;
        sBoton.gridy = 2;
        sBoton.weighty = 1;
        sBoton.weightx = 1;
        sBoton.fill = GridBagConstraints.BOTH;

        tTitulo.setText(ti);
        pTitulo.add(tTitulo,sTitulo);
        this.add(pTitulo,sTitulo);

        tTexto.setText(te);
        pTexto.add(tTexto,sTitulo);
        this.add(pTexto,sTexto);

        this.add(botonGuardar,sBoton);
    }
    private void inicializarListteners() {
        botonGuardar.addActionListener((e)->{
            Boolean salir = false;
            String tituloRecogido , textoRecogido;
            tituloRecogido = tTitulo.getText();
            textoRecogido = tTexto.getText();
            do{
                if(tituloRecogido.equals("") || textoRecogido.equals("")){
                    JOptionPane.showMessageDialog(this, "Rellena todos los campos");
                    salir = false;
                    
                }else{
                    Fichero fich = new Fichero(tituloRecogido, textoRecogido,this);
                    

                    salir = true;
                }
            }while(salir = false);
                
            this.setVisible(false);
            this.dispose();
        });
    }
    public void incializar() {
        anadirComponentes();
        inicializarListteners(); 
        this.setVisible(true);
    }
    public void editorDeTexto(String ti, String te) {
        anadirComponentes(ti, te);
        inicializarListteners(); 
        this.setVisible(true);
    }
}