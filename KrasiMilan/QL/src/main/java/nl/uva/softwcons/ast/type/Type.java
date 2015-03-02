package nl.uva.softwcons.ast.type;

public abstract class Type {

    public abstract <T> T accept(TypeVisitor<T> visitor);

}
