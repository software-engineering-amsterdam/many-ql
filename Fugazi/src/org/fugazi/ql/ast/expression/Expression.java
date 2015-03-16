package org.fugazi.ql.ast.expression;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;

public abstract class Expression extends AbstractASTNode {

    public Expression() {
        super();
    }

    public abstract String toString();

    public abstract Type getReturnedType();

    public abstract <T> T accept(IExpressionVisitor<T> visitor);

    public boolean isExpressionOfTypeBool() {
        return isExpressionOfType(new BoolType());
    }

    public boolean isExpressionOfTypeInt() {
        return isExpressionOfType(new IntType());
    }

    public boolean isExpressionOfTypeString() {
        return isExpressionOfType(new StringType());
    }

    public boolean isExpressionOfType(Type type) {
        return this.getReturnedType().equals(type);
    }
}