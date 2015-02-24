package lang.tests.evaluator;

import lang.ql.semantics.EvalEnv;
import lang.ql.semantics.values.BooleanValue;
import lang.ql.semantics.values.UndefinedValue;
import lang.tests.TestHelper;
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
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1.1>1.0", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void gtDecFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1.0>1.0", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void gtIntTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("3>1", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
    @Test
    public void gtIntFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1>3", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void ltDecTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1.0<1.1", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void ltDecFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1.0<1.0", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void ltIntTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1<3", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
    @Test
    public void ltIntFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("3<1", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void ltEquDecTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1.0<=1.1", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void ltEquDecFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1.1<=1.0", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void ltEquIntTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1<=3", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
    @Test
    public void ltEquIntFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("3<=1", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void gtEquDecTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1.1>=1.0", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void gtEquDecFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1.0>=1.1", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void gtEquIntTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("3>=1", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
    @Test
    public void gtEquIntFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1>=3", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void notEquBoolTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("true!=false", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void notEquBoolFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("true!=true", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void notEquStringTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("\"string\"!=\"s\"", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void notEquStringFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("\"string\"!=\"string\"", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void notEquDecTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1.0!=1.1", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void notEquDecFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1.0!=1.0", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void notEquIntTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("10!=11", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
    @Test
    public void notEquIntFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1!=1", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void equBoolTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("true==true", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void equBoolFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("true==false", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void equStringTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("\"string\"==\"string\"", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void equStringFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("\"string\"==\"s\"", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void equDecTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1.0==1.0", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void equDecFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1.0==1.1", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void equIntTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("10==10", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void equIntFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("1==2", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void undefinedEqu()
    {
        EvalEnv env = new EvalEnv();
        env.registerValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("1==hasHouse==2", env), UndefinedValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedLt()
    {
        EvalEnv env = new EvalEnv();
        env.registerValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("1<hasHouse<2", env), UndefinedValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedGt()
    {
        EvalEnv env = new EvalEnv();
        env.registerValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("1>hasHouse>2", env), UndefinedValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedLtEqu()
    {
        EvalEnv env = new EvalEnv();
        env.registerValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("1<=hasHouse<=2", env), UndefinedValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedGtEqu()
    {
        EvalEnv env = new EvalEnv();
        env.registerValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("1>=hasHouse>=2", env), UndefinedValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedNotEqu()
    {
        EvalEnv env = new EvalEnv();
        env.registerValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("1!=hasHouse!=2", env), UndefinedValue.class);
        assertNotNull(v);
    }
}
