package nl.uva.se.visitor;

import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Question;

public interface Visitor {
	
	public void visit(Form form);
	public void visit(Question question);
	public void visit(CalculatedQuestion calculatedQuestion);

}
