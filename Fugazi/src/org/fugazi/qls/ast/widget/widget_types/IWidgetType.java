package org.fugazi.qls.ast.widget.widget_types;

import org.fugazi.qls.ast.widget.IWidgetsTypeVisitor;

public interface IWidgetType {
    public <T> T accept(IWidgetsTypeVisitor<T> visitor);
}
