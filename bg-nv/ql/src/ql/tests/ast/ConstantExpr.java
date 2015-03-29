package ql.tests.ast;

import org.junit.Test;
import ql.ast.expression.*;
import ql.tests.TestHelper;
import ql.util.ParserHelper;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by bore on 19/02/15.
 */
public class ConstantExpr
{
    @Test
    public void intExpr()
    {
        IntExpr e = TestHelper.as(ParserHelper.ParseExpression("1"), IntExpr.class);
        assertNotNull(e);
        assertEquals(1, (long) e.getValue());
    }

    @Test
    public void decExpr()
    {
        DecExpr e = TestHelper.as(ParserHelper.ParseExpression("1.2"), DecExpr.class);
        assertNotNull(e);
        assertTrue(new BigDecimal("1.2").compareTo(e.getValue()) == 0);
    }

    @Test
    public void decExprPartial()
    {
        DecExpr e = TestHelper.as(ParserHelper.ParseExpression(".2"), DecExpr.class);
        assertNotNull(e);
        assertTrue(new BigDecimal(".2").compareTo(e.getValue()) == 0);
    }

    @Test
    public void decExprZero()
    {
        DecExpr e = TestHelper.as(ParserHelper.ParseExpression("1.0"), DecExpr.class);
        assertNotNull(e);
        assertTrue(new BigDecimal("1.0").compareTo(e.getValue()) == 0);
    }

    @Test
    public void decExprLong()
    {
        DecExpr e = TestHelper.as(ParserHelper.ParseExpression("1234567.8987654321"), DecExpr.class);
        assertNotNull(e);
        assertTrue(new BigDecimal("1234567.8987654321").compareTo(e.getValue()) == 0);
    }

    @Test
    public void stringExprPlainRegQuotes()
    {
        StrExpr e = TestHelper.as(ParserHelper.ParseExpression("\"string\""), StrExpr.class);
        assertNotNull(e);
        assertEquals("string", e.getValue());
    }

    @Test
    public void stringExprDiffQuotes()
    {
        StrExpr e = TestHelper.as(ParserHelper.ParseExpression("\"string\""), StrExpr.class);
        assertNotNull(e);
        assertEquals("string", e.getValue());
    }

    @Test
    public void stringExprEmpty()
    {
        StrExpr e = TestHelper.as(ParserHelper.ParseExpression("\"\""), StrExpr.class);
        assertNotNull(e);
        assertEquals("", e.getValue());
    }

    @Test
    public void stringExprNestedQuotes()
    {
        StrExpr e = TestHelper.as(ParserHelper.ParseExpression("\"str\\\"ing\""), StrExpr.class);
        assertNotNull(e);
        assertEquals("str\"ing", e.getValue());
    }

    @Test
    public void stringExprMultipleNestedQuotes()
    {
        StrExpr e = TestHelper.as(ParserHelper.ParseExpression(
                "\"This string contains \\\"multiple\\\" \\\"quotes\\\"\""), StrExpr.class);

        assertNotNull(e);
        assertEquals("This string contains \"multiple\" \"quotes\"", e.getValue());
    }

    @Test
    public void stringExprMultipleDifferentNestedQuotes()
    {
        StrExpr e = TestHelper.as(ParserHelper.ParseExpression(
                "\"This string contains \\\"multiple\\\" \\\"quotes\\\"\""), StrExpr.class);

        assertNotNull(e);
        assertEquals("This string contains \"multiple\" \"quotes\"", e.getValue());
    }

    @Test
    public void boolExprTrue()
    {
        BoolExpr e = TestHelper.as(ParserHelper.ParseExpression("true"), BoolExpr.class);
        assertNotNull(e);
        assertEquals(true, e.getValue());
    }

    @Test
    public void boolExprFalse()
    {
        BoolExpr e = TestHelper.as(ParserHelper.ParseExpression("false"), BoolExpr.class);
        assertNotNull(e);
        assertEquals(false, e.getValue());
    }

    @Test
    public void identifierExpr()
    {
        Ident e = TestHelper.as(ParserHelper.ParseExpression("any"), Ident.class);
        assertNotNull(e);
    }
}
