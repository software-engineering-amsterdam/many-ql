package nl.uva.softwcons.validation;

import static org.assertj.core.api.Assertions.assertThat;
import helper.TestHelper;
import nl.uva.softwcons.Questionnaire;
import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.form.Form;
import nl.uva.softwcons.ast.statement.ComputedQuestion;

import org.junit.Test;

public class VariableExtractorTest {

    @Test
    public void testNoExtractedVariablesFromLiterals() {
        assertThat(VariableExctractor.extractFrom(getExpression("false"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("0"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1.0"))).isEmpty();

        // empty string literal ""
        assertThat(VariableExctractor.extractFrom(getExpression("\"\""))).isEmpty();
    }

    @Test
    public void testSingleExtractedVariableFromIdentifierLiteral() {
        assertThat(VariableExctractor.extractFrom(getExpression("id"))).extracting("name").containsOnly("id");
    }

    @Test
    public void testAdditionExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 + 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 + var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var + var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo + bar + baz"))).extracting("name").containsOnly(
                "foo", "bar", "baz");
    }

    @Test
    public void testSubtractionExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 - 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 - var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var - var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo - bar - baz"))).extracting("name").containsOnly(
                "foo", "bar", "baz");
    }

    @Test
    public void testMultiplicationExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 * 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 * var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var * var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo * bar * baz"))).extracting("name").containsOnly(
                "foo", "bar", "baz");
    }

    @Test
    public void testDivisionExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 / 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 / var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var / var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo / bar / baz"))).extracting("name").containsOnly(
                "foo", "bar", "baz");
    }

    @Test
    public void testEqualsExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 == 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 == var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var == var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo == bar || baz == true"))).extracting("name")
                .containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testNotEqualsExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 != 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 != var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var != var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo != bar || baz != true"))).extracting("name")
                .containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testGreaterOrEqualExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 >= 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 >= var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var >= var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo >= bar || baz >= true"))).extracting("name")
                .containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testGreaterThanExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 > 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 > var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var > var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo > bar || baz > true"))).extracting("name")
                .containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testLowerOrEqualExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 <= 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 <= var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var <= var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo <= bar || baz <= true"))).extracting("name")
                .containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testLowerThanExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 < 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 < var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var < var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo < bar || baz < true"))).extracting("name")
                .containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testAndExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("true && false"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("true && var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var && var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo && bar && baz"))).extracting("name").containsOnly(
                "foo", "bar", "baz");
    }

    @Test
    public void testOrExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("true || false"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("true || var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var || var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo || bar || baz"))).extracting("name").containsOnly(
                "foo", "bar", "baz");
    }

    @Test
    public void testNotExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("!true"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("!var"))).extracting("name").containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("!var || !var"))).extracting("name")
                .containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("!foo || !bar || !baz"))).extracting("name")
                .containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testComplexAndNestedExpressionWithVariables() {
        final Expression expr = getExpression("(a > b) || (b > c && !(6*d + 15/e/e - f == 0))");

        assertThat(VariableExctractor.extractFrom(expr)).extracting("name").containsOnly("a", "b", "c", "d", "e", "f");
    }

    private Expression getExpression(final String expressionText) {
        final String questionText = "question: \"Label\" boolean(" + expressionText + ")";

        final Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText));
        final ComputedQuestion question = (ComputedQuestion) form.getBody().getStatements().get(0);

        return question.getExpression();
    }
}
