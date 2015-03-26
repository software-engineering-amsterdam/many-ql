package org.fugazi.qls.gui;

import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;

import javax.swing.*;

public class QLSUIForm extends UIForm {
    private QLSUIPanel QLSUIPanel;

    private JPanel currentPanel;

    public QLSUIForm(String _formTitle, QLSUIPanel _panel) {
        super(_formTitle, _panel);

        this.QLSUIPanel = _panel;
        this.QLSUIPanel.render(this.formFrame);
    }

    @Override
    public void showForm() {
        this.QLSUIPanel.render(this.formFrame);
        this.formFrame.setVisible(true);
    }

    @Override
    public void addWidget(JComponent _component) {
        if (this.currentPanel != null) {
            this.addWidgetToPanel(this.currentPanel, _component);
            this.formFrame.revalidate();
        }
    }
    
    public void addWidgetToPanel(JPanel _panel, JComponent _component) {
        _panel.add(_component);
        this.formFrame.revalidate();
    }

    public void addPage(UIPage _page) {
        this.currentPanel = _page.getPanel();
        this.QLSUIPanel.addPage(_page.getPanel(), _page.getTitle());
        this.formFrame.revalidate();
    }

    public void addSection(UISection _section) {
        this.currentPanel = _section.getPanel();
        UIPage page = _section.getPage();
        this.QLSUIPanel.addSection(page.getPanel(), _section.getPanel());
    }
}
