package lang.tests.semantics;

import lang.ql.semantics.QuestErrInfo;
import lang.ql.semantics.errors.*;
import lang.tests.TestHelper;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by bore on 21/02/15.
 */
public class TypeCheckerTest
{
    @Test
    public void duplicateLabelsWarning() throws FileNotFoundException
    {
        QuestErrInfo info = TestHelper.analyse("duplicateLabels");
        List<Message> ms = info.getMessages();
        Warning w = TestHelper.as(ms.get(0), Warning.class);
        assertNotNull(w);
    }

    @Test
    public void ifCondBoolError() throws FileNotFoundException
    {
        QuestErrInfo info = TestHelper.analyse("ifCondIllegal");
        List<Message> ms = info.getMessages();
        assertEquals(1, ms.size());
        TestHelper.assertErrorMessage(ms.get(0), "Error (Line 2): if statements should have conditions of type boolean");
    }

    @Test
    public void typeMismatchError() throws FileNotFoundException
    {
        QuestErrInfo info = TestHelper.analyse("typeMismatch");
        List<Message> ms = info.getMessages();
        assertEquals(1, ms.size());
        TestHelper.assertErrorMessage(ms.get(0),
                "Error (Line 2): expression of type Add cannot have children of different types: integer and string");
    }

    @Test
    public void incorrectTypesError() throws FileNotFoundException
    {
        QuestErrInfo info = TestHelper.analyse("incorrectTypes");
        List<Message> ms = info.getMessages();
        assertEquals(2, ms.size());

        TestHelper.assertErrorMessage(ms.get(0),"Error (Line 2): expression of type Or cannot children of type string");
        TestHelper.assertErrorMessage(ms.get(1),"Error (Line 3): expression of type Mul cannot children of type boolean");
    }

    @Test
    public void undeclaredIdentError() throws FileNotFoundException
    {
        QuestErrInfo info = TestHelper.analyse("undeclaredIdentifier");
        List<Message> ms = info.getMessages();
        assertEquals(1, ms.size());

        TestHelper.assertErrorMessage(ms.get(0),"Error (Line 2): identifier \"undeclId\" is not declared");
    }

    @Test
    public void defEvalMismatchError() throws FileNotFoundException
    {
        QuestErrInfo info = TestHelper.analyse("defEvalMismatch");
        List<Message> ms = info.getMessages();
        assertEquals(2, ms.size());

        TestHelper.assertErrorMessage(ms.get(0),
                "Error (Line 2): Question \"quest\" is defined as type string, but is calculated as type boolean");
        TestHelper.assertErrorMessage(ms.get(1),
                "Error (Line 3): Question \"anotherQuest\" is defined as type decimal, but is calculated as type boolean");
    }

    @Test
    public void duplicateIdentifiersError() throws FileNotFoundException
    {
        QuestErrInfo info = TestHelper.analyse("duplicateIdentifiers");
        List<Message> ms = info.getMessages();
        assertEquals(1, ms.size());

        TestHelper.assertErrorMessage(ms.get(0),
                "Error (Line 2): identifier \"hasSoldHouse\" is already declared twice on lines 2 and 3");
    }

    @Test
    public void identifierDeclaredOfDiffTypeError() throws FileNotFoundException
    {
        QuestErrInfo info = TestHelper.analyse("identDeclaredOfDiffType");
        List<Message> ms = info.getMessages();
        assertEquals(1, ms.size());

        TestHelper.assertErrorMessage(ms.get(0),
                "Error (Line: 2): Question \"hasSoldHouse\" is declared twice with a different type on line 2 and 3");
    }
}
