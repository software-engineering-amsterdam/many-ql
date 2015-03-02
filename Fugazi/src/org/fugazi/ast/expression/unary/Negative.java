package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.IntType;
import org.fugazi.ast.type.Type;

public class Negative extends Unary {
    public Negative(Expression _expr) {
        super(_expr);
    }
    public Negative(Expression _expr, int _lineNum) {
        super(_expr, _lineNum);
    }

    @Override
    public String toString() {
        return "- " + this.expr.toString();
    }

    @Override
    public Type getReturnedType() {
        return new IntType();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitNegative(this);
    }
}