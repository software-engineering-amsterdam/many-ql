package nl.uva.softwcons.eval;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;

import nl.uva.softwcons.ast.expression.binary.arithmetic.Addition;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Division;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Multiplication;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Subtraction;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterOrEqual;
import nl.uva.softwcons.ast.expression.binary.logical.And;
import nl.uva.softwcons.ast.expression.binary.logical.Or;
import nl.uva.softwcons.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ast.expression.literal.DecimalLiteral;
import nl.uva.softwcons.ast.expression.literal.IntegerLiteral;
import nl.uva.softwcons.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ast.expression.unary.logical.Not;
import nl.uva.softwcons.eval.value.BooleanValue;
import nl.uva.softwcons.eval.value.DecimalValue;
import nl.uva.softwcons.eval.value.IntegerValue;

import org.junit.Before;
import org.junit.Test;

public class EvaluatorTest {

    IntegerLiteral intLiteral1;
    IntegerLiteral intLiteral2;

    DecimalLiteral decLiteral1;
    DecimalLiteral decLiteral2;

    BooleanLiteral boolTrueLiteral;
    BooleanLiteral boolFalseLiteral;

    StringLiteral strLiteral1;
    StringLiteral strLiteral2;
    Evaluator evaluator;

    @Before
    public void beforeEachSetRating() {
        evaluator = new Evaluator();
        intLiteral1 = new IntegerLiteral(1);
        intLiteral2 = new IntegerLiteral(2);

        decLiteral1 = new DecimalLiteral(1.5);
        decLiteral2 = new DecimalLiteral(2.5);

        boolTrueLiteral = new BooleanLiteral(true);
        boolFalseLiteral = new BooleanLiteral(false);

        strLiteral1 = new StringLiteral("string1");
        strLiteral2 = new StringLiteral("string2");
    }

    @Test
    public void testVisitAddition() {
        Addition exprInt = new Addition(intLiteral1, intLiteral2);
        Addition exprDec = new Addition(decLiteral1, decLiteral2);
        Addition exprMixed = new Addition(decLiteral2, intLiteral2);

        assertThat(evaluator.visit(exprInt).getValue()).isEqualTo(BigInteger.valueOf(3));
        assertThat(evaluator.visit(exprInt)).isExactlyInstanceOf(IntegerValue.class);
        assertThat(evaluator.visit(exprInt).getValue()).isExactlyInstanceOf(BigInteger.class);

        assertThat(evaluator.visit(exprDec)).isExactlyInstanceOf(DecimalValue.class);
        assertThat(evaluator.visit(exprDec).getValue()).isExactlyInstanceOf(BigDecimal.class);
        assertThat(((BigDecimal) evaluator.visit(exprDec).getValue()).compareTo(new BigDecimal(4))).isEqualTo(0);

        assertThat(evaluator.visit(exprMixed)).isExactlyInstanceOf(DecimalValue.class);
        assertThat(evaluator.visit(exprMixed).getValue()).isExactlyInstanceOf(BigDecimal.class);
        assertThat(((BigDecimal) evaluator.visit(exprMixed).getValue()).compareTo(new BigDecimal(4.5))).isEqualTo(0);
    }

    @Test
    public void testVisitSubtraction() {
        Subtraction exprInt = new Subtraction(intLiteral1, intLiteral2);

        Subtraction exprDec = new Subtraction(decLiteral1, decLiteral2);
        Subtraction exprMixed = new Subtraction(intLiteral1, decLiteral1);
        Subtraction exprMixed2 = new Subtraction(decLiteral1, intLiteral1);

        assertThat(evaluator.visit(exprInt).getValue()).isEqualTo(BigInteger.valueOf(-1));
        assertThat(evaluator.visit(exprInt)).isExactlyInstanceOf(IntegerValue.class);
        assertThat(evaluator.visit(exprInt).getValue()).isExactlyInstanceOf(BigInteger.class);

        assertThat(evaluator.visit(exprMixed).getValue()).isEqualTo(BigDecimal.valueOf(-0.5));
        assertThat(evaluator.visit(exprMixed)).isExactlyInstanceOf(DecimalValue.class);
        assertThat(evaluator.visit(exprMixed).getValue()).isExactlyInstanceOf(BigDecimal.class);

        assertThat(evaluator.visit(exprMixed2).getValue()).isEqualTo(BigDecimal.valueOf(0.5));
        assertThat(evaluator.visit(exprMixed2)).isExactlyInstanceOf(DecimalValue.class);
        assertThat(evaluator.visit(exprMixed2).getValue()).isExactlyInstanceOf(BigDecimal.class);

        assertThat(evaluator.visit(exprDec)).isExactlyInstanceOf(DecimalValue.class);
        assertThat(evaluator.visit(exprDec).getValue()).isExactlyInstanceOf(BigDecimal.class);
        assertThat(((BigDecimal) evaluator.visit(exprDec).getValue()).compareTo(new BigDecimal(-1))).isEqualTo(0);
    }

