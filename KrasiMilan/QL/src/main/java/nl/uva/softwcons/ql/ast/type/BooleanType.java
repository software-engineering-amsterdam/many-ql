package nl.uva.softwcons.ql.ast.type;

public class BooleanType extends Type {

    public static final BooleanType instance = new BooleanType();

    private BooleanType() {

    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
