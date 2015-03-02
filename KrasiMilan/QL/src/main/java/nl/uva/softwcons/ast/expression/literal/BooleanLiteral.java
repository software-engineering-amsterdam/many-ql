package nl.uva.softwcons.ast.expression.literal;

import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;

public class BooleanLiteral extends Expression {
    private boolean value;
    private LineInfo lineInfo;

    public BooleanLiteral(boolean value, LineInfo lineInfo) {
        this.value = value;
        this.lineInfo = lineInfo;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public LineInfo getLineInfo() {
        return this.lineInfo;
    }

}
