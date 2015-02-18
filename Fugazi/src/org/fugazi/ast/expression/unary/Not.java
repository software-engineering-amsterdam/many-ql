package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.type.BoolType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class Not extends Unary {

    private final List<Type> supportedTypes;

    public Not(Expression _expr) {
        super(_expr);
        this.supportedTypes = new ArrayList<Type>();
        this.supportedTypes.add(new BoolType());
    }

    @Override
    public String toString() {
        return "! " + this.expr.toString();
    }

    @Override
    public List<Type> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitNot(this);
    }
}