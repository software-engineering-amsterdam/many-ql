package org.uva.sea.ql.encoders.ast;

import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BracedExpression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;
import org.uva.sea.ql.encoders.ast.expression.UnaryExpression;

public class BaseAstVisitor<T> implements AstVisitor<T> {

	@Override
	public T visit(BinaryExpression binaryExpression) {
		return null;
	}

	@Override
	public T visit(BracedExpression bracedExpression) {
		return null;
	}

	@Override
	public T visit(NameExpression nameExpression) {
		return null;
	}

	@Override
	public T visit(Question question) {
		return null;
	}

	@Override
	public T visit(Questionnaire questionnaire) {
		return null;
	}

	@Override
	public T visit(ConditionalBlock conditionalBlock) {
		return null;
	}

	@Override
	public T visit(UnaryExpression unaryExpression) {
		return null;
	}
}