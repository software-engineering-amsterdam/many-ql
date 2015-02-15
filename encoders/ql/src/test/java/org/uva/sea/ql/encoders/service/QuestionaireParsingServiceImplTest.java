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

	@Before
	public void setUp() throws Exception {
		questionaireParsingService = new QuestionaireParsingServiceImpl();
	}

	// TODO create better name for test
	@Test
	public void testParseQuestionaire() {
		String location = "example.ql";

		String hasSoldHouse = "hasSoldHouse";
		Questionaire questionaire = questionaireParsingService.parse(location);

		// TODO improve assertions
		Question questionHasSoldHouse = questionaire.getQuestion(hasSoldHouse);
		assertThat(questionHasSoldHouse, is(notNullValue()));
		assertThat(questionHasSoldHouse.getName(), is(hasSoldHouse));
	}
}
