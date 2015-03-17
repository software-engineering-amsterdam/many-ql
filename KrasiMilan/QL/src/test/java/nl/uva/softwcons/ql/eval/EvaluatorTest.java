package nl.uva.softwcons.ql.eval;

import static nl.uva.softwcons.helper.TestHelper.DUMMY_LINE_INFO;
import static nl.uva.softwcons.helper.TestHelper.QUESTION;
import static nl.uva.softwcons.helper.TestHelper.QUESTION2;
import static nl.uva.softwcons.helper.TestHelper.QUESTION3;
import static nl.uva.softwcons.helper.TestHelper.UNUSED;
import static nl.uva.softwcons.ql.eval.value.UndefinedValue.UNDEFINED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import nl.uva.softwcons.helper.TestHelper;
import nl.uva.softwcons.ql.Questionnaire;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.statement.Computable;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.eval.value.BooleanValue;
import nl.uva.softwcons.ql.eval.value.NumberValue;
import nl.uva.softwcons.ql.eval.value.Value;

import org.junit.Test;
import org.mockito.ArgumentMatcher;

public class EvaluatorTest {

    private static final Identifier QUESTION4 = new Identifier("question4", DUMMY_LINE_INFO);

    private static final class BooleanValueMatcher extends ArgumentMatcher<Value> {
        private final boolean expectedValue;

        public BooleanValueMatcher(boolean expectedValue) {
            this.expectedValue = expectedValue;
        }

        @Override
        public boolean matches(Object argument) {
            return ((Value) argument).getBoolean() == expectedValue;
        }
    }

