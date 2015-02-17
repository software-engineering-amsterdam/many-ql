package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;

public abstract class Literal extends Expression {

    public abstract String toString();

    public abstract <T> T accept(IExpressionVisitor<T> visitor);
}
