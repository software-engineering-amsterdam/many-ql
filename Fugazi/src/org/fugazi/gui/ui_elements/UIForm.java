package org.fugazi.gui.ui_elements;

import javax.swing.*;

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
    
    public void addElement(IUIElement _elem) {
        JComponent component = _elem.getComponent();
        if (component != null)
            this.panel.add(component);
    }
}