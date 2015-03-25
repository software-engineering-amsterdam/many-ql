package test.ql.typechecker.arithmetic;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.ql.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestMultiplication extends BaseTest {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			// Integers with integers.
				{ "5 * 10", true },
				// Integer with float and vice versa.
				{ "5 * 10.5", true},
				{ "10.5 * 5", true},
				// Floats with floats.
				{ "5.0 * 10.5", true},
				// Strings. Not allowed.
				{ "\"String 1\" * 5", false},
				{ "5 * \"String 1\"", false},
				{ "\"String 1\" * \"String 2\"", false},
				// Booleans. Not allowed.
				{ "true * 5", false},
				{ "5 * true", false},
				{ "true * false", false},
				// Identifiers pointing to a integer.
				{ "form myForm { "
					+ "	newQuestion : integer { \"Number\" }"
					+ "	if(newQuestion * 5 == 5) {}"
					+ "}", true},
				// Identifiers pointing to a float.
				{ "form myForm { "
					+ "	newQuestion : float { \"Number\" }"
					+ "	if(newQuestion * 5 == 5) {}"
					+ "}", true},
				{ "form myForm { "
					+ "	newQuestion : money { \"Number\" }"
					+ "	if(newQuestion * 5 == 5) {}"
					+ "}", true},
				// Identifier pointing to a string. Not allowed to multiply.
				{ "form myForm { "
					+ "	newQuestion : string { \"String\" }"
					+ "	if(newQuestion * 5 == 5) {}"
					+ "}", false},
				// Identifier pointing to a boolean. Not allowed to multiply.
				{ "form myForm { "
					+ "	newQuestion : boolean { \"Boolean\" }"
					+ "	if(newQuestion * 5 == 5) {}"
					+ "}", false},
    	 });
     }

     public TestMultiplication(String input, boolean expected) {
    	 super(input, expected);
     }
}
