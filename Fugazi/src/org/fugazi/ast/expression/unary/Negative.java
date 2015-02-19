package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.IntType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class Negative extends Unary {

    private final List<Class> supportedTypes;

    public Negative(Expression _expr) {
        super(_expr);

        Class intTypeClass = new IntType().getClass();
        this.supportedTypes = new ArrayList<Class>();
        this.supportedTypes.add(intTypeClass);
    }

    @Override
    public String toString() {
        return "- " + this.expr.toString();
    }

    @Override
    public List<Class> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitNegative(this);
    }
}