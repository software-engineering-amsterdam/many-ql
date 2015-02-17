package org.uva.sea.ql.factory;

import org.uva.sea.ql.model.QuestionType;
import org.uva.sea.ql.model.statement.QuestionStatement;
import org.uva.sea.ql.parser.antlr.QLParser.QuestionContext;

public interface IQLFactory {
	public QuestionStatement getQuestion(QuestionContext ctx);
	public QuestionType getQuestionType (String s);
	
}
