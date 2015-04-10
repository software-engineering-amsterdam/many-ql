package qlProject.ast.type;


public interface ITypeVisitor {

	public Object visit (StringType type);

	public Object visit(IntType type);

	public Object visit(BooleanType type);

}