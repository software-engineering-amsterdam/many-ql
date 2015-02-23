package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class ID extends Literal {

    private final String name;
    private final Type type;
    private final Class returnedType;

    public ID(String _name, Type _type, int _lineNum) {
        super(_lineNum);

        this.name = _name;
        this.type = _type;
        this.returnedType = this.type.getClass();

    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public Class getReturnedType() {
        return this.returnedType;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitID(this);
    }
}

