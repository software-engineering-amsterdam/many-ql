package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.IntType;

import java.util.ArrayList;
import java.util.List;

public class INT extends Literal {

    private final int value;
    private final Class returnedType;

    public INT(int _value, int _lineNum) {
        super(_lineNum);

        this.value = _value;
        this.returnedType = IntType.class;

    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public Class getReturnedType() {
        return this.returnedType;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitINT(this);
    }
}

