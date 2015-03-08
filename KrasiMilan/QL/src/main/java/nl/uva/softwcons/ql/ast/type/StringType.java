package nl.uva.softwcons.ql.ast.type;

public class StringType extends Type {

    public static final StringType instance = new StringType();

    private StringType() {

    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
