package org.fugazi.ast.expression.logical;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.type.BoolType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class And extends Logical {
    private final List<Type> supportedTypes;

    public And(Expression _left, Expression _right) {
        super(_left, _right);
        this.supportedTypes = new ArrayList<Type>();
        this.supportedTypes.add(new BoolType());
    }

    @Override
    public String toString() {
        return this.left.toString() + " && " + this.right.toString();
    }

    @Override
    public List<Type> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitAnd(this);
    }
}