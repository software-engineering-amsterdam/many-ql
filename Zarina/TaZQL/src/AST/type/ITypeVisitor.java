package ast.type;


public interface ITypeVisitor<T> {
	public T visit(TextType type);
	public T visit(DigitsType type);
	public T visit(ChoiceType type);
	public T getValue();
}
