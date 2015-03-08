package nl.uva.softwcons.ql.ast;

import static org.assertj.core.api.Assertions.assertThat;
import helper.TestHelper;
import nl.uva.softwcons.ql.Questionnaire;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Multiplication;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.type.BooleanType;
import nl.uva.softwcons.ql.ast.type.DateType;
import nl.uva.softwcons.ql.ast.type.NumberType;
import nl.uva.softwcons.ql.ast.type.StringType;
import nl.uva.softwcons.ql.ast.type.Type;

import org.junit.Test;

public class ASTBuilderVisitorTest {

    private static final Type[] ALL_PARSEABLE_TYPES = { BooleanType.instance, StringType.instance, DateType.instance,
            NumberType.instance };

    @Test
    public void testSingleQuestionInForm() {
        String questionText = "question: \"Label\" boolean";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText));
        Question question = (Question) form.getStatements().get(0);

        assertThat(form.getStatements().get(0)).isExactlyInstanceOf(Question.class);
        assertThat(question.getId().getName()).isEqualTo("question");
        assertThat(question.getLabel()).isEqualTo("Label");
    }

    @Test
    public void testMultipleQuestionsInForm() {
        String question1Text = "question1: \"Label 1\" boolean";
        String question2Text = "question2: \"Label 2\" boolean";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", question1Text, question2Text));
        Question question1 = (Question) form.getStatements().get(0);
        Question question2 = (Question) form.getStatements().get(1);

        assertThat(form.getStatements()).hasSize(2);
        assertThat(form.getStatements()).hasOnlyElementsOfType(Question.class);
        assertThat(question1.getId().getName()).isEqualTo("question1");
        assertThat(question1.getLabel()).isEqualTo("Label 1");
        assertThat(question2.getId().getName()).isEqualTo("question2");
        assertThat(question2.getLabel()).isEqualTo("Label 2");
    }

    @Test
    public void testAllQuestionTypes() {
        String booleanQuestion = "question: \"Label me\" boolean";
        String stringQuestion = "question: \"Label me\" string";
        String dateQuestion = "question: \"Label me\" date";
        String numberQuestion = "question: \"Label me\" number";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", booleanQuestion, stringQuestion, dateQuestion,
                numberQuestion));

        assertThat(form.getStatements()).extracting("type").contains((Object[]) ALL_PARSEABLE_TYPES);
    }

    @Test
    public void testSingleComputedQuestionInForm() {
        String questionText = "question: \"Label\" boolean (6 * 5)";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText));
        ComputedQuestion question = (ComputedQuestion) form.getStatements().get(0);

        assertThat(form.getStatements().get(0)).isExactlyInstanceOf(ComputedQuestion.class);
        assertThat(question.getId().getName()).isEqualTo("question");
        assertThat(question.getLabel()).isEqualTo("Label");
        assertThat(question.getExpression()).isInstanceOf(Expression.class);
    }

    @Test
    public void testMultipleComputedQuestionsInForm() {
        String question1Text = "question1: \"Label 1\" boolean (true)";
        String question2Text = "question2: \"Label 2\" boolean (6+2>3)";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", question1Text, question2Text));
        ComputedQuestion question1 = (ComputedQuestion) form.getStatements().get(0);
        ComputedQuestion question2 = (ComputedQuestion) form.getStatements().get(1);

        assertThat(form.getStatements()).hasSize(2);
        assertThat(form.getStatements()).hasOnlyElementsOfType(ComputedQuestion.class);
        assertThat(question1.getId().getName()).isEqualTo("question1");
        assertThat(question1.getLabel()).isEqualTo("Label 1");
        assertThat(question1.getExpression()).isInstanceOf(Expression.class);
        assertThat(question2.getId().getName()).isEqualTo("question2");
        assertThat(question2.getLabel()).isEqualTo("Label 2");
        assertThat(question2.getExpression()).isInstanceOf(Expression.class);
    }

    @Test
    public void testAllComputedQuestionTypes() {
        String booleanQuestion = "question: \"Label me\" boolean (1+2)";
        String stringQuestion = "question: \"Label me\" string (true)";
        String numberQuestion = "question: \"Label me\" number(1+2)";
        String dateQuestion = "question: \"Label me\" date(true)";
        Form form = Questionnaire.build(TestHelper.buildForm("form1", booleanQuestion, stringQuestion, numberQuestion,
                dateQuestion));

        assertThat(form.getStatements()).extracting("type").contains((Object[]) ALL_PARSEABLE_TYPES);
    }

    @Test
    public void testMultiplicationExpression() {
        String question = "question: \"Question\" number(1*2)";
        Form form = Questionnaire.build(buildForm("form1", question));
        assertThat(((ComputedQuestion) form.getStatements().get(0)).getExpression()).isExactlyInstanceOf(
                Multiplication.class);
    }

    private String buildForm(final String formName, final String... statements) {
        return String.format("form %s { %s }", formName, String.join(" ", statements));
    }
}
