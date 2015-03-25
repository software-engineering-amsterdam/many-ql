package test.ql.typechecker.arithmetic;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.ql.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestPositive extends BaseTest {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			// Integer.
				{ "+5", true },
				// Float.
				{ "+10.5", true},
				// Strings. Not allowed.
				{ "+\"String 1\"", false},
				// Booleans. Not allowed.
				{ "+true", false},
				// Identifiers pointing to a integer.
				{ "form myForm { "
					+ "	newQuestion : integer { \"Number\" }"
					+ "	if(+newQuestion * 5 == 5) {}"
					+ "}", true},
				// Identifiers pointing to a float.
				{ "form myForm { "
					+ "	newQuestion : float { \"Number\" }"
					+ "	if(+newQuestion * 5 == 5) {}"
					+ "}", true},
				{ "form myForm { "
					+ "	newQuestion : money { \"Number\" }"
					+ "	if(+newQuestion * 5 == 5) {}"
					+ "}", true}
    	 });
     }

     public TestPositive(String input, boolean expected) {
    	 super(input, expected);
     }
}
