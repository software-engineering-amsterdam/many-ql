package nl.uva.softwcons.eval;

import static helper.TestHelper.DUMMY_LINE_INFO;
import static org.assertj.core.api.Assertions.assertThat;
import helper.TestHelper;

import java.math.BigDecimal;
import java.math.BigInteger;

import nl.uva.softwcons.Questionnaire;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Addition;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Division;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Multiplication;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Subtraction;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterOrEqual;
import nl.uva.softwcons.ast.expression.binary.logical.And;
import nl.uva.softwcons.ast.expression.binary.logical.Or;
import nl.uva.softwcons.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ast.expression.literal.DecimalLiteral;
import nl.uva.softwcons.ast.expression.literal.IntegerLiteral;
import nl.uva.softwcons.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ast.expression.unary.logical.Not;
import nl.uva.softwcons.ast.form.Form;
import nl.uva.softwcons.eval.value.BooleanValue;
import nl.uva.softwcons.eval.value.DecimalValue;
import nl.uva.softwcons.eval.value.IntegerValue;

import org.junit.Before;
import org.junit.Test;

public class EvaluatorTest {

    private IntegerLiteral intLiteral1;
    private IntegerLiteral intLiteral2;

    private DecimalLiteral decLiteral1;
    private DecimalLiteral decLiteral2;

    private BooleanLiteral boolTrueLiteral;
    private BooleanLiteral boolFalseLiteral;

    private StringLiteral strLiteral1;
    private StringLiteral strLiteral2;
    private Evaluator evaluator;

    @Before
    public void beforeEachSetRating() {
        evaluator = new Evaluator(null);
        intLiteral1 = new IntegerLiteral(1, DUMMY_LINE_INFO);
        intLiteral2 = new IntegerLiteral(2, DUMMY_LINE_INFO);

        decLiteral1 = new DecimalLiteral(1.5, DUMMY_LINE_INFO);
        decLiteral2 = new DecimalLiteral(2.5, DUMMY_LINE_INFO);

        boolTrueLiteral = new BooleanLiteral(true, DUMMY_LINE_INFO);
        boolFalseLiteral = new BooleanLiteral(false, DUMMY_LINE_INFO);

        // TODO add tests for strings
        strLiteral1 = new StringLiteral("string1", DUMMY_LINE_INFO);
        strLiteral2 = new StringLiteral("string2", DUMMY_LINE_INFO);
    }

    @Test
    public void testVisitAddition() {
        Addition exprInt = new Addition(intLiteral1, intLiteral2, DUMMY_LINE_INFO);
        Addition exprDec = new Addition(decLiteral1, decLiteral2, DUMMY_LINE_INFO);
        Addition exprMixed = new Addition(decLiteral2, intLiteral2, DUMMY_LINE_INFO);

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
        Subtraction exprInt = new Subtraction(intLiteral1, intLiteral2, DUMMY_LINE_INFO);

        Subtraction exprDec = new Subtraction(decLiteral1, decLiteral2, DUMMY_LINE_INFO);
        Subtraction exprMixed = new Subtraction(intLiteral1, decLiteral1, DUMMY_LINE_INFO);
        Subtraction exprMixed2 = new Subtraction(decLiteral1, intLiteral1, DUMMY_LINE_INFO);

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
        Multiplication exprInt = new Multiplication(intLiteral1, intLiteral2, DUMMY_LINE_INFO);

        Multiplication exprDec = new Multiplication(decLiteral1, decLiteral2, DUMMY_LINE_INFO);

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

        Division exprInt = new Division(intLiteral1, intLiteral2, DUMMY_LINE_INFO);
        Division exprDec = new Division(decLiteral1, decLiteral2, DUMMY_LINE_INFO);

        assertThat(evaluator.visit(exprInt)).isExactlyInstanceOf(IntegerValue.class);
        assertThat(evaluator.visit(exprInt).getValue()).isExactlyInstanceOf(BigInteger.class);
        assertThat(evaluator.visit(exprInt).getValue()).isEqualTo(BigInteger.valueOf(0));

        assertThat(evaluator.visit(exprDec)).isExactlyInstanceOf(DecimalValue.class);
        assertThat(evaluator.visit(exprDec).getValue()).isExactlyInstanceOf(BigDecimal.class);
        BigDecimal result = new BigDecimal(1.5).divide(new BigDecimal(2.5));
        assertThat(((BigDecimal) evaluator.visit(exprDec).getValue()).compareTo(result)).isEqualTo(0);

        Division exprMixedFromInt = new Division(new IntegerLiteral(3, DUMMY_LINE_INFO), decLiteral1, DUMMY_LINE_INFO);
        assertThat(evaluator.visit(exprMixedFromInt)).isExactlyInstanceOf(DecimalValue.class);
        assertThat(evaluator.visit(exprMixedFromInt).getValue()).isExactlyInstanceOf(BigDecimal.class);
        BigDecimal result2 = new BigDecimal(3.0).divide(new BigDecimal(1.5));
        assertThat(((BigDecimal) evaluator.visit(exprMixedFromInt).getValue()).compareTo(result2)).isEqualTo(0);

    }

