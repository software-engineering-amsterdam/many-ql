package test.typechecker.statement;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ql.TypeEnvironment;
import ql.ast.QLNode;
import ql.ast.visitor.typechecker.TypeChecker;
import ql.parser.Parser;

@RunWith(value = Parameterized.class)
public class TestQuestion {
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

	private QLNode inputNode;
	private boolean expected;

	private Parser formParser = new Parser();
	private TypeEnvironment register = new TypeEnvironment();

	public TestQuestion(String input, boolean expected) {
		System.out.println("Testing: " + input);

		register = new TypeEnvironment();

		inputNode = formParser.parse(input);
		this.expected = expected;
	}

	@BeforeClass
	public static void printHeader() {
		System.out.println("========================");
		System.out.println("*** Testing Question ***");
		System.out.println("========================");
	}

	@Test
	public void test() {
		assertEquals(expected, TypeChecker.check(inputNode, register));
	}
}
