package nl.uva.sc.encoders.qlruntime.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.parser.QuestionnaireParser;
import nl.uva.sc.encoders.ql.parser.QuestionnaireParsingResult;

import org.junit.Before;
import org.junit.Test;

public class QuestionnaireParserTest {

	private QuestionnaireParser questionnaireParsingService;

	private static final String RESOURCE_ROOT = "src/main/resources/ql/";

	@Before
	public void setUp() throws Exception {
		questionnaireParsingService = new QuestionnaireParser();
	}

	// TODO create better name for test
	@Test
	public void testQuestionnaireNameIsParsed() throws Exception {
		String location = RESOURCE_ROOT + "input_form.ql";

		QuestionnaireParsingResult questionnaireParsingResult = questionnaireParsingService.parse(location);
		Questionnaire questionnaire = questionnaireParsingResult.getQuestionnaire();

		assertThat(questionnaire.getName(), is("taxOfficeExample"));
	}

	// TODO create better name for test
	@Test
	public void testQuestionnaireQuestionIsParsed() throws Exception {
		String location = RESOURCE_ROOT + "input_form.ql";

		String hasSoldHouse = "hasSoldHouse";

		QuestionnaireParsingResult questionnaireParsingResult = questionnaireParsingService.parse(location);
		Questionnaire questionnaire = questionnaireParsingResult.getQuestionnaire();

		Question question = questionnaire.getQuestion(hasSoldHouse);
		assertThat(question, is(notNullValue()));
		assertThat(question.getName(), is(hasSoldHouse));
	}
}
