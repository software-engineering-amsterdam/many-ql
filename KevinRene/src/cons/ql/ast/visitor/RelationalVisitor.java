package cons.ql.ast.visitor;

import cons.ql.ast.expression.relational.*;

public interface RelationalVisitor {
	public void visit(And andNode);	
	public void visit(Eq eqNode);
	public void visit(GEq geqNode);
	public void visit(GT gtNode);
	public void visit(LEq leqNode);
	public void visit(LT ltNode);
	public void visit(NEq neqNode);
	public void visit(Or orNode);
}
