package luis_calero_alberto;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import java.awt.*;

/**
 * Esta clase la utilizaremos para reutilizar todo el codigo que podamos
 */
public class Utilidades {

    /**
     * Como tenemos varias interfaces iguales llamaremos a este metodo y le
     * pasaremos los componentes ya inicializados que queramos meter
     * 
     * @param panel           panel donde introduciremos los componentes
     * @param medidaInicial   primer JComboBox
     * @param medidaFinal     segundo JComboBox
     * @param numeroInicial   TextField donde introduciremos el numero
     * @param textoResultado  JTextField que saldra el texto con el resultado
     * @param numeroResultado JTextField donde aparecera el resultado
     */
    public static void colocarElementos(JComponent panel, JComboBox medidaInicial, JComboBox medidaFinal,
            JTextField numeroInicial, JTextField textoResultado, JTextField numeroResultado) {

        panel.setLayout(new GridBagLayout());
        GridBagConstraints settings = new GridBagConstraints();

        settings.gridx = 0;
        settings.gridy = 1;

        settings.insets = new Insets(5, 20, 20, 5);
        panel.add(medidaInicial, settings);
        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 1;
        settings.insets = new Insets(5, 20, 20, 5);
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.weightx = 1;
        panel.add(numeroInicial, settings);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 2;
        settings.insets = new Insets(5, 20, 20, 5);

        panel.add(medidaFinal, settings);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 4;
        settings.insets = new Insets(5, 20, 20, 5);
        settings.gridwidth = 3;
        settings.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textoResultado, settings);
        textoResultado.setEditable(false);
        textoResultado.setBorder(null);

        settings = new GridBagConstraints();
        settings.gridx = 2;
        settings.gridy = 3;
        settings.insets = new Insets(05, 20, 20, 05);
        settings.weightx = 1;
        settings.gridwidth = 2;
        settings.ipadx = 200;
        settings.fill = GridBagConstraints.HORIZONTAL;
        panel.add(numeroResultado, settings);

    }

}
