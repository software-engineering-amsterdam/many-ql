package org.fugazi.ql.gui.ui_elements;

import org.fugazi.ql.gui.widgets.IWidget;

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
        this.formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formFrame.setResizable(false);

        GridLayout layout = new GridLayout(0, 1);
        this.panel.setLayout(layout);
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
}