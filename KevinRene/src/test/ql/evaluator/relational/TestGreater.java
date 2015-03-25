package test.ql.evaluator.relational;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ql.Value;
import ql.value.BooleanValue;
import ql.value.UndefinedValue;
import test.ql.evaluator.BaseTest;

@RunWith(value = Parameterized.class)
public class TestGreater extends BaseTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ "3 > 5", new BooleanValue(false) },
				{ "5 > 5", new BooleanValue(false) },
	   			{ "7 > 5", new BooleanValue(true) },
	   			{ "integerQuestion > 5", new BooleanValue(true) },
	   			{ "integerQuestion > 10", new BooleanValue(false) },
	   			{ "integerQuestion > 15", new BooleanValue(false) },
	   			{ "5 > integerQuestion", new BooleanValue(false) },
	   			{ "10 > integerQuestion", new BooleanValue(false) },
	   			{ "15 > integerQuestion", new BooleanValue(true) },
	   			
	   			{ "3.0 > 5.0", new BooleanValue(false) },
				{ "5.0 > 5.0", new BooleanValue(false) },
	   			{ "7.0 > 5.0", new BooleanValue(true) },
	   			{ "floatQuestion > 5.0", new BooleanValue(true) },
	   			{ "floatQuestion > 10.5", new BooleanValue(false) },
	   			{ "floatQuestion > 15.0", new BooleanValue(false) },
	   			{ "5.0 > floatQuestion", new BooleanValue(false) },
	   			{ "10.5 > floatQuestion", new BooleanValue(false) },
	   			{ "15.0 > floatQuestion", new BooleanValue(true) },
	   			
	   			{ "3 > 5.0", new BooleanValue(false) },
				{ "5 > 5.0", new BooleanValue(false) },
	   			{ "7 > 5.0", new BooleanValue(true) },
	   			{ "integerQuestion > 5.0", new BooleanValue(true) },
	   			{ "integerQuestion > 10.0", new BooleanValue(false) },
	   			{ "integerQuestion > 15.0", new BooleanValue(false) },
	   			{ "5.0 > integerQuestion", new BooleanValue(false) },
	   			{ "10.0 > integerQuestion", new BooleanValue(false) },
	   			{ "15.0 > integerQuestion", new BooleanValue(true) },
	   			
	   			{ "3.0 > 5", new BooleanValue(false) },
				{ "5.0 > 5", new BooleanValue(false) },
	   			{ "7.0 > 5", new BooleanValue(true) },
	   			{ "floatQuestion > 5", new BooleanValue(true) },
	   			{ "floatQuestion > 10", new BooleanValue(true) },
	   			{ "floatQuestion > 15", new BooleanValue(false) },
	   			{ "5 > floatQuestion", new BooleanValue(false) },
	   			{ "10 > floatQuestion", new BooleanValue(false) },
	   			{ "15 > floatQuestion", new BooleanValue(true) },
	   			
	   			{ "undefinedQuestion > 10.5", new UndefinedValue() },
	   			{ "10.5 > undefinedQuestion", new UndefinedValue() },
	   			
	   			{ "undefinedQuestion > 10", new UndefinedValue() },
	   			{ "10 > undefinedQuestion", new UndefinedValue() },	   			
		});
	}

	public TestGreater(String input, Value expected) {
		super(input, expected);
	}
}
