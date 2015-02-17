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
public class TestForm {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {                             
    			 { "houseValue : money { \"Lol I dont care\" assign(\"Rubbish\") }", false },
    			 { "form taxOfficeExample {"
					+ 	"hasSoldHouse : boolean {"
					+ 		"\"Did you sell a house in 2010?\""
					+ 	"}"
					+ 	"if(5 == 5) {"
					+ 		"houseValue : money {"
					+ 			"\"Lol I dont care\""
					+ 		"}"
					+ 	"}"
					+ "}", true }
    	 });
     }

     private ASTNode inputNode;
     private boolean expected;
     
     private Parser formParser = new Parser();
     private TypeChecker typeChecker = new TypeChecker();

     public TestForm(String input, boolean expected) {
    	 System.out.println("Testing: " + input);
    	 
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
    	 assertEquals(expected, typeChecker.checkStaticTypes(inputNode));
     }
}
