package nl.uva.softwcons.ast.expression.unary;

import nl.uva.softwcons.ast.expression.Expression;

public abstract class UnaryExpression extends Expression {

    private Expression expression;

    public UnaryExpression(Expression expr) {
        this.expression = expr;
    }

}
