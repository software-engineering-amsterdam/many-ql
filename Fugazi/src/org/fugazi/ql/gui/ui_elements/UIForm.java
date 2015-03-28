package org.fugazi.ql.gui.ui_elements;

import javax.swing.*;

public class UIForm {

    public static final int winHeight = 600;
    public static final int winWidth = 580;
    
    protected final JFrame formFrame;
    protected final UIPanel panel;

    public UIForm(String _formTitle) {
        this.panel = new UIPanel();
        this.formFrame = new JFrame(_formTitle);
        this.panel.render(this.formFrame);

        this.formFrame.setSize(winWidth, winHeight);
        this.formFrame.setLocationRelativeTo(null);
        this.formFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.formFrame.setResizable(false);
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