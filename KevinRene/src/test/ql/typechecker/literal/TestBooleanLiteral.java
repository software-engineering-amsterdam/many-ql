package test.ql.typechecker.literal;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.ql.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestBooleanLiteral extends BaseTest {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			// Integer.
    			{  "aQuestion : boolean { \"Integer\" assign(42) }", false},
				// Float.
				{  "aQuestion : boolean { \"Float\" assign(10.1) }", false},
				// Strings.
				{  "aQuestion : boolean { \"String\" assign(\"Waddap\") }", false},
				// Booleans.
				{  "aQuestion : boolean { \"Boolean\" assign(true) }", true},
				// Identifiers pointing to a integer.
				{ "form myForm { "
					+ "	newQuestion : integer { \"Number\" }"
					+ "	secondQuestion : boolean { \"Number\" assign(newQuestion) }"
					+ "}", false},
				// Identifiers pointing to a float.
				{ "form myForm { "
					+ "	newQuestion : float { \"Number\" }"
					+ "	secondQuestion : boolean { \"Number\" assign(newQuestion) }"
					+ "}", false},
				{ "form myForm { "
					+ "	newQuestion : money { \"Number\" }"
					+ "	secondQuestion : boolean { \"Number\" assign(newQuestion) }"
					+ "}", false},
				// Identifier pointing to a string.
				{ "form myForm { "
					+ "	newQuestion : string { \"String\" }"
					+ "	secondQuestion : boolean { \"Number\" assign(newQuestion) }"
					+ "}", false},
				// Identifier pointing to a boolean.
				{ "form myForm { "
					+ "	newQuestion : boolean { \"Boolean\" }"
					+ "	secondQuestion : boolean { \"Number\" assign(newQuestion) }"
					+ "}", true},
    	 });
     }

     public TestBooleanLiteral(String input, boolean expected) {
    	 super(input, expected);
     }
}
