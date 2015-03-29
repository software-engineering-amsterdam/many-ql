package ql.tests.evaluator;

import ql.semantics.ValueTable;
import ql.semantics.values.*;
import ql.tests.TestHelper;
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
        IntValue v = TestHelper.as(TestHelper.evaluate("1+2", null), IntValue.class);
        assertNotNull(v);
        assertEquals(((Integer)3), v.getValue());
    }

    @Test
    public void addString()
    {
        StrValue v = TestHelper.as(TestHelper.evaluate("\"str\"+\"ing\"", null), StrValue.class);
        assertNotNull(v);
        assertEquals("string", v.getValue());
    }

    @Test
    public void addDec()
    {
        DecValue v = TestHelper.as(TestHelper.evaluate("1.2+2.8", null), DecValue.class);
        assertNotNull(v);
        assertEquals(new BigDecimal("4.0"), v.getValue());
    }

    @Test
    public void subInt()
    {
        IntValue v = TestHelper.as(TestHelper.evaluate("10-5", null), IntValue.class);
        assertNotNull(v);
        assertEquals(((Integer)5), v.getValue());
    }

    @Test
    public void subDec()
    {
        DecValue v = TestHelper.as(TestHelper.evaluate("5.5 - 3.5", null), DecValue.class);
        assertNotNull(v);
        assertEquals(new BigDecimal("2.0"), v.getValue());
    }

    @Test
    public void mulInt()
    {
        IntValue v = TestHelper.as(TestHelper.evaluate("10 * 5", null), IntValue.class);
        assertNotNull(v);
        assertEquals(((Integer)50), v.getValue());
    }

    @Test
    public void mulDec()
    {
        DecValue v = TestHelper.as(TestHelper.evaluate("5.5 * 2.0", null), DecValue.class);
        assertNotNull(v);
        assertEquals(new BigDecimal("11.00"), v.getValue());
    }

    @Test
    public void divInt()
    {
        IntValue v = TestHelper.as(TestHelper.evaluate("10 / 3", null), IntValue.class);
        assertNotNull(v);
        assertEquals(((Integer)3), v.getValue());
    }

    @Test
    public void divDec()
    {
        DecValue v = TestHelper.as(TestHelper.evaluate("10.0 / 3.0", null), DecValue.class);
        assertNotNull(v);
        assertEquals(new BigDecimal("3.33333"), v.getValue());
    }

    @Test
    public void negInt()
    {
        IntValue v = TestHelper.as(TestHelper.evaluate("-3", null), IntValue.class);
        assertNotNull(v);
        assertEquals(((Integer)(-3)), v.getValue());
    }

    @Test
    public void negDec()
    {
        DecValue v = TestHelper.as(TestHelper.evaluate("-3.0", null), DecValue.class);
        assertNotNull(v);
        assertEquals(new BigDecimal("-3.0"), v.getValue());
    }

    @Test
    public void posInt()
    {
        IntValue v = TestHelper.as(TestHelper.evaluate("+3", null), IntValue.class);
        assertNotNull(v);
        assertEquals(((Integer)3), v.getValue());
    }

    @Test
    public void posDec()
    {
        DecValue v = TestHelper.as(TestHelper.evaluate("+3.0", null), DecValue.class);
        assertNotNull(v);
        assertEquals(new BigDecimal("3.0"), v.getValue());
    }

    @Test
    public void undefinedAdd()
    {
        ValueTable table = new ValueTable();
        table.storeEntry("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("2+hasHouse+1", table), UndefValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedSub()
    {
        ValueTable table = new ValueTable();
        table.storeEntry("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("2-hasHouse-1", table), UndefValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedMul()
    {
        ValueTable table = new ValueTable();
        table.storeEntry("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("2*hasHouse*1", table), UndefValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedDiv()
    {
        ValueTable table = new ValueTable();
        table.storeEntry("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("2/hasHouse/1", table), UndefValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedPos()
    {
        ValueTable table = new ValueTable();
        table.storeEntry("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("+hasHouse", table), UndefValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedNeg()
    {
        ValueTable table = new ValueTable();
        table.storeEntry("hasHouse", new UndefValue());
        UndefValue v = TestHelper.as(TestHelper.evaluate("-hasHouse", table), UndefValue.class);
        assertNotNull(v);
    }
}
