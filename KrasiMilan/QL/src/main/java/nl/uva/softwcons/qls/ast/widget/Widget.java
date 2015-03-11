package nl.uva.softwcons.qls.ast.widget;

import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.style.Style;
import nl.uva.softwcons.qls.ast.widget.type.WidgetType;

public class Widget implements ASTNode {
    private final WidgetType widgetType;
    private final Style widgetStyle;

    public Widget(final WidgetType type) {
        this.widgetStyle = null;
        this.widgetType = type;
    }

    public Widget(final WidgetType type, final Style style) {
        this.widgetStyle = style;
        this.widgetType = type;
    }

    public Style getWidgetStyle() {
        return widgetStyle;
    }

    public WidgetType getWidgetType() {
        return widgetType;
    }
}
