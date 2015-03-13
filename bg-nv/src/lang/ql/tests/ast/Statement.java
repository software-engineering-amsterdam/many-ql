package lang.ql.tests.ast;

import lang.ql.ast.expression.*;
import lang.ql.ast.type.*;
import lang.ql.ast.statement.*;
import lang.ql.util.ParserHelper;
import lang.ql.tests.TestHelper;
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
        TestHelper.assertChildType(q.getType(), BoolType.class);
    }

    @Test
    public void decimalQuestion()
    {
        Question q = TestHelper.as(ParserHelper.ParseQuestion("decimal testQuestion5 \"Sample Test\""), Question.class);
        assertNotNull(q);
        assertEquals("testQuestion5", q.getId());
        assertEquals("Sample Test", q.getLabel());
        TestHelper.assertChildType(q.getType(), DecType.class);
    }

    @Test
    public void calcQuestion()
    {
        CalculatedQuestion q = TestHelper.as(ParserHelper.ParseQuestion(
                "integer hasSoldHouse \"Example\" 1+2/3"), CalculatedQuestion.class);
        assertNotNull(q);
        assertEquals("hasSoldHouse", q.getId());
        assertEquals("Example", q.getLabel());
        TestHelper.assertChildType(q.getType(), IntType.class);
        TestHelper.assertChildType(q.getCalculation(), Add.class);
    }

    @Test
    public void stringCalcQuestion()
    {
        CalculatedQuestion q = TestHelper.as(ParserHelper.ParseQuestion(
                "string Quest_123 \"Example\" \"test\""), CalculatedQuestion.class);
        assertNotNull(q);
        assertEquals("Quest_123", q.getId());
        assertEquals("Example", q.getLabel());
        TestHelper.assertChildType(q.getType(), StrType.class);
        TestHelper.assertChildType(q.getCalculation(), StrExpr.class);
    }

    @Test
    public void ifCond()
    {
        IfCondition c = TestHelper.as(ParserHelper.ParseIfCondition("if(true)\n{ boolean a \"\"}"), IfCondition.class);
        assertNotNull(c);
        assertEquals(1, c.getBody().size());
        TestHelper.assertChildType(c.getCondition(), BoolExpr.class);
    }
}
