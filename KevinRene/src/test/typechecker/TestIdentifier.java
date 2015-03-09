package test.typechecker;

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
public class TestIdentifier {
	@Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {    
				{ "form formname {"
				+ "	houseValue : money { \"question text\" } "
				+ "	leftOver : money { \"Money left: \" assign(houseValue - 1000) }"
				+ "}", true },
				
				{ "form formname {"
				+ "	hasSoldHouse : boolean { \"question text\" } "
				+ " if(hasSoldHouse) {"
				+ "		leftOver : money { \"Money left: \" assign(500 - 1000) }"
				+ " }"
				+ "}", true },
				
				{ "form formname {"
				+ "	if(true) {"
				+ "		randomQuestion : money { \"question text\" } "
				+ "	} else {"
				+ " 	randomQuestion : money { \"question text\" } "
				+ " }"
				+ "}", true },
				
				{ "form formname {"
				+ "	if(houseValue) {"
				+ "		randomQuestion : money { \"question text\" } "
				+ "	}"
				+ "	houseValue : money { \"question text\" } "
				+ "	leftOver : money { \"Money left: \" assign(carValue - 1000) }"
				+ "}", false },
				
				{ "form formname {"
				+ "	if(true) {"
				+ "		randomQuestion : money { \"question text\" } "
				+ "	}"
				+ "	leftOver : money { \"Money left: \" assign(randomQuestion - 1000) }"
				+ "}", false },		

				{ "form formname {"
				+ "	if(true) {"
				+ "		moneyQuestion : money { \"question text\" } "
				+ "	} else {"
				+ "		randomQuestion : money { \"question text\" } "
				+ " }"
				+ "	leftOver : money { \"Money left: \" assign(randomQuestion - 1000) }"
				+ "}", false },

				{ "form formname {"
				+ "	if(true) {"
				+ "		moneyQuestion : money { \"question text\" } "
				+ "	} else {"
				+ "		leftOver : money { \"Money left: \" assign(moneyQuestion - 1000) }"
				+ " }"
				+ "}", false },

				{ "leftOver : money { \"Money left: \" assign(carValue - 1000) }", false },
				{ "leftOver : money { \"Money left: \" assign(leftOver - 1000) }", false }
    			 
    	 });
     }

	private ASTNode inputNode;
	private boolean expected;

	private Parser formParser = new Parser();
	private TypeEnvironment register = new TypeEnvironment();

	public TestIdentifier(String input, boolean expected) {
		System.out.println("Testing: " + input);

		register = new TypeEnvironment();

		this.inputNode = formParser.parse(input);
		this.expected = expected;
	}

	@BeforeClass
	public static void printHeader() {
		System.out.println("==========================");
		System.out.println("*** Testing Identifier ***");
		System.out.println("==========================");
	}

	@Test
	public void testIdentifier() {
		assertEquals(expected, TypeChecker.check(inputNode, register));
	}
}
