package cons.ql.ast.visitor;

import cons.ql.ast.expression.literal.*;

public interface QLTypeVisitor {
	public void visit(QLBoolean booleanNode);	
	public void visit(QLFloat floatNode);
	public void visit(QLIdent identNode);
	public void visit(QLInt intNode);
	public void visit(QLString stringNode);
}
