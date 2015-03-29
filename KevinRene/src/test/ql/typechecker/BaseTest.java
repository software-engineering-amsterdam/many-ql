package test.ql.typechecker;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ql.ast.Expression;
import ql.ast.QLNode;
import ql.ast.Statement;
import ql.ast.visitor.typechecker.TypeChecker;
import ql.ast.visitor.typechecker.TypeEnvironment;
import ql.errorhandling.ErrorEnvironment;
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
		System.out.println("===============================");
		System.out.println("*** Testing QL Type Checker ***");
		System.out.println("===============================");
	}
	
	@Before
	public void setupTest() {
		// Clear the register to avoid problems.
		register = new TypeEnvironment();
	}

	@Test
	public void test() {
		ErrorEnvironment errors;

		if(inputNode instanceof Expression) {
			errors = TypeChecker.check((Expression) inputNode, register);
		} else {
			errors = TypeChecker.check((Statement) inputNode, register);
		}
		
		boolean result = !errors.hasErrors();
		
		
		if(result != expected) {
			System.out.println(errors.getErrors());
		}
		
		System.out.println("   Result: " + result);

		assertEquals(expected, result);
	}
}
