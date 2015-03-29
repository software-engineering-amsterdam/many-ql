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
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.expression.literal.Literal;
import org.uva.ql.typechecker.TypeChecker;

public class IntTest {

	private TypeChecker typechecker;
	private Literal left;
	private Literal right;
	private CodePosition codePosition;

	@Before
	public void setUp() throws Exception {
		codePosition = new CodePosition(0, 0);
		left = new IntLiteral(5, codePosition);
		right = new IntLiteral(5, codePosition);
		typechecker = new TypeChecker();
	}

	@Test
	public void testIntAdditionInt() {
		Addition add = new Addition(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(add), true);
	}

	@Test
	public void testIntSubstractionInt() {
		Substraction substraction = new Substraction(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(substraction), true);
	}

	@Test
	public void testIntMultiplyInt() {
		Multiply multiply = new Multiply(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(multiply), true);
	}

	@Test
	public void testIntDivideInt() {
		Divide divide = new Divide(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(divide), true);
	}

	@Test
	public void testIntGreaterInt() {
		GreaterEqual greaterEqual = new GreaterEqual(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(greaterEqual), true);
	}

	@Test
	public void testIntGreaterEqualInt() {
		Greater greater = new Greater(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(greater), true);
	}

	@Test
	public void testIntLessInt() {
		Less less = new Less(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(less), true);
	}

	@Test
	public void testIntLessEqualInt() {
		LessEqual lessEqual = new LessEqual(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(lessEqual), true);
	}
	
	@Test
	public void testIntEqualInt() {
		Equal equal = new Equal(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(equal), true);
	}
	
	@Test
	public void testIntNotEqualInt() {
		NotEqual notEqual = new NotEqual(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(notEqual), true);
	}	

	@Test
	public void testIntOrInt() {
		Or or= new Or(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(or), false);
	}
	
	@Test
	public void testIntAndInt() {
		And and = new And(left, right, codePosition);
		Assert.assertEquals(typechecker.visit(and), false);
	}

	
}
