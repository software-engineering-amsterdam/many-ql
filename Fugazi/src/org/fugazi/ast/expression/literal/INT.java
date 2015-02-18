package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.IntType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class INT extends Literal {

    private final int value;
    private final List<Type> supportedTypes;

    public INT(int _value) {
        this.value = _value;
        this.supportedTypes = new ArrayList<Type>();
        this.supportedTypes.add(new IntType());
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public List<Type> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitINT(this);
    }
}

