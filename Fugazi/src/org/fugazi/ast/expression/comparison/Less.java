package org.fugazi.ast.expression.comparison;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;
import org.fugazi.ast.type.IntType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class Less extends Comparison {

    private final List<Type> supportedTypes;

    public Less(Expression _left, Expression _right) {
        super(_left, _right);
        supportedTypes = new ArrayList<Type>();
        supportedTypes.add(new IntType());
    }

    @Override
    public String toString() {
        return this.left.toString() + " < " + this.right.toString();
    }

    @Override
    public List<Type> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitLesser(this);
    }
}