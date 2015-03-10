package nl.uva.se.evaluation;

import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.evaluation.value.BooleanValue;
import nl.uva.se.evaluation.value.UndefinedValue;
import nl.uva.se.evaluation.value.Value;
import nl.uva.se.visitor.FormVisitor;
import nl.uva.se.visitor.StatementVisitor;

public class Evaluator implements FormVisitor, StatementVisitor {

	private ValueTable values;
	
	private Evaluator() {
		values = new ValueTable();
	}
	
	public static ValueTable evaluate(Form form) {
		Evaluator evaluator = new Evaluator();
		form.accept(evaluator);
		
		return evaluator.values;
	}

	public void visit(Form form) {
		form.visitChildren(this);
	}

	public void visit(Question question) {
		values.addValue(question.getId(), new UndefinedValue());
	}

	public void visit(CalculatedQuestion calculatedQuestion) {
		Value exprValue = ExpressionEvaluator.getValue(calculatedQuestion.getExpression(), values);
		values.addValue(calculatedQuestion.getId(), exprValue);
	}

	public void visit(Condition condition) {
		Value condValue = ExpressionEvaluator.getValue(condition.getExpression(), values);
		
		if (!condValue.isUndefined() && ((BooleanValue) condValue).getValue()) {
			condition.visitChildren(this);
		}
	}

}
