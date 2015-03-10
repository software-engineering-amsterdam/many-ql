package nl.uva.softwcons.ql.ast.type;

public interface TypeVisitor<T> {

    public T visit(BooleanType type);

    public T visit(StringType type);

    public T visit(NumberType type);

    public T visit(DateType type);

    public T visit(UndefinedType type);

}
