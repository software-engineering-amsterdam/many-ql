package ql.tests.evaluator;

import ql.semantics.ValueTable;
import ql.semantics.values.BooleanValue;
import ql.tests.TestHelper;
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
