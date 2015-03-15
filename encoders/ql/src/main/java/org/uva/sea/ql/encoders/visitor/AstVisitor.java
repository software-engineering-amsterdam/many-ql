package org.uva.sea.ql.encoders.visitor;

import org.uva.sea.ql.encoders.ast.ConditionalBlock;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BooleanExpression;
import org.uva.sea.ql.encoders.ast.expression.BracedExpression;
import org.uva.sea.ql.encoders.ast.expression.IntegerExpression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;
import org.uva.sea.ql.encoders.ast.expression.StringExpression;
import org.uva.sea.ql.encoders.ast.expression.UnaryExpression;

public interface AstVisitor<T> {

	T visit(UnaryExpression unaryExpression);

	T visit(BinaryExpression binaryExpression);

	T visit(BracedExpression bracedExpression);

	T visit(NameExpression nameExpression);

	T visit(Question question);

	T visit(Questionnaire questionnaire);

	T visit(ConditionalBlock conditionalBlock);

	T visit(StringExpression stringExpression);

	T visit(IntegerExpression integerExpression);

	T visit(BooleanExpression booleanExpression);

}
