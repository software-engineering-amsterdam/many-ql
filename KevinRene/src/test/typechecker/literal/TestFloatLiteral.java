package test.typechecker.literal;

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
public class TestFloatLiteral {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			// Integer.
    			{  "aQuestion : float { \"Integer\" assign(42) }", true},
				// Float.
				{  "aQuestion : float { \"Float\" assign(10.1) }", true},
				// Strings.
				{  "aQuestion : float { \"String\" assign(\"Waddap\") }", false},
				// Booleans.
				{  "aQuestion : float { \"Boolean\" assign(true) }", false},
				// Identifiers pointing to a integer.
				{ "form myForm { "
					+ "	newQuestion : integer { \"Number\" }"
					+ "	secondQuestion : float { \"Number\" assign(newQuestion) }"
					+ "}", true},
				// Identifiers pointing to a float.
				{ "form myForm { "
					+ "	newQuestion : float { \"Number\" }"
					+ "	secondQuestion : float { \"Number\" assign(newQuestion) }"
					+ "}", true},
				{ "form myForm { "
					+ "	newQuestion : money { \"Number\" }"
					+ "	secondQuestion : float { \"Number\" assign(newQuestion) }"
					+ "}", true},
				// Identifier pointing to a string.
				{ "form myForm { "
					+ "	newQuestion : string { \"String\" }"
					+ "	secondQuestion : float { \"Number\" assign(newQuestion) }"
					+ "}", false},
				// Identifier pointing to a boolean.
				{ "form myForm { "
					+ "	newQuestion : boolean { \"Boolean\" }"
					+ "	secondQuestion : float { \"Number\" assign(newQuestion) }"
					+ "}", false},
    	 });
     }

     private ASTNode inputNode;
     private boolean expected;
     
     private Parser formParser = new Parser();
     private TypeEnvironment register = new TypeEnvironment();

     public TestFloatLiteral(String input, boolean expected) {
    	 System.out.println("Testing: " + input);

         register = new TypeEnvironment();
    	 
    	 inputNode = formParser.parse(input);
    	 this.expected = expected;
     }
     
     @BeforeClass
     public static void printHeader() {
    	 System.out.println("============================");
    	 System.out.println("*** Testing Float Literal***");
    	 System.out.println("============================");
     }
     
     @Test
     public void testFloatLiteral() {
    	 assertEquals(expected, TypeChecker.check(inputNode, register));
     }
}
