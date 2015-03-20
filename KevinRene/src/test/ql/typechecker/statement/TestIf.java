package test.ql.typechecker.statement;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.ql.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestIf extends BaseTest {
	public static String createTestForm(String questionType) {
		return "form myForm { "
				+ "newQuestion : " + questionType + " { \"Something\" }"
				+ "if(newQuestion) {}"
				+ "}";
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
				{ "if (true) { }", true },
				{ "if (42) { }", false },
				{ "if (4.2) { }", false },
				{ "if (\"String\") { }", false },
				
				{ createTestForm("boolean"), true },
				{ createTestForm("integer"), false },
				{ createTestForm("float"), false },
				{ createTestForm("string"), false },
		});
	}

	public TestIf(String input, boolean expected) {
		super(input, expected);
	}
}