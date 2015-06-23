package test.ql.typechecker.statement;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.ql.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestComputedQuestion extends BaseTest {
	public static String createComputedQuestion(String questionType, String assignment) {
		return "aQuestion : " + questionType + " { \"Question text\" assign(" + assignment + ") }";
	}
	
	@Parameters
    public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			 	{ createComputedQuestion("boolean", "true"), true },
					{ createComputedQuestion("integer", "5"), true },
					{ createComputedQuestion("integer", "5.0"), true },
					{ createComputedQuestion("float", "5"), true },
					{ createComputedQuestion("float", "5.0"), true },
					{ createComputedQuestion("money", "5"), true },
					{ createComputedQuestion("money", "5.0"), true },
					{ createComputedQuestion("string", "\"String\""), true },
					
					{ createComputedQuestion("boolean", "5"), false },
					{ createComputedQuestion("boolean", "5.0"), false },
					{ createComputedQuestion("boolean", "\"String\""), false },
					{ createComputedQuestion("integer", "true"), false },
					{ createComputedQuestion("integer", "\"String\""), false },
					{ createComputedQuestion("float", "true"), false },
					{ createComputedQuestion("float", "\"String\""), false },
					{ createComputedQuestion("money", "true"), false },
					{ createComputedQuestion("money", "\"String\""), false },
					{ createComputedQuestion("string", "true"), false },
					{ createComputedQuestion("string", "5"), false },
					{ createComputedQuestion("string", "5.0"), false },
    	 });
    }
	
    public TestComputedQuestion(String input, boolean expected) {
		super(input, expected);
	}
}
