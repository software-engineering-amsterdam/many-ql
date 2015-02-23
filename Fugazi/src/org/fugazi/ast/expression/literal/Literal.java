package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;

public abstract class Literal extends Expression {

    public Literal(int _lineNum) {
        super(_lineNum);
    }

    public abstract String toString();

    public abstract <T> T accept(IExpressionVisitor<T> visitor);
}
