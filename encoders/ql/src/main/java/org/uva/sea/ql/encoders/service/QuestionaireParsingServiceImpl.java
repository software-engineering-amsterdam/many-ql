package org.uva.sea.ql.encoders.service;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.uva.sea.ql.encoders.QL2BaseListener;
import org.uva.sea.ql.encoders.QL2Lexer;
import org.uva.sea.ql.encoders.QL2Parser;
import org.uva.sea.ql.encoders.QL2Parser.FormContext;
import org.uva.sea.ql.encoders.QL2Parser.QuestionRuleContext;
import org.uva.sea.ql.encoders.model.Question;
import org.uva.sea.ql.encoders.model.Questionaire;

/**
 * Implementation for {@link QuestionaireParsingService}.
 * 
 * @author Pim Tegelaar
 */
public class QuestionaireParsingServiceImpl implements
		QuestionaireParsingService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Questionaire parse(String location) throws IOException {

		QL2Lexer lexer = new QL2Lexer(new ANTLRFileStream(location));
		QL2Parser parser = new QL2Parser(new CommonTokenStream(lexer));

		final Questionaire questionaire = new Questionaire();
		parser.addParseListener(new QL2BaseListener() {
			@Override
			public void exitForm(FormContext ctx) {
				questionaire.setName(ctx.formName.getText());
			}

			@Override
			public void exitQuestionRule(QuestionRuleContext ctx) {
				Question question = new Question();
				question.setName(ctx.questionName.getText());
				questionaire.addQuestion(question);
			}
		});
		parser.form();
		return questionaire;
	}

}
