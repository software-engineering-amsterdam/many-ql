package nl.uva.softwcons.ql.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import nl.uva.softwcons.helper.TestHelper;
import nl.uva.softwcons.ql.Questionnaire;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.validation.Error;
import nl.uva.softwcons.ql.validation.dependency.CyclicDependencyChecker;
import nl.uva.softwcons.ql.validation.dependency.error.CyclicQuestionsDependency;

import org.junit.Test;

public class CyclicDependencyCheckerTest {

    @Test
    public void validateNoInitialCyclicDependencyErrors() {
        final String question = "question: \"Label 1\" boolean";
        final List<Error> validationErrors = getCyclicDependencyCheckerValidationErrors(question);

        assertThat(validationErrors).isEmpty();
    }

    @Test
    public void testCyclicQuestionDependencyError() {
        final String question1 = "question1: \"Label 1\" boolean(question1)";
        final List<Error> validationErrors = getCyclicDependencyCheckerValidationErrors(question1);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(CyclicQuestionsDependency.class);
    }

    @Test
    public void testCyclicQuestionDependencyInNestedExpression() {
        final String question1 = "question1: \"Label 1\" boolean(true != (false || x || question1))";
        final List<Error> validationErrors = getCyclicDependencyCheckerValidationErrors(question1);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(CyclicQuestionsDependency.class);
    }

    @Test
    public void testCyclicQuestionDependencyInConditional() {
        final String question1 = "if (true) { question1: \"Label 1\" boolean(question1) }";
        final List<Error> validationErrors = getCyclicDependencyCheckerValidationErrors(question1);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(CyclicQuestionsDependency.class);
    }

    @Test
    public void testReferenceToQuestionWithCyclicDependencyDoesNotProduceError() {
        final String question1 = "question1: \"Label 1\" boolean(question1)";
        final String question2 = "question2: \"Label 2\" boolean(question1)";
        final List<Error> validationErrors = getCyclicDependencyCheckerValidationErrors(question1, question2);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(CyclicQuestionsDependency.class);
    }

    @Test
    public void testCyclicQuestionDependencyErrorFoundOnceForEachVariable() {
        final String question1 = "question1: \"Label 1\" boolean(question1 != (question1 && question1 || question1))";
        final List<Error> validationErrors = getCyclicDependencyCheckerValidationErrors(question1);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(CyclicQuestionsDependency.class);
    }

    @Test
    public void testMultipleCyclicQuestionDependencyErrors() {
        final String question1 = "question1: \"Label 1\" boolean(true != (false || x || question1))";
        final String question2 = "question2: \"Label 1\" boolean(question2 != false)";
        final String question3 = "question3: \"Label 1\" boolean(question3 != true)";
        final List<Error> validationErrors = getCyclicDependencyCheckerValidationErrors(question1, question2, question3);

        assertThat(validationErrors).hasSize(3);
        assertThat(validationErrors).hasOnlyElementsOfType(CyclicQuestionsDependency.class);
    }

    /**
     * TODO extract me into a common method when we create the checker
     * interface.
     * 
     * Builds a Form called always "form1" with the given statements (separating
     * them by newlines), runs the {@link CyclicDependencyChecker} checker and
     * returns the list of found errors.
     * 
     * @param formContents
     *            The statements that will be included in the form
     * @return The errors found by the {@link CyclicDependencyChecker} checker
     */
    private static List<Error> getCyclicDependencyCheckerValidationErrors(final String... formContents) {
        final Form form = Questionnaire.build(TestHelper.buildForm("form1", formContents));
        final CyclicDependencyChecker checker = new CyclicDependencyChecker();
        form.accept(checker);

        return checker.getErrors();

    }
}
