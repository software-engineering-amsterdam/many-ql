package test.qls.typechecker.statement;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.qls.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestQuestion extends BaseTest {
	public static String createAllQuestionStylesheet() {
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
				+ 		"}"
				+ "}";
	}
	public static String createQuestionWidget(String identifier, String widget) {
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
				+ 			"question " + identifier + " {"
				+ 				"widget " + widget 
				+ 			"}"
				+ 		"}"
				+ "}";
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ createAllQuestionStylesheet(), true },
				{ createQuestionWidget("booleanQuestion", "dropdown(\"Yes\", \"No\")"), true },
				
				{ createQuestionWidget("integerQuestion", "dropdown(\"Yes\", \"No\")"), false },
			}
		);
	}

	public TestQuestion(String input, boolean expected) {
		super(input, expected);
	}
}
