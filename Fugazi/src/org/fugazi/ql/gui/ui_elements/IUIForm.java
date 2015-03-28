package org.fugazi.ql.gui.ui_elements;

import javax.swing.*;

public interface IUIForm {

    public static final int winHeight = 600;
    public static final int winWidth = 580;
    
    public void showForm();
    public void addWidget(JComponent _component);
    public void removeWidget(JComponent _component);
}
