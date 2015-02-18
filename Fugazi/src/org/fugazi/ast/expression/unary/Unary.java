package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.Expression;

public abstract class Unary extends Expression {

    protected final Expression expr;

    public Unary(Expression _expr) {
        this.expr = _expr;
    }

    public Expression getExpr() {
        return this.expr;
    }
}