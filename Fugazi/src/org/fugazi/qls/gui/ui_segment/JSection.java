package org.fugazi.qls.gui.ui_segment;

import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.qls.gui.QlsUIForm;

import javax.swing.*;
import java.awt.*;

public class JSection {
    private final JPage page;
    private final JPanel panel;

    //TODO REMOVALS

    public JSection(JPage _page, String _title) {
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(0, 1));

        this.panel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.CENTER);
        this.panel.add(new JLabel(_title));
        this.panel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.CENTER);

        this.page = _page;
    }
    public void addToForm(QlsUIForm _uiForm) {
        _uiForm.addSection(this);
    }
    public void removeFromForm(UIForm _uiForm) {
//        _uiForm.remove(this.panel);
    }

    public JPage getPage() {
        return this.page;
    }

    public JPanel getPanel() {
        return this.panel;
    }
}
