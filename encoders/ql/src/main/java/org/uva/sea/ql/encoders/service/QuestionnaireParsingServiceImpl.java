package org.uva.sea.ql.encoders.service;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.uva.sea.ql.encoders.EncodersQLLexer;
import org.uva.sea.ql.encoders.EncodersQLParser;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionnaireContext;
import org.uva.sea.ql.encoders.ast.Questionnaire;

/**
 * Implementation for {@link QuestionnaireParsingService}.
 */
public class QuestionnaireParsingServiceImpl implements
		QuestionnaireParsingService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Questionnaire parse(String location) throws IOException {
		EncodersQLLexer lexer = new EncodersQLLexer(new ANTLRFileStream(
				location));
		EncodersQLParser parser = new EncodersQLParser(new CommonTokenStream(
				lexer));

		QuestionnaireContext parseTree = parser.questionnaire();
		QuestionnaireVisitor visitor = new QuestionnaireVisitor();
		visitor.visit(parseTree);

		Questionnaire questionnaire = visitor.getQuestionnaire();
		return questionnaire;
	}

}
