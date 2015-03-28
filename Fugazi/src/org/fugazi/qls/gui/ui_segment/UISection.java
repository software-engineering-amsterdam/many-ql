package org.fugazi.qls.gui.ui_segment;

import org.fugazi.ql.gui.ui_element.UIForm;
import org.fugazi.qls.gui.ui_element.QLSUIForm;

import javax.swing.*;
import java.awt.*;

public class UISection {
    private final UIPage page;
    private final JPanel panel;
    private final int index;


    public UISection(UIPage _page, String _title, int _index) {
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(0, 1));

        this.panel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.CENTER);
        this.panel.add(new JLabel(_title));
        this.panel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.CENTER);

        this.page = _page;
        this.index = _index;
    }
    public void addToForm(UIForm _uiForm) {
        QLSUIForm form = (QLSUIForm) _uiForm;
        form.addSection(this);
    }

    public void removeFromForm(UIForm _uiForm) {
        QLSUIForm form = (QLSUIForm) _uiForm;
        form.removeSection(this);
    }

    public UIPage getPage() {
        return this.page;
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public int getIndex() { 
        return this.index; 
    }
}
