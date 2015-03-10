package test.typechecker;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ql.TypeEnvironment;
import ql.ast.Expression;
import ql.ast.QLNode;
import ql.ast.Statement;
import ql.ast.visitor.typechecker.TypeChecker;
import ql.parser.Parser;

public abstract class BaseTest {
	private QLNode inputNode;
	private boolean expected;

	private static TypeEnvironment register;

	public BaseTest(String input, boolean expected) {
		System.out.println("Testing: " + input);

		inputNode = Parser.parse(input);
		this.expected = expected;
	}

	@BeforeClass
	public static void setupEnvironment() {
		System.out.println("============================");
		System.out.println("*** Testing Type Checker ***");
		System.out.println("============================");
	}
	
	@Before
	public void setupTest() {
		// Clear the register to avoid problems.
		register = new TypeEnvironment();
	}

	@Test
	public void test() {
		boolean expressionValue;

		if(inputNode instanceof Expression) {
			expressionValue = TypeChecker.check((Expression) inputNode, register);
		} else {
			expressionValue = TypeChecker.check((Statement) inputNode, register);
		}
		
		System.out.println("   Result: " + expressionValue);

		assertEquals(expected, expressionValue);
	}
}
