package org.fugazi.ast.expression.comparison;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;

public class EQ extends Comparison {

    private final Class returnedType;

    public EQ(Expression _left, Expression _right, int _lineNum) {
        super(_left, _right, _lineNum);
        this.returnedType = BoolType.class;
    }

    @Override
    public String toString() {
        return this.left.toString() + "==" + this.right.toString();
    }

    @Override
    public Class getReturnedType() {
        return this.returnedType;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitEQ(this);
    }
}