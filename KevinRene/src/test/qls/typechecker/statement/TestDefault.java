package test.qls.typechecker.statement;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.qls.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestDefault extends BaseTest {
	public static String createDefaultStyledWidget(String type, String widget) {
		return 	  "stylesheet formNode {" 
				+ 		"page Housing {"
				+ 			"default " + type + " {"
				+ 				"widget " + widget 
				+ 			"}"
				+ 		"}"
				+ "}";
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ createDefaultStyledWidget("boolean", "spinbox"), true }, });
	}

	public TestDefault(String input, boolean expected) {
		super(input, expected);
	}
}
