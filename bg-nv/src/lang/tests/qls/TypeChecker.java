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
        List<Message> ms = TestHelper.analyse("duplicateLabels");
        assertEquals(1, ms.size());
        Warning w = TestHelper.as(ms.get(0), Warning.class);
        assertNotNull(w);
    }
}
