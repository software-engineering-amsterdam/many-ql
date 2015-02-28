package org.uva.sea.ql.encoders.ast;

public class Evaluator {
	
	TypeErrorLogger typeErrorLogger = new TypeErrorLogger();
	
	public boolean parseExpression(Expression parseExpression)
	{
		boolean expressionParseable = false;
		
		//perform test for expression
		try {
			//rewrite to proper test, add test classes (e.g. AddSubTest, BiggerThenTest)
			expressionParseable = true;
		} catch (Exception e) {
			typeErrorLogger.addTypeError(new TypeError("What a stupid error: ", e.getMessage()));
			expressionParseable = false;
		}
		
		typeErrorLogger.addTypeError(new TypeError("What a stupid error: ", "This is a fake error"));
		
		return expressionParseable;
	}
}
