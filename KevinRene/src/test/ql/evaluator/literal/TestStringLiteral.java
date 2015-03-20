package test.ql.evaluator.literal;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ql.Value;
import ql.value.StringValue;
import test.ql.evaluator.BaseTest;

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

     public TestStringLiteral(String input, Value expected) {
    	 super(input, expected);
     }
}
