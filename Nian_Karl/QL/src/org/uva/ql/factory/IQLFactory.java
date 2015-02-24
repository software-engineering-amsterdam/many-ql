package org.uva.ql.factory;

import org.antlr.v4.runtime.atn.SemanticContext.Operator;
import org.uva.ql.antlr.QLParser.QuestionNormalContext;
import org.uva.ql.ast.statement.QuestionStatement;
import org.uva.ql.ast.type.QuestionType;

public interface IQLFactory {
	public QuestionStatement getQuestion(QuestionNormalContext ctx);
	public QuestionType getQuestionType (String s);
	public boolean stringToBoolean(String s);
	public Operator getOperator(String s);	
}
