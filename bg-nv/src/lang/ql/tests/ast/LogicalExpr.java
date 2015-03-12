package lang.ql.tests.ast;

import lang.ql.ast.expression.And;
import lang.ql.ast.expression.Gt;
import lang.ql.ast.expression.Not;
import lang.ql.ast.expression.Or;
import lang.ql.util.ParserHelper;
import lang.ql.tests.TestHelper;
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
