package org.uva.sea.ql.encoders.ast;

import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BracedExpression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;
import org.uva.sea.ql.encoders.ast.expression.UnaryExpression;

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
}
