package org.uva.ql.test.evaluator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.binary.Addition;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.binary.NotEqual;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.evaluation.Evaluator;

public class StringTest {

	private final String STR_VALUE1 = "Hello";
	private final String STR_VALUE2 = "World";
	private final CodePosition POS = new CodePosition(0, 0);
	private final StrLiteral STR_LITERAL1 = new StrLiteral(STR_VALUE1, POS);
	private final StrLiteral STR_LITERAL2 = new StrLiteral(STR_VALUE2, POS);
	private final Evaluator EVALUATOR = new Evaluator();

	@Test
	public void testPlusStr() {
		String expected = STR_VALUE1 + STR_VALUE2;
		String actual = (String) EVALUATOR.evaluate(new Addition(STR_LITERAL1, STR_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEqualStr1() {
		boolean expected = STR_VALUE1 == STR_VALUE1;
		boolean actual = (boolean) EVALUATOR.evaluate(new Equal(STR_LITERAL1, STR_LITERAL1, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEqualStr2() {
		boolean expected = STR_VALUE1 == STR_VALUE2;
		boolean actual = (boolean) EVALUATOR.evaluate(new Equal(STR_LITERAL1, STR_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualStr1() {
		boolean expected = STR_VALUE1 != STR_VALUE1;
		boolean actual = (boolean) EVALUATOR.evaluate(new NotEqual(STR_LITERAL1, STR_LITERAL1, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualStr2() {
		boolean expected = STR_VALUE1 != STR_VALUE2;
		boolean actual = (boolean) EVALUATOR.evaluate(new NotEqual(STR_LITERAL1, STR_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

}
