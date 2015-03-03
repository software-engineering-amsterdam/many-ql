package test.evaluator.literal;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cons.TypeEnvironment;
import cons.ql.ast.ASTNode;
import cons.ql.ast.visitor.typechecker.TypeChecker;
import cons.ql.parser.Parser;

@RunWith(value = Parameterized.class)
public class TestStringLiteral {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			// Integer.
    			{  "aQuestion : string { \"Integer\" assign(42) }", false},
				// Float.
				{  "aQuestion : string { \"Float\" assign(10.1) }", false},
				// Strings.
				{  "aQuestion : string { \"String\" assign(\"Waddap\") }", true},
				// Booleans.
				{  "aQuestion : string { \"Boolean\" assign(true) }", false},
				// Identifiers pointing to a integer.
				{ "form myForm { "
					+ "	newQuestion : integer { \"Number\" }"
					+ "	secondQuestion : string { \"Number\" assign(newQuestion) }"
					+ "}", false},
				// Identifiers pointing to a float.
				{ "form myForm { "
					+ "	newQuestion : float { \"Number\" }"
					+ "	secondQuestion : string { \"Number\" assign(newQuestion) }"
					+ "}", false},
				{ "form myForm { "
					+ "	newQuestion : money { \"Number\" }"
					+ "	secondQuestion : string { \"Number\" assign(newQuestion) }"
					+ "}", false},
				// Identifier pointing to a string.
				{ "form myForm { "
					+ "	newQuestion : string { \"String\" }"
					+ "	secondQuestion : string { \"Number\" assign(newQuestion) }"
					+ "}", true},
				// Identifier pointing to a boolean.
				{ "form myForm { "
					+ "	newQuestion : boolean { \"Boolean\" }"
					+ "	secondQuestion : string { \"Number\" assign(newQuestion) }"
					+ "}", false},
    	 });
     }

     private ASTNode inputNode;
     private boolean expected;
     
     private Parser formParser = new Parser();
     private TypeEnvironment register = new TypeEnvironment();

     public TestStringLiteral(String input, boolean expected) {
    	 System.out.println("Testing: " + input);

         register = new TypeEnvironment();
    	 
    	 inputNode = formParser.parse(input);
    	 this.expected = expected;
     }
     
     @BeforeClass
     public static void printHeader() {
    	 System.out.println("=============================");
    	 System.out.println("*** Testing String Literal***");
    	 System.out.println("=============================");
     }
     
     @Test
     public void testStringLiteral() {
    	 assertEquals(expected, TypeChecker.check(inputNode, register));
     }
}
