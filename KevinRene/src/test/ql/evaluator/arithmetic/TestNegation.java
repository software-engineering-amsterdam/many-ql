package test.ql.evaluator.arithmetic;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ql.Value;
import ql.value.FloatValue;
import ql.value.IntegerValue;
import ql.value.UndefinedValue;
import test.ql.evaluator.BaseTest;

@RunWith(value = Parameterized.class)
public class TestNegation extends BaseTest {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
     			// Integer.
 				{ "-5", new IntegerValue(-5) },
 				// Float.
 				{ "-10.5", new FloatValue((float) -10.5) },
 				// Identifiers pointing to a integer.
 				{ "-integerQuestion", new IntegerValue(-10) },
 				// Identifiers pointing to a float.
 				{ "-floatQuestion", new FloatValue((float) -10.5) },
 				// Undefined
 				{ "-undefinedQuestion", new UndefinedValue() }
     	 });
     }

     public TestNegation(String input, Value expected) {
    	 super(input, expected); 
     }
}
