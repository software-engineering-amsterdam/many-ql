package nl.uva.softwcons.ql.ast.type;

public final class StringType extends Type {
    public static final StringType STRING_TYPE = new StringType();

    private StringType() {
    }

    @Override
    public <T> T accept(final TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
