package org.fugazi.ql.ast.expression.logical;

import org.fugazi.ql.ast.expression.Binary;
import org.fugazi.ql.ast.expression.Expression;

public abstract class Logical extends Binary {

    public Logical(Expression _left, Expression _right) {
        super(_left, _right);
    }
}