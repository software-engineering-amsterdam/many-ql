package test.typechecker.arithmetic;

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
public class TestPositive {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			// Integer.
				{ "+5", true },
				// Float.
				{ "+10.5", true},
				// Strings. Not allowed.
				{ "+\"String 1\"", false},
				// Booleans. Not allowed.
				{ "+true", false},
				// Identifiers pointing to a integer.
				{ "form myForm { "
					+ "	newQuestion : integer { \"Number\" }"
					+ "	if(+newQuestion * 5 == 5) {}"
					+ "}", true},
				// Identifiers pointing to a float.
				{ "form myForm { "
					+ "	newQuestion : float { \"Number\" }"
					+ "	if(+newQuestion * 5 == 5) {}"
					+ "}", true},
				{ "form myForm { "
					+ "	newQuestion : money { \"Number\" }"
					+ "	if(+newQuestion * 5 == 5) {}"
					+ "}", true}
    	 });
     }

     private ASTNode inputNode;
     private boolean expected;
     
     private Parser formParser = new Parser();
     private TypeEnvironment register = new TypeEnvironment();

     public TestPositive(String input, boolean expected) {
    	 System.out.println("Testing: " + input);

         register = new TypeEnvironment();
    	 
    	 inputNode = formParser.parse(input);
    	 this.expected = expected;
     }
     
     @BeforeClass
     public static void printHeader() {
    	 System.out.println("========================");
    	 System.out.println("*** Testing Positive ***");
    	 System.out.println("========================");
     }
     
     @Test
     public void testPositive() {
    	 assertEquals(expected, TypeChecker.check(inputNode, register));
     }
}
