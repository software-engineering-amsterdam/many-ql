package nl.uva.softwcons.ql.eval;

import static helper.TestHelper.QUESTION;
import static helper.TestHelper.QUESTION2;
import static helper.TestHelper.UNUSED;
import static org.assertj.core.api.Assertions.assertThat;
import helper.TestHelper;

import java.util.List;
import java.util.stream.Collectors;

import nl.uva.softwcons.ql.Questionnaire;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;

import org.junit.Test;

public class ReferencesResolverTest {

    @Test
    public void testResolvingReferencedConditionalsForUnusedVariable() {
        String questionText = "question: \"Label\" boolean";
        String conditionText = "if (question) { question2: \"Label\" boolean }";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText, conditionText));
        ReferencesResolver referencesResolver = new ReferencesResolver(form);

        assertThat(referencesResolver.getReferencedConditionals(UNUSED)).isEmpty();
    }

    @Test
    public void testResolvingReferencedQuestionsForUnusedVariable() {
        String questionText = "question: \"Label\" boolean";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText));
        ReferencesResolver referencesResolver = new ReferencesResolver(form);

        assertThat(referencesResolver.getReferencedQuestions(UNUSED)).isEmpty();
    }

    @Test
    public void testResolvingReferencedConditionalsForUnboundedVariable() {
        String questionText = "question: \"Label\" boolean";
        String conditionText = "if (test) { question2: \"Label\" boolean }";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText, conditionText));
        ReferencesResolver referencesResolver = new ReferencesResolver(form);

        assertThat(referencesResolver.getReferencedConditionals(QUESTION)).isEmpty();
    }

    @Test
    public void testResolvingReferencedQuestionsForUnboundedVariable() {
        String questionText = "question: \"Label\" boolean";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText));
        ReferencesResolver referencesResolver = new ReferencesResolver(form);

        assertThat(referencesResolver.getReferencedQuestions(QUESTION)).isEmpty();
    }

    @Test
    public void testResolvingReferencedConditionalsForQuestionBoundedVariable() {
        String questionText = "question: \"Label\" boolean (question != true)";
        String conditionText = "if (test) { question2: \"Label\" boolean }";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText, conditionText));
        ReferencesResolver referencesResolver = new ReferencesResolver(form);

        assertThat(referencesResolver.getReferencedConditionals(QUESTION)).isEmpty();
    }

    @Test
    public void testResolvingReferencedQuestionsForConditionalBoundedVariable() {
        String questionText = "question: \"Label\" boolean";
        String conditionText = "if (question) { question2: \"Label\" boolean }";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText, conditionText));
        ReferencesResolver referencesResolver = new ReferencesResolver(form);

        assertThat(referencesResolver.getReferencedQuestions(QUESTION)).isEmpty();
    }

    @Test
    public void testResolvingReferencedConditionalsForBoundedVariable() {
        String conditionText = "if (question) { question2: \"Label\" boolean }";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", conditionText));
        Conditional conditionForQuestion = (Conditional) form.getStatements().get(0);
        ReferencesResolver referencesResolver = new ReferencesResolver(form);

        assertThat(referencesResolver.getReferencedConditionals(QUESTION)).containsOnly(conditionForQuestion);
    }

    @Test
    public void testResolvingReferencedQuestionsForBoundedVariable() {
        String questionText = "question1: \"Label\" boolean (question != true)";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText));
        ComputedQuestion question1 = (ComputedQuestion) form.getStatements().get(0);
        ReferencesResolver referencesResolver = new ReferencesResolver(form);

        assertThat(referencesResolver.getReferencedQuestions(QUESTION)).containsOnly(question1);
    }

    @Test
    public void testResolvingMultipleConditionalReferencesForBoundedVariable() {
        String condition1Text = "if (question != true) { question1: \"Label\" boolean }";
        String condition2Text = "if (question || false) { question2: \"Label\" boolean }";
        String condition3Text = "if (question > 1) { question3: \"Label\" boolean }";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", condition1Text, condition2Text, condition3Text));
        ReferencesResolver referencesResolver = new ReferencesResolver(form);

        // convert all statements to conditionals for easier assertion
        List<Conditional> expectedConditionals = form.getStatements().stream().map(Conditional.class::cast)
                .collect(Collectors.toList());

        assertThat(referencesResolver.getReferencedConditionals(QUESTION)).hasSize(3);
        assertThat(referencesResolver.getReferencedConditionals(QUESTION)).containsExactlyElementsOf(
                expectedConditionals);
    }

    @Test
    public void testResolvingMultipleQuestionReferencesForBoundedVariable() {
        String question1Text = "question1: \"Label\" boolean (question != true)";
        String question2Text = "question2: \"Label\" boolean (question > 2)";
        String question3Text = "question3: \"Label\" boolean (question + 2 - 1 == 5)";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", question1Text, question2Text, question3Text));
        ReferencesResolver referencesResolver = new ReferencesResolver(form);

        // convert all statements to computed questions for easier assertion
        List<ComputedQuestion> expectedConditionals = form.getStatements().stream().map(ComputedQuestion.class::cast)
                .collect(Collectors.toList());

        assertThat(referencesResolver.getReferencedQuestions(QUESTION)).hasSize(3);
        assertThat(referencesResolver.getReferencedQuestions(QUESTION)).containsExactlyElementsOf(expectedConditionals);
    }

    @Test
    public void testResolvingBothQuestionAndConditionalReferencesForBoundedVariables() {
        String question1Text = "question1: \"Label\" boolean (question != true)";
        String condition1Text = "if (question) { question2: \"Label\" boolean (question > 2) }";
        String condition2Text = "if (question2) { question3: \"Label\" boolean }";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", question1Text, condition1Text, condition2Text));
        ReferencesResolver referencesResolver = new ReferencesResolver(form);

        // expected results
        ComputedQuestion question1 = (ComputedQuestion) form.getStatements().get(0);
        Conditional conditional1 = (Conditional) form.getStatements().get(1);
        ComputedQuestion question2 = (ComputedQuestion) conditional1.getQuestions().get(0);
        Conditional conditional2 = (Conditional) form.getStatements().get(2);

        assertThat(referencesResolver.getReferencedQuestions(QUESTION)).containsExactly(question1, question2);
        assertThat(referencesResolver.getReferencedConditionals(QUESTION)).containsExactly(conditional1);
        assertThat(referencesResolver.getReferencedConditionals(QUESTION2)).containsExactly(conditional2);
    }
}
