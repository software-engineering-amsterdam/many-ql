package nl.uva.se.ql.ast.type;

public interface TypeVisitor<T> {

	public T visit(BooleanType booleanType);
	public T visit(DecimalType decimalType);
	public T visit(IntegerType integerType);
	public T visit(StringType stringType);
	public T visit(UndefinedType undefinedType);
	
}
