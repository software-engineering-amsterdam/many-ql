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
        assertEquals(ce.isValidExpression(), true);
    }
}
