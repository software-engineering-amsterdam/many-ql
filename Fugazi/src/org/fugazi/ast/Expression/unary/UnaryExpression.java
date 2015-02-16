package org.fugazi.ast.Expression.unary;

import org.fugazi.ast.Expression.Expression;

public abstract class UnaryExpression extends Expression {

    protected Expression expr;

    public UnaryExpression(Expression _expr) {
        expr = _expr;
    }

    public Expression getExpr() {
        return expr;
    }
}