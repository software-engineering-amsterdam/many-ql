package org.fugazi.ql.ast.type;

public class UndefinedType extends Type {

    public UndefinedType() {
        super();
    }

    @Override
    public String toString() {
        return "Undefined";
    }

    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visitUndefinedType(this);
    }
}