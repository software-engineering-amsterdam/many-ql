package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.Expression;

public abstract class UnaryExpression extends Expression {

    protected Expression expr;

    public UnaryExpression(Expression _expr) {
        expr = _expr;
    }

    public Expression getExpr() {
        return expr;
    }
}