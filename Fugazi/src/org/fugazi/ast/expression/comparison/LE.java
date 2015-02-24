package org.fugazi.ast.expression.comparison;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class LE extends Comparison {
    public LE(Expression _left, Expression _right) {
        super(_left, _right);
    }

    public LE(Expression _left, Expression _right, int _lineNum) {
        super(_left, _right, _lineNum);
    }

    @Override
    public String toString() {
        return this.left.toString() + " <= " + this.right.toString();
    }

    @Override
    public Type getReturnedType() {
        return new BoolType();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitLE(this);
    }
}