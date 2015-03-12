package lang.qls.tests;

import lang.ql.semantics.errors.Messages;
import lang.ql.tests.TestHelper;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by bore on 09/03/15.
 */
public class TypeChecker
{
    @Test
    public void widgetTypeMismatchQuestion() throws FileNotFoundException
    {
//        Messages ms = TestHelper.getStylesheet("widgetTypeMismatch", "qlForm");
//        assertEquals(1, ms.size());
//        TestHelper.assertErrorMessage(ms.get(0),
//                "Error (Line 3): widget of type boolean does not match the statement declaration type");
    }
}
