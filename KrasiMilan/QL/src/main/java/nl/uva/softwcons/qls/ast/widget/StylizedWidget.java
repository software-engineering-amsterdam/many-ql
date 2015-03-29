package nl.uva.softwcons.qls.ast.widget;

import java.util.Optional;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.style.Style;
import nl.uva.softwcons.qls.ast.widget.type.WidgetType;

public class StylizedWidget implements ASTNode {
    private WidgetType widgetType;
    private final Style widgetStyle;

    public StylizedWidget() {
        this.widgetStyle = new Style(null);
    }

    public StylizedWidget(final WidgetType type) {
        this.widgetStyle = new Style(type.getLineInfo());
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
        return Optional.ofNullable(widgetType);
    }

    public LineInfo getLineInfo() {
        return widgetType.getLineInfo();
    }
}
