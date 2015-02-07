package anotherOne.ast.expression.booleanExpr;

import java.util.Map;

import anotherOne.ast.expression.Bool;
import anotherOne.ast.expression.Id;
import anotherOne.ast.expression.arithmeticExpr.AdditionExpr;
import anotherOne.ast.expression.arithmeticExpr.ArithmeticExpression;
import anotherOne.ast.expression.arithmeticExpr.DivisionExpr;
import anotherOne.ast.expression.arithmeticExpr.Integ;
import anotherOne.ast.expression.arithmeticExpr.IntIdExpr;
import anotherOne.ast.expression.arithmeticExpr.MultiplicationExpr;
import anotherOne.ast.expression.arithmeticExpr.SubtractionExpr;
import anotherOne.ast.value.BooleanTypeValue;
import anotherOne.ast.value.NumericalTypeValue;
import anotherOne.ast.value.TypeValue;

public class BooleanExpressionEvaluationVisitor { //<Integer>{ // int int?  // arithmeticExpressionVisitor!!!

//	private VariableEnvironment environment;
	private Map<String,TypeValue> environment;  // remove null value
//	private Map<String,BoolIdExpr> environment;
	
	
	public BooleanExpressionEvaluationVisitor(Map<String,TypeValue> environment){
		this.environment = environment;
	}
	public boolean visit (BoolIdExpr boolIdExpr){//,Map<String, Id> varsMap){
//		assert 
		System.out.println("visited ID: " + boolIdExpr.getIdString() + ": ");
		System.out.println(environment.size());
		boolean bl = ((BooleanTypeValue)environment.get(boolIdExpr.getIdString())).getValue();
		if (((BooleanTypeValue)environment.get(boolIdExpr.getIdString())).getValue()) {
			System.out.println("true");}else {System.out.println("false");}
//		}
		//		BooleanTypeValue bool;

		// 			 if value is null / undefined -> EXCEPTION
		// assert -> if value is not boolean -> error
		return ((BooleanTypeValue)environment.get(boolIdExpr.getIdString())).getValue();
	}

	public boolean visit (BiggerThanExpr expr){//,Map<String, Id> varsMap){
		System.out.println("PPPPPrint");
		int evalLeft = ((ArithmeticExpression)expr.left).accept(this);
		int evalRight = ((ArithmeticExpression)expr.right).accept(this);
		return (evalLeft > evalRight);
				
	}

	public boolean visit (BiggerEqExpr expr){//, Map<String, Id> varsMap){

		int evalLeft = ((ArithmeticExpression)expr.left).accept(this);
		int evalRight = ((ArithmeticExpression)expr.right).accept(this);
		return (evalLeft >= evalRight);
				
	}

	public boolean visit (SmallerThanExpr expr){//, Map<String, Id> varsMap){

		int evalLeft = ((ArithmeticExpression)expr.left).accept(this);
		int evalRight = ((ArithmeticExpression)expr.right).accept(this);
		return (evalLeft < evalRight);
				
	}

	public boolean visit (SmallerEqExpr expr){//, Map<String, Id> varsMap){

		int evalLeft = ((ArithmeticExpression)expr.left).accept(this);
		int evalRight = ((ArithmeticExpression)expr.right).accept(this);
		return (evalLeft <= evalRight);
				
	}

	public boolean visit (EqualExpr expr){//, Map<String, Id> varsMap){

		int evalLeft = ((ArithmeticExpression)expr.left).accept(this);
		int evalRight = ((ArithmeticExpression)expr.right).accept(this);
		return (evalLeft == evalRight);
				
	}

	public boolean visit (UnequalExpr expr){//, Map<String, Id> varsMap){

		int evalLeft = ((ArithmeticExpression)expr.left).accept(this);
		int evalRight = ((ArithmeticExpression)expr.right).accept(this);
		return (evalLeft != evalRight);
				
	}

	public boolean visit (AndExpr andExpr){//,Map<String, Id> varsMap){
		return andExpr.left.accept(this) && 
				andExpr.right.accept(this);
	}
	
	public boolean visit (OrExpr orExpr){//,Map<String, Id> varsMap){
		return orExpr.left.accept(this)|| 
				orExpr.right.accept(this);
	}

	public boolean visit (NotExpr notExpr){//,Map<String, Id> varsMap){
		return !(notExpr.expr.accept(this));
	}

	public int visit (Integ intLiteral){//, Map<String, Id> varsMap){
		return intLiteral.value; // 150
	}

	public boolean visit (Bool boolLiteral){//, Map<String, Id> varsMap){
		return boolLiteral.value; // 150
	}
	
	public int visit (IntIdExpr intIdExpr){ // change to string
		// assert											   // explain why map and not original values of Id through setvariablevisitor
		System.out.println("visited ID: " + intIdExpr.getIdString() + ": ");
		System.out.println(environment.size());
		
//		System.out.println("kijk:-->" + varsMap.get(id.getIdString()).getNumericalValue());//.getIdNumericalValue());
		
//		if (!(varsMap.containsKey(id.getIdString()))){
//			throw new Error("Please enter a valid value");
//		}
//			System.out.println("visited ID: " + id.getIdString() + ": " + varsMap.get(id.getIdString()).getNumericalValue());//.getIdNumericalValue());
//		return 10000;}	
		// 			  if value is null / undefined -> EXCEPTION
		//  assert -> if value is not int -> throw exception
		//			  
		return ((NumericalTypeValue)environment.get(intIdExpr.getIdString())).getValue();}
//		if (id.getIdString() == null){
//			else {throw new Error("Please enter a valid age");
//			return null;
//			}
//		else 
//		System.out.println("visited ID: " + id.getIdString() + ": " + id.getNumericalValue());//.getIdNumericalValue());
//		return id.getNumericalValue(); //100;
//		return id.Getvalue;
//	}

	public int visit (AdditionExpr toAdd){
		return (toAdd.left.accept(this) + 
				toAdd.right.accept(this));
//		return (((AdditionExpr) toAdd.left.).accept(this) + ((AdditionExpr) toAdd.right).accept(this));
	}
	
	public int visit (SubtractionExpr toSubtract){
		return (toSubtract.left.accept(this) - 
				toSubtract.right.accept(this) );
	}
	
	public int visit (MultiplicationExpr toMultiply){
		return (toMultiply.left.accept(this) * 
				toMultiply.right.accept(this) );
	}
	
	public int visit (DivisionExpr toDivide){
		return (toDivide.left.accept(this) / 
				toDivide.right.accept(this) );	}
	
//	public int visit(Int int1) {
//		// TODO Auto-generated method stub
//		return 0;
//	}	
}

//	public boolean visit (BoolIdExpr expr){//, Map<String, Id> varsMap){ // change to string
//		System.out.println("visited ID: " + expr.getIdString() + ": ");
//		System.out.println(environment.size());
//		return environment.get(expr.getIdString()).getValue();}


	//	public boolean visit (AndExpr andExpr){
//		return (andExpr.left.accept(this) && andExpr.right.accept(this) );
////		return (((AdditionExpr) toAdd.left.).accept(this) + ((AdditionExpr) toAdd.right).accept(this));
//	}
	
//	public boolean visit (OrExpr orExpr){
//		return (orExpr.left.accept(this) || orExpr.right.accept(this) );
//	}
	
//	public boolean visit (MultiplicationExpr toMultiply){
//		return (toMultiply.left.accept(this) * toMultiply.right.accept(this) );
//	}
//	
//	public boolean visit (DivisionExpr toDivide){
//		return (toDivide.left.accept(this) / toDivide.right.accept(this) );	}	
//}
