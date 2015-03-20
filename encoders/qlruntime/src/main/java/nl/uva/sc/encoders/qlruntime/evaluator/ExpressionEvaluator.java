package nl.uva.sc.encoders.qlruntime.evaluator;

import java.util.List;

import nl.uva.sc.encoders.ql.ast.expression.BinaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.BracedExpression;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.expression.NameExpression;
import nl.uva.sc.encoders.ql.ast.expression.UnaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.sc.encoders.ql.ast.expression.literal.IntegerLiteral;
import nl.uva.sc.encoders.ql.ast.expression.literal.StringLiteral;
import nl.uva.sc.encoders.ql.ast.operator.BinaryOperator;
import nl.uva.sc.encoders.ql.ast.operator.UnaryOperator;
import nl.uva.sc.encoders.ql.visitor.ExpressionVisitor;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.value.BooleanValue;
import nl.uva.sc.encoders.qlruntime.value.IntegerValue;
import nl.uva.sc.encoders.qlruntime.value.StringValue;
import nl.uva.sc.encoders.qlruntime.value.Value;

public class ExpressionEvaluator implements ExpressionVisitor<Value> {

	private final List<RuntimeQuestion> questions;

	public ExpressionEvaluator(List<RuntimeQuestion> questions) {
		this.questions = questions;
	}

	@Override
	public Value visit(BracedExpression bracedExpression) {
		Expression expression = bracedExpression.getExpression();
		return expression.accept(this);
	}

	@Override
	public Value visit(BinaryExpression binaryExpression) {
		Expression leftHand = binaryExpression.getLeftHand();
		Expression rightHand = binaryExpression.getRightHand();
		Value leftValue = leftHand.accept(this);
		Value rightValue = rightHand.accept(this);

		BinaryOperator operator = binaryExpression.getOperator();
		return operator.accept(new BinaryEvaluator(leftValue, rightValue));
	}

	@Override
	public Value visit(UnaryExpression unaryExpression) {
		Expression expression = unaryExpression.getExpression();
		UnaryOperator operator = unaryExpression.getOperator();
		Value value = expression.accept(this);
		return operator.accept(new UnaryEvaluator(value));
	}

	@Override
	public Value visit(NameExpression nameExpression) {
		String name = nameExpression.getName();
		RuntimeQuestion runtimeQuestion = RuntimeQuestion.getRuntimeQuestion(name, questions);
		return runtimeQuestion.getValue();
	}

	@Override
	public Value visit(BooleanLiteral booleanLiteral) {
		return new BooleanValue(booleanLiteral.getValue());
	}

	@Override
	public Value visit(IntegerLiteral integerLiteral) {
		return new IntegerValue(integerLiteral.getValue());
	}

	@Override
	public Value visit(StringLiteral stringLiteral) {
		return new StringValue(stringLiteral.getValue());
	}
}
