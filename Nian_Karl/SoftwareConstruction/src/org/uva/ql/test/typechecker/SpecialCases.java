package org.uva.ql.test.typechecker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.binary.Addition;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.expression.literal.Literal;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.typechecker.TypeChecker;

public class SpecialCases {

	private Literal int1;
	private Literal int2;
	private Literal int3;
	private Literal str1;
	private CodePosition codePos;
	private TypeChecker typeChecker;

	@Before
	public void setUp() throws Exception {
		codePos = new CodePosition(0, 0);
		int1 = new IntLiteral(5, codePos);
		int2 = new IntLiteral(3, codePos);
		int3 = new IntLiteral(2, codePos);
		str1 = new StrLiteral("Hello", codePos);
		typeChecker = new TypeChecker();
	}

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
