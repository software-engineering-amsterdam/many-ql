package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.IntType;

import java.util.ArrayList;
import java.util.List;

public class Positive extends Unary {

    private final List<Class> supportedTypes;

    public Positive(Expression _expr, int _lineNum) {
        super(_expr, _lineNum);

        Class intTypeClass = IntType.class;
        this.supportedTypes = new ArrayList<Class>();
        this.supportedTypes.add(intTypeClass);
    }

    @Override
    public String toString() {
        return "+ " + this.expr.toString();
    }

    @Override
    public List<Class> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitPositive(this);
    }
}