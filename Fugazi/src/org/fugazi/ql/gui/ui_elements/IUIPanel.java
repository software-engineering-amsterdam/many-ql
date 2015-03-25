package org.fugazi.ql.gui.ui_elements;

import javax.swing.*;

public interface IUIPanel {

    public void render(JFrame _rootContainer);
    public void add(JComponent _component);
    public void remove(JComponent _component);

}
