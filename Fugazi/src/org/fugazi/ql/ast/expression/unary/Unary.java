package org.fugazi.ql.ast.expression.unary;

import org.fugazi.ql.ast.expression.Expression;

public abstract class Unary extends Expression {

    private final Expression expr;

    public Unary(Expression _expr) {
        super();
        this.expr = _expr;
    }

    public Expression getExpr() {
        return this.expr;
    }
}