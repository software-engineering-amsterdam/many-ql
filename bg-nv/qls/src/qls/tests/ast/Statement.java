package qls.tests.ast;

import ql.ast.type.IntType;
import ql.tests.TestHelper;
import qls.ast.Page;
import qls.ast.statement.DefaultStat;
import qls.ast.statement.Question;
import qls.ast.statement.QuestionWithRules;
import qls.ast.statement.Section;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by bore on 29/03/15.
 */
public class Statement
{
    private static final IntType intType = new IntType();

    @org.junit.Test
    public void defaultStat()
    {
        String defaultString = "default integer { width: 15 backcolor: #9955FF }";
        DefaultStat value = TestHelper.as(qls.util.ParserHelper.ParseStatement(defaultString), DefaultStat.class);
        assertNotNull(value);
        assertEquals(intType, value.getType());
    }

    @org.junit.Test
    public void question()
    {
        Question value = TestHelper.as(qls.util.ParserHelper.ParseStatement("question status"), Question.class);
        assertNotNull(value);
        assertEquals("status", value.getId());
    }

    @org.junit.Test
    public void questionWithRules()
    {
        String qString = "question status { forecolor: #123456 }";
        QuestionWithRules value = TestHelper.as(qls.util.ParserHelper.ParseStatement(qString), QuestionWithRules.class);
        assertNotNull(value);
        assertEquals("status", value.getId());
        assertNotNull(value.getBody());
    }

    @org.junit.Test
    public void section()
    {
        String sString = "section \"Income\" { question taxes }";
        Section value = TestHelper.as(qls.util.ParserHelper.ParseStatement(sString), Section.class);
        assertNotNull(value);
        assertEquals("Income", value.getName());
        assertEquals(1, value.getBody().size());
    }

    @org.junit.Test
    public void page()
    {
        String page = "page \"Income\" { question taxes }";
        Page value = TestHelper.as(qls.util.ParserHelper.ParsePage(page), Page.class);
        assertNotNull(value);
        assertEquals("Income", value.getTitle());
        assertEquals(1, value.getBody().size());
    }
}
