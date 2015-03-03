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
public class TestBooleanLiteral {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			// Integer.
    			{  "aQuestion : boolean { \"Integer\" assign(42) }", false},
				// Float.
				{  "aQuestion : boolean { \"Float\" assign(10.1) }", false},
				// Strings.
				{  "aQuestion : boolean { \"String\" assign(\"Waddap\") }", false},
				// Booleans.
				{  "aQuestion : boolean { \"Boolean\" assign(true) }", true},
				// Identifiers pointing to a integer.
				{ "form myForm { "
					+ "	newQuestion : integer { \"Number\" }"
					+ "	secondQuestion : boolean { \"Number\" assign(newQuestion) }"
					+ "}", false},
				// Identifiers pointing to a float.
				{ "form myForm { "
					+ "	newQuestion : float { \"Number\" }"
					+ "	secondQuestion : boolean { \"Number\" assign(newQuestion) }"
					+ "}", false},
				{ "form myForm { "
					+ "	newQuestion : money { \"Number\" }"
					+ "	secondQuestion : boolean { \"Number\" assign(newQuestion) }"
					+ "}", false},
				// Identifier pointing to a string.
				{ "form myForm { "
					+ "	newQuestion : string { \"String\" }"
					+ "	secondQuestion : boolean { \"Number\" assign(newQuestion) }"
					+ "}", false},
				// Identifier pointing to a boolean.
				{ "form myForm { "
					+ "	newQuestion : boolean { \"Boolean\" }"
					+ "	secondQuestion : boolean { \"Number\" assign(newQuestion) }"
					+ "}", true},
    	 });
     }

     private ASTNode inputNode;
     private boolean expected;
     
     private Parser formParser = new Parser();
     private TypeEnvironment register = new TypeEnvironment();

     public TestBooleanLiteral(String input, boolean expected) {
    	 System.out.println("Testing: " + input);

         register = new TypeEnvironment();
    	 
    	 inputNode = formParser.parse(input);
    	 this.expected = expected;
     }
     
     @BeforeClass
     public static void printHeader() {
    	 System.out.println("==============================");
    	 System.out.println("*** Testing Boolean Literal***");
    	 System.out.println("==============================");
     }
     
     @Test
     public void testBooleanLiteral() {
    	 assertEquals(expected, TypeChecker.check(inputNode, register));
     }
}
