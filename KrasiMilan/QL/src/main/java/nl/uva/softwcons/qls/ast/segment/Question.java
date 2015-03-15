package nl.uva.softwcons.qls.ast.segment;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.widget.Widget;

public class Question extends PageSegment implements ASTNode {
    private final Identifier id;
    private final Widget widget;

    public Question(final Identifier id) {
        this.id = id;
        this.widget = null;
    }

    public Question(final Identifier id, final Widget widget) {
        this.id = id;
        this.widget = widget;
    }

    public Identifier getId() {
        return id;
    }

    public Widget getWidget() {
        return widget;
    }

}
