package org.uva.ql.test.typechecker;

import org.junit.Assert;
import org.junit.Before;
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

	private TypeChecker typechecker;
	private Literal left;
	private Literal right;
	private CodePosition codePosition;

	@Before
	public void setUp() throws Exception {
		codePosition = new CodePosition(0, 0);
		left = new BoolLiteral(true, codePosition);
		right = new BoolLiteral(false, codePosition);
		typechecker = new TypeChecker();
	}

	@Test
	public void testBoolAdditionBool() {
		Addition add = new Addition(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(add), false);
	}

	@Test
	public void testBoolSubstractionBool() {
		Substraction substraction = new Substraction(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(substraction), false);
	}

	@Test
	public void testBoolMultiplyBool() {
		Multiply multiply = new Multiply(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(multiply), false);
	}

	@Test
	public void testBoolDivideBool() {
		Divide divide = new Divide(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(divide), false);
	}

	@Test
	public void testBoolGreaterBool() {
		GreaterEqual greaterEqual = new GreaterEqual(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(greaterEqual), false);
	}

	@Test
	public void testBoolGreaterEqualBool() {
		Greater greater = new Greater(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(greater), false);
	}

	@Test
	public void testBoolLessBool() {
		Less less = new Less(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(less), false);
	}

	@Test
	public void testBoolLessEqualBool() {
		LessEqual lessEqual = new LessEqual(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(lessEqual), false);
	}

	@Test
	public void testBoolEqualBool() {
		Equal equal = new Equal(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(equal), true);
	}

	@Test
	public void testBoolNotEqualBool() {
		NotEqual notEqual = new NotEqual(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(notEqual), true);
	}

	@Test
	public void testBoolOrBool() {
		Or or = new Or(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(or), true);
	}

	@Test
	public void testBoolAndBool() {
		And and = new And(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(and), true);
	}

}
