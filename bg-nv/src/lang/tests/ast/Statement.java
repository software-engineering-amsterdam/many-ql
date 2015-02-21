package lang.tests.ast;

import lang.ql.ast.expression.*;
import lang.ql.ast.statement.CalculatedQuestion;
import lang.ql.ast.statement.IfCondition;
import lang.ql.ast.statement.Question;
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
        assertEquals("Example", q.getText());
        // TODO: check for type
    }

    @Test
    public void calcQuestion()
    {
        CalculatedQuestion q = TestHelper.as(ParserHelper.ParseQuestion(
                "integer hasSoldHouse \"Example\" 1+2/3"), CalculatedQuestion.class);
        assertNotNull(q);
        assertEquals("hasSoldHouse", q.getId());
        assertEquals("Example", q.getText());
        // TODO: check for type
        assertTrue(q.getExpr() instanceof Add);
    }

    @Test
    public void stringCalcQuestion()
    {
        CalculatedQuestion q = TestHelper.as(ParserHelper.ParseQuestion(
                "string Quest_123 \"Example\" \"test\""), CalculatedQuestion.class);
        assertNotNull(q);
        assertEquals("Quest_123", q.getId());
        assertEquals("Example", q.getText());
        // TODO: check for type
        assertTrue(q.getExpr() instanceof StrExpr);
    }

    @Test
    public void ifCond()
    {
        IfCondition c = TestHelper.as(ParserHelper.ParseIfCondiion("if(true)\n{ boolean a \"\"}"), IfCondition.class);
        assertNotNull(c);
        assertEquals(1, c.getStatements().size());
        assertTrue(c.getExpr() instanceof BoolExpr);
    }
}
