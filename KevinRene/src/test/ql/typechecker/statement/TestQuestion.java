package test.ql.typechecker.statement;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.ql.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestQuestion extends BaseTest {
	public static String createComputedQuestion(String questionType) {
		return "aQuestion : " + questionType + " { \"Question text\" }";
	}
	
	@Parameters
    public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			 	{ createComputedQuestion("boolean"), true },
					{ createComputedQuestion("integer"), true },
					{ createComputedQuestion("float"), true },
					{ createComputedQuestion("money"), true },
					{ createComputedQuestion("string"), true }
    	 });
	}

	public TestQuestion(String input, boolean expected) {
		super(input, expected);
	}
}
