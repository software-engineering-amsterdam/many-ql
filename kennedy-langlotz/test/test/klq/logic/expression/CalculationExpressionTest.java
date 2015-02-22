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
        CalculationExpression ce = new CalculationExpression("5 + ((1 + 2) * 4) - 3");
        String rpn = ce.evaluate();
        assertEquals(rpn, "14");
    }

    @Test
    public void test2() throws Exception{
        CalculationExpression ce = new CalculationExpression("-1+2");
        String rpn = ce.evaluate();
        assertEquals(rpn, "1");
    }

    @Test
    public void test3() throws Exception{
        CalculationExpression ce = new CalculationExpression("2+(-3+1)");
        String rpn = ce.evaluate();
        assertEquals(rpn, "0");
    }

    @Test
    public void test4() throws Exception{
        CalculationExpression ce = new CalculationExpression("2+(-3*(-2))+1");
        String rpn = ce.evaluate();
        assertEquals(rpn, "9");
    }

    @Test
    public void test5() throws Exception{
        CalculationExpression ce = new CalculationExpression("-(13.3-0.3)+5");
        String rpn = ce.evaluate();
        assertEquals(rpn, "-8");
    }
}
