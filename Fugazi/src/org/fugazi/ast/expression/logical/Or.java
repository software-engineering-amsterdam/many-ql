package org.fugazi.ast.expression.logical;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class Or extends Logical {
    public Or(Expression _left, Expression _right) {
        super(_left, _right);
    }
    public Or(Expression _left, Expression _right, int _lineNum) {
        super(_left, _right, _lineNum);
    }

    @Override
    public String toString() {
        return this.left.toString() + " || " + this.right.toString();
    }

    @Override
    public Type getReturnedType() {
        return new BoolType();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitOr(this);
    }
}