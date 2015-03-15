package nl.uva.softwcons.ql.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import nl.uva.softwcons.helper.TestHelper;
import nl.uva.softwcons.ql.Questionnaire;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.validation.identifier.QuestionIdentifierChecker;
import nl.uva.softwcons.ql.validation.identifier.error.DuplicateQuestionIdentifier;

import org.junit.Test;

public class QuestionIdentifierCheckerTest {

    @Test
    public void testDuplicateQuesionIdentifiers() {
        final String question = "question: \"Label 1\" boolean";
        final List<Error> validationErrors = getIdentifierCheckerValidationErrors(question, question);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testDuplicateQuesionIdentifiersWithConditional() {
        final String question = "question: \"Label\" boolean";
        final String ifStatement = " if (true) { question: \"Label\" boolean }";

        final List<Error> validationErrors = getIdentifierCheckerValidationErrors(question, ifStatement);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testDuplicateQuesionIdentifiersNotSuccessive() {
        final String question1 = "question: \"Label 1\" boolean";
        final String question2 = "question2: \"Label 2\" boolean";
        final List<Error> validationErrors = getIdentifierCheckerValidationErrors(question1, question2, question1);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testMultipleDuplicateQuesionIdentifiersWithConditional() {
        final String question = "question: \"Label 1\" boolean";
        final String ifStatement = " if (true) { question: \"Label\" boolean }";

        final List<Error> validationErrors = getIdentifierCheckerValidationErrors(question, question, ifStatement);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testDifferentDuplicateQuesionIdentifiers() {
        final String question = "question: \"Label\" boolean";
        final String question2 = "question2: \"Label\" boolean";

        final List<Error> validationErrors = getIdentifierCheckerValidationErrors(question, question2, question,
                question2);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    private static List<Error> getIdentifierCheckerValidationErrors(final String... formContents) {
        Form form = Questionnaire.build(TestHelper.buildForm("form1", formContents));
        QuestionIdentifierChecker checker = new QuestionIdentifierChecker();
        form.accept(checker);

        return checker.getErrors();

    }

}
