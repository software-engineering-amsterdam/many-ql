package nl.uva.softwcons.qls.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import nl.uva.softwcons.helper.TestHelper;
import nl.uva.softwcons.ql.Questionnaire;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.validation.Error;
import nl.uva.softwcons.ql.validation.identifier.error.DuplicateQuestionIdentifier;
import nl.uva.softwcons.qls.StylesheetBuilder;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.validation.questionidentifier.QuestionIdentifierChecker;
import nl.uva.softwcons.qls.validation.questionidentifier.error.MissingQuestionIdentifier;
import nl.uva.softwcons.qls.validation.questionidentifier.error.UnknownQuestionIdentifier;

import org.junit.Test;

public class QuestionIdentifierCheckerTest {

    @Test
    public void testMissingIdentifierOnlyOneQuestionPresent() {
        List<Error> errors = getQuestionIdentifierErrors("page page1 { question q1 }");
        assertThat(errors).hasSize(1);
        assertThat(errors.get(0)).isExactlyInstanceOf(MissingQuestionIdentifier.class);
        assertThat(errors.get(0).getMessage()).contains("q2");
        assertThat(errors.get(0).getMessage()).contains("q3");
        assertThat(errors.get(0).getMessage()).doesNotContain("q1");
    }

    @Test
    public void testMissingIdentifierTwoQuestionsPresent() {
        List<Error> errors = getQuestionIdentifierErrors("page page1 { question q1 question q2 }");
        assertThat(errors).hasSize(1);
        assertThat(errors.get(0)).isExactlyInstanceOf(MissingQuestionIdentifier.class);
        assertThat(errors.get(0).getMessage()).contains("q3");
        assertThat(errors.get(0).getMessage()).doesNotContain("q1");
        assertThat(errors.get(0).getMessage()).doesNotContain("q2");
    }

    @Test
    public void testMissingIdentifierAllQuestionsPresent() {
        List<Error> errors = getQuestionIdentifierErrors("page page1 { question q1 question q2 question q3}");
        assertThat(errors).isEmpty();
    }

    @Test
    public void testDuplicateQuestionIdentifierOneDuplication() {
        List<Error> errors = getQuestionIdentifierErrors("page page1 { question q1 question q2 question q3 question q1}");
        assertThat(errors).hasSize(1);
        assertThat(errors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testDuplicateQuestionIdentifierTwoDuplications() {
        List<Error> errors = getQuestionIdentifierErrors("page page1 { question q1 question q3 question q2 question q3 question q1}");
        assertThat(errors).hasSize(2);
        assertThat(errors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testDuplicateQuestionIdentifierTwoSameDuplications() {
        List<Error> errors = getQuestionIdentifierErrors("page page1 { question q1 question q3 question q2 question q1 question q1}");
        assertThat(errors).hasSize(2);
        assertThat(errors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testUnknownQuestionIdentifierOne() {
        List<Error> errors = getQuestionIdentifierErrors("page page1 { question q1 question q3 question q2 question q4}");
        assertThat(errors).hasSize(1);
        assertThat(errors).hasOnlyElementsOfType(UnknownQuestionIdentifier.class);
    }

    @Test
    public void testUnknownQuestionIdentifierTwoEquals() {
        List<Error> errors = getQuestionIdentifierErrors("page page1 { question q1 question q3 question q2 question q4 question q4}");
        assertThat(errors).hasSize(3);
        assertThat(errors.get(0)).isExactlyInstanceOf(UnknownQuestionIdentifier.class);
        assertThat(errors.get(1)).isExactlyInstanceOf(UnknownQuestionIdentifier.class);
        assertThat(errors.get(2)).isExactlyInstanceOf(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testAllErrorsPresent() {
        List<Error> errors = getQuestionIdentifierErrors("page page1 { question q8 question q8}");
        assertThat(errors).hasSize(4);
        assertThat(errors.get(0)).isExactlyInstanceOf(UnknownQuestionIdentifier.class);
        assertThat(errors.get(1)).isExactlyInstanceOf(UnknownQuestionIdentifier.class);
        assertThat(errors.get(2)).isExactlyInstanceOf(DuplicateQuestionIdentifier.class);
        assertThat(errors.get(3)).isExactlyInstanceOf(MissingQuestionIdentifier.class);
        assertThat(errors.get(3).getMessage()).contains("q3");
        assertThat(errors.get(3).getMessage()).contains("q2");
        assertThat(errors.get(3).getMessage()).contains("q1");
    }

    @Test
    public void testMixedErrorsPresent() {
        List<Error> errors = getQuestionIdentifierErrors("page page1 { question q8 question q5 question q2}");
        assertThat(errors).hasSize(3);
        assertThat(errors.get(0)).isExactlyInstanceOf(UnknownQuestionIdentifier.class);
        assertThat(errors.get(1)).isExactlyInstanceOf(UnknownQuestionIdentifier.class);
        assertThat(errors.get(2)).isExactlyInstanceOf(MissingQuestionIdentifier.class);
        assertThat(errors.get(2).getMessage()).contains("q3");
        assertThat(errors.get(2).getMessage()).contains("q1");
        assertThat(errors.get(2).getMessage()).doesNotContain("q2");
    }

    private static Form getForm() {
        final String question1 = "q1: \"Label 1\" boolean";
        final String question2 = "q2: \"Label 2\" boolean";
        final String conditional1 = "if (q1) { q3: \"Label 1\" boolean(q1) }";
        return Questionnaire.build(TestHelper.buildForm("form1", question1, question2, conditional1));
    }

    private static List<Error> getQuestionIdentifierErrors(final String... stylesheetContents) {
        final Stylesheet stylesheet = StylesheetBuilder.build(TestHelper.buildStylesheet("stylesheet1",
                stylesheetContents));
        final QuestionIdentifierChecker checker = new QuestionIdentifierChecker(getForm());
        stylesheet.accept(checker);

        return checker.getErrors();

    }

}
