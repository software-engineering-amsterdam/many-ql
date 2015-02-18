package lang.tests.Expressions;

import lang.ql.ast.expression.And;
import lang.ql.ast.expression.Not;
import lang.ql.ast.expression.Or;
import lang.tests.ParserHelper;
import lang.tests.TestHelper;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by bore on 17/02/15.
 */
public class LogicalExpr
{
    @Test
    public void notExpr()
    {
        Not a = TestHelper.as(ParserHelper.ParseExpression("!x"), Not.class);
        assertNotNull(a);
    }

    @Test
    public void notExprNested()
    {
        Not a = TestHelper.as(ParserHelper.ParseExpression("!!x"), Not.class);
        assertNotNull(a);
        assertTrue(a.getOperand() instanceof Not);
    }

    @Test
    public void andExpr()
    {
        And a = TestHelper.as(ParserHelper.ParseExpression("x&&y"), And.class);
        assertNotNull(a);
    }

    @Test
    public void andExprThreeArgs()
    {
        And a = TestHelper.as(ParserHelper.ParseExpression("x&&y&&z"), And.class);
        assertNotNull(a);
        assertTrue(a.getLeft() instanceof And);
    }

    @Test
    public void andExprNestedLeft()
    {
        And a = TestHelper.as(ParserHelper.ParseExpression("(x&&y)&&z"), And.class);
        assertNotNull(a);
        assertTrue(a.getLeft() instanceof And);
    }

    @Test
    public void andExprNestedRight()
    {
        And a = TestHelper.as(ParserHelper.ParseExpression("x&&(y&&z)"), And.class);
        assertNotNull(a);
        assertTrue(a.getRight() instanceof And);
    }


    @Test
    public void orExpr()
    {
        Or a = TestHelper.as(ParserHelper.ParseExpression("x||y"), Or.class);
        assertNotNull(a);
    }

    @Test
    public void orExprThreeArgs()
    {
        Or a = TestHelper.as(ParserHelper.ParseExpression("x||y||z"), Or.class);
        assertNotNull(a);
        assertTrue(a.getLeft() instanceof Or);
    }

    @Test
    public void orExprNestedLeft()
    {
        Or a = TestHelper.as(ParserHelper.ParseExpression("(x||y)||z"), Or.class);
        assertNotNull(a);
        assertTrue(a.getLeft() instanceof Or);
    }

    @Test
    public void orExprNestedRight()
    {
        Or a = TestHelper.as(ParserHelper.ParseExpression("x||(y||z)"), Or.class);
        assertNotNull(a);
        assertTrue(a.getRight() instanceof Or);
    }

    @Test
    public void orAnd()
    {
        And a = TestHelper.as(ParserHelper.ParseExpression("x||y&&z"), And.class);
        assertNotNull(a);
        assertTrue(a.getLeft() instanceof Or);
    }

    @Test
    public void orInParenAnd()
    {
        And a = TestHelper.as(ParserHelper.ParseExpression("(x||y)&&z"), And.class);
        assertNotNull(a);
        assertTrue(a.getLeft() instanceof Or);
    }

    @Test
    public void orAndInParen()
    {
        Or a = TestHelper.as(ParserHelper.ParseExpression("x||(y&&z)"), Or.class);
        assertNotNull(a);
        assertTrue(a.getRight() instanceof And);
    }

    @Test
    public void orNot()
    {
        Or a = TestHelper.as(ParserHelper.ParseExpression("x||!y"), Or.class);
        assertNotNull(a);
        assertTrue(a.getRight() instanceof Not);
    }

    @Test
    public void notAnd()
    {
        Not a = TestHelper.as(ParserHelper.ParseExpression("!(x&&y)"), Not.class);
        assertNotNull(a);
        assertTrue(a.getOperand() instanceof And);
    }

}
