package test.klq.ast;

import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.literal.BooleanNode;
import com.klq.ast.impl.expr.literal.NumberNode;
import com.klq.ast.impl.expr.math.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

/**
 * Created by Juriaan on 7-3-2015.
 */
public class EvaluationTest {
    private AExpression left;
    private AExpression right;

    @Before
    public void setUp() throws Exception {
        left = new NumberNode(BigDecimal.valueOf(20));
        right = new NumberNode(BigDecimal.valueOf(10));
    }

    @Test
    public void testAdd() throws Exception {
        AExpression expr = new AddNode(left, right);
        assertEquals(new BigDecimal("30"), expr.evaluate(null).getValue());
    }

    @Test
    public void testSubtract() throws Exception {
        AExpression expr = new SubtractNode(left, right);
        assertEquals(new BigDecimal("10"), expr.evaluate(null).getValue());
    }

    @Test
    public void testMultiply() throws Exception {
        AExpression expr = new MultiplyNode(left, right);
        assertEquals(new BigDecimal("200"), expr.evaluate(null).getValue());
    }

    @Test
    public void testDivide() throws Exception {
        AExpression expr = new DivideNode(left, right);
        assertEquals(new BigDecimal("2"), expr.evaluate(null).getValue());
    }

    @Test
     public void testGreaterThan() throws Exception {
        AExpression expr = new GreaterThanNode(left, right);
        assertEquals(true, expr.evaluate(null).getValue());

        expr = new GreaterThanNode(right, left);
        assertEquals(false, expr.evaluate(null).getValue());
    }

    @Test
    public void testGreaterEquals() throws Exception {
        AExpression expr = new GreaterEqualsNode(left, right);
        assertEquals(true, expr.evaluate(null).getValue());

        expr = new GreaterEqualsNode(right, left);
        assertEquals(false, expr.evaluate(null).getValue());

        expr = new GreaterEqualsNode(left, new NumberNode(new BigDecimal("20")));
        assertEquals(true, expr.evaluate(null).getValue());
    }

    @Test
    public void testLessThan() throws Exception {
        AExpression expr = new LessThanNode(left, right);
        assertEquals(false, expr.evaluate(null).getValue());

        expr = new LessThanNode(right, left);
        assertEquals(true, expr.evaluate(null).getValue());
    }

    @Test
    public void testLessEquals() throws Exception {
        AExpression expr = new LessEqualsNode(left, right);
        assertEquals(false, expr.evaluate(null).getValue());

        expr = new LessEqualsNode(right, left);
        assertEquals(true, expr.evaluate(null).getValue());

        expr = new LessEqualsNode(left, new NumberNode(new BigDecimal("20")));
        assertEquals(true, expr.evaluate(null).getValue());
    }

    @Test
    public void testEquals() throws Exception {
        AExpression expr = new EqualsNode(left, right);
        assertEquals(false, expr.evaluate(null).getValue());

        expr = new EqualsNode(left, new NumberNode(new BigDecimal("20")));
        assertEquals(true, expr.evaluate(null).getValue());
    }

    @Test
    public void testNotEquals() throws Exception {
        AExpression expr = new NotEqualsNode(left, right);
        assertEquals(true, expr.evaluate(null).getValue());

        expr = new NotEqualsNode(left, new NumberNode(new BigDecimal("20")));
        assertEquals(false, expr.evaluate(null).getValue());
    }

    @Test
    public void testAndOr() throws Exception {
        BooleanNode trueNode = new BooleanNode(true);
        BooleanNode falseNode = new BooleanNode(false);

        AExpression expr = new AndNode(trueNode, trueNode);
        assertEquals(true, expr.evaluate(null).getValue());

        expr = new AndNode(trueNode, falseNode);
        assertEquals(false, expr.evaluate(null).getValue());

        expr = new AndNode(trueNode, falseNode);
        assertEquals(false, expr.evaluate(null).getValue());

        expr = new AndNode(falseNode, falseNode);
        assertEquals(false, expr.evaluate(null).getValue());

        expr = new OrNode(trueNode, trueNode);
        assertEquals(true, expr.evaluate(null).getValue());

        expr = new OrNode(trueNode, falseNode);
        assertEquals(true, expr.evaluate(null).getValue());

        expr = new OrNode(falseNode, trueNode);
        assertEquals(true, expr.evaluate(null).getValue());

        expr = new OrNode(falseNode, falseNode);
        assertEquals(false, expr.evaluate(null).getValue());
    }

    @Test
    public void testDeepEvaluation() throws Exception {
        AExpression child1 = new NumberNode(new BigDecimal("10"));
        AExpression child2 = new NumberNode(new BigDecimal("20"));
        AExpression child3 = new NumberNode(new BigDecimal("35"));
        AExpression child4 = new NumberNode(new BigDecimal("7"));

        AddNode add = new AddNode(child1, child2); //30
        SubtractNode sub = new SubtractNode(child3, child4); //28

        GreaterThanNode gt = new GreaterThanNode(add, sub);

        assertEquals(true, gt.evaluate(null).getValue());
    }

    @Test
    public void testUndefined() throws Exception {
//        AValueNode child1 = new BooleanNode(true);
//        AValueNode child2 = new UndefinedNode();
//
//        AndNode and = new AndNode(child1, child2);
//        assertEquals("Undefined", and.evaluate(null).getValue());
    }
}
