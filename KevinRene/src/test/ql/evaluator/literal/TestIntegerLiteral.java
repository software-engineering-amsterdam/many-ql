package test.ql.evaluator.literal;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ql.Value;
import ql.value.IntegerValue;
import test.ql.evaluator.BaseTest;

@RunWith(value = Parameterized.class)
public class TestIntegerLiteral extends BaseTest {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			 { "10", new IntegerValue(10) },
    			 { "-10", new IntegerValue(-10) },
    			 { "integerQuestion", new IntegerValue(10) }
    	 });
     }

     public TestIntegerLiteral(String input, Value expected) {
    	 super(input, expected);
     }
}
