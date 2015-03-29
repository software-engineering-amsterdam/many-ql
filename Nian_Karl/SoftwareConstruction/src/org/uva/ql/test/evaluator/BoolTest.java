package org.uva.ql.test.evaluator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.binary.And;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.binary.NotEqual;
import org.uva.ql.ast.expression.binary.Or;
import org.uva.ql.ast.expression.literal.BoolLiteral;
import org.uva.ql.ast.expression.unary.Not;
import org.uva.ql.evaluation.Evaluator;

public class BoolTest {

	private final CodePosition POS = new CodePosition(0, 0);
	private final BoolLiteral BOOL_LITERAL1 = new BoolLiteral(true, POS);
	private final BoolLiteral BOOL_LITERAL2 = new BoolLiteral(false, POS);
	private final Evaluator EVALUATOR = new Evaluator();

	@Test
	public void testNot1() {
		boolean expected = !true;
		boolean actual = (boolean) EVALUATOR.evaluate(new Not(BOOL_LITERAL1, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	public void testNot2() {
		boolean expected = !false;
		boolean actual = (boolean) EVALUATOR.evaluate(new Not(BOOL_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualBool1() {
		boolean expected = true != true;
		boolean actual = (boolean) EVALUATOR.evaluate(new NotEqual(BOOL_LITERAL1, BOOL_LITERAL1, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualBool2() {
		boolean expected = true != false;
		boolean actual = (boolean) EVALUATOR.evaluate(new NotEqual(BOOL_LITERAL1, BOOL_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEqualBool1() {
		boolean expected = true == true;
		boolean actual = (boolean) EVALUATOR.evaluate(new Equal(BOOL_LITERAL1, BOOL_LITERAL1, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEqualBool2() {
		boolean expected = true == false;
		boolean actual = (boolean) EVALUATOR.evaluate(new Equal(BOOL_LITERAL1, BOOL_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testAnd() {
		boolean expected = true && false;
		boolean actual = (boolean) EVALUATOR.evaluate(new And(BOOL_LITERAL1, BOOL_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testOr() {
		boolean expected = true || false;
		boolean actual = (boolean) EVALUATOR.evaluate(new Or(BOOL_LITERAL1, BOOL_LITERAL2, POS)).value();
		Assert.assertEquals(expected, actual);
	}

}
