package org.fugazi.qls.ast.widget;

import org.fugazi.qls.ast.AbstractASTNode;
import org.fugazi.qls.ast.style.DefaultStyle;
import org.fugazi.qls.ast.widget.widget_type.IWidgetType;

public abstract class Widget extends AbstractASTNode {
    
    private final IWidgetType type;
    private final DefaultStyle style;
    
    public Widget(IWidgetType _type, DefaultStyle _style) {
        this.type = _type;
        this.style = _style;
    }
}
