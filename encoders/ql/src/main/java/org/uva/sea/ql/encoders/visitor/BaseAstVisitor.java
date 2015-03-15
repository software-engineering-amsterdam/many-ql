package org.uva.sea.ql.encoders.visitor;

import org.uva.sea.ql.encoders.ast.ConditionalBlock;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BracedExpression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;
import org.uva.sea.ql.encoders.ast.expression.UnaryExpression;
import org.uva.sea.ql.encoders.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.encoders.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.encoders.ast.expression.literal.StringLiteral;

public class BaseAstVisitor<T> implements AstVisitor<T> {

	private static final String NOT_SUPPORTED_OPERATION = "Not supported operation";

	@Override
	public T visit(BinaryExpression binaryExpression) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public T visit(BracedExpression bracedExpression) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public T visit(NameExpression nameExpression) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public T visit(Question question) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public T visit(Questionnaire questionnaire) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public T visit(ConditionalBlock conditionalBlock) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public T visit(UnaryExpression unaryExpression) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public T visit(BooleanLiteral booleanLiteral) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public T visit(IntegerLiteral integerLiteral) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}

	@Override
	public T visit(StringLiteral stringLiteral) {
		throw new IllegalStateException(NOT_SUPPORTED_OPERATION);
	}
}
