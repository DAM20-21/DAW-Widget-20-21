package bonifacio_hernandez_javier;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.event.MouseEvent;

public class Miboton extends JButton implements MouseListener{
    private Color color=Color.black;
    private widgetFormatoTexto widget;

    public Miboton(String nombre) {
        Font fuente=new Font("Serief",Font.ITALIC,14);
        this.setFont(fuente);
        this.addMouseListener(this);
        this.setText(nombre);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1){
        }else{
            color =JColorChooser.showDialog(this,"Escoge un color",color);

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public widgetFormatoTexto getWidget() {
        return this.widget;
    }

    public void setWidget(widgetFormatoTexto widget) {
        this.widget = widget;
    }

}
