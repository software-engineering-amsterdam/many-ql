package org.fugazi.qls.gui;

import org.fugazi.ql.gui.ui_elements.IUIPanel;

import javax.swing.*;
import java.awt.*;

public class QlsUIPanel implements IUIPanel {

    private JTabbedPane panel;

    public QlsUIPanel() {
        this.panel = new JTabbedPane();
        GridLayout layout = new GridLayout(0, 1);
        this.panel.setLayout(layout);
    }

    public void render(JFrame _rootContainer) {
        _rootContainer.add(this.panel);
    }

    public void add(JComponent _component) {
        this.panel.add(_component);
    }

    public void remove(JComponent _component) {
        this.panel.remove(_component);
    }

    public void addPage(JPanel _page, String _title) {
        this.panel.addTab(_title, _page);
    }
}
