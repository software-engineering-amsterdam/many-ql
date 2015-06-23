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
import org.uva.ql.ast.expression.literal.Literal;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.typechecker.TypeChecker;

public class StringTest {

	private final TypeChecker TYPECHECKER = new TypeChecker();
	private final CodePosition POS = new CodePosition(0, 0);
	private final Literal LEFT_EXPR = new StrLiteral("Str Literal 1", POS);
	private final Literal RIGHT_EXPR = new StrLiteral("Str Literal 2", POS);
	
	@Test
	public void testStrAdditionStr() {
		Addition add = new Addition(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(add), true);
	}

	@Test
	public void testStrSubstractionStr() {
		Substraction substraction = new Substraction(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(substraction), false);
	}

	@Test
	public void testStrMultiplyStr() {
		Multiply multiply = new Multiply(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(multiply), false);
	}

	@Test
	public void testStrDivideStr() {
		Divide divide = new Divide(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(divide), false);
	}

	@Test
	public void testStrGreaterStr() {
		GreaterEqual greaterEqual = new GreaterEqual(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(greaterEqual), false);
	}

	@Test
	public void testStrGreaterEqualStr() {
		Greater greater = new Greater(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(greater), false);
	}

	@Test
	public void testStrLessStr() {
		Less less = new Less(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(less), false);
	}

	@Test
	public void testStrLessEqualStr() {
		LessEqual lessEqual = new LessEqual(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(lessEqual), false);
	}

	@Test
	public void testStrEqualStr() {
		Equal equal = new Equal(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(equal), true);
	}

	@Test
	public void testStrNotEqualStr() {
		NotEqual notEqual = new NotEqual(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(notEqual), true);
	}

	@Test
	public void testStrOrStr() {
		Or or = new Or(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(or), false);
	}

	@Test
	public void testStrAndStr() {
		And and = new And(LEFT_EXPR, RIGHT_EXPR, POS);
		Assert.assertEquals(TYPECHECKER.visit(and), false);
	}

}
