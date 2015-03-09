package nl.uva.softwcons.ql.ast.type;

public final class UndefinedType extends Type {
    public static final UndefinedType UNDEFINED_TYPE = new UndefinedType();

    private UndefinedType() {
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
