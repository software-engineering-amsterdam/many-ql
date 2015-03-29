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
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.expression.literal.Literal;
import org.uva.ql.typechecker.TypeChecker;

public class IntTest {

	private final TypeChecker TYPECHECKER= new TypeChecker();
	private final CodePosition POS= new CodePosition(0, 0);
	private final Literal LEFT_EXPR= new IntLiteral(5, POS);
	private final Literal RIGHT_EXPR= new IntLiteral(5, POS);

	@Test
	public void testIntAdditionInt() {
		Addition add = new Addition(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(add), true);
	}

	@Test
	public void testIntSubstractionInt() {
		Substraction substraction = new Substraction(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(substraction), true);
	}

	@Test
	public void testIntMultiplyInt() {
		Multiply multiply = new Multiply(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(multiply), true);
	}

	@Test
	public void testIntDivideInt() {
		Divide divide = new Divide(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(divide), true);
	}

	@Test
	public void testIntGreaterInt() {
		GreaterEqual greaterEqual = new GreaterEqual(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(greaterEqual), true);
	}

	@Test
	public void testIntGreaterEqualInt() {
		Greater greater = new Greater(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(greater), true);
	}

	@Test
	public void testIntLessInt() {
		Less less = new Less(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(less), true);
	}

	@Test
	public void testIntLessEqualInt() {
		LessEqual lessEqual = new LessEqual(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(lessEqual), true);
	}
	
	@Test
	public void testIntEqualInt() {
		Equal equal = new Equal(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(equal), true);
	}
	
	@Test
	public void testIntNotEqualInt() {
		NotEqual notEqual = new NotEqual(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(notEqual), true);
	}	

	@Test
	public void testIntOrInt() {
		Or or= new Or(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(or), false);
	}
	
	@Test
	public void testIntAndInt() {
		And and = new And(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(and), false);
	}

	
}
