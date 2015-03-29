package nl.uva.sc.encoders.qls.validation;

import static nl.uva.sc.encoders.ql.ast.QuestionBuilder.aQuestion;
import static nl.uva.sc.encoders.ql.ast.QuestionnaireBuilder.aQuestionnaire;
import static nl.uva.sc.encoders.qls.ast.StylesheetBuilder.aStylesheet;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.validation.TypeValidation;
import nl.uva.sc.encoders.ql.validation.ValidationMessage;
import nl.uva.sc.encoders.qls.ast.Stylesheet;

import org.junit.Test;

public class TypeCheckerTest {

	@Test
	public void testCheckTypes_referencedQuestionDoesNotExistInQLIsInvalid() {
		String questionLabel = "thisQuestionDoesNotExistInQL";
		Question questionA = aQuestion().withQuestionLabel(questionLabel).build();
		List<Question> questions = Arrays.asList(questionA);
		Questionnaire questionnaire = aQuestionnaire().withQuestions(questions).build();
		Stylesheet stylesheet = aStylesheet().build();
		TypeChecker typeChecker = new TypeChecker(stylesheet, questionnaire);

		List<TypeValidation> validations = typeChecker.checkTypes();
		assertThat(validations.toString(), validations.size(), is(1));
		ValidationMessage validationMessage = validations.get(0);
		assertThat(validationMessage.getValidationMessage(), is("Referenced Question does not exist in QL."));
	}

	@Test
	public void testCheckTypes_notAllQLQuestionsArePlacedIsInvalid() {

	}

	@Test
	public void testCheckTypes_incompatibleWidgetToQuestionAssignmentIsInvalid() {

	}

	@Test
	public void testCheckTypes_singleQuestionPlacedMultipleTimesIsInvalid() {

	}

}
