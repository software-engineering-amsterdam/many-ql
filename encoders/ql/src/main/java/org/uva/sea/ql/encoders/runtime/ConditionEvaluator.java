package org.uva.sea.ql.encoders.runtime;

import java.util.List;

import org.uva.sea.ql.encoders.ast.BaseAstVisitor;
import org.uva.sea.ql.encoders.ast.BinaryExpression;
import org.uva.sea.ql.encoders.ast.BracedExpression;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.NameExpression;
import org.uva.sea.ql.encoders.ast.operator.BinaryOperator;
import org.uva.sea.ql.encoders.ast.type.QLBoolean;
import org.uva.sea.ql.encoders.service.QuestionByName;

public class ConditionEvaluator extends BaseAstVisitor<QLBoolean> {

	private final List<RuntimeQuestion> questions;

	public ConditionEvaluator(List<RuntimeQuestion> questions) {
		this.questions = questions;
	}

	@Override
	public QLBoolean visit(BracedExpression bracedExpression) {
		Expression expression = bracedExpression.getExpression();
		return expression.accept(this);
	}

	@Override
	public QLBoolean visit(BinaryExpression binaryExpression) {
		Expression leftHand = binaryExpression.getLeftHand();
		Expression rightHand = binaryExpression.getRightHand();
		QLBoolean leftValue = leftHand.accept(this);
		QLBoolean rightValue = rightHand.accept(this);

		BinaryOperator binaryOperator = binaryExpression.getOperator();
		return binaryOperator.calculate(leftValue, rightValue);
	}

	@Override
	public QLBoolean visit(NameExpression nameExpression) {
		String name = nameExpression.getName();
		QuestionByName questionByName = new QuestionByName();
		RuntimeQuestion runtimeQuestion = questionByName.getRuntimeQuestion(name, questions);
		QLBoolean value = new QLBoolean((Boolean) runtimeQuestion.getValue());
		return value;
	}
}
