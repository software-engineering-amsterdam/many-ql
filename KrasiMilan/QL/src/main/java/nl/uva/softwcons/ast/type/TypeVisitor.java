package nl.uva.softwcons.ast.type;

public interface TypeVisitor<T> {

    public T visit(BooleanType type);

    public T visit(IntegerType type);

    public T visit(StringType type);

    public T visit(DecimalType type);

    public T visit(DateType type);

    public T visit(UndefinedType type);

}
