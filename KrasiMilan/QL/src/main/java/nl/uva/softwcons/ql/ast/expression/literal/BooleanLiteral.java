package nl.uva.softwcons.ql.ast.expression.literal;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.ExpressionVisitor;

public class BooleanLiteral extends Expression {
    private final boolean value;

    public BooleanLiteral(final boolean value, final LineInfo lineInfo) {
        super(lineInfo);
        this.value = value;
    }

    public boolean getValue() { // NOPMD
        return value;
    }

    @Override
    public <T> T accept(final ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
