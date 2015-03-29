package org.fugazi.qls.gui.ui_segment;

import org.fugazi.qls.gui.QLSUIForm;

import javax.swing.*;
import java.awt.*;

public class UIPage {

    private final JPanel panel;
    private final JPanel[] subPanelsHolder;
    private final String pageTitle;
    private final int index;

    public UIPage(String _title, int _index, int rows) {
        this.panel = new JPanel();
        panel.setLayout(new GridLayout(rows, 0));

        subPanelsHolder = new JPanel[rows];
        for (int i = 0; i < rows; i++) {
            subPanelsHolder[i] = new JPanel();
            subPanelsHolder[i].setLayout(new GridLayout(0, 1));
            this.panel.add(subPanelsHolder[i]);
        }

        this.pageTitle = _title;
        this.index = _index;
    }
    public void addToForm(QLSUIForm _uiForm) {
        _uiForm.addPage(this);

    }
    public void removeFromForm(QLSUIForm _uiForm) {
        _uiForm.removePage(this);
    }

    public String getTitle() {
        return this.pageTitle;
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public int getIndex() { return this.index; }

    public JPanel getSubPanel(int index) {
        return this.subPanelsHolder[index];
    }
}