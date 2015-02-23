package org.uva.sea.ql.factory;

import org.uva.sea.ql.AST.QuestionType;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.expression.Operator;
import org.uva.sea.ql.AST.statement.QuestionStatement;
import org.uva.sea.ql.parser.antlr.QLParser.ExpressionContext;
import org.uva.sea.ql.parser.antlr.QLParser.QuestionContext;

public interface IQLFactory {
	public QuestionStatement getQuestion(QuestionContext ctx);
	public QuestionType getQuestionType (String s);
	public boolean stringToBoolean(String s);
	public Expression getExpression(ExpressionContext expr);
	public Operator getOperator(String s);
}
