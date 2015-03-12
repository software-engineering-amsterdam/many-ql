package lang.ql.tests.evaluator;

import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.BooleanValue;
import lang.ql.tests.TestHelper;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by bore on 24/02/15.
 */
public class Identifiers
{
    @Test
    public void idInt()
    {
        ValueTable table = new ValueTable();
        table.storeValue("hasHouse", new BooleanValue(true));
        BooleanValue v = TestHelper.as(TestHelper.evaluate("hasHouse", table), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
}