    @Test
    public void testVisitMultiplication() {
        Multiplication exprInt = new Multiplication(intLiteral1, intLiteral2);

        Multiplication exprDec = new Multiplication(decLiteral1, decLiteral2);

        assertThat(evaluator.visit(exprInt).getValue()).isEqualTo(BigInteger.valueOf(2));
        assertThat(evaluator.visit(exprInt)).isExactlyInstanceOf(IntegerValue.class);
        assertThat(evaluator.visit(exprInt).getValue()).isExactlyInstanceOf(BigInteger.class);

        assertThat(evaluator.visit(exprDec)).isExactlyInstanceOf(DecimalValue.class);
        assertThat(evaluator.visit(exprDec).getValue()).isExactlyInstanceOf(BigDecimal.class);
        assertThat(((BigDecimal) evaluator.visit(exprDec).getValue()).compareTo(new BigDecimal(1.5 * 2.5)))
                .isEqualTo(0);
    }

    @Test
    public void testVisitDivision() {
        Division exprInt = new Division(intLiteral1, intLiteral2);
        Division exprDec = new Division(decLiteral1, decLiteral2);

        assertThat(evaluator.visit(exprInt)).isExactlyInstanceOf(IntegerValue.class);
        assertThat(evaluator.visit(exprInt).getValue()).isExactlyInstanceOf(BigInteger.class);
        assertThat(evaluator.visit(exprInt).getValue()).isEqualTo(BigInteger.valueOf(0));

        assertThat(evaluator.visit(exprDec)).isExactlyInstanceOf(DecimalValue.class);
        assertThat(evaluator.visit(exprDec).getValue()).isExactlyInstanceOf(BigDecimal.class);
        BigDecimal result = new BigDecimal(1.5).divide(new BigDecimal(2.5));
        assertThat(((BigDecimal) evaluator.visit(exprDec).getValue()).compareTo(result)).isEqualTo(0);
    }

    @Test
    public void testVisitGE() {
        GreaterOrEqual exprInt = new GreaterOrEqual(intLiteral1, intLiteral2);
        GreaterOrEqual exprDec = new GreaterOrEqual(decLiteral2, decLiteral1);

        GreaterOrEqual exprMixed = new GreaterOrEqual(decLiteral2, intLiteral2);

        assertThat(evaluator.visit(exprInt)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprInt).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprInt).getValue()).isEqualTo(false);

        assertThat(evaluator.visit(exprDec)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprDec).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprDec).getValue()).isEqualTo(true);

        assertThat(evaluator.visit(exprMixed)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprMixed).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprMixed).getValue()).isEqualTo(true);
    }

    @Test
    public void testVisitAnd() {
        And exprAndFalse = new And(boolFalseLiteral, boolTrueLiteral);
        And exprAndTrue = new And(boolTrueLiteral, boolTrueLiteral);
        And exprAndFalse2 = new And(boolFalseLiteral, boolFalseLiteral);

        assertThat(evaluator.visit(exprAndFalse)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprAndFalse).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprAndFalse).getValue()).isEqualTo(false);

        assertThat(evaluator.visit(exprAndTrue)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprAndTrue).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprAndTrue).getValue()).isEqualTo(true);

        assertThat(evaluator.visit(exprAndFalse2)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprAndFalse2).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprAndFalse2).getValue()).isEqualTo(false);
    }

    @Test
    public void testVisitOr() {
        Or exprOrTrue = new Or(boolFalseLiteral, boolTrueLiteral);
        Or exprOrTrue2 = new Or(boolTrueLiteral, boolTrueLiteral);
        Or exprOrFalse = new Or(boolFalseLiteral, boolFalseLiteral);

        assertThat(evaluator.visit(exprOrTrue)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprOrTrue).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprOrTrue).getValue()).isEqualTo(true);

        assertThat(evaluator.visit(exprOrTrue2)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprOrTrue2).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprOrTrue2).getValue()).isEqualTo(true);

        assertThat(evaluator.visit(exprOrFalse)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprOrFalse).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprOrFalse).getValue()).isEqualTo(false);
    }

    @Test
    public void testVisitNot() {
        Not exprNotTrue = new Not(boolFalseLiteral);
        Not exprNotFalse = new Not(boolTrueLiteral);

        assertThat(evaluator.visit(exprNotTrue)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprNotTrue).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprNotTrue).getValue()).isEqualTo(true);

        assertThat(evaluator.visit(exprNotFalse)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprNotFalse).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprNotFalse).getValue()).isEqualTo(false);
    }

}
