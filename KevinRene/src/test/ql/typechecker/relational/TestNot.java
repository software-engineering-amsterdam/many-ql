package test.ql.typechecker.relational;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.ql.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestNot extends BaseTest {
	public static String createTestForm(String questionType) {
		return "form myForm { "
				+ "newQuestion : " + questionType + " { \"Something\" }"
				+ "if(!newQuestion) {}"
				+ "}";
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
				{ "!true", true },
				{ "!false", true },
				// Type mismatch
				{ "!5", false }, 
				{ "!5.0", false },
				{ "!\"String\"", false },
				// Forms with identifiers
				{ createTestForm("integer"), false },
				{ createTestForm("float"), false },
				{ createTestForm("money"), false },
				{ createTestForm("string"), false },
				{ createTestForm("boolean"), true }
			});
	}

	public TestNot(String input, boolean expected) {
		super(input, expected);
	}
}
