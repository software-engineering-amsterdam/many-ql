package test.typechecker.relational;

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
public class TestNot {
	public static String createTestForm(String questionType) {
		return "form myForm { "
				+ "newQuestion : " + questionType + " { \"Something\" }"
				+ "if(!newQuestion) {}"
				+ "}";
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
				{ "!true", true },
				{ "!false", true },
				// Type mismatch
				{ "!5", false }, 
				{ "!5.0", false },
				{ "!\"String\"", false },
				// Forms with identifiers
				{ createTestForm("integer"), false },
				{ createTestForm("float"), false },
				{ createTestForm("money"), false },
				{ createTestForm("string"), false },
				{ createTestForm("boolean"), true }
			});
	}

	private ASTNode inputNode;
	private boolean expected;

	private Parser formParser = new Parser();
	private TypeEnvironment register = new TypeEnvironment();

	public TestNot(String input, boolean expected) {
		System.out.println("Testing: " + input);
		
		register = new TypeEnvironment();

		inputNode = formParser.parse(input);
		this.expected = expected;
	}

	@BeforeClass
	public static void printHeader() {
		System.out.println("===================");
		System.out.println("*** Testing Not ***");
		System.out.println("===================");
	}

	@Test
	public void test() {
		assertEquals(expected, TypeChecker.check(inputNode, register));
	}
}
