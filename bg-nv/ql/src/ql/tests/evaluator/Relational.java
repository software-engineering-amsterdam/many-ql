package ql.tests.evaluator;

import ql.semantics.ValueTable;
import ql.semantics.ValueTableEntry;
import ql.semantics.values.BoolValue;
import ql.semantics.values.UndefValue;
import ql.tests.TestHelper;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by bore on 24/02/15.
 */
public class Relational
{
    @Test
    public void gtDecTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1.1>1.0", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void gtDecFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1.0>1.0", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void gtIntTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("3>1", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
    @Test
    public void gtIntFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1>3", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void ltDecTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1.0<1.1", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void ltDecFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1.0<1.0", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void ltIntTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1<3", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
    @Test
    public void ltIntFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("3<1", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void ltEquDecTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1.0<=1.1", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void ltEquDecFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1.1<=1.0", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void ltEquIntTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1<=3", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
    @Test
    public void ltEquIntFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("3<=1", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void gtEquDecTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1.1>=1.0", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void gtEquDecFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1.0>=1.1", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void gtEquIntTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("3>=1", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
    @Test
    public void gtEquIntFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1>=3", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void notEquBoolTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("true!=false", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void notEquBoolFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("true!=true", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void notEquStringTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("\"string\"!=\"s\"", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void notEquStringFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("\"string\"!=\"string\"", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void notEquDecTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1.0!=1.1", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void notEquDecFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1.0!=1.0", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void notEquIntTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("10!=11", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
    @Test
    public void notEquIntFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1!=1", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void equBoolTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("true==true", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void equBoolFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("true==false", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void equStringTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("\"string\"==\"string\"", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void equStringFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("\"string\"==\"s\"", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void equDecTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1.0==1.0", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void equDecFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1.0==1.1", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void equIntTrue()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("10==10", null), BoolValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void equIntFalse()
    {
        BoolValue v = TestHelper.as(TestHelper.evaluate("1==2", null), BoolValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void undefinedEqu()
    {
        ValueTable table = new ValueTable();
        table.storeEntry("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("1==hasHouse==2", table), UndefValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedLt()
    {
        ValueTable table = new ValueTable();
        table.storeEntry("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("1<hasHouse<2", table), UndefValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedGt()
    {
        ValueTable table = new ValueTable();
        table.storeEntry("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("1>hasHouse>2", table), UndefValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedLtEqu()
    {
        ValueTable table = new ValueTable();
        table.storeEntry("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("1<=hasHouse<=2", table), UndefValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedGtEqu()
    {
        ValueTable table = new ValueTable();
        table.storeEntry("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("1>=hasHouse>=2", table), UndefValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedNotEqu()
    {
        ValueTable table = new ValueTable();
        table.storeEntry("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("1!=hasHouse!=2", table), UndefValue.class);
        assertNotNull(v);
    }
}
