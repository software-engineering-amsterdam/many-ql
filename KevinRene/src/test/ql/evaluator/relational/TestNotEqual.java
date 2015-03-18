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
public class TestNotEqual extends BaseTest {
	@Parameters
    public static Collection<Object[]> data() {
   	 return Arrays.asList(new Object[][] {
   			{ "true != false", new BooleanValue(true) },
   			{ "false != true", new BooleanValue(true) },
   			{ "false != false", new BooleanValue(false) },
   			{ "true != true", new BooleanValue(false) },
   			{ "booleanQuestion != false", new BooleanValue(true) },
   			{ "false != booleanQuestion", new BooleanValue(true) },
   			{ "true != booleanQuestion", new BooleanValue(false) },
   			
   			{ "5 != 5", new BooleanValue(false) },
   			{ "5 != 7", new BooleanValue(true) },
   			
   			{ "5.0 != 5.0", new BooleanValue(false) },
   			{ "5.0 != 7.0", new BooleanValue(true) },
   			
   			{ "5.0 != 5", new BooleanValue(false) },
   			{ "5 != 5.0", new BooleanValue(false) },
   			
   			{ "5.0 != 7", new BooleanValue(true) },
   			{ "5 != 7.0", new BooleanValue(true) },
   			
   			{ "\"Bob\" != \"Bob\"", new BooleanValue(false) },
   			{ "\"Bob\" != \"Fred\"", new BooleanValue(true) },
   	 });
    }

    public TestNotEqual(String input, Value expected) {
    	super(input, expected);
    }
}
