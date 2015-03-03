package org.fugazi.qls.ast.widget;

import org.fugazi.qls.ast.AbstractASTNode;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.widget.widget_type.IWidgetType;

public abstract class Widget extends AbstractASTNode {
    
    private final IWidgetType type;
    private final Style style;
    
    public Widget(IWidgetType _type, Style _style) {
        this.type = _type;
        this.style = _style;
    }
}
