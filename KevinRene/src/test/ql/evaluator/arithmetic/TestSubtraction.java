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
public class TestSubtraction extends BaseTest {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			// Integers with integers.
				{ "5 - 10", new IntegerValue(-5) },
				// Integer with float and vice versa.
				{ "5 - 10.5", new FloatValue((float) -5.5) },
				{ "10.5 - 5", new FloatValue((float) 5.5) },
				// Floats with floats.
				{ "5.0 - 10.5", new FloatValue((float) -5.5) },
				
				// Identifiers pointing to a integer.
				{ "integerQuestion - 10", new IntegerValue(0) },
				{ "10 - integerQuestion", new IntegerValue(0) },
				
				// Identifiers pointing to a float.
				{ "floatQuestion - 10", new FloatValue((float) 0.5) },
				{ "10 - floatQuestion", new FloatValue((float) -0.5) },
				
				// Undefined
				{ "undefinedQuestion - 10", new UndefinedValue() },
				{ "10 - undefinedQuestion", new UndefinedValue() },
				{ "undefinedQuestion - 10.5", new UndefinedValue() },
				{ "10.5 - undefinedQuestion", new UndefinedValue() },
    	 });
     }

     public TestSubtraction(String input, Value expected) {
    	 super(input, expected); 
     }
}
