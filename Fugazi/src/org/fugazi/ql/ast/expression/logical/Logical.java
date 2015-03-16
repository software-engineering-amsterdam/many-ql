package org.fugazi.ql.ast.expression.logical;

import org.fugazi.ql.ast.expression.Binary;
import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.Type;

public abstract class Logical extends Binary {

    public Logical(Expression _left, Expression _right) {
        super(_left, _right);
    }

    public Type getReturnedType() {
        return new BoolType();
    }
}