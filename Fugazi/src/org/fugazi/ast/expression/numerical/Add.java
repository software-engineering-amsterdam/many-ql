package org.fugazi.ast.expression.numerical;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.IntType;

import java.util.ArrayList;
import java.util.List;

public class Add extends Numerical {
    private final Class returnedType;

    public Add(Expression _left, Expression _right, int _lineNum) {
        super(_left, _right, _lineNum);
        this.returnedType = IntType.class;
    }

    @Override
    public String toString() {
        return this.left.toString() + " + " + this.right.toString();
    }

    @Override
    public Class getReturnedType() {
        return this.returnedType;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitAdd(this);
    }
}