package org.fugazi.qls.ast.style;

import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.style.style_property.StyleProperty;
import org.fugazi.qls.ast.widget.widget_type.WidgetType;

import java.util.List;

public class DefaultTypeStyle extends Style { //todo: think of don't inherit from Style but aggregate it.

    private final Type questionType;
    private final WidgetType widgetType;

    public DefaultTypeStyle(List<StyleProperty> _styleProperties, Type _questionType, WidgetType _widgetType) {
        super(_styleProperties);
        this.questionType = _questionType;
        this.widgetType = _widgetType;
    }
}
