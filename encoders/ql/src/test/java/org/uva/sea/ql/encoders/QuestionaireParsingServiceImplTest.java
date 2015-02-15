package org.uva.sea.ql.encoders;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

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

		Questionaire questionaire = questionaireParsingService.parse(location);

		// TODO improve assertions
		List<Question> questions = questionaire.getQuestions();
		assertThat(questions, is(notNullValue()));
	}
}
