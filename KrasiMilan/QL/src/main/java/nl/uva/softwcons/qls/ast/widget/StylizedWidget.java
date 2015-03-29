package nl.uva.softwcons.qls.ast.widget;

import java.util.Optional;

import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.style.Style;
import nl.uva.softwcons.qls.ast.widget.type.WidgetType;

public class StylizedWidget implements ASTNode {
    private final WidgetType widgetType;
    private final Style widgetStyle;

    public StylizedWidget() {
        widgetStyle = new Style();
        widgetType = null;
    }

    public StylizedWidget(final WidgetType type) {
        this.widgetStyle = new Style();
        this.widgetType = type;
    }

    public StylizedWidget(final WidgetType type, final Style style) {
        this.widgetStyle = style;
        this.widgetType = type;
    }

    public Style getWidgetStyle() {
        return widgetStyle;
    }

    public Optional<WidgetType> getWidgetType() {
        return Optional.of(widgetType);
    }
}
