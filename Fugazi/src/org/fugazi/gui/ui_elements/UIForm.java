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

        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.formFrame.add(panel);
    }

    public void showForm() {
        this.formFrame.setVisible(true);
    }
    
    public void addQuestion(UIQuestion _quest) {
        IWidget widget = _quest.getWidget();
        this.panel.add(widget.getJComponent());
        this.formFrame.revalidate();
    }
    
    public void removeQuestion(UIQuestion _quest) {
        IWidget widget = _quest.getWidget();
        this.panel.remove(widget.getJComponent());
        this.formFrame.revalidate();
    }
    
    public void clearForm() {
        this.panel.removeAll();
        this.formFrame.revalidate();
    }
}