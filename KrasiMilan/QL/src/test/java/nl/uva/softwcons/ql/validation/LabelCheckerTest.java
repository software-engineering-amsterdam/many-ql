package nl.uva.softwcons.ql.validation;

import static nl.uva.softwcons.helper.TestHelper.getCheckerErrors;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import nl.uva.softwcons.ql.validation.label.LabelChecker;
import nl.uva.softwcons.ql.validation.label.error.DuplicateLabel;

import org.junit.Test;

public class LabelCheckerTest {

    @Test
    public void validateNoInitialErrors() {
        final String question = "question: \"Label 1\" boolean";
        final List<Error> validationErrors = getCheckerErrors(LabelChecker::check, question);

        assertThat(validationErrors).isEmpty();
    }

    @Test
    public void testDuplicateLabelsWarnings() {
        final String question1 = "question1: \"Label 1\" boolean";
        final String question2 = "question2: \"Label 1\" boolean";
        final List<Error> validationErrors = getCheckerErrors(LabelChecker::check, question1, question2);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateLabel.class);
    }

    @Test
    public void testDuplicateLabelsProducesWarnings() {
        final String question1 = "question1: \"Label 1\" boolean";
        final String question2 = "question2: \"Label 1\" boolean";
        final List<Error> validationErrors = getCheckerErrors(LabelChecker::check, question1, question2);

        assertThat(validationErrors.get(0).isFatal()).isFalse();
    }

    @Test
    public void testDuplicateLabelsNotSuccessive() {
        final String question1 = "question: \"Label 1\" boolean";
        final String question2 = "question2: \"Label 2\" boolean";
        final String question3 = "question3: \"Label 1\" boolean";
        final List<Error> validationErrors = getCheckerErrors(LabelChecker::check, question1, question2, question3);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateLabel.class);
    }

    @Test
    public void testDuplicateLabelsWithConditional() {
        final String question = "question1: \"Label\" boolean";
        final String ifStatement = " if (true) { question2: \"Label\" boolean }";

        final List<Error> validationErrors = getCheckerErrors(LabelChecker::check, question, ifStatement);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateLabel.class);
    }

    @Test
    public void testMultipleDuplicateLabelsWithConditional() {
        final String question1 = "question1: \"Label 1\" boolean";
        final String question2 = "question2: \"Label 1\" boolean";
        final String ifStatement = " if (true) { question3: \"Label 1\" boolean }";

        final List<Error> validationErrors = getCheckerErrors(LabelChecker::check, question1, question2, ifStatement);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateLabel.class);
    }

    @Test
    public void testDifferentDuplicateLabels() {
        final String question1 = "question1: \"test\" boolean";
        final String question2 = "question2: \"go\" boolean";
        final String question3 = "question3: \"test\" boolean";
        final String question4 = "question4: \"go\" boolean";

        final List<Error> validationErrors = getCheckerErrors(LabelChecker::check, question1, question2, question3,
                question4);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateLabel.class);
    }

}
