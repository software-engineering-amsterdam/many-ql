package nl.uva.sc.encoders.qlruntime.service;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.expression.NameExpression;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.qlruntime.service.QuestionnaireParsingResult;
import nl.uva.sc.encoders.qlruntime.service.QuestionnaireParsingService;
import nl.uva.sc.encoders.qlruntime.service.QuestionnaireParsingServiceImpl;

import org.junit.Before;
import org.junit.Test;

public class QuestionnaireParsingServiceImplTest {

	private QuestionnaireParsingService questionnaireParsingService;

	private static final String RESOURCE_ROOT = "src/main/resources/ql/";

	@Before
	public void setUp() throws Exception {
		questionnaireParsingService = new QuestionnaireParsingServiceImpl();
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
		assertThat(question.getCondition(), is((Expression) null));
	}

	// TODO create better name for test
	@Test
	public void testQuestionnaireConditionalBlockIsParsed() throws Exception {
		String location = RESOURCE_ROOT + "input_form.ql";

		String questionName = "sellingPrice";

		QuestionnaireParsingResult questionnaireParsingResult = questionnaireParsingService.parse(location);
		Questionnaire questionnaire = questionnaireParsingResult.getQuestionnaire();

		Question question = questionnaire.getQuestion(questionName);
		assertThat(question, is(notNullValue()));
		assertThat(question.getName(), is(questionName));
		Expression condition = question.getCondition();
		assertThat(condition, is(instanceOf(NameExpression.class)));
		NameExpression nameExpression = (NameExpression) condition;
		assertThat(nameExpression.getName(), is("hasSoldHouse"));
	}
}
