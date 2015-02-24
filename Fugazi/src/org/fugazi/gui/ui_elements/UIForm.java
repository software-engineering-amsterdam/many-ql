package org.fugazi.gui.ui_elements;

import org.fugazi.gui.widgets.IWidget;

import javax.swing.*;

public class UIForm {

    private final JFrame formFrame;

    public static final int winHeight = 400;
    public static final int winWidth = 480;
    
    private final JPanel panel = new JPanel();

    public UIForm(String _formTitle) {
        this.formFrame = new JFrame(_formTitle);

        this.formFrame.setSize(winWidth, winHeight);
        this.formFrame.setLocationRelativeTo(null);
        this.formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.formFrame.add(panel);
    }

    public void showForm() {
        this.formFrame.setVisible(true);
    }
    
    public void addElement(UIElement _elem) {
        IWidget widget = _elem.getWidget();
        panel.add(widget.getJComponent());
    }
}