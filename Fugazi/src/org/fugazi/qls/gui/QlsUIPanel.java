package org.fugazi.qls.gui;

import org.fugazi.ql.gui.ui_elements.IUIPanel;
import org.fugazi.qls.gui.ui_segment.JPage;
import org.fugazi.qls.gui.ui_segment.JSection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class QlsUIPanel implements IUIPanel {

    private JTabbedPane panel;
    private List<JPage> pages;

    public QlsUIPanel() {
        this.panel = new JTabbedPane();
        this.pages = new ArrayList<>();
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

    public void addSection(JPanel _pagePanel, JPanel _sectionPanel) {
        _pagePanel.add(_sectionPanel);
    }
}
