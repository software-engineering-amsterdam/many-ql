package cons.ql.ast.visitor;

import cons.ql.ast.expression.arithmetic.*;

public interface ArithmetricVisitor {
	public void visit(Add addNode);	
	public void visit(Div divNode);
	public void visit(Mul divNode);
	public void visit(Sub divNode);
}
