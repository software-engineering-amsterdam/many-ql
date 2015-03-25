package org.fugazi.qls.gui.ui_segment;

import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.qls.gui.QlsUIForm;

import javax.swing.*;
import java.awt.*;

public class JPage {

    private final JPanel panel;
    private final String pageTitle;

    public JPage(String _title) {
        this.panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        this.pageTitle = _title;
    }
    public void addToForm(QlsUIForm _uiForm) {
        _uiForm.addPage(this);

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
