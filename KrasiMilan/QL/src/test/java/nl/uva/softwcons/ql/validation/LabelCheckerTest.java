package nl.uva.softwcons.ql.validation;

import static org.assertj.core.api.Assertions.assertThat;
import helper.TestHelper;

import java.util.List;

import nl.uva.softwcons.ql.Questionnaire;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.validation.Error;
import nl.uva.softwcons.ql.validation.labels.LabelChecker;
import nl.uva.softwcons.ql.validation.labels.error.DuplicateLabel;

import org.junit.Test;

public class LabelCheckerTest {

    @Test
    public void validateNoInitialErrors() {
        final String question = "question: \"Label 1\" boolean";
        final List<Error> validationErrors = getLabelCheckerValidationErrors(question);

        assertThat(validationErrors).isEmpty();
    }

    @Test
    public void testDuplicateLabelsWarnings() {
        final String question1 = "question1: \"Label 1\" boolean";
        final String question2 = "question2: \"Label 1\" boolean";
        final List<Error> validationErrors = getLabelCheckerValidationErrors(question1, question2);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateLabel.class);
    }

    @Test
    public void testDuplicateLabelsProducesWarnings() {
        final String question1 = "question1: \"Label 1\" boolean";
        final String question2 = "question2: \"Label 1\" boolean";
        final List<Error> validationErrors = getLabelCheckerValidationErrors(question1, question2);

        assertThat(validationErrors.get(0).isFatal()).isFalse();
    }

    @Test
    public void testDuplicateLabelsNotSuccessive() {
        final String question1 = "question: \"Label 1\" boolean";
        final String question2 = "question2: \"Label 2\" boolean";
        final String question3 = "question3: \"Label 1\" boolean";
        final List<Error> validationErrors = getLabelCheckerValidationErrors(question1, question2, question3);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateLabel.class);
    }

    @Test
    public void testDuplicateLabelsWithConditional() {
        final String question = "question1: \"Label\" boolean";
        final String ifStatement = " if (true) { question2: \"Label\" boolean }";

        final List<Error> validationErrors = getLabelCheckerValidationErrors(question, ifStatement);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateLabel.class);
    }

    @Test
    public void testMultipleDuplicateLabelsWithConditional() {
        final String question1 = "question1: \"Label 1\" boolean";
        final String question2 = "question2: \"Label 1\" boolean";
        final String ifStatement = " if (true) { question3: \"Label 1\" boolean }";

        final List<Error> validationErrors = getLabelCheckerValidationErrors(question1, question2, ifStatement);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateLabel.class);
    }

    @Test
    public void testDifferentDuplicateLabels() {
        final String question1 = "question1: \"test\" boolean";
        final String question2 = "question2: \"go\" boolean";
        final String question3 = "question3: \"test\" boolean";
        final String question4 = "question4: \"go\" boolean";

        final List<Error> validationErrors = getLabelCheckerValidationErrors(question1, question2, question3, question4);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateLabel.class);
    }

    /**
     * TODO extract me into a common method when we create the checker
     * interface.
     * 
     * Builds a Form called always "form1" with the given statements (separating
     * them by newlines), runs the {@link LabelChecker} checker and returns the
     * list of found errors.
     * 
     * @param formContents
     *            The statements that will be included in the form
     * @return The errors found by the {@link LabelChecker} checker
     */
    private static List<Error> getLabelCheckerValidationErrors(final String... formContents) {
        Form form = Questionnaire.build(TestHelper.buildForm("form1", formContents));
        LabelChecker checker = new LabelChecker();
        form.accept(checker);

        return checker.getErrors();

    }
}
