package test.qls.typechecker;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ql.ast.QLNode;
import ql.ast.QLType;
import ql.ast.expression.Identifier;
import ql.ast.type.QLBoolean;
import ql.ast.type.QLFloat;
import ql.ast.type.QLForm;
import ql.ast.type.QLInteger;
import ql.ast.type.QLString;
import ql.ast.visitor.typechecker.TypeEnvironment;
import ql.errorhandling.ErrorEnvironment;
import qls.ast.Statement;
import qls.ast.expression.Literal;
import qls.ast.visitor.typechecker.TypeChecker;
import qls.parser.Parser;

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
		System.out.println("================================");
		System.out.println("*** Testing QLS Type Checker ***");
		System.out.println("================================");
	}
	
	@Before
	public void setupTest() {
		// Clear the register to avoid problems.
		register = new TypeEnvironment();
		
		register.store(new Identifier("formNode"), new QLForm());
		register.store(new Identifier("booleanQuestion"), new QLBoolean());
		register.store(new Identifier("floatQuestion"), new QLFloat());
		register.store(new Identifier("integerQuestion"), new QLInteger());
		register.store(new Identifier("stringQuestion"), new QLString());
	}

	@Test
	public void test() {
		ErrorEnvironment errors;

		if(inputNode instanceof Statement) {
			errors = TypeChecker.check((Statement) inputNode, register);
		} else if(inputNode instanceof Literal) {
			errors = TypeChecker.check((Literal<?>) inputNode, register);
		} else {
			errors = TypeChecker.check((QLType) inputNode, register);
		}
		
		if(errors.hasErrors()) {
			System.out.print(errors.getErrors());
		}
		
		System.out.println("   Result: " + !errors.hasErrors());
		
		assertEquals(expected, !errors.hasErrors());
	}
}
