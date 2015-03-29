package nl.uva.softwcons.qls.ast.widget.type;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.qls.ast.ASTNode;

public abstract class WidgetType implements ASTNode {

    private final LineInfo lineInfo;

    public WidgetType(final LineInfo lineInfo) {
        this.lineInfo = lineInfo;
    }

    public abstract boolean isCompatibleWith(Type type);

    public abstract <T> T accept(WidgetTypeVisitor<T> visitor);

    public static boolean haveSameType(final WidgetType firstWidget, final WidgetType secondWidget) {
        return firstWidget.getClass() == secondWidget.getClass();
    }

    @Override
    public LineInfo getLineInfo() {
        return lineInfo;
    }

}
