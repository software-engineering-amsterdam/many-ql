package org.fugazi.ql.ast.type;

public class IntType extends Type {

    public IntType() {
        super();
    }
    public IntType(int _lineNum) {
        super(_lineNum);
    }

    @Override
    public String toString() {
        return "Int";
    }

    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visitIntType(this);
    }
}
