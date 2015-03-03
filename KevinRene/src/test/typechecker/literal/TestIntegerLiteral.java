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
public class TestIntegerLiteral {
	public static String createTestForm(String questionType) {
		return "form myForm { "
				+ "newQuestion : " + questionType + " { \"Number\" }"
				+ "secondQuestion : integer { \"Number\" assign(newQuestion) }"
				+ "}";
	}
	
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			// Integer.
    			{  "aQuestion : integer { \"Integer\" assign(42) }", true},
				// Float.
				{  "aQuestion : integer { \"Float\" assign(10.1) }", true},
				// Strings.
				{  "aQuestion : integer { \"String\" assign(\"Waddap\") }", false},
				// Booleans.
				{  "aQuestion : integer { \"Boolean\" assign(true) }", false},
				// Identifiers pointing to a integer.
				{ createTestForm("integer"), true},
				// Identifiers pointing to a float.
				{ createTestForm("float"), true},
				{ createTestForm("money"), true},
				// Identifier pointing to a string.
				{ createTestForm("string"), false},
				// Identifier pointing to a boolean.
				{ createTestForm("boolean"), false},
    	 });
     }

     private ASTNode inputNode;
     private boolean expected;
     
     private Parser formParser = new Parser();
     private TypeEnvironment register = new TypeEnvironment();

     public TestIntegerLiteral(String input, boolean expected) {
    	 System.out.println("Testing: " + input);

         register = new TypeEnvironment();
    	 
    	 inputNode = formParser.parse(input);
    	 this.expected = expected;
     }
     
     @BeforeClass
     public static void printHeader() {
    	 System.out.println("==============================");
    	 System.out.println("*** Testing Integer Literal***");
    	 System.out.println("==============================");
     }
     
     @Test
     public void testIntegerLiteral() {
    	 assertEquals(expected, TypeChecker.check(inputNode, register));
     }
}
