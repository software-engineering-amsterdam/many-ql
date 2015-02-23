package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.IntType;

import java.util.ArrayList;
import java.util.List;

public class Positive extends Unary {
    private final Class returnedType;

    public Positive(Expression _expr, int _lineNum) {
        super(_expr, _lineNum);
        this.returnedType = IntType.class;
    }

    @Override
    public String toString() {
        return "+ " + this.expr.toString();
    }

    @Override
    public Class getReturnedType() {
        return this.returnedType;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitPositive(this);
    }
}