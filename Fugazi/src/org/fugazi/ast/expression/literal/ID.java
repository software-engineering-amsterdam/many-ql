package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.Type;

public class ID extends Literal {

    private final String name;
    private final Type type;

    public ID(String _name, Type _type) {
        super();
        this.name = _name;
        this.type = _type;
    }
    public ID(String _name, Type _type, int _lineNum) {
        super(_lineNum);

        this.name = _name;
        this.type = _type;
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
    public Type getReturnedType() {
        return this.type;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitID(this);
    }
}

