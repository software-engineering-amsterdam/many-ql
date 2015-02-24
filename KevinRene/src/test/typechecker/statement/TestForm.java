package test.typechecker.statement;

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
public class TestForm {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			 { "form taxOfficeExample {"
					+ 	"hasSoldHouse : boolean {"
					+ 		"\"Did you sell a house in 2010?\""
					+ 	"}"
					+ 	"if((5 == 5) == true) {"
					+ 		"houseValue : money {"
					+ 			"\"Lol I dont care\""
					+ 		"}"
					+ 	"}"
					+ "}", true },
					// Second form
					{ "form taxOfficeExample {"
					+ 	"hasSoldHouse : boolean { \"Did you sell a house in 2010?\" }"
					+ 	"if((5 == 5) == true) {"
					+ 		"houseValue : money { \"Lol I dont care\" }"
					+ 	"} else {"
					+ "	 	otherQuestion : boolean { \"Did you sell a house in 2010?\" }"
					+ "  }"
					+ "}", true }
    	 });
     }

     private ASTNode inputNode;
     private boolean expected;
     
     private Parser formParser = new Parser();
     private TypeEnvironment register = new TypeEnvironment();

     public TestForm(String input, boolean expected) {
    	 System.out.println("Testing: " + input);

         register = new TypeEnvironment();
    	 
    	 inputNode = formParser.parse(input);
    	 this.expected = expected;
     }
     
     @BeforeClass
     public static void printHeader() {
    	 System.out.println("====================");
    	 System.out.println("*** Testing Form ***");
    	 System.out.println("====================");
     }
     
     @Test
     public void testForm() {
    	 assertEquals(expected, TypeChecker.check(inputNode, register));
     }
}
