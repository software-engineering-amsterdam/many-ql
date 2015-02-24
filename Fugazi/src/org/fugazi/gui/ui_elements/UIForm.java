package org.fugazi.gui.ui_elements;

import org.fugazi.gui.widgets.IWidget;

import javax.imageio.event.IIOWriteProgressListener;
import javax.swing.*;

// Todo: don't inherite but aggregate
public class UIForm extends JFrame {

    public static final int winHeight = 400;
    public static final int winWidth = 480;
    
    private final JPanel panel = new JPanel();

    public UIForm(String _formTitle) {
        super(_formTitle);

        this.setSize(winWidth, winHeight);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.add(panel);
    }
    
    public void addElement(UIElement _elem) {
        IWidget widget = _elem.getWidget();
        panel.add(widget.getJComponent());
    }
}