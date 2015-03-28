package org.fugazi.qls.gui;

import org.fugazi.ql.gui.ui_elements.UIPanel;

import javax.swing.*;

/**
 * This class wraps the UIPanel of QL, it creates a new Tabbed panel and it adds it to the base
 * QL JPanel, the all the Pages/Sections handling is done from on this tabbed Panel.
 */
public  class QLSUIPanel {

    private final JTabbedPane panel;

    public QLSUIPanel(UIPanel _uiPanel) {
        this.panel = new JTabbedPane();
        _uiPanel.add(this.panel);
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
