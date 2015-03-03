package nl.uva.se.visitor;

import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;

public interface StatementVisitor {
	
	public void visit(Question question);
	public void visit(CalculatedQuestion calculatedQuestion);
	public void visit(Condition condition);

}
