package nl.uva.softwcons.ql.ast.type;

public class DateType extends Type {

    public static final DateType instance = new DateType();

    private DateType() {

    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
