package org.uva.sea.ql.encoders.runtime;

import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.NameExpression;

public class ExpressionEvaluator {

	public Object evaluateExpression(RuntimeQuestion runtimeQuestion) {
		return evaluateCondition(runtimeQuestion);
	}

	private boolean evaluateCondition(RuntimeQuestion runtimeQuestion) {

		Expression questionCondition = runtimeQuestion.getQuestion().getCondition();

		// How to avoid usage instanceof?
		// How to deal with other types of Expressions?
		// How to get the Questionnaire context to modify the UI fields??
		if (questionCondition instanceof NameExpression) {

			// for (RuntimeQuestion runtimeQuestion : runtimeQuestions) {
			//
			// if
			// (questionCondition.toString().equals(runtimeQuestion.getQuestion().getName()))
			// {
			// System.out.println(runtimeQuestion.getValue());
			// }
			// }
		}
		return false;
	}

	// private boolean evaluateComputation() {
	// return false;
	// }

}