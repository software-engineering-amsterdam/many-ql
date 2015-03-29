package org.uva.ql.test.evaluator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.expression.association.Parenthesis;
import org.uva.ql.ast.expression.binary.Addition;
import org.uva.ql.ast.expression.binary.Divide;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.binary.Greater;
import org.uva.ql.ast.expression.binary.GreaterEqual;
import org.uva.ql.ast.expression.binary.Less;
import org.uva.ql.ast.expression.binary.LessEqual;
import org.uva.ql.ast.expression.binary.Multiply;
import org.uva.ql.ast.expression.binary.NotEqual;
import org.uva.ql.ast.expression.binary.Substraction;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.expression.unary.Negative;
import org.uva.ql.ast.expression.unary.Positive;
import org.uva.ql.ast.value.IntValue;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;

public class IntTest {
	private final int INT_VALUE1 = 15;
	private final int INT_VALUE2 = 5;
	private final CodePosition POS = new CodePosition(0, 0);
	private final Identifier ID = new Identifier("ID", POS);
	private final IntLiteral INT_LITERAL1 = new IntLiteral(INT_VALUE1, POS);
	private final IntLiteral INT_LITERAL2 = new IntLiteral(INT_VALUE2, POS);
	private Evaluator evaluator = new Evaluator();

	@Test
	public void testPOSitive() {
		int expected = +INT_VALUE1;
		int actual = (int) evaluator.evaluate(new Positive(INT_LITERAL1, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNegative() {
		int expected = -INT_VALUE1;
		int actual = (int) evaluator.evaluate(new Negative(INT_LITERAL1, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testPlusInt() {
		int expected = INT_VALUE1 + INT_VALUE2;
		int actual = (int) evaluator.evaluate(new Addition(INT_LITERAL1, INT_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testMinus() {
		int expected = INT_VALUE1 - INT_VALUE2;
		int actual = (int) evaluator.evaluate(new Substraction(INT_LITERAL1, INT_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testMutiply() {
		int expected = INT_VALUE1 * INT_VALUE2;
		int actual = (int) evaluator.evaluate(new Multiply(INT_LITERAL1, INT_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDivide() {
		int expected = INT_VALUE1 / INT_VALUE2;
		int actual = (int) evaluator.evaluate(new Divide(INT_LITERAL1, INT_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDivideZero() {
		boolean expected = false;
		boolean actual = evaluator.evaluate(new Divide(INT_LITERAL1, new IntLiteral(0, POS), POS)).isDefined();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEqualInt1() {
		boolean expected = INT_VALUE1 == INT_VALUE1;
		boolean actual = (boolean) evaluator.evaluate(new Equal(INT_LITERAL1, INT_LITERAL1, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEqualInt2() {
		boolean expected = INT_VALUE1 == INT_VALUE2;
		boolean actual = (boolean) evaluator.evaluate(new Equal(INT_LITERAL1, INT_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualInt1() {
		boolean expected = INT_VALUE1 != INT_VALUE1;
		boolean actual = (boolean) evaluator.evaluate(new NotEqual(INT_LITERAL1, INT_LITERAL1, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualInt2() {
		boolean expected = INT_VALUE1 != INT_VALUE2;
		boolean actual = (boolean) evaluator.evaluate(new NotEqual(INT_LITERAL1, INT_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGreater() {
		boolean expected = INT_VALUE1 > INT_VALUE2;
		boolean actual = (boolean) evaluator.evaluate(new Greater(INT_LITERAL1, INT_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqual() {
		boolean expected = INT_VALUE1 >= INT_VALUE2;
		boolean actual = (boolean) evaluator.evaluate(new GreaterEqual(INT_LITERAL1, INT_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLess() {
		boolean expected = INT_VALUE1 < INT_VALUE2;
		boolean actual = (boolean) evaluator.evaluate(new Less(INT_LITERAL1, INT_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLessEqual() {
		boolean expected = INT_VALUE1 <= INT_VALUE2;
		boolean actual = (boolean) evaluator.evaluate(new LessEqual(INT_LITERAL1, INT_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testParenthese() {
		int expected = (INT_VALUE1 - INT_VALUE2);
		int actual = (int) evaluator.evaluate(new Parenthesis(new Substraction(INT_LITERAL1, INT_LITERAL2, POS), POS))
				.value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCombination() {
		boolean expected = ((INT_VALUE1 - INT_VALUE2) * INT_VALUE2) > INT_VALUE1 * INT_VALUE2;
		Expression expr = new Greater(
				new Multiply(new Substraction(INT_LITERAL1, INT_LITERAL2, POS), INT_LITERAL2, POS), new Multiply(
						INT_LITERAL1, INT_LITERAL2, POS), POS);
		boolean actual = (boolean) evaluator.evaluate(expr).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testAddValue() {
		int expected = evaluator.countValues() + 1;
		evaluator.addValue(ID, new IntValue(99));
		int actual = evaluator.countValues();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testContains() {
		evaluator.addValue(ID, new IntValue(99));
		boolean expected = true;
		boolean actual = evaluator.contains(ID);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetValue() {
		IntValue expected = new IntValue(99);
		evaluator.addValue(ID, new IntValue(99));
		IntValue actual = (IntValue) evaluator.getValue(ID);
		Assert.assertEquals(expected, actual);
	}
	
	public void testSpecialCase(){
		// Testing case age == (num1 + num2)
		IntLiteral age = new IntLiteral(150,POS);
		IntLiteral num1 = new IntLiteral(50,POS);
		IntLiteral num2 = new IntLiteral(100,POS);
		Addition add = new Addition(num1, num2, POS);
		Equal equal = new Equal(age, add, POS);
		boolean val = evaluator.equals(equal);
		Assert.assertEquals(true, val);
	}
}
