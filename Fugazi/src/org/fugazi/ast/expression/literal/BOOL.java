package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;

import java.util.ArrayList;
import java.util.List;

public class BOOL extends Literal {

    private final Boolean value;
    private final Class returnedType;

    public BOOL(Boolean _value, int _lineNum) {
        super(_lineNum);

        this.value = _value;
        this.returnedType = BoolType.class;
    }

    public Boolean getValue() {
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
        return visitor.visitBOOL(this);
    }
}