package org.fugazi.ql.gui.widgets;

import javax.swing.*;
import java.util.EventListener;

public interface IWidget <T> {
    
    public JComponent getJComponent();

    public T getValue();
    public void setValue(T _value);
    public void setReadOnly(boolean _isReadonly);
    public void addEventListener(EventListener _listener);
}
