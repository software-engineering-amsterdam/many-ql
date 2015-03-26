package nl.uva.softwcons.qls.ast.widget;

import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.style.Style;
import nl.uva.softwcons.qls.ast.widget.type.WidgetType;

public class StylizedWidget implements ASTNode {
    private final WidgetType widgetType;
    private final Style widgetStyle;

    public StylizedWidget(final WidgetType type) {
        this.widgetStyle = null;
        this.widgetType = type;
    }

    public StylizedWidget(final WidgetType type, final Style style) {
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
