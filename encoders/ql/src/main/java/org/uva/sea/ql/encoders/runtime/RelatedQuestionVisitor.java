package org.uva.sea.ql.encoders.runtime;

import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.encoders.ast.BaseAstVisitor;
import org.uva.sea.ql.encoders.ast.BracedExpression;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.NameExpression;
import org.uva.sea.ql.encoders.ast.BinaryExpression;

public class RelatedQuestionVisitor extends BaseAstVisitor<Set<String>> {

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
	public Set<String> visit(NameExpression nameExpression) {
		String name = nameExpression.getName();
		Set<String> result = new HashSet<>();
		result.add(name);
		return result;
	}

}
