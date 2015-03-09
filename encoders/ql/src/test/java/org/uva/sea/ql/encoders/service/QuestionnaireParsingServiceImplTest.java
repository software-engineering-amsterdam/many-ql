package org.uva.sea.ql.encoders.service;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;

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

		Questionnaire questionnaire = questionnaireParsingService.parse(location);

		assertThat(questionnaire.getName(), is("taxOfficeExample"));
	}

	// TODO create better name for test
	@Test
	public void testQuestionnaireQuestionIsParsed() throws Exception {
		String location = RESOURCE_ROOT + "input_form.ql";

		String hasSoldHouse = "hasSoldHouse";
		Questionnaire questionnaire = questionnaireParsingService.parse(location);

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
		Questionnaire questionnaire = questionnaireParsingService.parse(location);

		Question question = questionnaire.getQuestion(questionName);
		assertThat(question, is(notNullValue()));
		assertThat(question.getName(), is(questionName));
		Expression condition = question.getCondition();
		assertThat(condition, is(instanceOf(NameExpression.class)));
		NameExpression nameExpression = (NameExpression) condition;
		assertThat(nameExpression.getName(), is("hasSoldHouse"));
	}
}
