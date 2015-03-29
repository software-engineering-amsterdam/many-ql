package test.ql.evaluator;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import ql.Value;
import ql.ast.Expression;
import ql.ast.QLNode;
import ql.ast.Statement;
import ql.ast.expression.Identifier;
import ql.ast.visitor.evaluator.Evaluator;
import ql.ast.visitor.evaluator.ValueEnvironment;
import ql.parser.Parser;
import ql.value.BooleanValue;
import ql.value.FloatValue;
import ql.value.IntegerValue;
import ql.value.StringValue;

public abstract class BaseTest {
	private QLNode inputNode;
	private Value expected;

	private static ValueEnvironment register = new ValueEnvironment();

	public BaseTest(String input, Value expected) {
		System.out.println("Testing: " + input);

		inputNode = Parser.parse(input);
		this.expected = expected;
	}

	@BeforeClass
	public static void setupEnvironment() {
		System.out.println("=========================");
		System.out.println("*** Testing Evaluator ***");
		System.out.println("=========================");

		register.store(new Identifier("integerQuestion"), new IntegerValue(10));
		register.store(new Identifier("floatQuestion"), new FloatValue((float) 10.5));
		register.store(new Identifier("booleanQuestion"), new BooleanValue(true));
		register.store(new Identifier("stringQuestion"), new StringValue("A string"));
	}

	@Test
	public void test() {
		Value expressionValue;

		if(inputNode instanceof Expression) {
			expressionValue = Evaluator.check((Expression) inputNode, register);
		} else {
			expressionValue = Evaluator.check((Statement) inputNode, register);
		}
		
		System.out.println("   Result: " + expressionValue);

		assertEquals(expected, expressionValue);
	}
}
