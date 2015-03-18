package test.ql.typechecker;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestCompatibility {
	 @Parameters
     public static Collection<Object[]> data() {
    	 return Arrays.asList(new Object[][] {
    			 { Arrays.asList(true, true, true, true), true },
    			 { Arrays.asList(true, true, true, false), false },
    			 { Arrays.asList(false, true, true, true), false }
    	 });
     }

     private List<Boolean> list;
     private boolean expected;

     public TestCompatibility(List<Boolean> list, boolean expected) {
    	 System.out.println("Testing: " + list);
    	 
    	 this.expected = expected;
    	 this.list = list;
     }
     
     @BeforeClass
     public static void printHeader() {
    	 System.out.println("=============================");
    	 System.out.println("*** Testing Compatibility ***");
    	 System.out.println("=============================");
     }
     
     @Test
     public void testCompatibility() {
    	 boolean result = list
 				.stream()
 				.allMatch(a -> a);
    	 
    	 assertEquals(expected, result);
     }
}
