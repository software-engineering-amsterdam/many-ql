package test.typechecker;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cons.TypeRegister;
import cons.ql.ast.ASTNode;
import cons.ql.ast.visitor.typechecker.TypeChecker;
import cons.ql.parser.Parser;

@RunWith(value = Parameterized.class)
public class TestAdd {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {                             
    			 { "5 + 10", true }
    	 });
     }

     private ASTNode inputNode;
     private boolean expected;
     
     private Parser formParser = new Parser();
     private TypeRegister register = new TypeRegister();
     private TypeChecker typeChecker = new TypeChecker(register);

     public TestAdd(String input, boolean expected) {
    	 System.out.println("Testing: " + input);

         register = new TypeRegister();
         typeChecker = new TypeChecker(register);
    	 
    	 inputNode = formParser.parse(input);
    	 this.expected = expected;
     }
     
     @BeforeClass
     public static void printHeader() {
    	 System.out.println("========================");
    	 System.out.println("*** Testing Addition ***");
    	 System.out.println("========================");
     }
     
     @Test
     public void testAdd() {
    	 assertEquals(expected, typeChecker.check(inputNode));
     }
}
