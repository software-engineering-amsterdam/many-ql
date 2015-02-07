package anotherOne.ast.trash;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import anotherOne.ast.expression.Id;
import anotherOne.ast.expression.arithmeticExpr.AdditionExpr;
import anotherOne.ast.expression.arithmeticExpr.DivisionExpr;
import anotherOne.ast.expression.arithmeticExpr.Integ;
import anotherOne.ast.expression.arithmeticExpr.MultiplicationExpr;
import anotherOne.ast.expression.arithmeticExpr.SubtractionExpr;

public class CopyOfVariablesCollectionVisitor { //<Integer>{ // int int?  // arithmeticExpressionVisitor!!!
	
	Map<String, Id> idMap = new HashMap<String, Id>();

	public Map<String, Id> visit (Integ intLiteral){
		return idMap; //intLiteral.value; // 150
	}
	
	public Map<String, Id> visit (Id id){
		
		System.out.println("collected ID: " + id.getIdString());
		idMap.put(id.getIdString(), id);
		return idMap;
	}

	public Map<String, Id> visit (AdditionExpr toAdd){
		toAdd.left.accept(this);
		idMap.putAll(toAdd.right.accept(this));
		return idMap;
	}
	
	public Map<String,Id> visit (SubtractionExpr toSubtract){
		idMap.putAll(toSubtract.left.accept(this));
		idMap.putAll(toSubtract.right.accept(this));
		return idMap;
	}
	
	public Map<String,Id> visit (MultiplicationExpr toMultiply){
		idMap.putAll(toMultiply.left.accept(this));
		idMap.putAll(toMultiply.right.accept(this));
		return idMap;
	}

	public Map<String, Id> visit (DivisionExpr toDivide){
		idMap.putAll(toDivide.left.accept(this));
		idMap.putAll(toDivide.right.accept(this));
		return idMap;
	}

}
