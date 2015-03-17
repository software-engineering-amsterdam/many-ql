package nl.uva.softwcons.ql.eval;

import static nl.uva.softwcons.helper.TestHelper.DUMMY_LINE_INFO;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Addition;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Division;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Multiplication;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Subtraction;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.GreaterOrEqual;
import nl.uva.softwcons.ql.ast.expression.binary.logical.And;
import nl.uva.softwcons.ql.ast.expression.binary.logical.Or;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ql.ast.expression.literal.NumberLiteral;
import nl.uva.softwcons.ql.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ql.ast.expression.unary.logical.Not;
import nl.uva.softwcons.ql.eval.value.BooleanValue;
import nl.uva.softwcons.ql.eval.value.NumberValue;
import nl.uva.softwcons.ql.eval.value.UndefinedValue;

import org.junit.Test;

public class ExpressionEvaluatorTest {
    private static final NumberLiteral INT_1 = new NumberLiteral(1, DUMMY_LINE_INFO);
    private static final NumberLiteral INT_2 = new NumberLiteral(2, DUMMY_LINE_INFO);

    private static final NumberLiteral DEC_1_5 = new NumberLiteral(1.5, DUMMY_LINE_INFO);
    private static final NumberLiteral DEC_2_5 = new NumberLiteral(2.5, DUMMY_LINE_INFO);

    private static final BooleanLiteral TRUE = new BooleanLiteral(true, DUMMY_LINE_INFO);
    private static final BooleanLiteral FALSE = new BooleanLiteral(false, DUMMY_LINE_INFO);

    // TODO add tests for strings
    private static final StringLiteral STR_FOO = new StringLiteral("foo", DUMMY_LINE_INFO);
    private static final StringLiteral STR_BAR = new StringLiteral("bar", DUMMY_LINE_INFO);

