package nl.uva.softwcons.qls.ast.widgetstyle;

import java.util.Optional;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.widgetstyle.type.WidgetType;

public class StyledWidget implements ASTNode {
    private WidgetType widgetType;
    private final Style widgetStyle;

    public StyledWidget() {
        this.widgetStyle = new Style(null);
    }

    public StyledWidget(final WidgetType type) {
        this.widgetStyle = new Style(type.getLineInfo());
        this.widgetType = type;
    }

    public StyledWidget(final WidgetType type, final Style style) {
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
