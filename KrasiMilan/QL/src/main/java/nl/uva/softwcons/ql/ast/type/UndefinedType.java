package nl.uva.softwcons.ql.ast.type;

public class UndefinedType extends Type {

    public static final UndefinedType instance = new UndefinedType();

    private UndefinedType() {

    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
