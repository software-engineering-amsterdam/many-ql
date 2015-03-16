package nl.uva.se.ql.gui.builders;

import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.form.FormVisitor;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.statement.StatementVisitor;
import nl.uva.se.ql.evaluation.ExpressionEvaluator;
import nl.uva.se.ql.evaluation.ValueTable;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.widgets.panes.QuestionPane;

public class GuiBuilder implements StatementVisitor, FormVisitor {
	
	private QuestionPane questionPane;
		
	private ValueTable values;
	
	public GuiBuilder(ValueTable values) {
		this.values = values;
		System.out.println("the valuetable"+values);
	}
	
	public void visit(Question question) {
		questionPane.addQuestion(question);
	}

	public void visit(CalculatedQuestion calculatedQuestion) {
		Question question = (Question) calculatedQuestion;
		questionPane.addQuestion(question);
	}
	
	public void visit(Condition condition) {
		ConditionBuilder conditionVisitor = new ConditionBuilder(condition);
		questionPane.addConditionBox(conditionVisitor.getConditionBox());	
		System.out.println("the condition: " + condition.getStatements());
	}

	public void visit(Form form) {
		questionPane = new QuestionPane(form, values);
		form.visitChildren(this);
	}
	
	public QuestionPane getQuestionPane(){
		return this.questionPane;
	}
}
