package test.klq.logic.expression;

import com.klq.logic.expression.operator.bool.*;
import com.klq.logic.expression.operator.math.Addition;
import com.klq.logic.expression.operator.math.Division;
import com.klq.logic.expression.operator.math.Multiplication;
import com.klq.logic.expression.operator.math.Subtraction;
import com.klq.logic.expression.terminal.*;
import com.klq.logic.expression.terminal.Boolean;
import com.klq.logic.expression.terminal.Number;
import com.klq.logic.expression.terminal.String;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Timon on 23.02.2015.
 */
public class ExpressionTest {

    @Test
    public void testMath(){
        Number n1 = new Number("5");
        Number n2 = new Number("-2");
        Addition additionNode = new Addition(n1, n2);
        Subtraction subtractionNode = new Subtraction(n1, n2);
        Multiplication multiplicationNode = new Multiplication(n1, n2);
        Division divisionNode = new Division(n1, n2);

        assertEquals(additionNode.evaluate().getContent(), "3");
        assertEquals(subtractionNode.evaluate().getContent(), "7");
        assertEquals(multiplicationNode.evaluate().getContent(), "-10");
        assertEquals(divisionNode.evaluate().getContent(), "-2.5");
    }

    @Test
    public void testMathDecimal(){
        Number n1 = new Number("4.3");
        Number n2 = new Number("-2.78");
        Addition additionNode = new Addition(n1, n2);
        Subtraction subtractionNode = new Subtraction(n1, n2);
        Multiplication multiplicationNode = new Multiplication(n1, n2);
        Division divisionNode = new Division(n1, n2);

        assertEquals(additionNode.evaluate().getContent(), "1.52");
        assertEquals(subtractionNode.evaluate().getContent(), "7.08");
        assertEquals(multiplicationNode.evaluate().getContent(), "-11.954");
        //Precision (Div.PRECISION) is set to 100, i.e. 100 decimal digitis
        assertTrue(divisionNode.evaluate().getContent().startsWith("-1.5467625899280575539568345323741"));
    }

    @Test
    public void nestedMath(){
        Number x1 = new Number("10");
        Number x2 = new Number("15");

        Number y1 = new Number("3");

        Addition add = new Addition(x1, x2);
        Multiplication mul = new Multiplication(y1, add);
        assertEquals(mul.evaluate().getContent(), "75");
    }

    @Test
    public void testEqualNotEqualString(){
        String s1 = new String("This is a string!");
        String s2 = new String("This is a string!");
        Equals eqNode = new Equals(s1, s2);
        NotEquals neqNode = new NotEquals(s1, s2);
        assertEquals(eqNode.evaluate(), Boolean.getTrue());
        assertEquals(neqNode.evaluate(), Boolean.getFalse());
    }

    @Test
    public void testEqualNotEqualDate(){
        Date d1 = new Date("1990-12-21");
        Date d2 = new Date("1990-12-12");
        Equals eq2Node = new Equals(d1, d2);
        NotEquals neq2Node = new NotEquals(d1, d2);
        assertEquals(eq2Node.evaluate(), Boolean.getFalse());
        assertEquals(neq2Node.evaluate(), Boolean.getTrue());
    }

    @Test
    public void testGreaterThanGreaterEqual(){
        Number n1 = new Number("12.23");
        Number n2 = new Number("12.23");
        GreaterThan gt = new GreaterThan(n1, n2);
        GreaterEquals ge = new GreaterEquals(n1, n2);
        assertEquals(gt.evaluate(), Boolean.getFalse());
        assertEquals(ge.evaluate(), Boolean.getTrue());
    }

    @Test
    public void testLessThanLessEquals(){
        String s1 = new String("Everything will be alright!");
        String s2 = new String("this should be greater!");
        LessThan lt = new LessThan(s1, s2);
        LessEquals le = new LessEquals(s1, s2);
        assertEquals(lt.evaluate(), Boolean.getTrue());
        assertEquals(le.evaluate(), Boolean.getTrue());
    }
}
