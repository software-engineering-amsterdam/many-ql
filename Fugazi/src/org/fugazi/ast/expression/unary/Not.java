package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;
import org.fugazi.ast.type.Type;

public class Not extends Unary {
    public Not(Expression _expr) {
        super(_expr);
    }
    public Not(Expression _expr, int _lineNum) {
        super(_expr, _lineNum);
    }

    @Override
    public String toString() {
        return "! " + this.expr.toString();
    }

    @Override
    public Type getReturnedType() {
        return new BoolType();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitNot(this);
    }
}