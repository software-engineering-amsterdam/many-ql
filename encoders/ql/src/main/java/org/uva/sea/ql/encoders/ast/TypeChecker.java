package org.uva.sea.ql.encoders.ast;

import java.util.List;

public class TypeChecker {
	
	TypeErrorLogger typeErrorLogger = new TypeErrorLogger();
	
	public boolean testExpression(Expression testExpression) {
		boolean expressionValid = false;
		
		//perform test for expression
		try {
			//TODO: rewrite to proper test, add test classes (e.g. AddSubTest, BiggerThenTest)
			expressionValid = true;
		} catch (Exception e) {
			typeErrorLogger.addTypeError(new TypeError ( "What a stupid error"
					                                   , e.getMessage()
			                                           , 1
			                                           , 2
		                                               )
				                        );
			expressionValid = false;
		}
		
		//TO BE REMOVED: dummy error due to lack of proper test
		typeErrorLogger.addTypeError( new TypeError ( "Dumb error"
									                , "Adding an integer to a boolean. Idiot.."
									                , 8
									                , 1
									                )
                                    );
		
		return expressionValid;
	}
	
	public List<TypeError> getTypeErrors() {
		return typeErrorLogger.getTypeErrors();
	}
}
