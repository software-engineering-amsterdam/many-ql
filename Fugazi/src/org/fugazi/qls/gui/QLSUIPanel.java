package org.fugazi.qls.gui;

import org.fugazi.ql.gui.ui_elements.IUIPanel;
import org.fugazi.qls.gui.ui_segment.UIPage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class QLSUIPanel implements IUIPanel {

    private JTabbedPane panel;
    private List<UIPage> pages;

    public QLSUIPanel() {
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

    public void addPage(JPanel _panel, String _title, int index) {
        int tabCount = this.panel.getTabCount();
        if (index > tabCount) {
            this.panel.addTab(_title, _panel);
        } else {
            this.panel.insertTab(_title, null, _panel, null, index);
        }
    }

    public void removePage(JPanel _panel) {
        this.panel.remove(_panel);
    }

    public void addSection(JPanel _pagePanel, JPanel _sectionPanel) {
        _pagePanel.add(_sectionPanel);
    }

    public void removeSection(JPanel _pagePanel, JPanel _sectionPanel) {
        _pagePanel.remove(_sectionPanel);
    }

    public JTabbedPane getPanel() {
        return this.panel;
    }
}
