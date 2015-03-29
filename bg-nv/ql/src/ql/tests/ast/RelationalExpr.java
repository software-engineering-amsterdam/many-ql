package ql.tests.ast;

import org.junit.Test;
import ql.ast.expression.*;
import ql.tests.TestHelper;
import ql.util.ParserHelper;

import static org.junit.Assert.assertNotNull;

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
        TestHelper.assertChildType(e.getLeft(), Gt.class);
    }

    @Test
    public void gtExprNestedLeft()
    {
        Gt e = TestHelper.as(ParserHelper.ParseExpression("(x>y)>z"), Gt.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getLeft(), Gt.class);
    }

    @Test
    public void gtExprNestedRight()
    {
        Gt e = TestHelper.as(ParserHelper.ParseExpression("x>(y>z)"), Gt.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getRight(), Gt.class);
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
        TestHelper.assertChildType(e.getLeft(), GtEqu.class);
    }

    @Test
    public void gtEquExprNestedLeft()
    {
        GtEqu e = TestHelper.as(ParserHelper.ParseExpression("(x>=y)>=z"), GtEqu.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getLeft(), GtEqu.class);
    }

    @Test
    public void gtEquExprNestedRight()
    {
        GtEqu e = TestHelper.as(ParserHelper.ParseExpression("x>=(y>=z)"), GtEqu.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getRight(), GtEqu.class);
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
        TestHelper.assertChildType(e.getLeft(), Lt.class);
    }

    @Test
    public void ltExprNestedLeft()
    {
        Lt e = TestHelper.as(ParserHelper.ParseExpression("(x<y)<z"), Lt.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getLeft(), Lt.class);
    }

    @Test
    public void ltExprNestedRight()
    {
        Lt e = TestHelper.as(ParserHelper.ParseExpression("x<(y<z)"), Lt.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getRight(), Lt.class);
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
        TestHelper.assertChildType(e.getLeft(), LtEqu.class);
    }

    @Test
    public void ltEquExprNestedLeft()
    {
        LtEqu e = TestHelper.as(ParserHelper.ParseExpression("(x<=y)<=z"), LtEqu.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getLeft(), LtEqu.class);
    }

    @Test
    public void ltEquExprNestedRight()
    {
        LtEqu e = TestHelper.as(ParserHelper.ParseExpression("x<=(y<=z)"), LtEqu.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getRight(), LtEqu.class);
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
        TestHelper.assertChildType(e.getLeft(), Equ.class);
    }

    @Test
    public void equExprNestedLeft()
    {
        Equ e = TestHelper.as(ParserHelper.ParseExpression("(x==y)==z"), Equ.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getLeft(), Equ.class);
    }

    @Test
    public void equExprNestedRight()
    {
        Equ e = TestHelper.as(ParserHelper.ParseExpression("x==(y==z)"), Equ.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getRight(), Equ.class);
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
        TestHelper.assertChildType(e.getLeft(), NotEqu.class);
    }

    @Test
    public void notEquExprNestedLeft()
    {
        NotEqu e = TestHelper.as(ParserHelper.ParseExpression("(x!=y)!=z"), NotEqu.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getLeft(), NotEqu.class);
    }

    @Test
    public void notEquExprNestedRight()
    {
        NotEqu e = TestHelper.as(ParserHelper.ParseExpression("x!=(y!=z)"), NotEqu.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getRight(), NotEqu.class);
    }

    @Test
    public void addLtMul()
    {
        Lt e = TestHelper.as(ParserHelper.ParseExpression("x+y<z*w"), Lt.class);
        assertNotNull(e);
        TestHelper.assertChildType(e.getRight(), Mul.class);
        TestHelper.assertChildType(e.getLeft(), Add.class);
    }
}
