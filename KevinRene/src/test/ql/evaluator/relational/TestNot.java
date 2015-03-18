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
public class TestNot extends BaseTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ "!true", new BooleanValue(false) },
				{ "!false", new BooleanValue(true) },
				{ "!!true", new BooleanValue(true) },
				{ "!!false", new BooleanValue(false) }, 
		});
	}

	public TestNot(String input, Value expected) {
		super(input, expected);
	}
}
