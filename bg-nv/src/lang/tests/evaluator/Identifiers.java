package lang.tests.evaluator;

import lang.ql.semantics.EvalEnv;
import lang.ql.semantics.values.BooleanValue;
import lang.tests.TestHelper;
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
        EvalEnv env = new EvalEnv();
        env.registerValue("hasHouse", new BooleanValue(true));
        BooleanValue v = TestHelper.as(TestHelper.evaluate("hasHouse", env), BooleanValue.class);
        assertNotNull(v);
        assertTrue(v.getValue());
    }
}
