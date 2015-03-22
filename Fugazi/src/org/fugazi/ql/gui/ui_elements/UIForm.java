package org.fugazi.ql.gui.ui_elements;

import javax.swing.*;
import java.awt.*;

public class UIForm {

    private final JFrame formFrame;

    public static final int winHeight = 600;
    public static final int winWidth = 580;
    
    private final JPanel panel = new JPanel();

    public UIForm(String _formTitle) {
        this.formFrame = new JFrame(_formTitle);

        this.formFrame.setSize(winWidth, winHeight);
        this.formFrame.setLocationRelativeTo(null);
        this.formFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.formFrame.setResizable(false);

        GridLayout layout = new GridLayout(0, 1);
        this.panel.setLayout(layout);
        this.formFrame.add(panel);
    }

    public void showForm() {
        this.formFrame.setVisible(true);
    }

    public void addWidget(JComponent _component) {
        this.panel.add(_component);
        this.formFrame.revalidate();
    }

    public void removeWidget(JComponent _component) {
        this.panel.remove(_component);
        this.formFrame.revalidate();
    }
}