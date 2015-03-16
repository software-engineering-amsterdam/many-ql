package ast.type;


public interface ITypeVisitor<T> {
	public T visit(TextType type);
	public T visit(IntegerType type);
	public T visit(ChoiceType type);
	public T visit(UndefinedType type);
}
