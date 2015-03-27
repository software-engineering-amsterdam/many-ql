package org.fugazi.ql.gui.ui_elements;

import javax.swing.*;
import java.awt.*;

public class UIPanel implements IUIPanel {
    
    private JPanel panel;
    
    public UIPanel() {
        this.panel = new JPanel();
        GridLayout layout = new GridLayout(0, 1);
        this.panel.setLayout(layout);
    }

    @Override
    public void render(JFrame _rootContainer) {
        _rootContainer.add(this.panel);
    }

    @Override
    public void add(JComponent _component) {
        this.panel.add(_component);
    }
    
    @Override
    public void remove(JComponent _component) {
        this.panel.remove(_component);
    }
}
