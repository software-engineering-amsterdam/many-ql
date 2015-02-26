package nl.uva.softwcons.validation;

import static org.assertj.core.api.Assertions.assertThat;
import helper.TestHelper;

import java.math.BigDecimal;

import nl.uva.softwcons.Questionnaire;
import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ast.expression.literal.DecimalLiteral;
import nl.uva.softwcons.ast.expression.literal.IntegerLiteral;
import nl.uva.softwcons.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ast.form.Form;
import nl.uva.softwcons.ast.statement.ComputedQuestion;

import org.junit.Test;

public class VariableExtractorTest {

    @Test
    public void testNoExtractedVariablesFromLiterals() {
        assertThat(VariableExctractor.extractFrom(new BooleanLiteral(false))).isEmpty();
        assertThat(VariableExctractor.extractFrom(new IntegerLiteral(0))).isEmpty();
        assertThat(VariableExctractor.extractFrom(new StringLiteral(""))).isEmpty();
        assertThat(VariableExctractor.extractFrom(new DecimalLiteral(BigDecimal.ONE))).isEmpty();
    }

    @Test
    public void testSingleExtractedVariableFromIdentifierLiteral() {
        final Identifier id = new Identifier("id");
        assertThat(VariableExctractor.extractFrom(id)).containsOnly("id");
    }

    @Test
    public void testAdditionExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 + 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 + var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var + var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo + bar + baz"))).containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testSubtractionExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 - 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 - var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var - var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo - bar - baz"))).containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testMultiplicationExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 * 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 * var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var * var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo * bar * baz"))).containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testDivisionExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 / 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 / var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var / var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo / bar / baz"))).containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testEqualsExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 == 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 == var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var == var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo == bar || baz == true"))).containsOnly("foo",
                "bar", "baz");
    }

    @Test
    public void testNotEqualsExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 != 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 != var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var != var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo != bar || baz != true"))).containsOnly("foo",
                "bar", "baz");
    }

    @Test
    public void testGreaterOrEqualExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 >= 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 >= var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var >= var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo >= bar || baz >= true"))).containsOnly("foo",
                "bar", "baz");
    }

    @Test
    public void testGreaterThanExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 > 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 > var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var > var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo > bar || baz > true"))).containsOnly("foo", "bar",
                "baz");
    }

    @Test
    public void testLowerOrEqualExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 <= 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 <= var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var <= var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo <= bar || baz <= true"))).containsOnly("foo",
                "bar", "baz");
    }

    @Test
    public void testLowerThanExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("1 < 1"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("1 < var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var < var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo < bar || baz < true"))).containsOnly("foo", "bar",
                "baz");
    }

    @Test
    public void testAndExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("true && false"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("true && var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var && var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo && bar && baz")))
                .containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testOrExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("true || false"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("true || var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("var || var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("foo || bar || baz")))
                .containsOnly("foo", "bar", "baz");
    }

    @Test
    public void testNotExpressionWithVariables() {
        assertThat(VariableExctractor.extractFrom(getExpression("!true"))).isEmpty();
        assertThat(VariableExctractor.extractFrom(getExpression("!var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("!var || !var"))).containsOnly("var");
        assertThat(VariableExctractor.extractFrom(getExpression("!foo || !bar || !baz"))).containsOnly("foo", "bar",
                "baz");
    }

    @Test
    public void testComplexAndNestedExpressionWithVariables() {
        final Expression expr = getExpression("(a > b) || (b > c && !(6*d + 15/e/e - f == 0))");

        assertThat(VariableExctractor.extractFrom(expr)).containsOnly("a", "b", "c", "d", "e", "f");
    }

    private Expression getExpression(final String expressionText) {
        final String questionText = "question: \"Label\" boolean(" + expressionText + ")";

        final Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText));
        final ComputedQuestion question = (ComputedQuestion) form.getBody().getStatements().get(0);

        return question.getExpression();
    }
}
