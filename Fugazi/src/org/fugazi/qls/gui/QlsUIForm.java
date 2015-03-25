package org.fugazi.qls.gui;

import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.qls.gui.ui_segment.JPage;

public class QlsUIForm extends UIForm {
    private QlsUIPanel qlsUIPanel;

    public QlsUIForm(String _formTitle, QlsUIPanel _panel) {
        super(_formTitle, _panel);
        this.qlsUIPanel = _panel;
        this.qlsUIPanel.render(this.formFrame);
    }

    @Override
    public void showForm() {
        this.qlsUIPanel.render(this.formFrame);
        this.formFrame.setVisible(true);
    }

    public void addPage(JPage _page) {
        this.qlsUIPanel.addPage(_page.getPanel(), _page.getTitle());
        this.formFrame.revalidate();
    }
}
