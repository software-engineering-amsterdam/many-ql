package nl.uva.softwcons.qls.ast.segment;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.widget.Widget;

public class Question extends PageSegment implements ASTNode {
    private final Identifier id;
    private final Widget widget;
    private final LineInfo lineInfo;

    public Question(final Identifier id, LineInfo lineInfo) {
        this.id = id;
        this.lineInfo = lineInfo;
        this.widget = null;
    }

    public Question(final Identifier id, final Widget widget, LineInfo lineInfo) {
        this.id = id;
        this.widget = widget;
        this.lineInfo = lineInfo;
    }

    public LineInfo getLineInfo() {
        return lineInfo;
    }

    public Identifier getId() {
        return id;
    }

    public Widget getWidget() {
        return widget;
    }

    @Override
    public <T> T accept(final SegmentVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
