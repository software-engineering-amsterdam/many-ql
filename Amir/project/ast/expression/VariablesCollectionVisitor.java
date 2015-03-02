package project.ast.expression;

import java.util.HashMap;
import java.util.Map;

import project.ast.expression.StringExpr.StringComparisonExpr;
import project.ast.expression.StringExpr.StringConcatenationExpr;
import project.ast.expression.StringExpr.StringLiteral;
import project.ast.expression.arithmeticExpr.AdditionExpr;
import project.ast.expression.arithmeticExpr.ArithmeticExpression;
import project.ast.expression.arithmeticExpr.DivisionExpr;
import project.ast.expression.arithmeticExpr.IntIdExpr;
import project.ast.expression.arithmeticExpr.Integ;
import project.ast.expression.arithmeticExpr.MultiplicationExpr;
import project.ast.expression.arithmeticExpr.SubtractionExpr;
import project.ast.expression.booleanExpr.AndExpr;
import project.ast.expression.booleanExpr.BiggerEqExpr;
import project.ast.expression.booleanExpr.BiggerThanExpr;
import project.ast.expression.booleanExpr.BoolIdExpr;
import project.ast.expression.booleanExpr.EqualExpr;
import project.ast.expression.booleanExpr.NotExpr;
import project.ast.expression.booleanExpr.OrExpr;
import project.ast.expression.booleanExpr.SmallerEqExpr;
import project.ast.expression.booleanExpr.SmallerThanExpr;
import project.ast.expression.booleanExpr.UnequalExpr;

public class VariablesCollectionVisitor { //<Integer>{ // int int?  // arithmeticExpressionVisitor!!!

	public Map<String, Id> idMap = new HashMap<String, Id>();
	public Map<String, String> forbiddenReferences = new HashMap<String, String>();
	
	public VariablesCollectionVisitor(Map<String,Id> idMap){
		this.idMap = idMap;
	}
	
	public void visit (Integ intLiteral){
	}
	
	public void visit (IntIdExpr intIdExpr){
		System.out.println("collected ID: " + intIdExpr.getIdString());
		idMap.put(intIdExpr.getIdString(), intIdExpr);
	}

	public void visit (Id id){
		System.out.println("collected ID: " + id.getIdString());
		idMap.put(id.getIdString(), id);
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
		notExpr.subExpr.accept(this);
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

	public void visit(StringConcatenationExpr stringConcatenationExpr) {
		// TODO Auto-generated method stub
	}

	public void visit(StringComparisonExpr stringComparisonExpr) {
		// TODO Auto-generated method stub
		
	}

	public void visit(StringLiteral stringLiteral) {
		// TODO Auto-generated method stub
		
	}


}
