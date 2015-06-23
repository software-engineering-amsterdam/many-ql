package org.uva.ql.test.typechecker;

import org.junit.Assert;
import org.junit.Test;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.binary.Addition;
import org.uva.ql.ast.expression.binary.And;
import org.uva.ql.ast.expression.binary.Divide;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.binary.Greater;
import org.uva.ql.ast.expression.binary.GreaterEqual;
import org.uva.ql.ast.expression.binary.Less;
import org.uva.ql.ast.expression.binary.LessEqual;
import org.uva.ql.ast.expression.binary.Multiply;
import org.uva.ql.ast.expression.binary.NotEqual;
import org.uva.ql.ast.expression.binary.Or;
import org.uva.ql.ast.expression.binary.Substraction;
import org.uva.ql.ast.expression.literal.BoolLiteral;
import org.uva.ql.ast.expression.literal.Literal;
import org.uva.ql.typechecker.TypeChecker;

public class BoolTest {

	private final TypeChecker TYPECHECKER = new TypeChecker();
	private final CodePosition POS = new CodePosition(0, 0);
	private final Literal LEFT_EXPR = new BoolLiteral(true, POS);
	private final Literal RIGHT_EXPR = new BoolLiteral(false, POS);


	@Test
	public void testBoolAdditionBool() {
		Addition add = new Addition(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(add), false);
	}

	@Test
	public void testBoolSubstractionBool() {
		Substraction substraction = new Substraction(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(substraction), false);
	}

	@Test
	public void testBoolMultiplyBool() {
		Multiply multiply = new Multiply(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(multiply), false);
	}

	@Test
	public void testBoolDivideBool() {
		Divide divide = new Divide(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(divide), false);
	}

	@Test
	public void testBoolGreaterBool() {
		GreaterEqual greaterEqual = new GreaterEqual(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(greaterEqual), false);
	}

	@Test
	public void testBoolGreaterEqualBool() {
		Greater greater = new Greater(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(greater), false);
	}

	@Test
	public void testBoolLessBool() {
		Less less = new Less(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(less), false);
	}

	@Test
	public void testBoolLessEqualBool() {
		LessEqual lessEqual = new LessEqual(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(lessEqual), false);
	}

	@Test
	public void testBoolEqualBool() {
		Equal equal = new Equal(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(equal), true);
	}

	@Test
	public void testBoolNotEqualBool() {
		NotEqual notEqual = new NotEqual(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(notEqual), true);
	}

	@Test
	public void testBoolOrBool() {
		Or or = new Or(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(or), true);
	}

	@Test
	public void testBoolAndBool() {
		And and = new And(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(and), true);
	}

}
