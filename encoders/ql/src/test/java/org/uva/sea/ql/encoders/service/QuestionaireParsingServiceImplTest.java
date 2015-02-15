package org.uva.sea.ql.encoders.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.encoders.model.Question;
import org.uva.sea.ql.encoders.model.Questionaire;

public class QuestionaireParsingServiceImplTest {

	private QuestionaireParsingService questionaireParsingService;

	private static final String RESOURCE_ROOT = "src/main/resources/";

	@Before
	public void setUp() throws Exception {
		questionaireParsingService = new QuestionaireParsingServiceImpl();
	}

	// TODO create better name for test
	@Test
	public void testQuestionaireNameIsParsed() throws Exception {
		String location = RESOURCE_ROOT + "example.ql2";

		Questionaire questionaire = questionaireParsingService.parse(location);

		assertThat(questionaire.getName(), is("taxOfficeExample"));
	}

	// TODO create better name for test
	@Test
	public void testQuestionaireQuestionIsParsed() throws Exception {
		String location = RESOURCE_ROOT + "example.ql2";

		String hasSoldHouse = "hasSoldHouse";
		Questionaire questionaire = questionaireParsingService.parse(location);

		// TODO improve assertions
		Question questionHasSoldHouse = questionaire.getQuestion(hasSoldHouse);
		assertThat(questionHasSoldHouse, is(notNullValue()));
		assertThat(questionHasSoldHouse.getName(), is(hasSoldHouse));
	}
}
