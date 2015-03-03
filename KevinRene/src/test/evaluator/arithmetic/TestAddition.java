package test.evaluator.arithmetic;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cons.Value;
import cons.value.FloatValue;
import cons.value.IntegerValue;
import cons.value.UndefinedValue;
import test.evaluator.BaseTest;

@RunWith(value = Parameterized.class)
public class TestAddition extends BaseTest {
	 @Parameters
     public static Collection<Object[]> data() {
    	 BaseTest.header = "Addition";
    	 
    	 return Arrays.asList(new Object[][] {
    			// Integers with integers.
				{ "5 + 10", new IntegerValue(15) },
				// Integer with float and vice versa.
				{ "5 + 10.5", new FloatValue((float) 15.5) },
				{ "10.5 + 5", new FloatValue((float) 15.5) },
				// Floats with floats.
				{ "5.0 + 10.5", new FloatValue((float) 15.5) },
				
				// Identifiers pointing to a integer.
				{ "integerQuestion + 10", new IntegerValue(20) },
				{ "10 + integerQuestion", new IntegerValue(20) },
				
				// Identifiers pointing to a float.
				{ "floatQuestion + 10", new FloatValue((float) 20.5) },
				{ "10 + floatQuestion", new FloatValue((float) 20.5) },
				
				// Undefined
				{ "undefinedQuestion + 10", new UndefinedValue() },
				{ "10 + undefinedQuestion", new UndefinedValue() },
				{ "undefinedQuestion + 10.5", new UndefinedValue() },
				{ "10.5 + undefinedQuestion", new UndefinedValue() },
    	 });
     }

     @SuppressWarnings("rawtypes")
     public TestAddition(String input, Value expected) {
    	 super(input, expected); 
     }
}