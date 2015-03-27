package nl.uva.softwcons.ql.ast.type;

public final class BooleanType extends Type {
    public static final BooleanType BOOLEAN_TYPE = new BooleanType();

    private BooleanType() {
    }

    @Override
    public <T> T accept(final TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
