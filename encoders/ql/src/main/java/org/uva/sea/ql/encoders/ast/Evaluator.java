package org.uva.sea.ql.encoders.ast;

import java.util.List;

public class Evaluator {
	
	TypeErrorLogger typeErrorLogger = new TypeErrorLogger();
	
	public boolean parseExpression(Expression parseExpression) {
		boolean expressionParseable = false;
		
		//perform test for expression
		try {
			//TODO: rewrite to proper test, add test classes (e.g. AddSubTest, BiggerThenTest)
			expressionParseable = true;
		} catch (Exception e) {
			typeErrorLogger.addTypeError(new TypeError("What a stupid error: ", e.getMessage()));
			expressionParseable = false;
		}
		
		//TO BE REMOVED: dummy error due to lack of proper test
		typeErrorLogger.addTypeError(new TypeError("Stupid Error", "Mixed up Boolean with Integer in line 9. Idiot."));
		
		return expressionParseable;
	}
	
	public List<TypeError> getTypeErrors() {
		return typeErrorLogger.getTypeErrors();
	}
}
