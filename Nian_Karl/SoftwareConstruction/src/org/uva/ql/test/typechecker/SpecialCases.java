package org.uva.ql.test.typechecker;

import org.junit.Assert;
import org.junit.Test;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.binary.Addition;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.expression.literal.Literal;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.typechecker.TypeChecker;

public class SpecialCases {

	private final CodePosition codePos = new CodePosition(0, 0);
	private final TypeChecker typeChecker = new TypeChecker();
	private final Literal int1 = new IntLiteral(5, codePos);
	private final Literal int2 = new IntLiteral(3, codePos);
	private final Literal int3 = new IntLiteral(2, codePos);
	private final Literal str1 = new StrLiteral("Hello", codePos);

	@Test
	public void testSpecialCase1() {
		// Testing 5 == (3+2)
		Addition add = new Addition(int2, int3, codePos);
		Equal equal = new Equal(int1, add, codePos);
		Assert.assertEquals(typeChecker.visit(equal), true);
	}

	@Test
	public void testSpecialCase2() {
		// Testing "Hello" == (3+2)
		Addition add = new Addition(int2, int3, codePos);
		Equal equal = new Equal(str1, add, codePos);
		Assert.assertEquals(typeChecker.visit(equal), false);
	}
}
