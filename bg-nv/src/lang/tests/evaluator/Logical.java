package lang.tests.evaluator;

import lang.ql.semantics.EvalEnv;
import lang.ql.semantics.values.BooleanValue;
import lang.ql.semantics.values.UndefinedValue;
import lang.tests.TestHelper;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bore on 24/02/15.
 */
public class Logical
{
    @Test
    public void andFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("true&&false", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void andTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("true&&true", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void orTrue()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("true||false", null), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }

    @Test
    public void orFalse()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("false||false", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void not()
    {
        BooleanValue v = TestHelper.as(TestHelper.evaluate("!true", null), BooleanValue.class);
        assertNotNull(v);
        assertFalse(v.getValue());
    }

    @Test
    public void undefinedNot()
    {
        EvalEnv env = new EvalEnv();
        env.registerValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("!hasHouse", env), UndefinedValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedAnd()
    {
        EvalEnv env = new EvalEnv();
        env.registerValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("true&&hasHouse&&false", env), UndefinedValue.class);
        assertNotNull(v);
    }

    @Test
    public void undefinedOr()
    {
        EvalEnv env = new EvalEnv();
        env.registerValue("hasHouse", new UndefinedValue());
        UndefinedValue v = TestHelper.as(TestHelper.evaluate("true||hasHouse||false", env), UndefinedValue.class);
        assertNotNull(v);
    }
}
