package org.uva.sea.ql.encoders.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.uva.sea.ql.encoders.EncodersQLLexer;
import org.uva.sea.ql.encoders.EncodersQLParser;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionnaireContext;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.ast.TypeError;

/**
 * Implementation for {@link QuestionnaireParsingService}.
 */
public class QuestionnaireParsingServiceImpl implements
		QuestionnaireParsingService {

	public List<TypeError> typeErrors = new ArrayList<TypeError>();
	
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
		typeErrors = visitor.getTypeErrors();
		Questionnaire questionnaire = (Questionnaire) visitor.visit(parseTree);

		return questionnaire;
	}
	
	@Override
	public List<TypeError> getTypeErrors() {
		return typeErrors;
	}
}
