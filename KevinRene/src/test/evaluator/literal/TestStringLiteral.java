package test.evaluator.literal;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.evaluator.BaseTest;
import cons.Value;
import cons.value.StringValue;

@RunWith(value = Parameterized.class)
public class TestStringLiteral extends BaseTest {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			 { "\"A string\"", new StringValue("A string") },
    			 { "\"A \\" + "\"nested\\"+ "\" string\"", new StringValue("A \"nested\" string") },
    			 { "stringQuestion", new StringValue("A string") }
    	 });
     }

     @SuppressWarnings("rawtypes")
     public TestStringLiteral(String input, Value expected) {
    	 super(input, expected);
     }
}
