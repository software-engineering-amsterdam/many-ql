package org.fugazi.ql.ast.expression.numerical;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.IExpressionVisitor;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.Type;

public class Div extends Numerical {
    
    public Div(Expression _left, Expression _right) {
        super(_left, _right);
    }
    
    public Div(Expression _left, Expression _right, int _lineNum) {
        super(_left, _right, _lineNum);
    }

    @Override
    public String toString() {
        return this.getLeft().toString() + " / " + this.getRight().toString();
    }

    @Override
    public Type getReturnedType() { return new IntType(); }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitDiv(this);
    }
}