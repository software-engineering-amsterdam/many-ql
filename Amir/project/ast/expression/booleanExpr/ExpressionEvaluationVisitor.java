package project.ast.expression.booleanExpr;

import java.util.HashMap;
import java.util.Map;

import project.Tuple;
import project.ast.expression.Bool;
import project.ast.expression.Id;
import project.ast.expression.StringExpr.StringLiteral;
import project.ast.expression.arithmeticExpr.Integ;
import project.ast.value.TypeValue;
import project.ast.values.BoolValue;
import project.ast.values.IntValue;
import project.ast.values.Value;

public class ExpressionEvaluationVisitor { //<Integer>{ // int int?  // arithmeticExpressionVisitor!!!

	private Map<String,TypeValue> environment;
	public Map<String,Tuple> questionsInfo2 = new HashMap<String,Tuple>();

	public ExpressionEvaluationVisitor(Map<String,TypeValue> environment, Map<String,Tuple> questionsInfo2){
		this.environment = environment;
		this.questionsInfo2 = questionsInfo2;
	}
////	public Value visit (BoolIdExpr boolIdExpr){
//////		assert 
////		System.out.println("visited ID: " + boolIdExpr.getIdString() + ": ");
////		System.out.println(environment.size());
////		boolean bl = ((BooleanTypeValue)environment.get(boolIdExpr.getIdString())).getValue();
////		if (((BooleanTypeValue)environment.get(boolIdExpr.getIdString())).getValue()) {
////			System.out.println("true");}else {System.out.println("false");}
//////		}
////		//		BooleanTypeValue bool;
////
////		// 			 if value is null / undefined -> EXCEPTION
////		// assert -> if value is not boolean -> error
////		return ((BooleanTypeValue)environment.get(boolIdExpr.getIdString())).getValue();
//	}

////	public Value visit (BiggerThanExpr expr){
////		System.out.println("PPPPPrint");
////		int evalLeft = ((ArithmeticExpression)expr.left).accept(this);
////		int evalRight = ((ArithmeticExpression)expr.right).accept(this);
////		return (evalLeft > evalRight);
////				
//	}

////	public Value visit (BiggerEqExpr expr){
////
////		int evalLeft = ((ArithmeticExpression)expr.left).accept(this);
////		int evalRight = ((ArithmeticExpression)expr.right).accept(this);
////		return (evalLeft >= evalRight);
////				
//	}

////	public Value visit (SmallerThanExpr expr){
////
////		int evalLeft = ((ArithmeticExpression)expr.left).accept(this);
////		int evalRight = ((ArithmeticExpression)expr.right).accept(this);
////		return (evalLeft < evalRight);
////				
//	}

////	public Value visit (SmallerEqExpr expr){
////
////		int evalLeft = ((ArithmeticExpression)expr.left).accept(this);
////		int evalRight = ((ArithmeticExpression)expr.right).accept(this);
////		return (evalLeft <= evalRight);
//	}

////	public Value visit (EqualExpr expr){
////
////		int evalLeft = ((ArithmeticExpression)expr.left).accept(this);
////		int evalRight = ((ArithmeticExpression)expr.right).accept(this);
////		return (evalLeft == evalRight);
//	}

////	public Value visit (UnequalExpr expr){
////
////		int evalLeft = ((ArithmeticExpression)expr.left).accept(this);
////		int evalRight = ((ArithmeticExpression)expr.right).accept(this);
////		return (evalLeft != evalRight);
//	}

////	public Value visit (AndExpr andExpr){
////		return andExpr.left.accept(this) && 
////				andExpr.right.accept(this);
//	}
	
//	public Value visit (OrExpr orExpr){
//		return orExpr.left.accept(this)|| 
//				orExpr.right.accept(this);
//	}

	public Value visit (NotExpr expr){
		return expr.evaluate(expr.subExpr.accept(this));
	}
	
	public Value visit (BinaryOperation expr){
		return expr.evaluate(expr.getLeftHand().access(this),expr.getRightHand().access(this));
	}
	
	public Value visit (Integ intLiteral){
		return new IntValue(intLiteral.value); // 150
	}

	public Value visit (Bool boolLiteral){
		return new BoolValue(boolLiteral.value); // 150
	}
	
	public Value visit (Id id){ // change to string
		// assert											   // explain why map and not original values of Id through setvariablevisitor
		System.out.println("visited ID: " + id.getIdString() + ": ");
		System.out.println(environment.size());
		return questionsInfo2.get(id.idString).value;
//		return ((NumericalTypeValue)environment.get(id.getIdString())).getValue();}
	}
//	public Value visit (IntIdExpr intIdExpr){ // change to string
////		// assert											   // explain why map and not original values of Id through setvariablevisitor
////		System.out.println("visited ID: " + intIdExpr.getIdString() + ": ");
////		System.out.println(environment.size());
////		
////		return ((NumericalTypeValue)environment.get(intIdExpr.getIdString())).getValue();}

	public Value visit(StringLiteral stringLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

////	public Value visit (AdditionExpr toAdd){
////		return toAddtoAdd.left.accept(this) + 
////				toAdd.right.accept(this));
//////		return (((AdditionExpr) toAdd.left.).accept(this) + ((AdditionExpr) toAdd.right).accept(this));
//	}
	
////	public Value visit (SubtractionExpr toSubtract){
////		return (toSubtract.left.accept(this) - 
////				toSubtract.right.accept(this) );
//	}
	
////	public Value visit (MultiplicationExpr toMultiply){
////		return (toMultiply.left.accept(this) * 
////				toMultiply.right.accept(this) );
//	}
	
////	public Value visit (DivisionExpr toDivide){
////		return (toDivide.left.accept(this) / 
////				toDivide.right.accept(this) );	
//		}

////	public Value visit(OrExpr orExpr) {
////		// TODO Auto-generated method stub
////		return null;
//	}
	
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
