package ast.type;


public interface ITypeVisitor<T> {
	//T visit(TextType type);
	public T getValue();
}
