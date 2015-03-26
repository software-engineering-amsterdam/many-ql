package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.ui_elements.IUIForm;
import org.fugazi.ql.gui.ui_elements.UIForm;

public interface IWidget {

    public void render(IUIForm _canvas);
    public void suppress(IUIForm _canvas);

    public ExpressionValue getWidgetValue();
    public void setWidgetValue(ExpressionValue _value);
    public void setReadOnly(boolean _isReadonly);
    public void addEventListener(WidgetsEventListener _listener);
}
