package org.fugazi.qls.gui;

import org.fugazi.ql.gui.ui_elements.UIPanel;
import org.fugazi.qls.gui.ui_segment.UIPage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class wraps the UIPanel of QL, it creates a new Tabbed panel and it adds it to the base
 * QL JPanel, the all the Pages/Sections handling is done from on this tabbed Panel.
 */
public  class QLSUIPanel {

    private final JTabbedPane panel;
    private List<UIPage> pages;

    public QLSUIPanel(UIPanel _uiPanel) {
        this.panel = new JTabbedPane();
        _uiPanel.add(this.panel);
        
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
