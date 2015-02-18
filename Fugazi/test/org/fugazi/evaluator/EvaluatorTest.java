package org.fugazi.evaluator;

import org.fugazi.ast.expression.literal.*;
import org.fugazi.ast.expression.logical.And;
import org.fugazi.ast.expression.logical.Or;
import org.fugazi.ast.expression.numerical.*;
import org.fugazi.ast.expression.unary.Negative;
import org.fugazi.ast.expression.unary.Not;
import org.fugazi.ast.expression.unary.Positive;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluatorTest {

    private Evaluator evaluator;
    
    // Test data
    private final INT num5 = new INT(5);
    private final INT num4 = new INT(4);
    private final STRING stringFoo = new STRING("Foo");
    private final STRING stringBar = new STRING("bar");
    private final BOOL boolTrue = new BOOL(true);
    private final BOOL boolFalse = new BOOL(false);

    private final String testId = "testId";
    private final String testString1 = "testString1";
    private final String testString2 = "testString2";

    @Before
    public void setupEnv() {
        evaluator = new Evaluator();
    }

//    @AfterClass
//    public void clearValue() {
//        evaluator.clearValues();
//    }

    /**
     * Test Value Storage
     */
    @Test
    public void testSaveValue() throws Exception {
        // test: save testId
        evaluator.saveValue(testId, new BoolValue(true));
        assertTrue(evaluator.isValueExists(testId));
    }

    @Test
    public void testGetValue() throws Exception {
        // test: get testId
        evaluator.saveValue(testId, new BoolValue(true));
        ExpressionValue test = evaluator.getValue(testId);
        assertEquals(true, test.getValue());
    }
    
    /**
     * Test Add
     */
    @Test
    public void testAddExpressionWithNums() throws Exception {
        // test: 5 + 4 = 9;
        Add expression = new Add(num5, num4);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), 9);
    }

    @Test
    public void testAddExpressionWithStrings() throws Exception {
        // test: Foo + bar = Foobar;
        Add expression = new Add(stringFoo, stringBar);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), "Foobar");
    }

    @Test
    public void testAddExpressionWithBools() throws Exception {
        // test: Undefined
        Add expression = new Add(boolTrue, boolFalse);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), new UndefinedValue().getValue());
    }

    /**
     * Test Sub
     */
    @Test
    public void testSubExpressionWithNums() throws Exception {
        Sub expression = new Sub(num5, num4);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), 1);
    }

    @Test
    public void testSubExpressionWithStrings() throws Exception {
        // test: Undefined
        Sub expression = new Sub(stringFoo, stringBar);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), new UndefinedValue().getValue());
    }

    @Test
    public void testSubExpressionWithBools() throws Exception {
        // test: Undefined
        Add expression = new Add(boolTrue, boolFalse);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), new UndefinedValue().getValue());
    }

    /**
     * Test Mul
     */
    @Test
    public void testMulExpressionWithNums() throws Exception {
        // test: 5 * 4 = 20;
        Mul expression = new Mul(num5, num4);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), 20);
    }

    @Test
    public void testMulExpressionWithStrings() throws Exception {
        // test: Undefined
        Mul expression = new Mul(stringFoo, stringBar);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), new UndefinedValue().getValue());
    }

    @Test
    public void testMulExpressionWithBools() throws Exception {
        // test: Undefined
        Mul expression = new Mul(boolTrue, boolFalse);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), new UndefinedValue().getValue());
    }

    /**
     * Test Div
     */
    @Test
    public void testDivExpressionWithNums() throws Exception {
        // test: 5 / 4 = 1;
        Div expression = new Div(num5, num4);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), 1);
    }

    @Test
    public void testDivExpressionWithStrings() throws Exception {
        // test: Undefined
        Div expression = new Div(stringFoo, stringBar);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), new UndefinedValue().getValue());
    }

    @Test
    public void testDivExpressionWithBools() throws Exception {
        // test: Undefined
        Div expression = new Div(boolTrue, boolFalse);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), new UndefinedValue().getValue());
    }

    /**
     * Test Literals
     */
    @Test
    public void testIDExpression() throws Exception {
        ID id = new ID(testString1);
        evaluator.saveValue(testString1, new IntValue(5));
        ExpressionValue value = evaluator.evaluateExpression(id);
        assertEquals(value.getValue(), 5);
    }

    @Test
    public void testBOOLExpression() throws Exception {
        BOOL bool = new BOOL(true);
        ExpressionValue value = evaluator.evaluateExpression(bool);
        assertEquals(value.getValue(), bool.getValue());
    }

    @Test
    public void testINTExpression() throws Exception {
        INT num = num5;
        ExpressionValue value = evaluator.evaluateExpression(num);
        assertEquals(value.getValue(), num.getValue());
    }

    @Test
    public void testSTRINGExpression() throws Exception {
        STRING str = new STRING(testString1);
        ExpressionValue value = evaluator.evaluateExpression(str);
        assertEquals(value.getValue(), str.getValue());
    }

    /**
     * Test And
     */
    @Test
    public void testAndExpressionWithNums() throws Exception {
        // test: Undefined
        And expression = new And(num5, num4);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), new UndefinedValue().getValue());
    }

    @Test
    public void testAndExpressionWithStrings() throws Exception {
        // test: Undefined
        And expression = new And(stringFoo, stringBar);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), new UndefinedValue().getValue());
    }

    @Test
    public void testAndExpressionWithBools() throws Exception {
        // test: True && False = False
        And expression = new And(boolTrue, boolFalse);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), false);
    }

    /**
     * Test Or
     */
    @Test
    public void testOrExpressionWithNums() throws Exception {
        // test: Undefined
        Or expression = new Or(num5, num4);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), new UndefinedValue().getValue());
    }

    @Test
    public void testOrExpressionWithStrings() throws Exception {
        // test: Undefined
        Or expression = new Or(stringFoo, stringBar);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), new UndefinedValue().getValue());
    }

    @Test
    public void testOrExpressionWithBools() throws Exception {
        // test: True || False = True
        Or expression = new Or(boolTrue, boolFalse);
        ExpressionValue value = evaluator.evaluateExpression(expression);
        assertEquals(value.getValue(), true);
    }

    /**
     * Test Not
     */
    @Test
    public void testNotExpressionWithBools() throws Exception {
        // test: !False = True
        Not expression1 = new Not(boolFalse);
        ExpressionValue value1 = evaluator.evaluateExpression(expression1);
        assertEquals(value1.getValue(), true);

        // test: !True = False
        Not expression2 = new Not(boolTrue);
        ExpressionValue value2 = evaluator.evaluateExpression(expression2);
        assertEquals(value2.getValue(), false);
    }

    /**
     * Test Positive
     */
    @Test
    public void testPosExpressionWithBools() throws Exception {
        // test: (+)5 = 5
        Positive expression = new Positive(num5);
        ExpressionValue value1 = evaluator.evaluateExpression(expression);
        assertEquals(value1.getValue(), num5.getValue());
    }

    /**
     * Test Negative
     */
    @Test
    public void testNegExpressionWithBools() throws Exception {
        // test: (-)5 = -5
        Negative expression = new Negative(num5);
        ExpressionValue value1 = evaluator.evaluateExpression(expression);
        assertEquals(value1.getValue(), -num5.getValue());
    }
}