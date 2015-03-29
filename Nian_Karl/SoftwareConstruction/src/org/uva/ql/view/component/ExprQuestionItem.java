package org.uva.ql.view.component;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.statement.QuestionComputed;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.view.widget.Widget;

public class ExprQuestionItem extends QuestionItem {

	private final Expression expr;

	public ExprQuestionItem(QuestionComputed question, Widget widget) {
		super(question, widget);
		this.expr = question.getExpression();
		widget.getWidget().setEnabled(false);
	}

	public void evaluateAndChange(Evaluator evaluator) {
		Value value = evaluator.evaluate(expr);
			widget.setWidgetValue(value);		
	}
}
