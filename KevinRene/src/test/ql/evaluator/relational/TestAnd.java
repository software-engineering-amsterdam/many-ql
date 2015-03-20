package test.ql.evaluator.relational;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ql.Value;
import ql.value.BooleanValue;
import test.ql.evaluator.BaseTest;

@RunWith(value = Parameterized.class)
public class TestAnd extends BaseTest {
	@Parameters
    public static Collection<Object[]> data() {
   	 return Arrays.asList(new Object[][] {
   			 { "true && false", new BooleanValue(false) },
   			 { "false && true", new BooleanValue(false) },
   			 { "false && false", new BooleanValue(false) },
   			 { "true && true", new BooleanValue(true) },
   			 { "booleanQuestion && false", new BooleanValue(false) },
   			 { "booleanQuestion && true", new BooleanValue(true) },
   			 { "false && booleanQuestion", new BooleanValue(false) },
   			 { "true && booleanQuestion", new BooleanValue(true) },
   	 });
    }

    public TestAnd(String input, Value expected) {
   	 super(input, expected);
    }
}
