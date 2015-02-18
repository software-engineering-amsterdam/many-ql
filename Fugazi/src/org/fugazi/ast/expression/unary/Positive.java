package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.type.IntType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class Positive extends Unary {

    private final List<Type> supportedTypes;

    public Positive(Expression _expr) {
        super(_expr);
        this.supportedTypes = new ArrayList<Type>();
        this.supportedTypes.add(new IntType());
    }

    @Override
    public String toString() {
        return "+ " + this.expr.toString();
    }

    @Override
    public List<Type> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitPositive(this);
    }
}