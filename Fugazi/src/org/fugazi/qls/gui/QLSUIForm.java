package org.fugazi.qls.gui;

import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class QLSUIForm extends UIForm {

    private QLSUIPanel qlsuiPanel; // Wrapper object of UIPanel.

    private final Map<JComponent, JPanel> componentJPanelMap;
    private JPanel currentPanel;

    public QLSUIForm(String _formTitle) {
        super(_formTitle);
        this.qlsuiPanel = new QLSUIPanel(this.panel);
        this.componentJPanelMap = new HashMap<>();
    }

    @Override
    public void addWidget(JComponent _component) {
        JPanel componentPanel =  this.componentJPanelMap.get(_component);
        if (componentPanel == null) {
            // initial addition, question always inside a page / section
            componentPanel = this.currentPanel;
            this.componentJPanelMap.put(_component, componentPanel);
        }
        this.addWidgetToPanel(componentPanel, _component);
    }

    private void addWidgetToPanel(JPanel _panel, JComponent _component) {
        _panel.add(_component);
        this.formFrame.revalidate();
    }

    @Override
    public void removeWidget(JComponent _component) {
        JPanel componentPanel =  this.componentJPanelMap.get(_component);
        if (componentPanel != null) {
            componentPanel.remove(_component);
        }
        this.formFrame.revalidate();
    }

    public void addPage(UIPage _page) {
        this.currentPanel = _page.getPanel();
        this.qlsuiPanel.addPage(_page.getPanel(), _page.getTitle());
        this.formFrame.revalidate();
    }

    public void removePage(UIPage _page) {
        // widgets cannot be assigned now - to what would they be?
        this.currentPanel = null;
        this.qlsuiPanel.addPage(_page.getPanel(), _page.getTitle());
        this.formFrame.revalidate();
    }

    public void addSection(UISection _section) {
        this.currentPanel = _section.getPanel();
        UIPage page = _section.getPage();
        this.qlsuiPanel.addSection(page.getPanel(), _section.getPanel());
    }
    
    public void removeSection(UISection _section) {
        this.currentPanel = _section.getPage().getPanel();
        UIPage page = _section.getPage();
        this.qlsuiPanel.removeSection(page.getPanel(), _section.getPanel());
    }
}
