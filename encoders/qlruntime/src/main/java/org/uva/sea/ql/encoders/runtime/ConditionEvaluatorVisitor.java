package org.uva.sea.ql.encoders.runtime;

import java.util.List;

import org.uva.sea.ql.encoders.ast.ConditionalBlock;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BracedExpression;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;
import org.uva.sea.ql.encoders.ast.expression.UnaryExpression;
import org.uva.sea.ql.encoders.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.encoders.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.encoders.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.encoders.runtime.operator.BinaryOperator;
import org.uva.sea.ql.encoders.runtime.operator.UnaryOperator;
import org.uva.sea.ql.encoders.runtime.value.BooleanValue;
import org.uva.sea.ql.encoders.service.OperatorTable;
import org.uva.sea.ql.encoders.service.QuestionByName;
import org.uva.sea.ql.encoders.visitor.AstVisitor;

public class ConditionEvaluatorVisitor implements AstVisitor<BooleanValue> {

	private final List<RuntimeQuestion> questions;

	private final OperatorTable operatorTable;

	public ConditionEvaluatorVisitor(List<RuntimeQuestion> questions, OperatorTable operatorTable) {
		this.questions = questions;
		this.operatorTable = operatorTable;
	}

	@Override
	public BooleanValue visit(BracedExpression bracedExpression) {
		Expression expression = bracedExpression.getExpression();
		return expression.accept(this);
	}

	@Override
	public BooleanValue visit(BinaryExpression binaryExpression) {
		Expression leftHand = binaryExpression.getLeftHand();
		Expression rightHand = binaryExpression.getRightHand();
		BooleanValue leftValue = leftHand.accept(this);
		BooleanValue rightValue = rightHand.accept(this);

		BinaryOperator operator = operatorTable.getBinaryOperator(binaryExpression.getOperator());
		return (BooleanValue) operator.calculate(leftValue, rightValue);
	}

	@Override
	public BooleanValue visit(UnaryExpression unaryExpression) {
		Expression expression = unaryExpression.getExpression();
		UnaryOperator operator = operatorTable.getUnaryOperator(unaryExpression.getOperator());
		BooleanValue value = expression.accept(this);
		return (BooleanValue) operator.calculate(value);
	}

	@Override
	public BooleanValue visit(NameExpression nameExpression) {
		String name = nameExpression.getName();
		QuestionByName questionByName = new QuestionByName();
		RuntimeQuestion runtimeQuestion = questionByName.getRuntimeQuestion(name, questions);
		return (BooleanValue) runtimeQuestion.getValue();
	}

	@Override
	public BooleanValue visit(BooleanLiteral booleanLiteral) {
		return new BooleanValue(booleanLiteral.getValue());
	}

	@Override
	public BooleanValue visit(StringLiteral stringLiteral) {
		throw new AssertionError(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public BooleanValue visit(IntegerLiteral integerLiteral) {
		throw new AssertionError(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public BooleanValue visit(Question question) {
		throw new AssertionError(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public BooleanValue visit(Questionnaire questionnaire) {
		throw new AssertionError(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public BooleanValue visit(ConditionalBlock conditionalBlock) {
		throw new AssertionError(NOT_SUPPORTED_OPERATION);
	}
}
