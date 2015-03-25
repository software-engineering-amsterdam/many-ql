package test.ql.typechecker.literal;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.ql.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestFloatLiteral extends BaseTest {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			// Integer.
    			{  "aQuestion : float { \"Integer\" assign(42) }", true},
				// Float.
				{  "aQuestion : float { \"Float\" assign(10.1) }", true},
				// Strings.
				{  "aQuestion : float { \"String\" assign(\"Waddap\") }", false},
				// Booleans.
				{  "aQuestion : float { \"Boolean\" assign(true) }", false},
				// Identifiers pointing to a integer.
				{ "form myForm { "
					+ "	newQuestion : integer { \"Number\" }"
					+ "	secondQuestion : float { \"Number\" assign(newQuestion) }"
					+ "}", true},
				// Identifiers pointing to a float.
				{ "form myForm { "
					+ "	newQuestion : float { \"Number\" }"
					+ "	secondQuestion : float { \"Number\" assign(newQuestion) }"
					+ "}", true},
				{ "form myForm { "
					+ "	newQuestion : money { \"Number\" }"
					+ "	secondQuestion : float { \"Number\" assign(newQuestion) }"
					+ "}", true},
				// Identifier pointing to a string.
				{ "form myForm { "
					+ "	newQuestion : string { \"String\" }"
					+ "	secondQuestion : float { \"Number\" assign(newQuestion) }"
					+ "}", false},
				// Identifier pointing to a boolean.
				{ "form myForm { "
					+ "	newQuestion : boolean { \"Boolean\" }"
					+ "	secondQuestion : float { \"Number\" assign(newQuestion) }"
					+ "}", false},
    	 });
     }

     public TestFloatLiteral(String input, boolean expected) {
    	 super(input, expected);
     }
}
