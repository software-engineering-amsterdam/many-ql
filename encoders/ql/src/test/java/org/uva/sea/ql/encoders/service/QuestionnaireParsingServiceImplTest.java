package org.uva.sea.ql.encoders.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.encoders.model.Question;
import org.uva.sea.ql.encoders.model.Questionnaire;

public class QuestionnaireParsingServiceImplTest {

	private QuestionnaireParsingService questionnaireParsingService;

	private static final String RESOURCE_ROOT = "src/main/resources/";

	@Before
	public void setUp() throws Exception {
		questionnaireParsingService = new QuestionnaireParsingServiceImpl();
	}

	// TODO create better name for test
	@Test
	public void testQuestionnaireNameIsParsed() throws Exception {
		String location = RESOURCE_ROOT + "example.ql2";

		Questionnaire questionnaire = questionnaireParsingService.parse(location);

		assertThat(questionnaire.getName(), is("taxOfficeExample"));
	}

	// TODO create better name for test
	@Test
	public void testQuestionnaireQuestionIsParsed() throws Exception {
		String location = RESOURCE_ROOT + "example.ql2";

		String hasSoldHouse = "hasSoldHouse";
		Questionnaire questionnaire = questionnaireParsingService.parse(location);

		Question question = questionnaire.getQuestion(hasSoldHouse);
		assertThat(question, is(notNullValue()));
		assertThat(question.getName(), is(hasSoldHouse));
		assertThat(question.getType(), is("boolean"));
		assertThat(question.getCondition(), is((String) null));
	}

	// TODO create better name for test
	@Test
	public void testQuestionnaireConditionalBlockIsParsed() throws Exception {
		String location = RESOURCE_ROOT + "example.ql2";

		String questionName = "sellingPrice";
		Questionnaire questionnaire = questionnaireParsingService.parse(location);

		Question question = questionnaire.getQuestion(questionName);
		assertThat(question, is(notNullValue()));
		assertThat(question.getName(), is(questionName));
		assertThat(question.getType(), is("money"));
		assertThat(question.getCondition(), is("hasSoldHouse"));
	}
}
