package nl.uva.softwcons.ql.ast.expression;

import nl.uva.softwcons.ql.ast.ASTNode;
import nl.uva.softwcons.ql.ast.LineInfo;

public abstract class Expression implements ASTNode {
    private final LineInfo lineInfo;

    public Expression(final LineInfo lineInfo) {
        this.lineInfo = lineInfo;
    }

    public abstract <T> T accept(ExpressionVisitor<T> visitor);

    public LineInfo getLineInfo() {
        return lineInfo;
    }
}
