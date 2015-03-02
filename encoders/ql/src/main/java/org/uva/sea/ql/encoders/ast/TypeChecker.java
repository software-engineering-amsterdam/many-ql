package org.uva.sea.ql.encoders.ast;

import java.util.ArrayList;
import java.util.List;

public class TypeChecker {

	private List<TypeValidation> typeValidations = new ArrayList<TypeValidation>();

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
			TypeValidation typeValidation = new TypeValidation("What a stupid error", e.getMessage());
			typeValidations.add(typeValidation);
			expressionValid = false;
		}

		// TO BE REMOVED: dummy error due to lack of proper test
		TypeValidation typeValidation = new TypeValidation("What a stupid error", "Adding an integer to a boolean. Idiot..");
		typeValidations.add(typeValidation);

		return expressionValid;
	}

	public boolean testLogical(String leftHand, String operator, String rightHand) {
		return false;
	}

	public List<TypeValidation> getTypeErrors() {
		return typeValidations;
	}

}
