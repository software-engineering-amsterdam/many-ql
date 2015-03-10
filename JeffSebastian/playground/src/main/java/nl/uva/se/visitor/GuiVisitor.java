package nl.uva.se.visitor;

import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.evaluation.ExpressionEvaluator;
import nl.uva.se.evaluation.ValueTable;
import nl.uva.se.evaluation.value.Value;
import nl.uva.se.gui.elements.QuestionPane;

public class GuiVisitor implements StatementVisitor, FormVisitor {
	
	private QuestionPane questionPane;
	private boolean isFromCondition;
	
	private ValueTable values;
	
	public GuiVisitor(ValueTable values) {
		this.values = values;
	}
	
	public void visit(Question question) {
		questionPane.addQuestion(question, isFromCondition);
	}

	public void visit(CalculatedQuestion calculatedQuestion) {
		Question question = (Question) calculatedQuestion;
		questionPane.addQuestion(question, isFromCondition);
	}
	
	public void visit(Condition condition) {
		Value<Boolean> value = ExpressionEvaluator.evaluate(condition.getExpression(), values);
		
		if (!value.isUndefined() && value.getValue()) {
			isFromCondition = true;
			condition.visitChildren(this);
		}
		isFromCondition = false;
	}

	public void visit(Form form) {
		questionPane = new QuestionPane(form);
		form.visitChildren(this);
	}
	
	public QuestionPane getQuestionPane(){
		return this.questionPane;
	}
}
