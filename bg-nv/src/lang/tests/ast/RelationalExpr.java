package lang.tests.ast;

import lang.ql.ast.expression.*;
import lang.tests.ParserHelper;
import lang.tests.TestHelper;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by bore on 19/02/15.
 */
public class RelationalExpr
{
    @Test
    public void gtExpr()
    {
        Gt e = TestHelper.as(ParserHelper.ParseExpression("x>y"), Gt.class);
        assertNotNull(e);
    }

    @Test
    public void gtExprThreeArgs()
    {
        Gt e = TestHelper.as(ParserHelper.ParseExpression("x>y>z"), Gt.class);
        assertNotNull(e);
        assertTrue(e.getLeft() instanceof Gt);
    }

    @Test
    public void gtExprNestedLeft()
    {
        Gt e = TestHelper.as(ParserHelper.ParseExpression("(x>y)>z"), Gt.class);
        assertNotNull(e);
        assertTrue(e.getLeft() instanceof Gt);
    }

    @Test
    public void gtExprNestedRight()
    {
        Gt e = TestHelper.as(ParserHelper.ParseExpression("x>(y>z)"), Gt.class);
        assertNotNull(e);
        assertTrue(e.getRight() instanceof Gt);
    }
    @Test
    public void gtEquExpr()
    {
        GtEqu e = TestHelper.as(ParserHelper.ParseExpression("x>=y"), GtEqu.class);
        assertNotNull(e);
    }

    @Test
    public void gtEquExprThreeArgs()
    {
        GtEqu e = TestHelper.as(ParserHelper.ParseExpression("x>=y>=z"), GtEqu.class);
        assertNotNull(e);
        assertTrue(e.getLeft() instanceof GtEqu);
    }

    @Test
    public void gtEquExprNestedLeft()
    {
        GtEqu e = TestHelper.as(ParserHelper.ParseExpression("(x>=y)>=z"), GtEqu.class);
        assertNotNull(e);
        assertTrue(e.getLeft() instanceof GtEqu);
    }

    @Test
    public void gtEquExprNestedRight()
    {
        GtEqu e = TestHelper.as(ParserHelper.ParseExpression("x>=(y>=z)"), GtEqu.class);
        assertNotNull(e);
        assertTrue(e.getRight() instanceof GtEqu);
    }

    @Test
    public void ltExpr()
    {
        Lt e = TestHelper.as(ParserHelper.ParseExpression("x<y"), Lt.class);
        assertNotNull(e);
    }

    @Test
    public void ltExprThreeArgs()
    {
        Lt e = TestHelper.as(ParserHelper.ParseExpression("x<y<z"), Lt.class);
        assertNotNull(e);
        assertTrue(e.getLeft() instanceof Lt);
    }

    @Test
    public void ltExprNestedLeft()
    {
        Lt e = TestHelper.as(ParserHelper.ParseExpression("(x<y)<z"), Lt.class);
        assertNotNull(e);
        assertTrue(e.getLeft() instanceof Lt);
    }

    @Test
    public void ltExprNestedRight()
    {
        Lt e = TestHelper.as(ParserHelper.ParseExpression("x<(y<z)"), Lt.class);
        assertNotNull(e);
        assertTrue(e.getRight() instanceof Lt);
    }

    @Test
    public void ltEquExpr()
    {
        LtEqu e = TestHelper.as(ParserHelper.ParseExpression("x<=y"), LtEqu.class);
        assertNotNull(e);
    }

    @Test
    public void ltEquExprThreeArgs()
    {
        LtEqu e = TestHelper.as(ParserHelper.ParseExpression("x<=y<=z"), LtEqu.class);
        assertNotNull(e);
        assertTrue(e.getLeft() instanceof LtEqu);
    }

    @Test
    public void ltEquExprNestedLeft()
    {
        LtEqu e = TestHelper.as(ParserHelper.ParseExpression("(x<=y)<=z"), LtEqu.class);
        assertNotNull(e);
        assertTrue(e.getLeft() instanceof LtEqu);
    }

    @Test
    public void ltEquExprNestedRight()
    {
        LtEqu e = TestHelper.as(ParserHelper.ParseExpression("x<=(y<=z)"), LtEqu.class);
        assertNotNull(e);
        assertTrue(e.getRight() instanceof LtEqu);
    }

    @Test
    public void equExpr()
    {
        Equ e = TestHelper.as(ParserHelper.ParseExpression("x==y"), Equ.class);
        assertNotNull(e);
    }

    @Test
    public void equExprThreeArgs()
    {
        Equ e = TestHelper.as(ParserHelper.ParseExpression("x==y==z"), Equ.class);
        assertNotNull(e);
        assertTrue(e.getLeft() instanceof Equ);
    }

    @Test
    public void equExprNestedLeft()
    {
        Equ e = TestHelper.as(ParserHelper.ParseExpression("(x==y)==z"), Equ.class);
        assertNotNull(e);
        assertTrue(e.getLeft() instanceof Equ);
    }

    @Test
    public void equExprNestedRight()
    {
        Equ e = TestHelper.as(ParserHelper.ParseExpression("x==(y==z)"), Equ.class);
        assertNotNull(e);
        assertTrue(e.getRight() instanceof Equ);
    }

    @Test
    public void notEquExpr()
    {
        NotEqu e = TestHelper.as(ParserHelper.ParseExpression("x!=y"), NotEqu.class);
        assertNotNull(e);
    }

    @Test
    public void notEquExprThreeArgs()
    {
        NotEqu e = TestHelper.as(ParserHelper.ParseExpression("x!=y!=z"), NotEqu.class);
        assertNotNull(e);
        assertTrue(e.getLeft() instanceof NotEqu);
    }

    @Test
    public void notEquExprNestedLeft()
    {
        NotEqu e = TestHelper.as(ParserHelper.ParseExpression("(x!=y)!=z"), NotEqu.class);
        assertNotNull(e);
        assertTrue(e.getLeft() instanceof NotEqu);
    }

    @Test
    public void notEquExprNestedRight()
    {
        NotEqu e = TestHelper.as(ParserHelper.ParseExpression("x!=(y!=z)"), NotEqu.class);
        assertNotNull(e);
        assertTrue(e.getRight() instanceof NotEqu);
    }

    @Test
    public void addLtMul()
    {
        Lt e = TestHelper.as(ParserHelper.ParseExpression("x+y<z*w"), Lt.class);
        assertNotNull(e);
        assertTrue(e.getRight() instanceof Mul);
        assertTrue(e.getLeft() instanceof Add);
    }
}
