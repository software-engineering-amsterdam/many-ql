package org.fugazi.evaluator;

import org.fugazi.ast.expression.literal.NUMBER;
import org.fugazi.ast.expression.numerical.Add;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluatorTest {

    public Evaluator evaluator;
    
    @Before
    public void setupEnv() {
        evaluator = new Evaluator();
    }
    
    @Test
    public void testSaveValue() throws Exception {
        evaluator.saveValue("testId", new BoolValue(true));
        assertTrue(evaluator.isValueExists("testId"));
    }

    @Test
    public void testGetValue() throws Exception {
        evaluator.saveValue("testId", new BoolValue(true));
        ExpressionValue test = evaluator.getValue("testId");
        assertEquals(true, test.getValue());
    }

    @Test
    public void testEvaluateExpression() throws Exception {
        NUMBER num5 = new NUMBER(5);
        NUMBER num4 = new NUMBER(5);
        Add addExpression = new Add(num5, num4);
        ExpressionValue value = evaluator.evaluateExpression(addExpression);
        System.out.println(value);
    }
}