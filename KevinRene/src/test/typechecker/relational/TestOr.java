package test.typechecker.relational;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ql.TypeEnvironment;
import ql.ast.ASTNode;
import ql.ast.visitor.typechecker.TypeChecker;
import ql.parser.Parser;

@RunWith(value = Parameterized.class)
public class TestOr {
	public static String createTestForm(String questionType, String comparison) {
		return "form myForm { "
				+ "newQuestion : " + questionType + " { \"Something\" }"
				+ "if(newQuestion || " + comparison + ") {}"
				+ "}";
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
				{ "10 || 100", false },
				{ "10.5 || 10", false }, 
				{ "10.1 || 100.5", false },
				{ "true || false", true }, 
				{ "\"a\" || \"b\"", false },
				// Type mismatch
				{ "10 || true", false }, 
				{ "true || \"string\"", false },
				{ "false || 100.5", false },
				// Forms with identifiers
				{ createTestForm("integer", "5"), false },
				{ createTestForm("integer", "5.0"), false },
				{ createTestForm("integer", "true"), false },
				{ createTestForm("integer", "\"String\""), false },
				{ createTestForm("float", "5"), false },
				{ createTestForm("float", "5.0"), false },
				{ createTestForm("float", "true"), false },
				{ createTestForm("float", "\"String\""), false },
				{ createTestForm("money", "5"), false },
				{ createTestForm("money", "5.0"), false },
				{ createTestForm("money", "true"), false },
				{ createTestForm("money", "\"String\""), false },
				{ createTestForm("string", "5"), false },
				{ createTestForm("string", "5.0"), false },
				{ createTestForm("string", "true"), false },
				{ createTestForm("string", "\"String\""), false },
				{ createTestForm("boolean", "5"), false },
				{ createTestForm("boolean", "5.0"), false },
				{ createTestForm("boolean", "true"), true },
				{ createTestForm("boolean", "\"String\""), false },
			});
	}

	private ASTNode inputNode;
	private boolean expected;

	private Parser formParser = new Parser();
	private TypeEnvironment register = new TypeEnvironment();

	public TestOr(String input, boolean expected) {
		System.out.println("Testing: " + input);

		register = new TypeEnvironment();

		inputNode = formParser.parse(input);
		this.expected = expected;
	}

	@BeforeClass
	public static void printHeader() {
		System.out.println("==================");
		System.out.println("*** Testing Or ***");
		System.out.println("==================");
	}

	@Test
	public void test() {
		assertEquals(expected, TypeChecker.check(inputNode, register));
	}
}
