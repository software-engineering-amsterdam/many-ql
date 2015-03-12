package nl.uva.se.visitor;

import nl.uva.se.gui.elements.QuestionPane;
import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.form.FormVisitor;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.statement.StatementVisitor;
import nl.uva.se.ql.evaluation.ExpressionEvaluator;
import nl.uva.se.ql.evaluation.ValueTable;
import nl.uva.se.ql.evaluation.value.Value;

public class GuiVisitor implements StatementVisitor, FormVisitor {
	
	private QuestionPane questionPane;
		
	private ValueTable values;
	
	public GuiVisitor(ValueTable values) {
		this.values = values;
	}
	
	public void visit(Question question) {
		questionPane.addQuestion(question);
	}

	public void visit(CalculatedQuestion calculatedQuestion) {
		Question question = (Question) calculatedQuestion;
		questionPane.addQuestion(question);
	}
	
	public void visit(Condition condition) {
		ConditionVisitor conditionVisitor = new ConditionVisitor(condition);
		questionPane.addConditionBox(conditionVisitor.getConditionBox());
		//TODO CLEAN THIS UP
		/*Value<Boolean> value = ExpressionEvaluator.evaluate(condition.getExpression(), values);
		
		if (!value.isUndefined() && value.getValue()) {
			isFromCondition = true;
			condition.visitChildren(this);
		}
		isFromCondition = false;*/
	}

	public void visit(Form form) {
		questionPane = new QuestionPane(form);
		form.visitChildren(this);
	}
	
	public QuestionPane getQuestionPane(){
		return this.questionPane;
	}
}
