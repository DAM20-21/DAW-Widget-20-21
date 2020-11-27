package nofuentes_mendez_elena;

import javax.swing.JPanel;
import java.awt.*;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

/**
 * WidgetVideoElena
 * 
 * @author Elena Nofuentes
 * @since 25-11-2020
 * @version 1.0
 * 
 */
public class WidgetVideoElena {
    /** Atributos de la clase */
    private JPanel panel;
    private JWebBrowser web;

    WidgetVideoElena() {

    }

    public JPanel getBrowserPanel() {
        JPanel webBrowserPanel = new JPanel();
        JWebBrowser webBrowser = new JWebBrowser();
        webBrowser.setBarsVisible(false);
        webBrowser.navigate("https://www.youtube.com/watch?v=iQR0b_hV0J4");
        webBrowserPanel.add(webBrowser);
        webBrowserPanel.revalidate();
        webBrowserPanel.repaint();
        return webBrowserPanel;
    }

}
