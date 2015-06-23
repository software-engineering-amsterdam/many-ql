package test.ql.typechecker.literal;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.ql.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestStringLiteral extends BaseTest {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			// Integer.
    			{  "aQuestion : string { \"Integer\" assign(42) }", false},
				// Float.
				{  "aQuestion : string { \"Float\" assign(10.1) }", false},
				// Strings.
				{  "aQuestion : string { \"String\" assign(\"Waddap\") }", true},
				// Booleans.
				{  "aQuestion : string { \"Boolean\" assign(true) }", false},
				// Identifiers pointing to a integer.
				{ "form myForm { "
					+ "	newQuestion : integer { \"Number\" }"
					+ "	secondQuestion : string { \"Number\" assign(newQuestion) }"
					+ "}", false},
				// Identifiers pointing to a float.
				{ "form myForm { "
					+ "	newQuestion : float { \"Number\" }"
					+ "	secondQuestion : string { \"Number\" assign(newQuestion) }"
					+ "}", false},
				{ "form myForm { "
					+ "	newQuestion : money { \"Number\" }"
					+ "	secondQuestion : string { \"Number\" assign(newQuestion) }"
					+ "}", false},
				// Identifier pointing to a string.
				{ "form myForm { "
					+ "	newQuestion : string { \"String\" }"
					+ "	secondQuestion : string { \"Number\" assign(newQuestion) }"
					+ "}", true},
				// Identifier pointing to a boolean.
				{ "form myForm { "
					+ "	newQuestion : boolean { \"Boolean\" }"
					+ "	secondQuestion : string { \"Number\" assign(newQuestion) }"
					+ "}", false},
    	 });
     }

     public TestStringLiteral(String input, boolean expected) {
    	 super(input, expected);
     }
}
