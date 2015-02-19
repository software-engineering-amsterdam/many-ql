package org.fugazi.ast.expression.numerical;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.IntType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class Mul extends Numerical {

    private final List<Class> supportedTypes;

    public Mul(Expression _left, Expression _right) {
        super(_left, _right);

        Class intTypeClass = new IntType().getClass();
        this.supportedTypes = new ArrayList<Class>();
        this.supportedTypes.add(intTypeClass);
    }

    @Override
    public String toString() {
        return this.left.toString() + " * " + this.right.toString();
    }

    @Override
    public List<Class> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitMul(this);
    }
}