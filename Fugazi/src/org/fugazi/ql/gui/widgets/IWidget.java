package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.evaluator.expression_value.ExpressionValue;

import javax.swing.JComponent;
import java.util.EventListener;

public interface IWidget {
    
    public JComponent getJComponent();

    public ExpressionValue getValue();
    public void setValue(ExpressionValue _value);
    public void setReadOnly(boolean _isReadonly);
    public void addEventListener(EventListener _listener);
}
