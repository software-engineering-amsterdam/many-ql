package org.fugazi.qls.gui;

import org.fugazi.ql.gui.ui_elements.IUIPanel;

import javax.swing.*;

public  class QLSUIPanel implements IUIPanel {

    private JTabbedPane panel;

    public QLSUIPanel() {
        this.panel = new JTabbedPane();
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

    public void addSection(JPanel _pageSubPanel, JPanel _sectionPanel) {
        _pageSubPanel.add(_sectionPanel);
    }

    public void removeSection(JPanel _pageSubPanel, JPanel _sectionPanel) {
        _pageSubPanel.remove(_sectionPanel);
    }

    public JTabbedPane getPanel() {
        return this.panel;
    }
}
