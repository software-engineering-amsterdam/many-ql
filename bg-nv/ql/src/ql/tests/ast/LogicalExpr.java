package ql.tests.ast;

import org.junit.Test;
import ql.ast.expression.And;
import ql.ast.expression.Gt;
import ql.ast.expression.Not;
import ql.ast.expression.Or;
import ql.tests.TestHelper;
import ql.util.ParserHelper;

import static org.junit.Assert.assertNotNull;

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
        TestHelper.assertChildType(a.getOperand(), Not.class);
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
        TestHelper.assertChildType(a.getLeft(), And.class);
    }

    @Test
    public void andExprNestedLeft()
    {
        And a = TestHelper.as(ParserHelper.ParseExpression("(x&&y)&&z"), And.class);
        assertNotNull(a);
        TestHelper.assertChildType(a.getLeft(), And.class);
    }

    @Test
    public void andExprNestedRight()
    {
        And a = TestHelper.as(ParserHelper.ParseExpression("x&&(y&&z)"), And.class);
        assertNotNull(a);
        TestHelper.assertChildType(a.getRight(), And.class);
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
        TestHelper.assertChildType(a.getLeft(), Or.class);
    }

    @Test
    public void orExprNestedLeft()
    {
        Or a = TestHelper.as(ParserHelper.ParseExpression("(x||y)||z"), Or.class);
        assertNotNull(a);
        TestHelper.assertChildType(a.getLeft(), Or.class);
    }

    @Test
    public void orExprNestedRight()
    {
        Or a = TestHelper.as(ParserHelper.ParseExpression("x||(y||z)"), Or.class);
        assertNotNull(a);
        TestHelper.assertChildType(a.getRight(), Or.class);
    }

    @Test
    public void orAnd()
    {
        And a = TestHelper.as(ParserHelper.ParseExpression("x||y&&z"), And.class);
        assertNotNull(a);
        TestHelper.assertChildType(a.getLeft(), Or.class);
    }

    @Test
    public void orInParenAnd()
    {
        And a = TestHelper.as(ParserHelper.ParseExpression("(x||y)&&z"), And.class);
        assertNotNull(a);
        TestHelper.assertChildType(a.getLeft(), Or.class);
    }

    @Test
    public void orAndInParen()
    {
        Or a = TestHelper.as(ParserHelper.ParseExpression("x||(y&&z)"), Or.class);
        assertNotNull(a);
        TestHelper.assertChildType(a.getRight(), And.class);
    }

    @Test
    public void orNot()
    {
        Or a = TestHelper.as(ParserHelper.ParseExpression("x||!y"), Or.class);
        assertNotNull(a);
        TestHelper.assertChildType(a.getRight(), Not.class);
    }

    @Test
    public void notAnd()
    {
        Not a = TestHelper.as(ParserHelper.ParseExpression("!(x&&y)"), Not.class);
        assertNotNull(a);
        TestHelper.assertChildType(a.getOperand(), And.class);
    }

    @Test
    public void orGtAnd()
    {
        And a = TestHelper.as(ParserHelper.ParseExpression("x||y>z&&w"), And.class);
        assertNotNull(a);
        Or left = TestHelper.as(a.getLeft(), Or.class);
        TestHelper.assertChildType(left.getRight(), Gt.class);
    }
}
