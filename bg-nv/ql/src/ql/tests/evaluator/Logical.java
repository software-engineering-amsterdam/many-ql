package ql.tests.evaluator;

import org.junit.Test;
import ql.semantics.ValueTable;
import ql.semantics.values.BoolValue;
import ql.semantics.values.UndefValue;
import ql.tests.TestHelper;

import static org.junit.Assert.*;

/**
 * Created by bore on 24/02/15.
 */
public class Logical
{
    @Test
    public void andFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("true&&false", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void andTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("true&&true", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void orTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("true||false", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void orFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("false||false", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void not()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("!true", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void undefinedNot()
    {
        ValueTable table = new ValueTable();
        table.storeValue("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("!hasHouse", table), UndefValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedAnd()
    {
        ValueTable table = new ValueTable();
        table.storeValue("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("true&&hasHouse&&false", table), UndefValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedOr()
    {
        ValueTable table = new ValueTable();
        table.storeValue("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("true||hasHouse||false", table), UndefValue.class);
        assertNotNull(v);
    }
}
