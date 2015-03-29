package nl.uva.sc.encoders.qls.validation;

import static nl.uva.sc.encoders.ql.ast.QuestionnaireBuilder.aQuestionnaire;
import static nl.uva.sc.encoders.qls.ast.StylesheetBuilder.aStylesheet;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.validation.TypeValidation;
import nl.uva.sc.encoders.ql.validation.ValidationMessage;
import nl.uva.sc.encoders.qls.ast.Page;
import nl.uva.sc.encoders.qls.ast.PageBuilder;
import nl.uva.sc.encoders.qls.ast.Section;
import nl.uva.sc.encoders.qls.ast.SectionBuilder;
import nl.uva.sc.encoders.qls.ast.Stylesheet;

import org.junit.Test;

public class TypeCheckerTest {

	@Test
	public void testCheckTypes_referencedQuestionDoesNotExistInQLIsInvalid() {
		String questionLabel = "thisQuestionDoesNotExistInQL";
		Questionnaire questionnaire = aQuestionnaire().build();
		List<Page> pages = new ArrayList<>();
		List<Section> sections = new ArrayList<>();
		List<String> questionNames = Arrays.asList(questionLabel);
		sections.add(SectionBuilder.aSection().withQuestions(questionNames).build());
		pages.add(PageBuilder.aPage().withSections(sections).build());
		Stylesheet stylesheet = aStylesheet().withPages(pages).build();
		TypeChecker typeChecker = new TypeChecker(stylesheet, questionnaire);

		List<TypeValidation> validations = typeChecker.checkTypes();
		assertThat(validations.toString(), validations.size(), is(1));
		ValidationMessage validationMessage = validations.get(0);
		assertThat(validationMessage.getValidationMessage(),
				is("Question 'thisQuestionDoesNotExistInQL' does not exist in questionnaire"));
	}

}