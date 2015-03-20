package nl.uva.se.ql.gui.builders;

import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.form.FormVisitor;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.statement.StatementVisitor;
import nl.uva.se.ql.gui.mediators.IMediator;
import nl.uva.se.ql.gui.widgets.panes.QuestionPane;

public class GuiBuilder implements StatementVisitor, FormVisitor {
	
	private QuestionPane questionPane;		
	private final IMediator mediator;
	
	public GuiBuilder(IMediator mediator) {
		this.mediator = mediator;
	}
	
	public void visit(Question question) {
		questionPane.addQuestion(question);
	}

	public void visit(CalculatedQuestion calculatedQuestion) {	
		questionPane.addQuestion(calculatedQuestion);
	}
	
	public void visit(Condition condition) {
		ConditionBuilder conditionVisitor = new ConditionBuilder(condition, mediator);		
		questionPane.addConditionBox(conditionVisitor.getConditionBox());			
	}

	public void visit(Form form) {
		questionPane = new QuestionPane(form, mediator);
		form.visitChildren(this);
	}
	
	public QuestionPane getQuestionPane(){
		return this.questionPane;
	}
}
