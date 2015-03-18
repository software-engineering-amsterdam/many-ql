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
				+ 			"question integerQuestion {"
				+ 				"widget text"
				+ 			"}"
				+ 			"question floatQuestion {"
				+ 				"widget spinbox"
				+ 			"}"
				+ 			"question stringQuestion {"
				+ 				"widget text"
				+ 			"}"
				+ 			"question booleanQuestion {"
				+ 				"widget checkbox"
				+ 			"}"
				+ 			"default " + type + " {"
				+ 				"widget " + widget 
				+ 			"}"
				+ 		"}"
				+ "}";
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ createDefaultStyledWidget("boolean", "dropdown(\"Yes\", \"No\")"), true },
				{ createDefaultStyledWidget("boolean", "radio(\"Yes\", \"No\")"), true },
				{ createDefaultStyledWidget("boolean", "checkbox"), true },
				
				{ createDefaultStyledWidget("integer", "dropdown(\"Yes\", \"No\")"), false },
			}
		);
	}

	public TestDefault(String input, boolean expected) {
		super(input, expected);
	}
}
