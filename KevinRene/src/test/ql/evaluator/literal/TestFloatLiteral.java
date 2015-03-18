package test.ql.evaluator.literal;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ql.Value;
import ql.value.FloatValue;
import test.ql.evaluator.BaseTest;

@RunWith(value = Parameterized.class)
public class TestFloatLiteral extends BaseTest {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			 { "10.5", new FloatValue((float) 10.5) },
    			 { "-10.5", new FloatValue((float) -10.5) },
    			 { "floatQuestion", new FloatValue((float) 10.5) }
    	 });
     }

     public TestFloatLiteral(String input, Value expected) {
    	 super(input, expected);
     }
}
