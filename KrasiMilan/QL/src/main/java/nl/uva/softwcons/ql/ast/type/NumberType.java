package nl.uva.softwcons.ql.ast.type;

public final class NumberType extends Type {
    public static final NumberType NUMBER_TYPE = new NumberType();

    private NumberType() {
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
