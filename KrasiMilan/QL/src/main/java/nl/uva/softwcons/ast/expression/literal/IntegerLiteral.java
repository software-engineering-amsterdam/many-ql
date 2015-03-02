package nl.uva.softwcons.ast.expression.literal;

import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;

public class IntegerLiteral extends Expression {
    private int value;
    private LineInfo lineInfo;

    public IntegerLiteral(int value, LineInfo lineInfo) {
        this.value = value;
        this.lineInfo = lineInfo;
    }

    public int getValue() {
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
