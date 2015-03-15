package org.fugazi.ql.ast.type;

public class BoolType extends Type {

    public BoolType() {
        super();
    }

    @Override
    public String toString() {
        return "Bool";
    }

    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visitBoolType(this);
    }
}
