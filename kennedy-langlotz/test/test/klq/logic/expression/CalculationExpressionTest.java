package test.klq.logic.expression;

import com.klq.logic.expression.CalculationExpression;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by Timon on 17.02.2015.
 */
public class CalculationExpressionTest {

    @Test
    public void test1() throws Exception{
        CalculationExpression ce = new CalculationExpression("14.23 * 27");
        assertTrue(ce.evaluate().startsWith("384.21"));
    }

    @Test
    public void test2() throws Exception{
        CalculationExpression ce = new CalculationExpression("12- 2.45");
        assertTrue(ce.evaluate().startsWith("9.55"));

    }

    @Test
    public void test3() throws Exception{
        CalculationExpression ce = new CalculationExpression("(1+2)*3");
        assertTrue(ce.evaluate().startsWith("9"));
    }

    @Test
    public void test4() throws Exception{
        CalculationExpression ce = new CalculationExpression("(1+(2*3)+2)*(2-3)");
        assertTrue(ce.evaluate().startsWith("-9"));
    }
}
