package org.fugazi.qls.gui.ui_segment;

import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.qls.gui.QLSUIForm;

import javax.swing.*;
import java.awt.*;

public class UISection {
    private final UIPage page;
    private final JPanel panel;

    //TODO REMOVALS

    public UISection(UIPage _page, String _title) {
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(0, 1));

        this.panel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.CENTER);
        this.panel.add(new JLabel(_title));
        this.panel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.CENTER);

        this.page = _page;
    }
    public void addToForm(QLSUIForm _uiForm) {
        _uiForm.addSection(this);
    }
    public void removeFromForm(UIForm _uiForm) {
//        _uiForm.remove(this.panel);
    }

    public UIPage getPage() {
        return this.page;
    }

    public JPanel getPanel() {
        return this.panel;
    }
}