    @Test
    public void testIntegerAddition() {
        final Addition exprInt = new Addition(INT_1, INT_2, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprInt, null)).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprInt, null).getNumber()).isEqualTo("3");
    }

    @Test
    public void testDecimalAddition() {
        final Addition exprDec = new Addition(DEC_1_5, DEC_2_5, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprDec, null)).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprDec, null).getNumber()).isEqualTo("4.0");
    }

    @Test
    public void testMixedAddition() {
        final Addition exprMixed = new Addition(DEC_2_5, INT_2, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprMixed, null)).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprMixed, null).getNumber()).isEqualTo("4.5");
    }

    @Test
    public void testIntegerSubtraction() {
        final Subtraction exprInt = new Subtraction(INT_1, INT_2, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers()).getNumber()).isEqualTo("-1");
        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);

    }

    @Test
    public void testDecimalSubtraction() {
        final Subtraction exprDec = new Subtraction(DEC_1_5, DEC_2_5, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers()).getNumber()).isEqualTo("-1.0");
    }

    @Test
    public void testMixedSubtraction() {
        final Subtraction exprMixed = new Subtraction(INT_1, DEC_1_5, DUMMY_LINE_INFO);
        final Subtraction exprMixed2 = new Subtraction(DEC_1_5, INT_1, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprMixed, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprMixed, new FormAnswers()).getNumber()).isEqualTo("-0.5");

        assertThat(ExpressionEvaluator.evaluate(exprMixed2, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprMixed2, new FormAnswers()).getNumber()).isEqualTo("0.5");

    }

    @Test
    public void testIntegerMultiplication() {
        final Multiplication exprInt = new Multiplication(INT_1, INT_2, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers()).getNumber()).isEqualTo("2");

    }

    @Test
    public void testDecimalMultiplication() {
        final Multiplication exprDec = new Multiplication(DEC_1_5, DEC_2_5, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers()).getNumber()).isEqualTo("3.75");
    }

    @Test
    public void testMixedMultiplication() {
        final Multiplication exprDec = new Multiplication(INT_1, DEC_2_5, DUMMY_LINE_INFO);
        final Multiplication exprDec2 = new Multiplication(DEC_2_5, INT_1, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers()).getNumber()).isEqualTo("2.5");

        assertThat(ExpressionEvaluator.evaluate(exprDec2, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprDec2, new FormAnswers()).getNumber()).isEqualTo("2.5");
    }

    @Test
    public void testIntegerDivision() {
        final Division exprInt = new Division(INT_1, INT_2, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers()).getNumber()).isEqualTo("0.5");
    }

    @Test
    public void testDecimalDivision() {
        final Division exprDec = new Division(DEC_1_5, DEC_2_5, DUMMY_LINE_INFO);
        final BigDecimal expected = new BigDecimal(1.5).divide(new BigDecimal(2.5));

        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers()).getNumber()).isEqualByComparingTo(expected);
    }

    @Test
    public void testMixedDivision() {
        final Division exprMixed = new Division(new NumberLiteral(3, DUMMY_LINE_INFO), DEC_1_5, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprMixed, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprMixed, new FormAnswers()).getNumber()).isEqualTo("2");
    }

    @Test
    public void testVisitGE() {
        GreaterOrEqual exprInt = new GreaterOrEqual(INT_1, INT_2, DUMMY_LINE_INFO);
        GreaterOrEqual exprDec = new GreaterOrEqual(DEC_2_5, DEC_1_5, DUMMY_LINE_INFO);

        GreaterOrEqual exprMixed = new GreaterOrEqual(DEC_2_5, INT_2, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers())).isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers()).getBoolean()).isEqualTo(false);

        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers())).isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers()).getBoolean()).isEqualTo(true);

        assertThat(ExpressionEvaluator.evaluate(exprMixed, new FormAnswers())).isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprMixed, new FormAnswers()).getBoolean()).isEqualTo(true);
    }

    @Test
    public void testVisitAnd() {
        And exprAndFalse = new And(FALSE, TRUE, DUMMY_LINE_INFO);
        And exprAndTrue = new And(TRUE, TRUE, DUMMY_LINE_INFO);
        And exprAndFalse2 = new And(FALSE, FALSE, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprAndFalse, new FormAnswers())).isExactlyInstanceOf(
                BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprAndFalse, new FormAnswers()).getBoolean()).isEqualTo(false);

        assertThat(ExpressionEvaluator.evaluate(exprAndTrue, new FormAnswers()))
                .isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprAndTrue, new FormAnswers()).getBoolean()).isEqualTo(true);

        assertThat(ExpressionEvaluator.evaluate(exprAndFalse2, new FormAnswers())).isExactlyInstanceOf(
                BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprAndFalse2, new FormAnswers()).getBoolean()).isEqualTo(false);
    }

    @Test
    public void testVisitOr() {
        Or exprOrTrue = new Or(FALSE, TRUE, DUMMY_LINE_INFO);
        Or exprOrTrue2 = new Or(TRUE, TRUE, DUMMY_LINE_INFO);
        Or exprOrFalse = new Or(FALSE, FALSE, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprOrTrue, new FormAnswers())).isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprOrTrue, new FormAnswers()).getBoolean()).isEqualTo(true);

        assertThat(ExpressionEvaluator.evaluate(exprOrTrue2, new FormAnswers()))
                .isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprOrTrue2, new FormAnswers()).getBoolean()).isEqualTo(true);

        assertThat(ExpressionEvaluator.evaluate(exprOrFalse, new FormAnswers()))
                .isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprOrFalse, new FormAnswers()).getBoolean()).isEqualTo(false);
    }

    @Test
    public void testVisitNot() {
        Not exprNotTrue = new Not(FALSE, DUMMY_LINE_INFO);
        Not exprNotFalse = new Not(TRUE, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprNotTrue, new FormAnswers()))
                .isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprNotTrue, new FormAnswers()).getBoolean()).isEqualTo(true);

        assertThat(ExpressionEvaluator.evaluate(exprNotFalse, new FormAnswers())).isExactlyInstanceOf(
                BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprNotFalse, new FormAnswers()).getBoolean()).isEqualTo(false);
    }

    @Test
    public void testAnswersValuesStorage() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final Identifier id2 = new Identifier("id2", DUMMY_LINE_INFO);
        final Addition exprWithVariables = new Addition(id1, id2, DUMMY_LINE_INFO);

        final FormAnswers answers = new FormAnswers();
        answers.setValue(id1, new NumberValue(1));
        answers.setValue(id2, new NumberValue(2));

        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers).getNumber()).isEqualTo("3");
    }

    @Test
    public void testEvaluateUnknownIdentifierAsUndefined() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final FormAnswers answers = new FormAnswers();

        assertThat(ExpressionEvaluator.evaluate(id1, answers)).isExactlyInstanceOf(UndefinedValue.class);
    }

    @Test
    public void testUndefinedAsLeftOperandAdition() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final Identifier id2 = new Identifier("id2", DUMMY_LINE_INFO);
        final Addition exprWithVariables = new Addition(id1, id2, DUMMY_LINE_INFO);

        final FormAnswers answers = new FormAnswers();
        answers.setValue(id2, new NumberValue(2));

        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(UndefinedValue.class);
    }

    @Test
    public void testUndefinedAsRightOperandAdition() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final Identifier id2 = new Identifier("id2", DUMMY_LINE_INFO);
        final Addition exprWithVariables = new Addition(id1, id2, DUMMY_LINE_INFO);

        final FormAnswers answers = new FormAnswers();
        answers.setValue(id1, new NumberValue(2));

        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(UndefinedValue.class);
    }

    @Test
    public void testUndefinedAsLeftOperandSubtraction() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final Identifier id2 = new Identifier("id2", DUMMY_LINE_INFO);
        final Subtraction exprWithVariables = new Subtraction(id1, id2, DUMMY_LINE_INFO);

        final FormAnswers answers = new FormAnswers();
        answers.setValue(id2, new NumberValue(2));

        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(UndefinedValue.class);
    }

    @Test
    public void testUndefinedAsRightOperandSubtraction() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final Identifier id2 = new Identifier("id2", DUMMY_LINE_INFO);
        final Subtraction exprWithVariables = new Subtraction(id1, id2, DUMMY_LINE_INFO);

        final FormAnswers answers = new FormAnswers();
        answers.setValue(id1, new NumberValue(2));

        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(UndefinedValue.class);
        answers.setValue(id2, new NumberValue(1));
        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers).getNumber()).isEqualTo("1");

    }

    @Test
    public void testUndefinedAsLeftOperandAnd() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final Identifier id2 = new Identifier("id2", DUMMY_LINE_INFO);
        final And exprWithVariables = new And(id1, id2, DUMMY_LINE_INFO);

        final FormAnswers answers = new FormAnswers();
        answers.setValue(id2, new BooleanValue(true));
        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(UndefinedValue.class);

        answers.setValue(id1, new BooleanValue(true));
        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers).getBoolean()).isEqualTo(true);

    }

    @Test
    public void testUndefinedAsRightOperandOr() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final Identifier id2 = new Identifier("id2", DUMMY_LINE_INFO);
        final Or exprWithVariables = new Or(id1, id2, DUMMY_LINE_INFO);

        final FormAnswers answers = new FormAnswers();
        answers.setValue(id1, new BooleanValue(false));

        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(UndefinedValue.class);
        answers.setValue(id2, new BooleanValue(false));

        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers).getBoolean()).isEqualTo(false);
    }

    @Test
    public void testUndefinedNot() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final Not exprWithVariables = new Not(id1, DUMMY_LINE_INFO);

        final FormAnswers answers = new FormAnswers();

        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(UndefinedValue.class);
        answers.setValue(id1, new BooleanValue(false));

        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers).getBoolean()).isEqualTo(true);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNumberBooleanAddition() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final Addition exprWithVariables = new Addition(INT_1, id1, DUMMY_LINE_INFO);

        final FormAnswers answers = new FormAnswers();
        answers.setValue(id1, new BooleanValue(false));

        ExpressionEvaluator.evaluate(exprWithVariables, answers);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testStringBooleanAddition() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final Addition exprWithVariables = new Addition(STR_BAR, id1, DUMMY_LINE_INFO);

        final FormAnswers answers = new FormAnswers();
        answers.setValue(id1, new BooleanValue(false));

        ExpressionEvaluator.evaluate(exprWithVariables, answers);
    }

}
