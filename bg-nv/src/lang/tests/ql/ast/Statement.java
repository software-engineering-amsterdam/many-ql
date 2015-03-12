package lang.tests.ql.ast;

import lang.ql.ast.expression.*;
import lang.ql.ast.type.*;
import lang.ql.ast.statement.*;
import lang.tests.ParserHelper;
import lang.tests.TestHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by bore on 19/02/15.
 */
public class Statement
{
    @Test
    public void question()
    {
        Question q = TestHelper.as(ParserHelper.ParseQuestion("boolean hasSoldHouse \"Example\""), Question.class);
        assertNotNull(q);
        assertEquals("hasSoldHouse", q.getId());
        assertEquals("Example", q.getLabel());
        assertTrue(q.getType() instanceof BoolType);
    }

    @Test
    public void decimalQuestion()
    {
        Question q = TestHelper.as(ParserHelper.ParseQuestion("decimal testQuestion5 \"Sample Test\""), Question.class);
        assertNotNull(q);
        assertEquals("testQuestion5", q.getId());
        assertEquals("Sample Test", q.getLabel());
        assertTrue(q.getType() instanceof DecType);
    }

    @Test
    public void calcQuestion()
    {
        CalculatedQuestion q = TestHelper.as(ParserHelper.ParseQuestion(
                "integer hasSoldHouse \"Example\" 1+2/3"), CalculatedQuestion.class);
        assertNotNull(q);
        assertEquals("hasSoldHouse", q.getId());
        assertEquals("Example", q.getLabel());
        assertTrue(q.getType() instanceof IntType);
        assertTrue(q.getCalculation() instanceof Add);
    }

    @Test
    public void stringCalcQuestion()
    {
        CalculatedQuestion q = TestHelper.as(ParserHelper.ParseQuestion(
                "string Quest_123 \"Example\" \"test\""), CalculatedQuestion.class);
        assertNotNull(q);
        assertEquals("Quest_123", q.getId());
        assertEquals("Example", q.getLabel());
        assertTrue(q.getType() instanceof StrType);
        assertTrue(q.getCalculation() instanceof StrExpr);
    }

    @Test
    public void ifCond()
    {
        IfCondition c = TestHelper.as(ParserHelper.ParseIfCondition("if(true)\n{ boolean a \"\"}"), IfCondition.class);
        assertNotNull(c);
        assertEquals(1, c.getBody().size());
        assertTrue(c.getCondition() instanceof BoolExpr);
    }
}
