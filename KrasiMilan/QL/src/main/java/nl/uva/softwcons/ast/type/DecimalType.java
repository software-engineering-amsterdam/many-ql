package nl.uva.softwcons.ast.type;

public class DecimalType extends Type {

    public static final DecimalType instance = new DecimalType();

    private DecimalType() {

    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