    @Test
    public void testGettingANonexistentValue() {
        String questionText = "question: \"Label\" boolean";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText));

        assertThat(new Evaluator(form).getValue(UNUSED)).isEqualTo(UNDEFINED);
    }

    @Test
    public void testGettingANonfiledQuestionValue() {
        String questionText = "question: \"Label\" boolean";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText));

        assertThat(new Evaluator(form).getValue(QUESTION)).isEqualTo(UNDEFINED);
    }

    @Test
    public void testGettingAYetNoncomputableValue() {
        String question1Text = "question: \"Label\" boolean";
        String question2Text = "question2: \"Label\" boolean(question != true)";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", question1Text, question2Text));

        assertThat(new Evaluator(form).getValue(QUESTION2)).isEqualTo(UNDEFINED);
    }

    @Test
    public void testGettingComputableQuestionValues() {
        String question1Text = "question: \"Label\" boolean (true != false)";
        String question2Text = "question2: \"Label\" number (6 * 5)";
        String question3Text = "question3: \"Label\" number (\"lazy\")";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", question1Text, question2Text, question3Text));

        assertThat(new Evaluator(form).getValue(QUESTION).getBoolean()).isEqualTo(true);
        assertThat(new Evaluator(form).getValue(QUESTION2).getNumber()).isEqualTo("30");
        assertThat(new Evaluator(form).getValue(QUESTION3).getString()).isEqualTo("lazy");
    }

    @Test
    public void testGettingAValueAfterManuallySettingIt() {
        String questionText = "question: \"Label\" boolean";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText));
        Evaluator e = new Evaluator(form);

        e.updateValue(QUESTION, new BooleanValue(true));

        assertThat(e.getValue(QUESTION).getBoolean()).isEqualTo(true);
    }

    @Test
    public void testThatUpdatingValuesIsPropagatedToReferences() {
        String questionText = "question: \"Label\" number";
        String question2Text = "question2: \"Label\" boolean (question > 0)";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText, question2Text));
        Evaluator e = new Evaluator(form);

        assertThat(e.getValue(QUESTION2)).isEqualTo(UNDEFINED);

        e.updateValue(QUESTION, new NumberValue(1));

        assertThat(e.getValue(QUESTION2).getBoolean()).isEqualTo(true);
    }

    @Test
    public void testThatUpdatingValuesIsPropagatedToReferencesInConditionals() {
        String questionText = "question: \"Label\" number";
        String question2Text = "if (true) { question2: \"Label\" number (question * 10) }";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText, question2Text));
        Evaluator e = new Evaluator(form);

        assertThat(e.getValue(QUESTION2)).isEqualTo(UNDEFINED);

        e.updateValue(QUESTION, new NumberValue(1));

        assertThat(e.getValue(QUESTION2).getNumber()).isEqualTo("10");
    }

    @Test
    public void testThatUpdatingValuesIsPropagatedAllTheWay() {
        String questionText = "question: \"Label\" number";
        String question2Text = "question2: \"Label\" boolean (question > 0)";
        String question3Text = "question3: \"Label\" boolean (question2 == true)";
        String question4Text = "question4: \"Label\" boolean (question3 == false)";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText, question2Text, question3Text,
                question4Text));
        Evaluator e = new Evaluator(form);

        assertThat(e.getValue(QUESTION2)).isEqualTo(UNDEFINED);
        assertThat(e.getValue(QUESTION3)).isEqualTo(UNDEFINED);
        assertThat(e.getValue(QUESTION4)).isEqualTo(UNDEFINED);

        e.updateValue(QUESTION, new NumberValue(1));

        assertThat(e.getValue(QUESTION2).getBoolean()).isEqualTo(true);
        assertThat(e.getValue(QUESTION3).getBoolean()).isEqualTo(true);
        assertThat(e.getValue(QUESTION4).getBoolean()).isEqualTo(false);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testThatCallbacksForQuestionsAreCalledAfterValueUpdate() {
        String questionText = "question: \"Label\" number";
        String question2Text = "question2: \"Label\" boolean (question > 0)";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText, question2Text));
        Evaluator e = new Evaluator(form);

        // add listener to "question2"
        ValueChangeListener<Value> listener = mock(ValueChangeListener.class);
        e.addListener((Computable) form.getStatements().get(1), listener);

        // verify it is not called before the update of "question"
        verify(listener, never()).processValueChange(null);

        e.updateValue(QUESTION, new NumberValue(1));

        // verify callback is called with the correct value
        verify(listener).processValueChange(argThat(new BooleanValueMatcher(true)));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testThatCallbacksForConditionalsAreCalledAfterValueUpdate() {
        String questionText = "question: \"Label\" number";
        String question2Text = "if (question > 0) { question2: \"Label\" boolean }";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText, question2Text));
        Evaluator e = new Evaluator(form);

        // add listener to the conditional
        ValueChangeListener<Value> listener = mock(ValueChangeListener.class);
        e.addListener((Computable) form.getStatements().get(1), listener);

        // verify it is not called before the update of "question"
        verify(listener, never()).processValueChange(null);

        e.updateValue(QUESTION, new NumberValue(1));

        // verify callback is called with the correct value
        verify(listener).processValueChange(argThat(new BooleanValueMatcher(true)));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testThatCallbacksForInsideConditionalsAreCalledAfterValueUpdate() {
        String questionText = "question: \"Label\" number";
        String conditionalText = "if (true) { question2: \"Label\" boolean (question > 0) }";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText, conditionalText));
        Conditional conditional = (Conditional) form.getStatements().get(1);
        Evaluator e = new Evaluator(form);

        // add listener to "question2"
        ValueChangeListener<Value> listener = mock(ValueChangeListener.class);
        e.addListener((ComputedQuestion) conditional.getQuestions().get(0), listener);

        // verify it is not called before the update of "question"
        verify(listener, never()).processValueChange(null);

        e.updateValue(QUESTION, new NumberValue(1));

        // verify callback is called with the correct value
        verify(listener).processValueChange(argThat(new BooleanValueMatcher(true)));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testThatCallbacksAreCalledAfterValueUpdateAllTheWay() {
        String questionText = "question: \"Label\" number";
        String question2Text = "question2: \"Label\" boolean (question > 0)";
        String question3Text = "question3: \"Label\" boolean (question2 == true)";
        String question4Text = "question4: \"Label\" boolean (question3 == false)";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText, question2Text, question3Text,
                question4Text));
        Evaluator e = new Evaluator(form);

        // add listeners to all computed questions
        ValueChangeListener<Value> question2listener = mock(ValueChangeListener.class);
        ValueChangeListener<Value> question3listener = mock(ValueChangeListener.class);
        ValueChangeListener<Value> question4listener = mock(ValueChangeListener.class);
        e.addListener((Computable) form.getStatements().get(1), question2listener);
        e.addListener((Computable) form.getStatements().get(2), question3listener);
        e.addListener((Computable) form.getStatements().get(3), question4listener);

        // verify nothing is called before the update of "question"
        verify(question2listener, never()).processValueChange(null);
        verify(question3listener, never()).processValueChange(null);
        verify(question4listener, never()).processValueChange(null);

        e.updateValue(QUESTION, new NumberValue(1));

        // verify callbacks are called with the correct values
        verify(question2listener).processValueChange(argThat(new BooleanValueMatcher(true)));
        verify(question3listener).processValueChange(argThat(new BooleanValueMatcher(true)));
        verify(question4listener).processValueChange(argThat(new BooleanValueMatcher(false)));
    }

}
