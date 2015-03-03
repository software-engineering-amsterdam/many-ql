package test.evaluator.relational;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.evaluator.BaseTest;
import cons.Value;
import cons.value.BooleanValue;

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

	@SuppressWarnings("rawtypes")
	public TestNot(String input, Value expected) {
		super(input, expected);
	}
}
