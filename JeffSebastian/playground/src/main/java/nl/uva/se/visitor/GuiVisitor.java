package nl.uva.se.visitor;

import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.gui.elements.QuestionPane;

public class GuiVisitor implements StatementVisitor, FormVisitor {
	
	private QuestionPane questionPane;	
	
	public void visit(Question question) {
		questionPane.addQuestion(question);
	}

	public void visit(CalculatedQuestion calculatedQuestion) {
		Question question = (Question) calculatedQuestion;
		questionPane.addQuestion(question);
	}

	public void visit(Condition condition) {		
		condition.visitChildren(this);	
		
	}

	public void visit(Form form) {
		questionPane = new QuestionPane(form);
		form.visitChildren(this);
	}
	
	public QuestionPane getQuestionPane(){
		return this.questionPane;
	}

}
