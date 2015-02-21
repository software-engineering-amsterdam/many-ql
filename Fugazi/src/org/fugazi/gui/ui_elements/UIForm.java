package org.fugazi.gui.ui_elements;

import javax.swing.*;
import java.awt.*;

public class UIForm extends JFrame {

    private final JPanel panel = new JPanel();

    public UIForm(String _formTitle) {
        super(_formTitle);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new FlowLayout());
        this.add(panel);
    }
    
    public void addQuestion(Component _comp) {
        this.panel.add(_comp);
    }
}
