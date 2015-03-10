package nl.uva.se.ql.ast.statement;


public interface StatementVisitor {
	
	public void visit(Question question);
	public void visit(CalculatedQuestion calculatedQuestion);
	public void visit(Condition condition);

}
