package org.fugazi.qls.gui;

import org.fugazi.ql.gui.ui_elements.IUIForm;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;

import javax.swing.*;

public class QLSUIForm implements IUIForm {
    private QLSUIPanel panel;

    private JPanel currentPanel;

    private final JFrame formFrame;

    public static final int winHeight = 600;
    public static final int winWidth = 580;

    public QLSUIForm(String _formTitle, QLSUIPanel _panel) {
        this.formFrame = new JFrame(_formTitle);
        this.formFrame.setSize(winWidth, winHeight);
        this.formFrame.setLocationRelativeTo(null);
        this.formFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.formFrame.setResizable(false);


        this.panel = _panel;
        this.panel.render(this.formFrame);
    }

    public void showForm() {
        this.formFrame.setVisible(true);
    }

    public void addWidget(JComponent _component) {
        // widgets can only be added inside page or section
        if (this.currentPanel != null) {
            this.addWidgetToPanel(this.currentPanel, _component);
            this.formFrame.revalidate();
        }
    }

    public void addWidgetToPanel(JPanel _panel, JComponent _component) {
        _panel.add(_component);
        this.formFrame.revalidate();
    }

    public void removeWidget(JComponent _component) {
        this.panel.remove(_component);
        this.formFrame.revalidate();
    }

    public void addPage(UIPage _page) {
        this.currentPanel = _page.getPanel();
        this.panel.addPage(_page.getPanel(), _page.getTitle());
        this.formFrame.revalidate();
    }

    public void removePage(UIPage _page) {
        // widgets cannot be assigned now - to what would they be?
        this.currentPanel = null;
        this.panel.addPage(_page.getPanel(), _page.getTitle());
        this.formFrame.revalidate();
    }

    public void addSection(UISection _section) {
        this.currentPanel = _section.getPanel();
        UIPage page = _section.getPage();
        this.panel.addSection(page.getPanel(), _section.getPanel());
    }
    public void removeSection(UISection _section) {
        this.currentPanel = _section.getPage().getPanel();
        UIPage page = _section.getPage();
        this.panel.removeSection(page.getPanel(), _section.getPanel());
    }
}
