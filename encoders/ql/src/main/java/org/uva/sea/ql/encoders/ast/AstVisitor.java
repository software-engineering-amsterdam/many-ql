package org.uva.sea.ql.encoders.ast;

import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BracedExpression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;
import org.uva.sea.ql.encoders.ast.expression.UnaryExpression;

public interface AstVisitor<T> {

	T visit(UnaryExpression unaryExpression);

	T visit(BinaryExpression binaryExpression);

	T visit(BracedExpression bracedExpression);

	T visit(NameExpression nameExpression);

	T visit(Question question);

	T visit(Questionnaire questionnaire);

	T visit(ConditionalBlock conditionalBlock);

}
