package test.ql.typechecker.statement;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import test.ql.typechecker.BaseTest;

@RunWith(value = Parameterized.class)
public class TestForm extends BaseTest {
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
					+ "}", true },
					// Third form
					{ "form nothingInIt { }", true },
					// Double declaration. Not allowed.
					{ "form taxOfficeExample {"
					+ "	hasSoldHouse : boolean { \"Did you sell a house in 2010?\" }"
					+ "	hasSoldHouse : integer { \"Did you sell a house in 2010?\" }"
					+ "}", false },
					// Reusing form identifier. Not allowed.
					{ "form taxOfficeExample {"
					+ "	taxOfficeExample : boolean { \"Did you sell a house in 2010?\" }"
					+ "}", false },
    	 });
     }
     
     public TestForm(String input, boolean expected) {
    	 super(input, expected);
     }
}
