package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.ui_elements.UIForm;

import java.util.EventListener;

public interface IWidget {

    public void render(UIForm _canvas);
    public void supress(UIForm _canvas);

    public ExpressionValue getValue();
    public void setValue(ExpressionValue _value);
    public void setReadOnly(boolean _isReadonly);
    public void addEventListener(EventListener _listener);
}
