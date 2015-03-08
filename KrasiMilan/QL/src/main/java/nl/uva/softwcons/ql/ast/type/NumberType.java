package nl.uva.softwcons.ql.ast.type;

public class NumberType extends Type {

    public static final NumberType instance = new NumberType();

    private NumberType() {

    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
