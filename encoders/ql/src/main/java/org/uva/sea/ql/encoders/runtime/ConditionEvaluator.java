package org.uva.sea.ql.encoders.runtime;

import java.util.List;

import org.uva.sea.ql.encoders.ast.BaseAstVisitor;
import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BracedExpression;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;
import org.uva.sea.ql.encoders.ast.operator.BinaryOperator;
import org.uva.sea.ql.encoders.ast.type.QLBoolean;
import org.uva.sea.ql.encoders.service.QuestionByName;

public class ConditionEvaluator extends BaseAstVisitor<Boolean> {

	private final List<RuntimeQuestion> questions;

	public ConditionEvaluator(List<RuntimeQuestion> questions) {
		this.questions = questions;
	}

	@Override
	public Boolean visit(BracedExpression bracedExpression) {
		Expression expression = bracedExpression.getExpression();
		return expression.accept(this);
	}

	@Override
	public Boolean visit(BinaryExpression binaryExpression) {
		Expression leftHand = binaryExpression.getLeftHand();
		Expression rightHand = binaryExpression.getRightHand();
		Boolean leftValue = leftHand.accept(this);
		Boolean rightValue = rightHand.accept(this);

		BinaryOperator binaryOperator = binaryExpression.getOperator();
		return binaryOperator.calculate(QLBoolean.BOOLEAN, leftValue, rightValue);
	}

	@Override
	public Boolean visit(NameExpression nameExpression) {
		String name = nameExpression.getName();
		QuestionByName questionByName = new QuestionByName();
		RuntimeQuestion runtimeQuestion = questionByName.getRuntimeQuestion(name, questions);
		Object value = runtimeQuestion.getValue();
		Boolean result = false;
		if (value != null) {
			result = new Boolean((Boolean) value);
		}
		return result;
	}
}
