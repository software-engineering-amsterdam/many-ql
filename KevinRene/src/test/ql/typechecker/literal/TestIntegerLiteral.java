package test.ql.typechecker.literal;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.ql.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestIntegerLiteral extends BaseTest {
	public static String createTestForm(String questionType) {
		return "form myForm { "
				+ "newQuestion : " + questionType + " { \"Number\" }"
				+ "secondQuestion : integer { \"Number\" assign(newQuestion) }"
				+ "}";
	}
	
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			// Integer.
    			{  "aQuestion : integer { \"Integer\" assign(42) }", true},
				// Float.
				{  "aQuestion : integer { \"Float\" assign(10.1) }", true},
				// Strings.
				{  "aQuestion : integer { \"String\" assign(\"Waddap\") }", false},
				// Booleans.
				{  "aQuestion : integer { \"Boolean\" assign(true) }", false},
				// Identifiers pointing to a integer.
				{ createTestForm("integer"), true},
				// Identifiers pointing to a float.
				{ createTestForm("float"), true},
				{ createTestForm("money"), true},
				// Identifier pointing to a string.
				{ createTestForm("string"), false},
				// Identifier pointing to a boolean.
				{ createTestForm("boolean"), false},
    	 });
     }
     
     public TestIntegerLiteral(String input, boolean expected) {
    	 super(input, expected);
     }
}
