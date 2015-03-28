package org.fugazi.qls.gui.ui_segment;

import org.fugazi.ql.gui.ui_element.UIForm;
import org.fugazi.qls.gui.ui_element.QLSUIForm;

import javax.swing.*;
import java.awt.*;

public class UIPage {

    private final JPanel panel;
    private final JPanel[] subPanelsHolder;
    private final String pageTitle;
    private final int index;

    public UIPage(String _title, int _index, int rows) {
        this.panel = new JPanel();

        if (rows == 0) {
            rows++; // otherwise GridLayout will through. Edge case for empty page.
        }
        this.subPanelsHolder = new JPanel[rows];
        this.initializeSubpanels(rows);

        this.pageTitle = _title;
        this.index = _index;
    }

    private void initializeSubpanels(int rows){
        panel.setLayout(new GridLayout(rows, 0));
        for (int i = 0; i < rows; i++) {
            subPanelsHolder[i] = new JPanel();
            subPanelsHolder[i].setLayout(new GridLayout(0, 1));
            this.panel.add(subPanelsHolder[i]);
        }
    }
    
    public void addToForm(UIForm _uiForm) {
        QLSUIForm form = (QLSUIForm) _uiForm;
        form.addPage(this);
    }
    
    public void removeFromForm(UIForm _uiForm) {
        QLSUIForm form = (QLSUIForm) _uiForm;
        form.removePage(this);
    }

    public String getTitle() {
        return this.pageTitle;
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public int getIndex() { 
        return this.index; 
    }

    public JPanel getSubPanel(int index) {
        return this.subPanelsHolder[index];
    }
}
