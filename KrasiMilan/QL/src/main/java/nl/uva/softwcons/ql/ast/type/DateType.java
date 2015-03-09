package nl.uva.softwcons.ql.ast.type;

public final class DateType extends Type {
    public static final DateType DATE_TYPE = new DateType();

    private DateType() {
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
