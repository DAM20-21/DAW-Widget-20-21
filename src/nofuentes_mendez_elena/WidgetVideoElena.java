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

    public JPanel getBrowserPanel(String url) {
        panel = new JPanel(new GridLayout(1, 1));
        web = new JWebBrowser();
        web.setBarsVisible(false);
        web.navigate(url);
        panel.add(web);
        panel.revalidate();
        panel.repaint();
        return panel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JWebBrowser getWeb() {
        return web;
    }

    public void setWeb(JWebBrowser web) {
        this.web = web;
    }

}