package test.evaluator.arithmetic;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.evaluator.BaseTest;
import cons.Value;
import cons.value.FloatValue;
import cons.value.IntegerValue;
import cons.value.UndefinedValue;

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

     @SuppressWarnings("rawtypes")
     public TestNegation(String input, Value expected) {
    	 super(input, expected); 
     }
}
