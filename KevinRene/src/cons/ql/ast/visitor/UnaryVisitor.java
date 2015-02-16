package cons.ql.ast.visitor;

import cons.ql.ast.expression.unary.*;

public interface UnaryVisitor {
	public void visit(Neg negNode);
	public void visit(Not notNode);
	public void visit(Pos posNode);
}
