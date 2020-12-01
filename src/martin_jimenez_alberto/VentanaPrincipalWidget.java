import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class VentanaPrincipalWidget {
    ArrayList<Fichero> listaFICHEROS ;//Lista que guarda Objetos Fichero
    int nFICHEROS;

    JFrame f;
    JPanel previewTexto;
    JTextField titulo;
    JButton botonEditar;

    JButton nuevaNota;


    VentanaPrincipalWidget() {
        f = new JFrame();
        f.setBounds(10, 0, 600, 900);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void anadirComponentes() {
        GridBagLayout gb = new GridBagLayout();
        f.setLayout(gb); 

        GridBagConstraints setting;
        String tituloString;
        nuevaNota = new JButton("+");
        nFICHEROS = listaFICHEROS.size();//Para trabajar con la misma variable en todos los métodos

        for(int i=0 ; i<nFICHEROS ; i++){//Añadir la vista de los ficheros al JFrame
            botonEditar = new JButton("Editar");
            previewTexto = new JPanel(new GridBagLayout());
            titulo = new JTextField();
            titulo.setEditable(false);
            //Añadir los componentes al JPanel
            tituloString = listaFICHEROS.get(i).getTitulo();
            titulo.setText(tituloString.toUpperCase());
            GridBagConstraints sTitulo = new GridBagConstraints();
            sTitulo.gridx = 0;
            sTitulo.gridy = 0;
            sTitulo.weightx = 10;
            sTitulo.weighty = 1;
            sTitulo.fill = GridBagConstraints.BOTH;
            previewTexto.add(titulo ,sTitulo);
            previewTexto.add(botonEditar);
            //Settings del PREVIEW
            setting = new GridBagConstraints();
            setting.gridx = 0;
            setting.gridy = i;
            setting.weightx = 1;
            setting.fill = GridBagConstraints.BOTH;
            //Borde de la preview
            LineBorder borde = new LineBorder(Color.black);
            previewTexto.setBorder(borde);
            f.add(previewTexto,setting);

            inicializarListtenersRepetidos(botonEditar, i);
        }
        GridBagConstraints snuevaNota = new GridBagConstraints();
        snuevaNota.gridx = 0;
        snuevaNota.gridy = nFICHEROS;
        f.add(nuevaNota,snuevaNota);
    }

    private void inicializarListteners() {
        nuevaNota.addActionListener((e)->{
            try{
                VentanaNota vn = new VentanaNota(this);
                vn.incializar();
            }catch(Exception ex){
                ex.printStackTrace(); 
            }
        });
    }

    private void inicializarListtenersRepetidos(JButton boton,int i) {
        boton.addActionListener(new ActionBoton(this, i));
    }

    /**
	 * Método para inicializar la pantalla
	 */
    public void incializar() {
        f.setVisible(true);
        guardarFicheros();
        anadirComponentes();
        inicializarListteners();
    }
    public void actualizarVentanaWid(){
        f.revalidate(); 
        f.repaint();
    }   

    /**
     * Devuelve el número de ficheros que hay en la carpeta de los ficheros
     * 
     * @return nFich
     */
    public void guardarFicheros(){
        listaFICHEROS = new ArrayList<>();
        File carpeta = new File("DAW-Widget-20-21/ficheros/Ficheros"); 
        File[] lista = carpeta.listFiles();
        String titulo;
        String texto;
        String[] aux = null;

        for(int i=0 ; i<lista.length; i++){
            titulo = lista[i].getName();
            texto = Fichero.getTexto(titulo);
            aux = titulo.split(".txt");
            titulo = aux[0];
 
            Fichero fich = new Fichero(titulo,texto);
            listaFICHEROS.add(fich);
        }
    }
}