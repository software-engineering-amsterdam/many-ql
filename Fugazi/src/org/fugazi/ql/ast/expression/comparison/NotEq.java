package org.fugazi.ql.ast.expression.comparison;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.IExpressionVisitor;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class NotEq extends Comparison {
    
    public NotEq(Expression _left, Expression _right) {
        super(_left, _right);
    }
    
    public NotEq(Expression _left, Expression _right, int _lineNum) {
        super(_left, _right, _lineNum);
    }

    @Override
    public String toString() {
        return this.getLeft().toString() + " != " + this.getRight().toString();
    }

    @Override
    public Type getReturnedType() {
        return new BoolType();
    }

    public List<Type> getSupportedTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new BoolType());
        supportedTypes.add(new IntType());
        supportedTypes.add(new StringType());

        return supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitNotEq(this);
    }
}