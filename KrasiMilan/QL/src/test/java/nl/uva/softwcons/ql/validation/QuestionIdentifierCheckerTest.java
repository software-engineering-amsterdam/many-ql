package nl.uva.softwcons.ql.validation;

import static nl.uva.softwcons.helper.TestHelper.getCheckerErrors;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import nl.uva.softwcons.ql.validation.identifier.QuestionIdentifierChecker;
import nl.uva.softwcons.ql.validation.identifier.error.DuplicateQuestionIdentifier;

import org.junit.Test;

public class QuestionIdentifierCheckerTest {

    @Test
    public void testDuplicateQuesionIdentifiers() {
        final String question = "question: \"Label 1\" boolean";
        final List<Error> validationErrors = getCheckerErrors(new QuestionIdentifierChecker(), question, question);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testDuplicateQuesionIdentifiersWithConditional() {
        final String question = "question: \"Label\" boolean";
        final String ifStatement = " if (true) { question: \"Label\" boolean }";

        final List<Error> validationErrors = getCheckerErrors(new QuestionIdentifierChecker(), question, ifStatement);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testDuplicateQuesionIdentifiersNotSuccessive() {
        final String question1 = "question: \"Label 1\" boolean";
        final String question2 = "question2: \"Label 2\" boolean";
        final List<Error> validationErrors = getCheckerErrors(new QuestionIdentifierChecker(), question1, question2,
                question1);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testMultipleDuplicateQuesionIdentifiersWithConditional() {
        final String question = "question: \"Label 1\" boolean";
        final String ifStatement = " if (true) { question: \"Label\" boolean }";

        final List<Error> validationErrors = getCheckerErrors(new QuestionIdentifierChecker(), question, question,
                ifStatement);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testDifferentDuplicateQuesionIdentifiers() {
        final String question = "question: \"Label\" boolean";
        final String question2 = "question2: \"Label\" boolean";

        final List<Error> validationErrors = getCheckerErrors(new QuestionIdentifierChecker(), question, question2,
                question, question2);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

}
