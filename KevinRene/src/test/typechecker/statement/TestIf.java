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
import ql.ast.ASTNode;
import ql.ast.visitor.typechecker.TypeChecker;
import ql.parser.Parser;

@RunWith(value = Parameterized.class)
public class TestIf {
	public static String createTestForm(String questionType) {
		return "form myForm { "
				+ "newQuestion : " + questionType + " { \"Something\" }"
				+ "if(newQuestion) {}"
				+ "}";
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
				{ "if (true) { }", true },
				{ "if (42) { }", false },
				{ "if (4.2) { }", false },
				{ "if (\"String\") { }", false },
				
				{ createTestForm("boolean"), true },
				{ createTestForm("integer"), false },
				{ createTestForm("float"), false },
				{ createTestForm("string"), false },
		});
	}

	private ASTNode inputNode;
	private boolean expected;

	private Parser formParser = new Parser();
	private TypeEnvironment register = new TypeEnvironment();

	public TestIf(String input, boolean expected) {
		System.out.println("Testing: " + input);

		register = new TypeEnvironment();

		inputNode = formParser.parse(input);
		this.expected = expected;
	}

	@BeforeClass
	public static void printHeader() {
		System.out.println("==================");
		System.out.println("*** Testing If ***");
		System.out.println("==================");
	}

	@Test
	public void testIf() {
		assertEquals(expected, TypeChecker.check(inputNode, register));
	}
}