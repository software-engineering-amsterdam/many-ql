package ql.tests.ast;

import org.junit.Test;
import ql.ast.expression.*;
import ql.tests.TestHelper;
import ql.util.ParserHelper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nik on 10-2-15.
 */
public class ArithmeticExpr
{
    @Test
    public void addExpr()
    {
        Add a = TestHelper.as(ParserHelper.ParseExpression("x+y"), Add.class);
        assertNotNull(a);
    }

    @Test
    public void addExprThreeArgs()
    {
        Add a = TestHelper.as(ParserHelper.ParseExpression("x+y+z"), Add.class);
        assertNotNull(a);
        assertTrue(a.getLeft() instanceof Add);
    }

    @Test
    public void addExprNestedLeft()
    {
        Add a = TestHelper.as(ParserHelper.ParseExpression("(x+y)+z"), Add.class);
        assertNotNull(a);
        assertTrue(a.getLeft() instanceof Add);
    }

    @Test
    public void addExprNestedRight()
    {
        Add a = TestHelper.as(ParserHelper.ParseExpression("x+(y+z)"), Add.class);
        assertNotNull(a);
        assertTrue(a.getRight() instanceof Add);
    }

    @Test
    public void subExpr()
    {
        Sub s = TestHelper.as(ParserHelper.ParseExpression("x-y"), Sub.class);
        assertNotNull(s);
    }

    @Test
    public void subExprThreeArgs()
    {
        Sub s = TestHelper.as(ParserHelper.ParseExpression("x-y-z"), Sub.class);
        assertNotNull(s);
        assertTrue(s.getLeft() instanceof Sub);
    }

    @Test
    public void subExprNestedLeft()
    {
        Sub s = TestHelper.as(ParserHelper.ParseExpression("(x-y)-z"), Sub.class);
        assertNotNull(s);
        assertTrue(s.getLeft() instanceof Sub);
    }

    @Test
    public void subExprNestedRight()
    {
        Sub s = TestHelper.as(ParserHelper.ParseExpression("x-(y-z)"), Sub.class);
        assertNotNull(s);
        assertTrue(s.getRight() instanceof Sub);
    }

    @Test
    public void mulExpr()
    {
        Mul m = TestHelper.as(ParserHelper.ParseExpression("x*y"), Mul.class);
        assertNotNull(m);
    }

    @Test
    public void mulExprThreeArgs()
    {
        Mul m = TestHelper.as(ParserHelper.ParseExpression("x*y*z"), Mul.class);
        assertNotNull(m);
        assertTrue(m.getLeft() instanceof Mul);
    }

    @Test
    public void mulExprNestedLeft()
    {
        Mul m = TestHelper.as(ParserHelper.ParseExpression("(x*y)*z"), Mul.class);
        assertNotNull(m);
        assertTrue(m.getLeft() instanceof Mul);
    }

    @Test
    public void mulExprNestedRight()
    {
        Mul m = TestHelper.as(ParserHelper.ParseExpression("x*(y*z)"), Mul.class);
        assertNotNull(m);
        assertTrue(m.getRight() instanceof Mul);
    }

    @Test
    public void divExpr()
    {
        Div d = TestHelper.as(ParserHelper.ParseExpression("x/y"), Div.class);
        assertNotNull(d);
    }

    @Test
    public void divExprThreeArgs()
    {
        Div d = TestHelper.as(ParserHelper.ParseExpression("x/y/z"), Div.class);
        assertNotNull(d);
        assertTrue(d.getLeft() instanceof Div);
    }

    @Test
    public void divExprNestedLeft()
    {
        Div d = TestHelper.as(ParserHelper.ParseExpression("(x/y)/z"), Div.class);
        assertNotNull(d);
        assertTrue(d.getLeft() instanceof Div);
    }

    @Test
    public void divExprNestedRight()
    {
        Div d = TestHelper.as(ParserHelper.ParseExpression("x/(y/z)"), Div.class);
        assertNotNull(d);
        assertTrue(d.getRight() instanceof Div);
    }

    @Test
    public void negExpr()
    {
        Neg n = TestHelper.as(ParserHelper.ParseExpression("-x"), Neg.class);
        assertNotNull(n);
    }

    @Test
    public void negExprNested()
    {
        Neg n = TestHelper.as(ParserHelper.ParseExpression("--x"), Neg.class);
        assertNotNull(n);
        assertTrue(n.getOperand() instanceof Neg);
    }

    @Test
    public void posExpr()
    {
        Pos p = TestHelper.as(ParserHelper.ParseExpression("+x"), Pos.class);
        assertNotNull(p);
    }

    @Test
    public void posExprNested()
    {
        Pos p = TestHelper.as(ParserHelper.ParseExpression("++x"), Pos.class);
        assertNotNull(p);
        assertTrue(p.getOperand() instanceof Pos);
    }

    @Test
    public void addAndSub()
    {
        Sub a = TestHelper.as(ParserHelper.ParseExpression("x+y-z"), Sub.class);
        assertNotNull(a);
        assertTrue(a.getLeft() instanceof Add);
    }

    @Test
    public void addAndMul()
    {
        Add a = TestHelper.as(ParserHelper.ParseExpression("x+y*z"), Add.class);
        assertNotNull(a);
        assertTrue(a.getRight() instanceof Mul);
    }

    @Test
    public void addInParenAndMul()
    {
        Mul a = TestHelper.as(ParserHelper.ParseExpression("(x+y)*z"), Mul.class);
        assertNotNull(a);
        assertTrue(a.getLeft() instanceof Add);
    }

    @Test
    public void divAndMul()
    {
        Mul a = TestHelper.as(ParserHelper.ParseExpression("x/y*z"), Mul.class);
        assertNotNull(a);
        assertTrue(a.getLeft() instanceof Div);
    }

    @Test
    public void divAndMulInParen()
    {
        Div a = TestHelper.as(ParserHelper.ParseExpression("x/(y*z)"), Div.class);
        assertNotNull(a);
        assertTrue(a.getRight() instanceof Mul);
    }

    @Test
    public void unaryAndBinaryPlus()
    {
        Add a = TestHelper.as(ParserHelper.ParseExpression("+x+y"), Add.class);
        assertNotNull(a);
        assertTrue(a.getLeft() instanceof Pos);
    }

    @Test
    public void NegAndMul()
    {
        Mul a = TestHelper.as(ParserHelper.ParseExpression("x*-y"), Mul.class);
        assertNotNull(a);
        assertTrue(a.getRight() instanceof Neg);
    }
}