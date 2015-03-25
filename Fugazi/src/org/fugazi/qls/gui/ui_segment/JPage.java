package org.fugazi.qls.gui.ui_segment;

import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.qls.gui.QlsUIForm;

import javax.swing.*;

public class JPage {

    private final JPanel panel;
    private final String pageTitle;

    public JPage(JPanel _panel, String _title) {
        this.panel = _panel;
        this.pageTitle = _title;
    }
    public void addToForm(QlsUIForm _uiForm) {
        _uiForm.addWidget(this.panel);

    }
    public void removeFromForm(UIForm _uiForm) {
        _uiForm.removeWidget(this.panel);
    }

    public String getTitle() {
        return this.pageTitle;
    }

    public JPanel getPanel() {
        return this.panel;
    }
}
