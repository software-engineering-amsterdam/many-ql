package test.klq.logic.expression;

import com.klq.logic.expression.comparison.ComparisonExpression;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Timon on 22.02.2015.
 */
public class ComparisonExpressionTest {

    @Test
    public void test1(){
        ComparisonExpression ce = new ComparisonExpression("3 < 5");
        assertEquals(ce.evaluate(), "true");
    }

    @Test
    public void test2(){
        ComparisonExpression ce = new ComparisonExpression("21.12.1990 > 22.02.2015");
        assertEquals(ce.evaluate(), "false");
    }

    @Test
    public void test3(){
        ComparisonExpression ce = new ComparisonExpression("\"beer\" < \"Zoo\"");
        assertEquals(ce.evaluate(), "true");
    }
}
