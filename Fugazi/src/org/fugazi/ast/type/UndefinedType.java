package org.fugazi.ast.type;

public class UndefinedType extends Type {

    public UndefinedType(int _lineNum) {
        super(_lineNum);
    }

    @Override
    public String toString() {
        return "Undefined";
    }

    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visitUndefinedType(this);
    }
}