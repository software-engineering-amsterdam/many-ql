package org.fugazi.qls.ast.widget;

import org.fugazi.qls.ast.AbstractASTQLSNode;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.widget.widget_type.WidgetType;

public abstract class Widget extends AbstractASTQLSNode {
    
    private final WidgetType type;
    private final Style style;
    
    public Widget(WidgetType _type, Style _style) {
        this.type = _type;
        this.style = _style;
    }
}
