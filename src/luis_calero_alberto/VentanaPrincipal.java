package luis_calero_alberto;

import javax.swing.*;

public class VentanaPrincipal {
    private JFrame ventana;

    public VentanaPrincipal() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 900, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JDialogConversor dialogo = new JDialogConversor(ventana);
        dialogo.setVisible(true);

    }

    public void inicializarComponentes() {

    }

    public void inicializar() {
        ventana.setVisible(true);
        inicializarComponentes();

    }

}
