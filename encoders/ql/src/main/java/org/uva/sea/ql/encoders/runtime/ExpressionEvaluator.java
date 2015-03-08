package org.uva.sea.ql.encoders.runtime;

import java.util.List;

import org.uva.sea.ql.encoders.ast.BracedExpression;
import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.NameExpression;
import org.uva.sea.ql.encoders.ast.BinaryExpression;

public class ExpressionEvaluator {

	public void evaluateExpression(RuntimeQuestion runtimeQuestion) {

		evaluateCondition(runtimeQuestion);
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

	private DataType determineDataType(Expression expression, List<RuntimeQuestion> runtimeQuestions) {

		if (expression instanceof NameExpression) {
			String name = ((NameExpression) expression).getName();
			RuntimeQuestion runtimeQuestion = getRuntimeQuestion(name, runtimeQuestions);
			if (runtimeQuestion != null) {
				return runtimeQuestion.getQuestion().getDataType();
			} else {
				return DataType.UNDEFINED;
			}
		}

		if (expression instanceof BracedExpression) {
			Expression innerExpression = ((BracedExpression) expression).getExpression();
			return determineDataType(innerExpression, runtimeQuestions);
		}

		if (expression instanceof BinaryExpression) {
			BinaryExpression binaryExpression = (BinaryExpression) expression;
			Expression leftHand = binaryExpression.getLeftHand();
			Expression rightHand = binaryExpression.getRightHand();
			DataType leftHandDataType = determineDataType(leftHand, runtimeQuestions);
			DataType rightHandDataType = determineDataType(rightHand, runtimeQuestions);
			if (leftHandDataType.equals(DataType.UNDEFINED) || rightHandDataType.equals(DataType.UNDEFINED)) {
				return DataType.UNDEFINED;
			}
			if (leftHandDataType.equals(rightHandDataType)) {
				return leftHandDataType;
			}

			return DataType.UNDEFINED;
		}

		throw new RuntimeException("Unsupported type " + expression.getClass());
	}

	private RuntimeQuestion getRuntimeQuestion(String name, List<RuntimeQuestion> runtimeQuestions) {

		for (RuntimeQuestion runtimeQuestion : runtimeQuestions) {
			String runtimeQuestionName = runtimeQuestion.getQuestion().getName();
			if (name.equals(runtimeQuestionName)) {
				return runtimeQuestion;
			}
		}

		return null;
	}
}