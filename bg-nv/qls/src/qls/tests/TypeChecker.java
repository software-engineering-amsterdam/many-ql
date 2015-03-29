package qls.tests;

import org.junit.Test;
import ql.semantics.errors.Messages;
import ql.tests.TestHelper;
import qls.util.ParserHelper;

import java.io.FileNotFoundException;

/**
 * Created by bore on 09/03/15.
 */
public class TypeChecker
{
    @Test
    public void questionAlreadyReferenced() throws FileNotFoundException
    {
        Messages ms = ParserHelper.check("styleQuestAlreadyReferenced", "example1");

        TestHelper.assertMsContainError(ms,
                "QLS Error (Line 8): question with id hasSoldHouse is already referenced on line 8");
    }

    @Test
    public void questionNotReferenced() throws FileNotFoundException
    {
        Messages ms = ParserHelper.check("styleQuestNotReferenced", "example1");

        TestHelper.assertMsContainError(ms,
                "QLS Error: question with id privateDebt is not referenced in the stylesheet");
    }

    @Test
    public void undefQuestion() throws FileNotFoundException
    {
        Messages ms = ParserHelper.check("styleUndefQuest", "example1");

        TestHelper.assertMsContainError(ms, "QLS Error (Line 8): question with id undefQuestion is not defined");
    }

    @Test
    public void widgetTypeMismatch() throws FileNotFoundException
    {
        Messages ms = ParserHelper.check("styleWidgetMismatch", "example1");

        TestHelper.assertMsContainError(ms,
                "QLS Error (Line 7): widget of type decimal does not match the statement declaration type");
    }
}
