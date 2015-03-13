package lang.ql.tests.evaluator;

import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.*;
import lang.ql.tests.TestHelper;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by bore on 24/02/15.
 */
public class Arithmetic
{
    @Test
    public void addInt()
    {
        IntegerValue v = TestHelper.as(TestHelper.evaluate("1+2", null), IntegerValue.class);
        assertNotNull(v);
        assertEquals(((Integer)3), v.getValue());
    }

    @Test
    public void addString()
    {
        StringValue v = TestHelper.as(TestHelper.evaluate("\"str\"+\"ing\"", null), StringValue.class);
        assertNotNull(v);
        assertEquals("string", v.getValue());
    }

    @Test
    public void addDec()
    {
        DecimalValue v = TestHelper.as(TestHelper.evaluate("1.2+2.8", null), DecimalValue.class);
        assertNotNull(v);
        assertEquals(new BigDecimal("4.0"), v.getValue());
    }

    @Test
    public void subInt()
    {
        IntegerValue v = TestHelper.as(TestHelper.evaluate("10-5", null), IntegerValue.class);
        assertNotNull(v);
        assertEquals(((Integer)5), v.getValue());
    }

    @Test
    public void subDec()
    {
        DecimalValue v = TestHelper.as(TestHelper.evaluate("5.5 - 3.5", null), DecimalValue.class);
        assertNotNull(v);
        assertEquals(new BigDecimal("2.0"), v.getValue());
    }

    @Test
    public void mulInt()
    {
        IntegerValue v = TestHelper.as(TestHelper.evaluate("10 * 5", null), IntegerValue.class);
        assertNotNull(v);
        assertEquals(((Integer)50), v.getValue());
    }

    @Test
    public void mulDec()
    {
        DecimalValue v = TestHelper.as(TestHelper.evaluate("5.5 * 2.0", null), DecimalValue.class);
        assertNotNull(v);
        assertEquals(new BigDecimal("11.00"), v.getValue());
    }

    @Test
    public void divInt()
    {
        IntegerValue v = TestHelper.as(TestHelper.evaluate("10 / 3", null), IntegerValue.class);
        assertNotNull(v);
        assertEquals(((Integer)3), v.getValue());
    }

    @Test
    public void divDec()
    {
        DecimalValue v = TestHelper.as(TestHelper.evaluate("10.0 / 3.0", null), DecimalValue.class);
        assertNotNull(v);
        assertEquals(new BigDecimal("3.33333"), v.getValue());
    }

    @Test
    public void negInt()
    {
        IntegerValue v = TestHelper.as(TestHelper.evaluate("-3", null), IntegerValue.class);
        assertNotNull(v);
        assertEquals(((Integer)(-3)), v.getValue());
    }

    @Test
    public void negDec()
    {
        DecimalValue v = TestHelper.as(TestHelper.evaluate("-3.0", null), DecimalValue.class);
        assertNotNull(v);
        assertEquals(new BigDecimal("-3.0"), v.getValue());
    }

    @Test
    public void posInt()
    {
        IntegerValue v = TestHelper.as(TestHelper.evaluate("+3", null), IntegerValue.class);
        assertNotNull(v);
        assertEquals(((Integer)3), v.getValue());
    }

    @Test
    public void posDec()
    {
        DecimalValue v = TestHelper.as(TestHelper.evaluate("+3.0", null), DecimalValue.class);
        assertNotNull(v);
        assertEquals(new BigDecimal("3.0"), v.getValue());
    }

    @Test
    public void undefinedAdd()
    {
        ValueTable table = new ValueTable();
        table.storeValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("2+hasHouse+1", table), UndefinedValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedSub()
    {
        ValueTable table = new ValueTable();
        table.storeValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("2-hasHouse-1", table), UndefinedValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedMul()
    {
        ValueTable table = new ValueTable();
        table.storeValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("2*hasHouse*1", table), UndefinedValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedDiv()
    {
        ValueTable table = new ValueTable();
        table.storeValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("2/hasHouse/1", table), UndefinedValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedPos()
    {
        ValueTable table = new ValueTable();
        table.storeValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("+hasHouse", table), UndefinedValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedNeg()
    {
        ValueTable table = new ValueTable();
        table.storeValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("-hasHouse", table), UndefinedValue.class);
        assertNotNull(v);
    }
}
