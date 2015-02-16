package cons.ql.ast.visitor;

import cons.ql.ast.Statement;
import cons.ql.ast.expression.*;

public interface Visitor {
	@SuppressWarnings("rawtypes")
	public void visit(QLType typeNode);
	public void visit(Unary unaryNode);
	public void visit(Binary binaryNode);
	public void visit(Statement statementNode);
}
