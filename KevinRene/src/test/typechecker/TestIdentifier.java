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
public class TestIdentifier {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {                             
    			 { "form formname {"
    			 		+ "houseValue : money { \"question text\" } "
    			 		+ "leftOver : money { \"Money left: \" assign(houseValue - 1000) }"
    			 		+ "}", true },
    			 { "form formname {"
    		     		+ "houseValue : money { \"question text\" } "
    		     		+ "leftOver : money { \"Money left: \" assign(carValue - 1000) }"
    		     		+ "}", false }
    			 
    	 });
     }

     private ASTNode inputNode;
     private boolean expected;
     
     private Parser formParser = new Parser();
     private TypeChecker typeChecker = new TypeChecker();

     public TestIdentifier(String input, boolean expected) {
    	 System.out.println("Testing: " + input);
    	 
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
    	 assertEquals(expected, typeChecker.checkStaticTypes(this.inputNode));
     }
}
