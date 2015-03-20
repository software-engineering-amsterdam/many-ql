package nl.uva.se.ql.evaluation;

import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.form.FormVisitor;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.statement.StatementVisitor;
import nl.uva.se.ql.evaluation.value.Value;

public class Evaluator implements FormVisitor, StatementVisitor {

	private ValueTable values;
	
	private Evaluator() {
		values = new ValueTable();
	}
	
	private Evaluator(ValueTable values) {
		this.values = values;
	}
	
	public static ValueTable evaluate(Form form, ValueTable values) {
		Evaluator evaluator = new Evaluator(values);
		form.accept(evaluator);
		
		return evaluator.values;
	}

	public void visit(Form form) {
		form.visitChildren(this);
	}

	public void visit(Question question) {
		if (values.containsKey(question.getId())) {
			values.addValue(question.getId(), values.getValue(question.getId()));
		} else {
			values.addValue(question.getId(), question.getType().getDefaultValue());
		}
	}

	public void visit(CalculatedQuestion calculatedQuestion) {
		Value exprValue = ExpressionEvaluator.evaluate(calculatedQuestion.getExpression(), values);
		values.addValue(calculatedQuestion.getId(), exprValue);
	}

	public void visit(Condition condition) {
		condition.visitChildren(this);
	}

}
