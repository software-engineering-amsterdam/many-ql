package test.typechecker;

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
public class TestIf {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {                             
				 { "if (true) { houseValue : money { \"Lol I dont care\" } }", true }, 
				 { "if (false || true) { houseValue : money { \"Lol I dont care\" } }", true }, 
				 { "if (123) { houseValue : money { \"Lol I dont care\" } }", false},
				 { "if (true) { houseValue : money { \"Lol I dont care\" assign(\"A string\") } }", false}
		 });
     }
     
     private ASTNode inputNode;
     private boolean expected;
     
     private Parser formParser = new Parser();
     private TypeEnvironment register = new TypeEnvironment();

     public TestIf(String input, boolean expected) {
    	 System.out.println("Testing: " + input);

         register = new TypeEnvironment();
    	 
    	 inputNode = formParser.parse(input);
    	 this.expected = expected;
     }
     
     @BeforeClass
     public static void printHeader() {
    	 System.out.println("==================");
    	 System.out.println("*** Testing If ***");
    	 System.out.println("==================");
     }
     
     @Test
     public void testIf() {
    	 assertEquals(expected, TypeChecker.check(inputNode, register));
     }
}