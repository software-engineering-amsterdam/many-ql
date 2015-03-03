package org.fugazi.qls.ast.widget;

import org.fugazi.qls.ast.AbstractASTNode;
import org.fugazi.qls.ast.widget.widget_type.IWidgetType;

public abstract class Widget extends AbstractASTNode {
    
    private final IWidgetType type;
    
    public Widget(IWidgetType _type) {
        this.type = _type;
    }
}
