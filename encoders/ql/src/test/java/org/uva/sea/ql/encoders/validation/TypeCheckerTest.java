package org.uva.sea.ql.encoders.validation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;

public class TypeCheckerTest {

	private TypeChecker typeChecker;

	@Before
	public void setUp() throws Exception {
		typeChecker = new TypeChecker();
	}

	@Test
	public void testCheckTypesFindsUnreferencedQuestion() {
		Questionnaire questionnaire = new Questionnaire();

		String condition = "undefinedQuestionName";
		Question question = new Question("someQuestionName", DataType.BOOLEAN,
				"Huh?");
		question.setCondition(condition);
		questionnaire.addQuestion(question);

		ValidationResult result = typeChecker.checkTypes(questionnaire);

		List<Validation> validations = result.getValidations();
		Validation validation = validations.get(0);
		assertThat(validation.getType(), is(ValidationType.UNDEFINED_REFERENCE));
	}

}
