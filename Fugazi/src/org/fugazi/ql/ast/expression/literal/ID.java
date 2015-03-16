package org.fugazi.ql.ast.expression.literal;

import org.fugazi.ql.ast.expression.IExpressionVisitor;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.ast.type.UndefinedType;
//import org.fugazi.ql.ast.type.UndefinedType;

public class ID extends Literal {

    private final String name;

    public ID(String _name) {
        super();
        this.name = _name;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return this.name;
    }

    public Type getReturnedType() {
        return new UndefinedType();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitID(this);
    }

    // this is necessary for mapping dependencies
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ID)) {
            return false;
        }

        ID other = (ID) obj;
        return (this.getName().equals(other.getName()));
    }

    @Override
    public int hashCode() {
        return (this.name.hashCode());
    }
}

