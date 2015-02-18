package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;
import org.fugazi.ast.type.IntType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class BOOL extends Literal {

    private final Boolean value;
    private final List<Type> supportedTypes;

    public BOOL(Boolean _value) {
        this.value = _value;
        this.supportedTypes = new ArrayList<Type>();
        this.supportedTypes.add(new BoolType());
    }

    public Boolean getValue() {
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
        return visitor.visitBOOL(this);
    }
}