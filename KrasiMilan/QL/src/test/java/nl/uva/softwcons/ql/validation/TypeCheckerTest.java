package nl.uva.softwcons.ql.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import nl.uva.softwcons.helper.TestHelper;
import nl.uva.softwcons.ql.Questionnaire;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.validation.typechecker.TypeChecker;
import nl.uva.softwcons.ql.validation.typechecker.error.DuplicateQuestionIdentifier;
import nl.uva.softwcons.ql.validation.typechecker.error.InvalidConditionType;
import nl.uva.softwcons.ql.validation.typechecker.error.InvalidOperatorTypes;
import nl.uva.softwcons.ql.validation.typechecker.error.InvalidQuestionExpressionType;
import nl.uva.softwcons.ql.validation.typechecker.error.UndefinedReference;

import org.junit.Test;

public class TypeCheckerTest {

    @Test
    public void validateNoInitialErrors() {
        final String question = "question: \"Label 1\" boolean";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).isEmpty();
    }

    @Test
    public void testDuplicateQuesionIdentifiers() {
        final String question = "question: \"Label 1\" boolean";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question, question);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testDuplicateQuesionIdentifiersNotSuccessive() {
        final String question1 = "question: \"Label 1\" boolean";
        final String question2 = "question2: \"Label 2\" boolean";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question1, question2, question1);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testDuplicateQuesionIdentifiersWithConditional() {
        final String question = "question: \"Label\" boolean";
        final String ifStatement = " if (true) { question: \"Label\" boolean }";

        final List<Error> validationErrors = getTypeCheckerValidationErrors(question, ifStatement);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testMultipleDuplicateQuesionIdentifiersWithConditional() {
        final String question = "question: \"Label 1\" boolean";
        final String ifStatement = " if (true) { question: \"Label\" boolean }";

        final List<Error> validationErrors = getTypeCheckerValidationErrors(question, question, ifStatement);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testDifferentDuplicateQuesionIdentifiers() {
        final String question = "question: \"Label\" boolean";
        final String question2 = "question2: \"Label\" boolean";

        final List<Error> validationErrors = getTypeCheckerValidationErrors(question, question2, question, question2);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).hasOnlyElementsOfType(DuplicateQuestionIdentifier.class);
    }

    @Test
    public void testValidQuestionWithBooleanType() {
        final String question = "question: \"Label 1\" boolean (true && false)";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).isEmpty();
    }

    @Test
    public void testValidQuestionWithNumberType() {
        final String question = "question: \"Label 1\" number (6 * 5.0)";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).isEmpty();
    }

    @Test
    public void testValidQuestionWithStringType() {
        final String question = "question: \"Label 1\" string (\"plain string\")";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).isEmpty();
    }

    @Test
    public void testValidConditionalWithBooleanExpressionType() {
        final String question = "if (true) { question: \"Label 1\" boolean }";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).isEmpty();
    }

    @Test
    public void testInvalidQuestionWithBooleanType() {
        final String question = "question: \"Label 1\" boolean (3 * 4)";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(InvalidQuestionExpressionType.class);
    }

    @Test
    public void testInvalidQuestionWithNumberType() {
        final String question = "question: \"Label 1\" number (true && false)";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(InvalidQuestionExpressionType.class);
    }

    @Test
    public void testInvalidQuestionWithStringType() {
        final String question = "question: \"Label 1\" string (6 * 5)";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(InvalidQuestionExpressionType.class);
    }

    @Test
    public void testInvalidConditionalWithDecimalExpressionType() {
        final String question = "if (6.0 * 5) { question: \"Label 1\" boolean }";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(InvalidConditionType.class);
    }

    @Test
    public void testInvalidConditionalWithNumberExpressionType() {
        final String question = "if (4 * 5) { question: \"Label 1\" boolean }";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(InvalidConditionType.class);
    }

    @Test
    public void testInvalidConditionalWithStringExpressionType() {
        final String question = "if (\"test\") { question: \"Label 1\" boolean }";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).hasOnlyElementsOfType(InvalidConditionType.class);
    }

    @Test
    public void testValidExpressionOperands() {
        final String question = "question: \"Label 1\" boolean(true)";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).isEmpty();
    }

    @Test
    public void testInvalidArithmeticExpressionOperands() {
        final String[] questions = { "question: \"Label 1\" number(6 + false)",
                "question: \"Label 1\" number(6 - false)", "question: \"Label 1\" number(6 * false)",
                "question: \"Label 1\" number(6 / false)" };

        for (final String question : questions) {
            final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

            assertThat(validationErrors).hasSize(1);
            assertThat(validationErrors).extracting("class").contains(InvalidOperatorTypes.class);
        }
    }

    @Test
    public void testInvalidComparisonExpressionOperands() {
        final String[] questions = { "question: \"Label 1\" boolean(6 < false)",
                "question: \"Label 1\" boolean(6 > false)", "question: \"Label 1\" boolean(6 >= false)",
                "question: \"Label 1\" boolean(6 <= false)" };

        for (final String question : questions) {
            final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

            assertThat(validationErrors).hasSize(1);
            assertThat(validationErrors).extracting("class").contains(InvalidOperatorTypes.class);
        }
    }

    @Test
    public void testInvalidLogicalExpressionOperands() {
        final String[] questions = { "question: \"Label 1\" boolean(6 && false)",
                "question: \"Label 1\" boolean(6 || false)", "question: \"Label 1\" boolean(!6)" };

        for (final String question : questions) {
            final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

            assertThat(validationErrors).hasSize(1);
            assertThat(validationErrors).extracting("class").contains(InvalidOperatorTypes.class);
        }
    }

    @Test
    public void testInvalidEqualityExpressionOperands() {
        final String[] questions = { "question: \"Label 1\" boolean(6 == false)",
                "question: \"Label 1\" boolean(6 != false)" };

        for (final String question : questions) {
            final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

            assertThat(validationErrors).hasSize(1);
            assertThat(validationErrors).extracting("class").contains(InvalidOperatorTypes.class);
        }
    }

    @Test
    public void testInvalidExpressionOperandsReferringAQuestion() {
        final String question1 = "question1: \"Label 1\" boolean";
        final String question2 = "question2: \"Label 2\" number(6 + question1)";

        final List<Error> validationErrors = getTypeCheckerValidationErrors(question1, question2);

        assertThat(validationErrors).hasSize(1);
        assertThat(validationErrors).extracting("class").contains(InvalidOperatorTypes.class);
    }

    @Test
    public void testUndefinedQuestionReferenceInComputedQuestion() {
        final String question = "question: \"Label 1\" boolean(notAQuestion)";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).extracting("class").contains(UndefinedReference.class,
                InvalidQuestionExpressionType.class);
    }

    @Test
    public void testUndefinedQuestionReferenceInConditional() {
        final String question = "if (notAQuestion) { question: \"Label 1\" boolean(true) }";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).extracting("class").contains(UndefinedReference.class, InvalidConditionType.class);
    }

    @Test
    public void testUndefinedQuestionReferenceNestedInConditional() {
        final String question = "if (notDefined > 4*(5 / 2)) { question: \"Label 1\" boolean(true) }";
        final List<Error> validationErrors = getTypeCheckerValidationErrors(question);

        assertThat(validationErrors).hasSize(2);
        assertThat(validationErrors).extracting("class").contains(UndefinedReference.class, InvalidOperatorTypes.class);
    }

    @Test
    public void testComplexFormWithMultipleErrors() {
        final String question1 = "question1: \"Label 1\" boolean";

        // reference to an undefined question, invalid operands in the division
        // expression
        final String question2 = "question2: \"Label 2\" number(question11 / 2)";

        // expression type not matching the question type
        final String question3 = "question3: \"Label 3\" number (1 == 0)";

        // invalid operands in the addition expression, invalid type for the
        // conditional and duplicate questions inside
        final String ifStatement = "if (question1 + (3 == 4)) { question11: \"Label 1\" boolean"
                + " question11: \"Label 1\" boolean }";

        final List<Error> validationErrors = getTypeCheckerValidationErrors(question1, question2, question3,
                ifStatement);

        assertThat(validationErrors).hasSize(6);
        assertThat(validationErrors).extracting("class").contains(UndefinedReference.class, InvalidOperatorTypes.class,
                InvalidQuestionExpressionType.class, InvalidOperatorTypes.class, InvalidConditionType.class,
                DuplicateQuestionIdentifier.class);
    }

    /**
     * TODO extract me into a common method when we create the checker
     * interface.
     * 
     * Builds a Form called always "form1" with the given statements (separating
     * them by newlines), runs the {@link TypeChecker} checker and returns the
     * list of found errors.
     * 
     * @param formContents
     *            The statements that will be included in the form
     * @return The errors found by the {@link TypeChecker} checker
     */
    private static List<Error> getTypeCheckerValidationErrors(final String... formContents) {
        Form form = Questionnaire.build(TestHelper.buildForm("form1", formContents));
        TypeChecker checker = new TypeChecker();
        form.accept(checker);

        return checker.getErrors();

    }
}
