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
public class TestEq {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {                             
    			 { "10 == 100", true }, 
                 { "true == false", true }, 
                 { "10.1 == 100.5", true }, 
                 { "\"a\" == \"b\"", true },
                 // Type mismatch
                 { "10 == true", false }, 
                 { "true == \"string\"", false },
                 { "false == 100.5", false } 
    	 });
     }

     private ASTNode inputNode;
     private boolean expected;
     
     private Parser formParser = new Parser();
     private TypeChecker typeChecker = new TypeChecker();

     public TestEq(String input, boolean expected) {
    	 System.out.println("Testing: " + input);
    	 
    	 inputNode = formParser.parse(input);
    	 this.expected = expected;
     }
     
     @BeforeClass
     public static void printHeader() {
    	 System.out.println("=====================");
    	 System.out.println("*** Testing Equal ***");
    	 System.out.println("=====================");
     }
     
     @Test
     public void testEq() {
    	 assertEquals(expected, typeChecker.checkStaticTypes(inputNode));
     }
}
