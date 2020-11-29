package prieto_talavero_juan_jose_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;


/**
 * Widget encargado de mostrar la hora actual
 * @author Juan José Prieto Talavero
 */
public class WidgetJotaHoraActual extends JLabel{

    private static final long serialVersionUID = 1L;
    private Runnable runnable;
    private DateTimeFormatter formateador;
    private Thread hiloReloj;
    private Font fuente;

    public WidgetJotaHoraActual(){
        super("", SwingConstants.CENTER);
        ajustarComponentes();        
        iniciarReloj();
    }

    /**
     * Se encarga de inicar componentes y asignar valores
     */
    private void ajustarComponentes() {
        formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
        fuente = new Font("Calibri", 3, 25);
        setFont(fuente);
        setForeground(Color.BLUE);
    }

    /**
     * Se encarga de inciar el runnable del reloj
     */
    private void iniciarReloj() {
        runnable = new Runnable(){
			@Override
			public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        setText(formateador.format(LocalDateTime.now()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
			}
        };
        hiloReloj = new Thread(runnable);
        hiloReloj.start();
    }
    
}
