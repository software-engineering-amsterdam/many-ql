package nl.uva.softwcons.ql.ast.type;

public interface TypeVisitor<T> {

    T visit(BooleanType type);

    T visit(StringType type);

    T visit(NumberType type);

    T visit(DateType type);

    T visit(UndefinedType type);

}
