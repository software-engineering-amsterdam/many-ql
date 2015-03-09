package org.uva.sea.ql.encoders.runtime;

import java.util.List;

import org.uva.sea.ql.encoders.ast.BaseAstVisitor;
import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BracedExpression;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;
import org.uva.sea.ql.encoders.ast.expression.UnaryExpression;
import org.uva.sea.ql.encoders.ast.operator.BinaryOperator;
import org.uva.sea.ql.encoders.ast.operator.UnaryOperator;
import org.uva.sea.ql.encoders.ast.type.DataType;
import org.uva.sea.ql.encoders.ast.type.QLBoolean;
import org.uva.sea.ql.encoders.ast.type.QLInteger;
import org.uva.sea.ql.encoders.ast.type.QLString;
import org.uva.sea.ql.encoders.service.QuestionByName;

public class ComputedEvaluatorVisitor extends BaseAstVisitor<Object> {

	private final DataType<?> dataType;

	private final List<RuntimeQuestion> questions;

	public ComputedEvaluatorVisitor(DataType<?> dataType, List<RuntimeQuestion> questions) {
		this.dataType = dataType;
		this.questions = questions;
	}

	@Override
	public Object visit(BracedExpression bracedExpression) {
		Expression expression = bracedExpression.getExpression();
		return expression.accept(this);
	}

	@Override
	public Object visit(BinaryExpression binaryExpression) {
		Expression leftHand = binaryExpression.getLeftHand();
		Expression rightHand = binaryExpression.getRightHand();
		Object leftValue = leftHand.accept(this);
		Object rightValue = rightHand.accept(this);

		BinaryOperator operator = binaryExpression.getOperator();
		if (dataType instanceof QLBoolean) {
			return operator.calculate((QLBoolean) dataType, (Boolean) leftValue, (Boolean) rightValue);
		} else if (dataType instanceof QLInteger) {
			return operator.calculate((QLInteger) dataType, (Integer) leftValue, (Integer) rightValue);
		}
		return operator.calculate((QLString) dataType, (String) leftValue, (String) rightValue);
	}

	@Override
	public Object visit(UnaryExpression unaryExpression) {
		Expression expression = unaryExpression.getExpression();
		UnaryOperator operator = unaryExpression.getOperator();
		Object value = expression.accept(this);
		return operator.calculate((QLBoolean) dataType, (Boolean) value);
	}

	@Override
	public Object visit(NameExpression nameExpression) {
		String name = nameExpression.getName();
		QuestionByName questionByName = new QuestionByName();
		RuntimeQuestion runtimeQuestion = questionByName.getRuntimeQuestion(name, questions);
		return runtimeQuestion.getValue();
	}
}
