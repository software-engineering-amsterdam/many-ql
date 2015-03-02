package org.uva.sea.ql.encoders.ast;

import java.util.List;

/**
 * TypeChecker implementation to verify whether correct types are used within
 * expressions
 */
public class TypeChecker {

	TypeErrorLogger typeErrorLogger = new TypeErrorLogger();

	public boolean testExpression(Expression testExpression) {
		boolean expressionValid = false;

		// OperatorExpression sample = (OperatorExpression) testExpression;
		// System.out.println(sample.getLeftHand().toString());

		System.out.println("test");

		// perform test for expression
		try {
			// TODO: rewrite to proper tests, add test classes (e.g. AddSubTest,
			// BiggerThenTest)
			expressionValid = true;
		} catch (Exception e) {
			TypeError typeError = new TypeError("What a stupid error", e.getMessage());
			typeErrorLogger.addTypeError(typeError);
			expressionValid = false;
		}

		// TO BE REMOVED: dummy error due to lack of proper test
		TypeError typeError = new TypeError("What a stupid error", "Adding an integer to a boolean. Idiot..");
		typeErrorLogger.addTypeError(typeError);

		return expressionValid;
	}

	public boolean testLogical(String leftHand, String operator, String rightHand) {
		return false;
	}

	public List<TypeError> getTypeErrors() {
		return typeErrorLogger.getTypeErrors();
	}
}
