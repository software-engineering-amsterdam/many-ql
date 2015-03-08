package nl.uva.softwcons.ql.ast.type;

public abstract class Type {

    public abstract <T> T accept(TypeVisitor<T> visitor);

}
