package nl.uva.softwcons.ql.ast.expression.unary;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;

public abstract class UnaryExpression extends Expression {
    private final Expression expression;

    public UnaryExpression(final Expression expr, final LineInfo lineInfo) {
        super(lineInfo);
        this.expression = expr;
    }

    public Expression getExpression() {
        return expression;
    }

}
