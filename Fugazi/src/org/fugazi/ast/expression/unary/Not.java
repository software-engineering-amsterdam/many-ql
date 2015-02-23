package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;

import java.util.ArrayList;
import java.util.List;

public class Not extends Unary {
    private final Class returnedType;

    public Not(Expression _expr, int _lineNum) {
        super(_expr, _lineNum);
        this.returnedType = BoolType.class;
    }

    @Override
    public String toString() {
        return "! " + this.expr.toString();
    }

    @Override
    public Class getReturnedType() {
        return this.returnedType;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitNot(this);
    }
}