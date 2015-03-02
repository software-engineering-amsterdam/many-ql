package org.fugazi.ql.ast.type;

public class BoolType extends Type {

    public BoolType() {
        super();
    }
    public BoolType(int _lineNum) {
        super(_lineNum);
    }

    @Override
    public String toString() {
        return "Bool";
    }

    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visitBoolType(this);
    }
}
