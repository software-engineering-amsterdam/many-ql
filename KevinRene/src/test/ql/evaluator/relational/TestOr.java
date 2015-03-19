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
public class TestOr extends BaseTest {
	@Parameters
    public static Collection<Object[]> data() {
   	 return Arrays.asList(new Object[][] {
   			 { "true || false", new BooleanValue(true) },
   			 { "false || true", new BooleanValue(true) },
   			 { "false || false", new BooleanValue(false) },
   			 { "true || true", new BooleanValue(true) },
   			 { "booleanQuestion || false", new BooleanValue(true) },
   			 { "false || booleanQuestion", new BooleanValue(true) },
   	 });
    }

    public TestOr(String input, Value expected) {
   	 super(input, expected);
    }
}
