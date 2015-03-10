package lang.tests.qls;

import lang.ql.semantics.errors.Message;
import lang.ql.semantics.errors.Warning;
import lang.tests.TestHelper;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

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
        List<Message> ms = TestHelper.getStylesheet("qls/samples/widgetTypeMismatch", "qls/samples/qlForm");
        assertEquals(1, ms.size());
        TestHelper.assertErrorMessage(ms.get(0),
                "Error (Line 3): widget of type boolean does not match the statement declaration type");
    }
}
