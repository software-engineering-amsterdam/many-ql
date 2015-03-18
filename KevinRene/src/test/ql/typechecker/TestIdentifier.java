package test.ql.typechecker;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestIdentifier extends BaseTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] {
						{ "form formname {"
						+ "	houseValue : money { \"question text\" } "
						+ "	leftOver : money { \"Money left: \" assign(houseValue - 1000) }"
						+ "}", true },

						{ "form formname {"
						+ "	hasSoldHouse : boolean { \"question text\" } "
						+ " if(hasSoldHouse) {"
						+ "		leftOver : money { \"Money left: \" assign(500 - 1000) }"
						+ " }" + "}", true },

						{ "form formname {"
						+ "	if(true) {"
						+ "		randomQuestion : money { \"question text\" } "
						+ "	} else {"
						+ " 	randomQuestion : money { \"question text\" } "
						+ " }" + "}", true },

						{ "form formname {"
						+ "	if(houseValue) {"
						+ "		randomQuestion : money { \"question text\" } "
						+ "	}"
						+ "	houseValue : money { \"question text\" } "
						+ "	leftOver : money { \"Money left: \" assign(carValue - 1000) }"
						+ "}", false },

						{ "form formname {"
						+ "	if(true) {"
						+ "		randomQuestion : money { \"question text\" } "
						+ "	}"
						+ "	leftOver : money { \"Money left: \" assign(randomQuestion - 1000) }"
						+ "}", false },

						{ "form formname {"
						+ "	if(true) {"
						+ "		moneyQuestion : money { \"question text\" } "
						+ "	} else {"
						+ "		randomQuestion : money { \"question text\" } "
						+ " }"
						+ "	leftOver : money { \"Money left: \" assign(randomQuestion - 1000) }"
						+ "}", false },

						{ "form formname {"
						+ " randomQuestion : money { \"question text\" } "
						+ "	if(true) {"
						+ "		moneyQuestion : money { \"question text\" } "
						+ "	} else {"
						+ "		randomQuestion : money { \"question text\" } "
						+ " }"
						+ "	leftOver : money { \"Money left: \" assign(randomQuestion - 1000) }"
						+ "}", false },

						{ "form formname {"
						+ "	if(true) {"
						+ "		moneyQuestion : money { \"question text\" } "
						+ "	} else {"
						+ "		leftOver : money { \"Money left: \" assign(moneyQuestion - 1000) }"
						+ " }" + "}", false },

						{ "leftOver : money { \"Money left: \" assign(carValue - 1000) }",
						false },
						{ "leftOver : money { \"Money left: \" assign(leftOver - 1000) }",
						false }

				});
	}

	public TestIdentifier(String input, boolean expected) {
		super(input, expected);
	}
}
