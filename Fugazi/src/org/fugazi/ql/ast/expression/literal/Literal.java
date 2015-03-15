package org.fugazi.ql.ast.expression.literal;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.IExpressionVisitor;

public abstract class Literal extends Expression {

    public Literal() {
        super();
    }

    public abstract String toString();

    public abstract <T> T accept(IExpressionVisitor<T> visitor);
}
