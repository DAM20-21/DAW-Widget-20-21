package perez_martin_miguel;

import java.awt.EventQueue;

public class Principal {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal ventana = new VentanaPrincipal();
                ventana.inicializar();
            }
        });
    }

}