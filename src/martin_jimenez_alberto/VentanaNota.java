import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
    int nFICHEROS;//Atributo para guardar el tamaño de la lista de los ficheros
    VentanaPrincipalWidget vp;// Atributo que almacena un objeto VentanaPrincipalWidget
    //Definición del boton que guarda lo escrito
    JButton botonGuardar;
    //Panel del título
    JPanel pTitulo;
    //Texto del título
    JTextField tTitulo;
    //Panel del texto
    JPanel pTexto;
    //Texto del atributo texto, es JTextArea para poder poner LineWrap(true) y que haga saltos de linea
    JTextArea tTexto;
    //
    String tituloString;

    String textoString;

    /**
     * Constructor parametrizado de una nota vacia
     */
    VentanaNota(VentanaPrincipalWidget vpr) {
        super();
        this.setBounds(10, 0, 500, 800);
        this.vp = vpr;
    }
    /**
     *  Constructor parametrizado de una nota con información
     * @param ti String con el título del feichero
     * @param te String con el texto del fichero
     */
    VentanaNota(String ti, String te,VentanaPrincipalWidget vpr) {
        super();
        this.setBounds(10, 0, 500, 800);
        this.vp = vpr;
        tituloString = ti;
        textoString = te;
    }
    
    /**
     * Método que añade los componentes
     */
    public void anadirComponentes() {
        GridBagLayout gb = new GridBagLayout();
        this.setLayout(gb); 
        
        botonGuardar = new JButton("Guardar");
        tTitulo = new JTextField();
        pTitulo = new JPanel(new GridBagLayout());
        tTexto = new JTextArea();
        tTexto.setLineWrap(true);
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
    /**
     * Métodos que añade los componentes de un Fichero con datos
     * @param ti String con el título
     * @param te String con el texto
     */
    public void anadirComponentesEdit() {
        GridBagLayout gb = new GridBagLayout();
        this.setLayout(gb); 
        botonGuardar = new JButton("Guardar");
        tTitulo  = new JTextField();
        pTitulo = new JPanel(new GridBagLayout());
        tTexto  = new JTextArea();
        tTexto.setLineWrap(true);
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

        tTitulo.setText(tituloString);
        pTitulo.add(tTitulo,sTitulo);
        this.add(pTitulo,sTitulo);

        tTexto.setText(textoString);
        pTexto.add(tTexto,sTitulo);
        this.add(pTexto,sTexto);

        this.add(botonGuardar,sBoton);
    }

    /**
     * Añade el listener del botón guardar
     */
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
                    Fichero fich = new Fichero(tituloRecogido, textoRecogido,vp);
                    salir = true;
                    
                }
            }while(salir = false);
            vp.repintar();
            this.dispose(); 
        });
    }
    
    

    /**
     * Metodo parainicializar sinparámetros
     */
    public void incializar() {
        anadirComponentes();
        inicializarListteners(); 
        this.setVisible(true);
    }
    /**
     * Método para inicializar con parámetros
     * @param ti String que contiene el título
     * @param te String que contiene el texto
     */
    public void editorDeTexto(String ti, String te) {
        anadirComponentesEdit(); 
        inicializarListteners();
        this.setVisible(true); 
    }
}