    @Test
    public void testVisitGE() {
        GreaterOrEqual exprInt = new GreaterOrEqual(intLiteral1, intLiteral2, DUMMY_LINE_INFO);
        GreaterOrEqual exprDec = new GreaterOrEqual(decLiteral2, decLiteral1, DUMMY_LINE_INFO);

        GreaterOrEqual exprMixed = new GreaterOrEqual(decLiteral2, intLiteral2, DUMMY_LINE_INFO);

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
        And exprAndFalse = new And(boolFalseLiteral, boolTrueLiteral, DUMMY_LINE_INFO);
        And exprAndTrue = new And(boolTrueLiteral, boolTrueLiteral, DUMMY_LINE_INFO);
        And exprAndFalse2 = new And(boolFalseLiteral, boolFalseLiteral, DUMMY_LINE_INFO);

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
        Or exprOrTrue = new Or(boolFalseLiteral, boolTrueLiteral, DUMMY_LINE_INFO);
        Or exprOrTrue2 = new Or(boolTrueLiteral, boolTrueLiteral, DUMMY_LINE_INFO);
        Or exprOrFalse = new Or(boolFalseLiteral, boolFalseLiteral, DUMMY_LINE_INFO);

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
        Not exprNotTrue = new Not(boolFalseLiteral, DUMMY_LINE_INFO);
        Not exprNotFalse = new Not(boolTrueLiteral, DUMMY_LINE_INFO);

        assertThat(evaluator.visit(exprNotTrue)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprNotTrue).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprNotTrue).getValue()).isEqualTo(true);

        assertThat(evaluator.visit(exprNotFalse)).isExactlyInstanceOf(BooleanValue.class);
        assertThat(evaluator.visit(exprNotFalse).getValue()).isExactlyInstanceOf(Boolean.class);
        assertThat(evaluator.visit(exprNotFalse).getValue()).isEqualTo(false);
    }

    @Test
    public void testAnswersValuesStorage() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final Identifier id2 = new Identifier("id2", DUMMY_LINE_INFO);
        final Identifier id3 = new Identifier("id3", DUMMY_LINE_INFO);

        String questionText1 = "id1: \"Label\" integer";
        String questionText2 = "id2: \"Label\" integer";
        String questionText3 = "id3: \"Label\" integer(id1 + id2)";

        Form form = Questionnaire.build(TestHelper.buildForm("form1", questionText1, questionText2, questionText3));
        FormAnswers answers = new FormAnswers();

        answers.setValue(id1, new IntegerValue(1));
        answers.setValue(id2, new IntegerValue(2));
        Evaluator evaluator = new Evaluator(answers);

        form.accept(evaluator);
        assertThat(answers.getValue(id3)).isExactlyInstanceOf(IntegerValue.class);
        assertThat(answers.getValue(id3).getValue()).isEqualTo(new IntegerLiteral(3, DUMMY_LINE_INFO).getValue());
    }
}
