package org.uva.sea.ql.encoders.runtime;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BracedExpression;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;
import org.uva.sea.ql.encoders.ast.expression.UnaryExpression;
import org.uva.sea.ql.encoders.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.encoders.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.encoders.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.encoders.visitor.ExpressionVisitor;

public class RelatedQuestionVisitor implements ExpressionVisitor<Set<String>> {

	@Override
	public Set<String> visit(BracedExpression bracedExpression) {
		Expression expression = bracedExpression.getExpression();
		return expression.accept(this);
	}

	@Override
	public Set<String> visit(BinaryExpression binaryExpression) {
		Expression leftHand = binaryExpression.getLeftHand();
		Expression rightHand = binaryExpression.getRightHand();
		Set<String> result = new HashSet<>();
		result.addAll(leftHand.accept(this));
		result.addAll(rightHand.accept(this));
		return result;
	}

	@Override
	public Set<String> visit(UnaryExpression unaryExpression) {
		Expression expression = unaryExpression.getExpression();
		return expression.accept(this);
	}

	@Override
	public Set<String> visit(NameExpression nameExpression) {
		String name = nameExpression.getName();
		Set<String> result = new HashSet<>();
		result.add(name);
		return result;
	}

	@Override
	public Set<String> visit(BooleanLiteral booleanLiteral) {
		return Collections.emptySet();
	}

	@Override
	public Set<String> visit(IntegerLiteral integerLiteral) {
		return Collections.emptySet();
	}

	@Override
	public Set<String> visit(StringLiteral stringLiteral) {
		return Collections.emptySet();
	}

}
