package org.fugazi.ast.expression.logical;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;

import java.util.ArrayList;
import java.util.List;

public class And extends Logical {
    private final Class returnedType;

    public And(Expression _left, Expression _right, int _lineNum) {
        super(_left, _right, _lineNum);
        this.returnedType = BoolType.class;
    }

    @Override
    public String toString() {
        return this.left.toString() + " && " + this.right.toString();
    }

    @Override
    public Class getReturnedType() {
        return this.returnedType;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitAnd(this);
    }
}