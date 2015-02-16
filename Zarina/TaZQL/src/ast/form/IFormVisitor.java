package ast.form;

public interface IFormVisitor<T> {
	 public T visit(Form form);
}
