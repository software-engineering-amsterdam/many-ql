package org.fugazi.ql.gui.ui_elements;

import javax.swing.*;

public class UIForm implements IUIForm{

    protected final JFrame formFrame;
    protected IUIPanel panel;

    public static final int winHeight = 600;
    public static final int winWidth = 580;

    public UIForm(String _formTitle, IUIPanel _panel) {
        this.panel = _panel;
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