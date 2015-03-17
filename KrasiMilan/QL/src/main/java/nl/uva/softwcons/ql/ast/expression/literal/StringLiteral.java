package nl.uva.softwcons.ql.ast.expression.literal;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.ExpressionVisitor;

public class StringLiteral extends Expression {
    private final String value;

    public StringLiteral(final String value, final LineInfo lineInfo) {
        super(lineInfo);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public <T> T accept(final ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
