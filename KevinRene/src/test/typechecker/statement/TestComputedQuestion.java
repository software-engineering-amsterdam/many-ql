package test.typechecker.statement;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cons.TypeEnvironment;
import cons.ql.ast.ASTNode;
import cons.ql.ast.visitor.typechecker.TypeChecker;
import cons.ql.parser.Parser;

@RunWith(value = Parameterized.class)
public class TestComputedQuestion {
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

	private ASTNode inputNode;
	private boolean expected;

	private Parser formParser = new Parser();
	private TypeEnvironment register = new TypeEnvironment();

	public TestComputedQuestion(String input, boolean expected) {
		System.out.println("Testing: " + input);

		register = new TypeEnvironment();

		inputNode = formParser.parse(input);
		this.expected = expected;
	}

	@BeforeClass
	public static void printHeader() {
		System.out.println("=================================");
		System.out.println("*** Testing Computed Question ***");
		System.out.println("=================================");
	}

	@Test
	public void test() {
		assertEquals(expected, TypeChecker.check(inputNode, register));
	}
}
