package anotherOne.ast.expression;

import java.util.HashMap;
import java.util.Map;

import anotherOne.ast.expression.arithmeticExpr.AdditionExpr;
import anotherOne.ast.expression.arithmeticExpr.ArithmeticExpression;
import anotherOne.ast.expression.arithmeticExpr.DivisionExpr;
import anotherOne.ast.expression.arithmeticExpr.Integ;
import anotherOne.ast.expression.arithmeticExpr.IntIdExpr;
import anotherOne.ast.expression.arithmeticExpr.MultiplicationExpr;
import anotherOne.ast.expression.arithmeticExpr.SubtractionExpr;
import anotherOne.ast.expression.booleanExpr.AndExpr;
import anotherOne.ast.expression.booleanExpr.BiggerEqExpr;
import anotherOne.ast.expression.booleanExpr.BiggerThanExpr;
import anotherOne.ast.expression.booleanExpr.BoolIdExpr;
import anotherOne.ast.expression.booleanExpr.EqualExpr;
import anotherOne.ast.expression.booleanExpr.NotExpr;
import anotherOne.ast.expression.booleanExpr.OrExpr;
import anotherOne.ast.expression.booleanExpr.SmallerEqExpr;
import anotherOne.ast.expression.booleanExpr.SmallerThanExpr;
import anotherOne.ast.expression.booleanExpr.UnequalExpr;

public class VariablesCollectionVisitor { //<Integer>{ // int int?  // arithmeticExpressionVisitor!!!

	public Map<String, Id> idMap = new HashMap<String, Id>();
	
	public VariablesCollectionVisitor(Map<String,Id> idMap){
		this.idMap = idMap;
	}
	
	public void visit (Integ intLiteral){
	}
	
	public void visit (IntIdExpr intIdExpr){
		System.out.println("collected ID: " + intIdExpr.getIdString());
		idMap.put(intIdExpr.getIdString(), intIdExpr);
	}

	public void visit (AdditionExpr toAdd){
		toAdd.left.accept(this);
		toAdd.right.accept(this);
	}
	
//break this	
	public void visit (SubtractionExpr toSubtract){
		toSubtract.left.accept(this);
		toSubtract.right.accept(this);
	}
	
	public void visit (MultiplicationExpr toMultiply){
		toMultiply.left.accept(this);
		toMultiply.right.accept(this);
	}

	public void visit (DivisionExpr toDivide){
		toDivide.left.accept(this);
		toDivide.right.accept(this);
	}
	
	public void visit (Bool boolLiteral){
	}
	
	public void visit (BoolIdExpr boolIdExpr){  // boolExpId / arithmExpId
		System.out.println("collected ID: " + boolIdExpr.getIdString());
		idMap.put(boolIdExpr.getIdString(), boolIdExpr);
	}

	public void visit (NotExpr notExpr){  // boolExpId / arithmExpId
		System.out.println("collected Not!!");// " + boolIdExpr.getIdString());
		notExpr.expr.accept(this);
//		idMap.put(boolIdExpr.getIdString(), boolIdExpr);
	}

//	checkBox id can be involved in bool expr  -> evaluate booleanExpression
//	Text field id can be involved in boolExpr -> evaluate boolean expression
//						and in arithmeticExpr -> evaluate arithmetic expression
	
	public void visit (AndExpr andExpr){
		andExpr.left.accept(this);
		andExpr.right.accept(this);
	}

	public void visit (OrExpr orExpr){
		orExpr.left.accept(this);
		orExpr.right.accept(this);
	}

	public void visit (BiggerThanExpr expr){
		((ArithmeticExpression)expr.left).accept(this);
		((ArithmeticExpression)expr.left).accept(this);
	}

	public void visit (BiggerEqExpr expr){
		((ArithmeticExpression)expr.left).accept(this);
		((ArithmeticExpression)expr.left).accept(this);
	}

	public void visit (SmallerThanExpr expr){
		((ArithmeticExpression)expr.left).accept(this);
		((ArithmeticExpression)expr.left).accept(this);
	}

	public void visit (SmallerEqExpr expr){
		((ArithmeticExpression)expr.left).accept(this);
		((ArithmeticExpression)expr.left).accept(this);
	}

	public void visit (EqualExpr expr){
		((ArithmeticExpression)expr.left).accept(this);
		((ArithmeticExpression)expr.left).accept(this);
	}

	public void visit (UnequalExpr expr){
		((ArithmeticExpression)expr.left).accept(this);
		((ArithmeticExpression)expr.left).accept(this);
	}


}
