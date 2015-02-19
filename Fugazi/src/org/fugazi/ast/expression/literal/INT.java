package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;
import org.fugazi.ast.type.IntType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class INT extends Literal {

    private final int value;
    private final List<Class> supportedTypes;

    public INT(int _value) {
        this.value = _value;
        Class intTypeClass = new IntType().getClass();
        this.supportedTypes = new ArrayList<Class>();
        this.supportedTypes.add(intTypeClass);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public List<Class> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitINT(this);
    }
}

