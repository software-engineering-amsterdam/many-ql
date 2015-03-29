package org.uva.ql.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.expression.association.Parenthesis;
import org.uva.ql.ast.expression.binary.And;
import org.uva.ql.ast.expression.binary.Divide;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.binary.Greater;
import org.uva.ql.ast.expression.binary.GreaterEqual;
import org.uva.ql.ast.expression.binary.Less;
import org.uva.ql.ast.expression.binary.LessEqual;
import org.uva.ql.ast.expression.binary.Substraction;
import org.uva.ql.ast.expression.binary.Multiply;
import org.uva.ql.ast.expression.binary.NotEqual;
import org.uva.ql.ast.expression.binary.Or;
import org.uva.ql.ast.expression.binary.Addition;
import org.uva.ql.ast.expression.literal.BoolLiteral;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.ast.expression.unary.Negative;
import org.uva.ql.ast.expression.unary.Not;
import org.uva.ql.ast.expression.unary.Positive;
import org.uva.ql.ast.value.IntValue;
import org.uva.ql.ast.value.UndefinedValue;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;

public class EvaluatorTest {

	private final int intVal1 = 15;
	private final int intVal2 = 5;
	private final String strVal1 = "Hello";
	private final String strVal2 = "World";
	
	
	private Evaluator evaluator;
	private CodePosition pos = new CodePosition(0, 0);
	private final Identifier id = new Identifier("ID", pos);

	private final IntLiteral int1 = new IntLiteral(intVal1, pos);
	private final IntLiteral int2 = new IntLiteral(intVal2, pos);
	private final BoolLiteral bool1 = new BoolLiteral(true, pos);
	private final BoolLiteral bool2 = new BoolLiteral(false, pos);
	private final StrLiteral str1 = new StrLiteral(strVal1, pos);
	private final StrLiteral str2 = new StrLiteral(strVal2, pos);

	@Before
	public void setUp() throws Exception {
		evaluator = new Evaluator();
	}

	@Test
	public void testAddValue() {
		int expected = evaluator.countValues() + 1;
		evaluator.addValue(id, new IntValue(99));
		int actual = evaluator.countValues();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testContains() {
		evaluator.addValue(id, new IntValue(99));
		boolean expected = true;
		boolean actual = evaluator.contains(id);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetValue() {
		IntValue expected = new IntValue(99);
		evaluator.addValue(id, new IntValue(99));
		IntValue actual = (IntValue) evaluator.getValue(id);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNot1() {
		boolean expected = !true;
		boolean actual = (boolean) evaluator.evaluate(new Not(bool1, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	public void testNot2() {
		boolean expected = !false;
		boolean actual = (boolean) evaluator.evaluate(new Not(bool2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testPositive() {
		int expected = +intVal1;
		int actual = (int) evaluator.evaluate(new Positive(int1, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNegative() {
		int expected = -intVal1;
		int actual = (int) evaluator.evaluate(new Negative(int1, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testPlusInt() {
		int expected = intVal1 + intVal2;
		int actual = (int) evaluator.evaluate(new Addition(int1, int2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testPlusStr() {
		String expected = strVal1 + strVal2;
		String actual = (String) evaluator.evaluate(new Addition(str1, str2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testMinus() {
		int expected = intVal1 - intVal2;
		int actual = (int) evaluator.evaluate(new Substraction(int1, int2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testMutiply() {
		int expected = intVal1 * intVal2;
		int actual = (int) evaluator.evaluate(new Multiply(int1, int2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDivide() {
		int expected = intVal1 / intVal2;
		int actual = (int) evaluator.evaluate(new Divide(int1, int2, pos)).value();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testDivideZero() {
		Value expected = new UndefinedValue();
		Value actual = evaluator.evaluate(new Divide(int1, new IntLiteral(0, pos), pos));
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testAnd() {
		boolean expected = true && false;
		boolean actual = (boolean) evaluator.evaluate(new And(bool1, bool2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testOr() {
		boolean expected = true || false;
		boolean actual = (boolean) evaluator.evaluate(new Or(bool1, bool2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEqualInt1() {
		boolean expected = intVal1 == intVal1;
		boolean actual = (boolean) evaluator.evaluate(new Equal(int1, int1, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEqualInt2() {
		boolean expected = intVal1 == intVal2;
		boolean actual = (boolean) evaluator.evaluate(new Equal(int1, int2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEqualBool1() {
		boolean expected = true == true;
		boolean actual = (boolean) evaluator.evaluate(new Equal(bool1, bool1, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEqualBool2() {
		boolean expected = true == false;
		boolean actual = (boolean) evaluator.evaluate(new Equal(bool1, bool2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEqualStr1() {
		boolean expected = strVal1 == strVal1;
		boolean actual = (boolean) evaluator.evaluate(new Equal(str1, str1, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEqualStr2() {
		boolean expected = strVal1 == strVal2;
		boolean actual = (boolean) evaluator.evaluate(new Equal(str1, str2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualInt1() {
		boolean expected = intVal1 != intVal1;
		boolean actual = (boolean) evaluator.evaluate(new NotEqual(int1, int1, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualInt2() {
		boolean expected = intVal1 != intVal2;
		boolean actual = (boolean) evaluator.evaluate(new NotEqual(int1, int2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualBool1() {
		boolean expected = true != true;
		boolean actual = (boolean) evaluator.evaluate(new NotEqual(bool1, bool1, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualBool2() {
		boolean expected = true != false;
		boolean actual = (boolean) evaluator.evaluate(new NotEqual(bool1, bool2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualStr1() {
		boolean expected = strVal1 != strVal1;
		boolean actual = (boolean) evaluator.evaluate(new NotEqual(str1, str1, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualStr2() {
		boolean expected = strVal1 != strVal2;
		boolean actual = (boolean) evaluator.evaluate(new NotEqual(str1, str2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGreater() {
		boolean expected = intVal1 > intVal2;
		boolean actual = (boolean) evaluator.evaluate(new Greater(int1, int2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqual() {
		boolean expected = intVal1 >= intVal2;
		boolean actual = (boolean) evaluator.evaluate(new GreaterEqual(int1, int2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLess() {
		boolean expected = intVal1 < intVal2;
		boolean actual = (boolean) evaluator.evaluate(new Less(int1, int2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLessEqual() {
		boolean expected = intVal1 <= intVal2;
		boolean actual = (boolean) evaluator.evaluate(new LessEqual(int1, int2, pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testParenthese() {
		int expected = (intVal1 - intVal2);
		int actual = (int) evaluator.evaluate(new Parenthesis(new Substraction(int1, int2, pos), pos)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCombination() {
		boolean expected = ((intVal1 - intVal2) * intVal2) > intVal1 * intVal2;
		Expression expr = new Greater(new Multiply(new Substraction(int1, int2, pos), int2, pos), new Multiply(int1,
				int2, pos), pos);
		boolean actual = (boolean) evaluator.evaluate(expr).value();
		Assert.assertEquals(expected, actual);
	}

}
