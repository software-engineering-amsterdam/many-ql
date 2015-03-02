package nl.uva.softwcons.ast.type;

public class IntegerType extends Type {

    public static final IntegerType instance = new IntegerType();

    private IntegerType() {

    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
