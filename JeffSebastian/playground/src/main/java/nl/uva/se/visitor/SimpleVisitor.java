package nl.uva.se.visitor;

import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;

public class SimpleVisitor implements Visitor {

	@Override
	public void visit(Form form) {
		System.out.println(form.getId());
	}

	@Override
	public void visit(Question question) {
		System.out.println(question.getQuestion());
		
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		System.out.println(calculatedQuestion.getQuestion());
		
	}

	@Override
	public void visit(Condition condition) {
		System.out.println("condition");
		
	}

}
