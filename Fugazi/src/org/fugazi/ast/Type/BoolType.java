package org.fugazi.ast.type;

public class BoolType extends Type {

    @Override
    public String toString() {
        return "Bool";
    }

    public <T> T accept(ITypeVisitor<T> visitor) {
        
        return visitor.visitBoolType(this);
    }
}
