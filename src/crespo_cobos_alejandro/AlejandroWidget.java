package crespo_cobos_alejandro;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlejandroWidget extends JPanel implements AncestorListener {

    private static final long serialVersionUID = 1L;

    private ImageIcon imagenIcono;

    private JTextField informacion;
    private JLabel imagenes;

    private JPanel panelImagenes;
    private JPanel panelCiudades;

    // Referencia al selectorColor:

    public AlejandroWidget() {
        super();
        

    }

    private void anadirElementos(){
         //Definimos el layout:
         GridBagLayout gbl = new GridBagLayout();
         GridBagConstraints opc = new GridBagConstraints();
         this.setLayout(new GridBagLayout());
		
		
		//PANEL PRINCIPAL
		//Titulo
	    //Panel de ciudades 
        opc = new GridBagConstraints();
        panelCiudades = new JPanel(new GridLayout(1,1));
        opc.gridx = 0;
        opc.gridy = 1;
        opc.weightx = 2;
        opc.weighty = 2;
        opc.fill = GridBagConstraints.BOTH; 

        //TExto de cuidades y caracteristas del dia
         opc = new GridBagConstraints();
        informacion = new JTextField("BUSCA LA CIUDAD");
        informacion.setOpaque(true);
        informacion.setEnabled(true);
        informacion.setEditable(false);
       
        opc.gridx = 0;
        opc.gridy = 1;
        opc.fill = GridBagConstraints.HORIZONTAL;
        panelCiudades.setBorder(BorderFactory.createEmptyBorder(80, 30, 80, 30));
        panelCiudades.add(informacion, opc);
        

        
        opc = new GridBagConstraints();
        panelImagenes = new JPanel(new GridLayout(1,1));
        opc.gridx = 1;
        opc.gridy = 1;
        opc.weightx = 2;
        opc.weighty = 2;
        opc.fill = GridBagConstraints.BOTH;

        opc = new GridBagConstraints();
        imagenes = new JLabel(new ImageIcon("src/imagenes/sol.png"));
        opc.gridx= 1;
        opc.gridy = 1;
        
        
        panelImagenes.add(imagenes, opc);
        

		
	}

    private void anadirListeners() {

    }

    @Override
    public void ancestorAdded(AncestorEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void ancestorRemoved(AncestorEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void ancestorMoved(AncestorEvent event) {
        // TODO Auto-generated method stub

    }
	
	
	
}