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
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.ast.expression.literal.Literal;
import org.uva.ql.typechecker.TypeChecker;

public class StringTest {

	private TypeChecker typechecker;
	private Literal left;
	private Literal right;
	private CodePosition codePosition;

	@Before
	public void setUp() throws Exception {
		codePosition = new CodePosition(0, 0);
		left = new StrLiteral("Str Literal 1", codePosition);
		right = new StrLiteral("Str Literal 2", codePosition);
		typechecker = new TypeChecker();
	}

	@Test
	public void testStrAdditionStr() {
		Addition add = new Addition(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(add), true);
	}

	@Test
	public void testStrSubstractionStr() {
		Substraction substraction = new Substraction(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(substraction), false);
	}

	@Test
	public void testStrMultiplyStr() {
		Multiply multiply = new Multiply(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(multiply), false);
	}

	@Test
	public void testStrDivideStr() {
		Divide divide = new Divide(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(divide), false);
	}

	@Test
	public void testStrGreaterStr() {
		GreaterEqual greaterEqual = new GreaterEqual(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(greaterEqual), false);
	}

	@Test
	public void testStrGreaterEqualStr() {
		Greater greater = new Greater(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(greater), false);
	}

	@Test
	public void testStrLessStr() {
		Less less = new Less(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(less), false);
	}

	@Test
	public void testStrLessEqualStr() {
		LessEqual lessEqual = new LessEqual(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(lessEqual), false);
	}

	@Test
	public void testStrEqualStr() {
		Equal equal = new Equal(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(equal), true);
	}

	@Test
	public void testStrNotEqualStr() {
		NotEqual notEqual = new NotEqual(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(notEqual), true);
	}

	@Test
	public void testStrOrStr() {
		Or or = new Or(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(or), false);
	}

	@Test
	public void testStrAndStr() {
		And and = new And(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(and), false);
	}

}
