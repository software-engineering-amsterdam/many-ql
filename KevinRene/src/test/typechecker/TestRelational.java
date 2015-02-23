package test.typechecker;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cons.ql.ast.ASTNode;
import cons.ql.ast.visitor.typechecker.TypeChecker;
import cons.ql.parser.Parser;

@RunWith(value = Parameterized.class)
public class TestRelational {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {                             
				 { "10 > 103", true }, 
				 { "10.3 >= 103", true }, 
				 { "10 <= 103", true }, 
				 { "10 < 103", true },
				 // Type mismatch
				 { "true < 104", false }, 
				 { "10 >= false", false }
		 });
     }
     
     private ASTNode inputNode;
     private boolean expected;
     
     private Parser formParser = new Parser();
     private TypeChecker typeChecker = new TypeChecker();

     public TestRelational(String input, boolean expected) {
    	 System.out.println("Testing: " + input);
    	 
    	 inputNode = formParser.parse(input);
    	 this.expected = expected;
     }
     
     @BeforeClass
     public static void printHeader() {
    	 System.out.println("==========================");
    	 System.out.println("*** Testing Relational ***");
    	 System.out.println("==========================");
     }
     
     @Test
     public void testRelational() {
    	 assertEquals(expected, typeChecker.check(inputNode));
     }
}
