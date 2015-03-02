package project;



import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import project.ast.IGlobalElement;
import project.ast.expression.BinaryExpression;
import project.ast.expression.Bool;
import project.ast.expression.Id;
import project.ast.expression.StringExpr.StringComparisonExpr;
import project.ast.expression.StringExpr.StringConcatenationExpr;
import project.ast.expression.arithmeticExpr.BinaryArithmeticExpr;
import project.ast.expression.arithmeticExpr.Integ;
import project.ast.expression.booleanExpr.BiggerEqExpr;
import project.ast.expression.booleanExpr.BiggerThanExpr;
import project.ast.expression.booleanExpr.BinaryBooleanExpr;
import project.ast.expression.booleanExpr.BinaryLogicalExpr;
import project.ast.expression.booleanExpr.ComparisonExpr;
import project.ast.expression.booleanExpr.EqualExpr;
import project.ast.expression.booleanExpr.NotExpr;
import project.ast.expression.booleanExpr.SmallerEqExpr;
import project.ast.expression.booleanExpr.SmallerThanExpr;
import project.ast.expression.booleanExpr.UnequalExpr;
import project.ast.value.BooleanTypeValue;
import project.ast.value.NumericalTypeValue;
import project.ast.value.TypeValue;
import project.typeChecking.ErrorObject;

public class TypeCheckVisitor { //<Integer>{ // int int?  // arithmeticExpressionVisitor!!!

	private Map<String,TypeValue> environment = new HashMap<String,TypeValue>();  // remove null value
	public Map<IGlobalElement, HashSet<ErrorObject>> errora = new HashMap<IGlobalElement, HashSet<ErrorObject>>();
	
	public TypeCheckVisitor(Map<String,TypeValue> environment){
		this.environment = environment;
	}

	public HashSet<ErrorObject> checkTypeSubExprs(BinaryExpression expr, TypeValue type){//expr,new BooleanTypeValue());
		HashSet<ErrorObject> errors = new HashSet<ErrorObject>();
		errors.addAll(visitBinarySubExprs(expr));
		errors.addAll(checkBinarySubExprs(expr,type));//.adSet<ErrorObject>
		return errors;
	}
	
	public HashSet<ErrorObject> checkIdType(BinaryExpression expr, TypeValue type){//expr,new BooleanTypeValue());
		HashSet<ErrorObject> errors = new HashSet<ErrorObject>();
		errors.addAll(visitBinarySubExprs(expr));
		errors.addAll(checkBinarySubExprs(expr,type));//.adSet<ErrorObject>
		return errors;
	}

	public HashSet<ErrorObject> checkBinarySubExprs(BinaryExpression expr, TypeValue type){
		HashSet<ErrorObject> errors = new HashSet<ErrorObject>();  
		if (!(expr.getLeft().getType().equals(type))){
			errors.add(new ErrorObject("Error: expression expr.getLeft().toString() seems to be of type "+expr.getLeft().getType()+"toString" +"but was expected to be of type:" + type + "type.toString"));
			System.out.println("test82");
		}
		if (!(expr.getRight().getType().equals(type))){
			errors.add(new ErrorObject("Error: expression expr.getRight().toString() seems to be of type "+expr.getRight().getType()+"toString" +"but was expected to be of type:" + type + "type.toString"));
		}

		System.out.println(expr.getLeft().getType() + "seems to be equal to " + type);
		System.out.println(expr.getRight().getType() + "seems to be equal to " + type);
		System.out.println("test83");
		return errors;
		}

//	public HashSet<ErrorObject> checkIdTypes(BinaryExpression expr, TypeValue type){
//		HashSet<ErrorObject> errors = new HashSet<ErrorObject>();  
//		System.out.println("test878");
//		if (!(expr.getType().equals(type))){
//			System.out.println("test878");
//			errors.add(new ErrorObject("Error: identifier expr.getLeft().toString() seems to be of type "+expr.getLeft().getType()+"toString" +"but was expected to be of type:" + "type.toString"));
//			System.out.println("test82");
//		}
//		return errors;
//		}

	public HashSet<ErrorObject> visitBinarySubExprs(BinaryExpression expr){
		HashSet<ErrorObject> errors = new HashSet<ErrorObject>();
		errors.addAll(expr.getLeft().accept(this)); 
		errors.addAll(expr.getRight().accept(this));
		System.out.println("test7");
		return errors;
	}

	public HashSet<ErrorObject> checkSubExprsMatching(BinaryExpression expr){
		HashSet<ErrorObject> errors = new HashSet<ErrorObject>();
		if (!(expr.getLeft().getType().equals(expr.getRight().getType()))){
			errors.add(new ErrorObject ("Error: the equality expression is erronious because the type: " + expr.getRight().getType()+"toString" +"of the left-hand element does not match the type: " + expr.getLeft().getType() + "toString " + "of the right-hand element"));
		}
		return errors;
	}

	public HashSet<ErrorObject> visit (BinaryArithmeticExpr expr){
		return checkTypeSubExprs(expr, new NumericalTypeValue());
	}

	public HashSet<ErrorObject> visit (BinaryLogicalExpr expr){
		System.out.println("test99");
		return checkTypeSubExprs(expr, new BooleanTypeValue());		
	}

	public HashSet<ErrorObject> visit (BiggerThanExpr expr){
		System.out.println("test6");
		return checkTypeSubExprs(expr, new NumericalTypeValue());
	}

	public HashSet<ErrorObject> visit (BiggerEqExpr expr){
		return checkTypeSubExprs(expr, new NumericalTypeValue());
        
	}

	public HashSet<ErrorObject> visit (SmallerThanExpr expr){
		return checkTypeSubExprs(expr, new NumericalTypeValue());
	}

	public HashSet<ErrorObject> visit (SmallerEqExpr expr){ 
		return checkTypeSubExprs(expr, new NumericalTypeValue());
	}

	public HashSet<ErrorObject> visit (EqualExpr expr){
		HashSet<ErrorObject> errors = new HashSet<ErrorObject>();
		errors.addAll(visitBinarySubExprs(expr));
		errors.addAll(checkSubExprsMatching(expr));
		return errors;
	}

	public HashSet<ErrorObject> visit (UnequalExpr expr){
		HashSet<ErrorObject> errors = new HashSet<ErrorObject>();
		errors.addAll(visitBinarySubExprs(expr));
		errors.addAll(checkSubExprsMatching(expr));
		return errors;
	}

	public HashSet<ErrorObject> visit (NotExpr expr){
		HashSet<ErrorObject> errors = new HashSet<ErrorObject>();
		if (!(expr.subExpr.getType().isType(new BooleanTypeValue()))){
			errors.add(new ErrorObject ("Error: sub-expression should be of type boolean, but seems to be of type " + expr.subExpr.getType() + "toString"));
		}
		errors.addAll(expr.subExpr.accept(this));
		return errors;
	}

	public HashSet<ErrorObject> visit (Integ intLiteral){
		return new HashSet<ErrorObject>();
	}

	public HashSet<ErrorObject> visit (Bool boolLiteral){
		return new HashSet<ErrorObject>();
	}

	public HashSet<ErrorObject> visit (Id expr){
		HashSet<ErrorObject> errors = new HashSet<ErrorObject>();
		expr.setEnvironment(environment);
		if (!(environment.containsKey(expr.idString))){
			errors.add(new ErrorObject ("Error: the identifier: " + expr.idString + " is undefined"));
		}
		return errors;
	}

	public HashSet<ErrorObject> visit(
			StringConcatenationExpr stringConcatenationExpr) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<ErrorObject> visit(StringComparisonExpr stringComparisonExpr) {
		// TODO Auto-generated method stub
		return null;
	}
}

//public boolean checkTypeSubExpr(BinaryExpression expr){
//return checkLeft && checkRight;
//}

//	public boolean visit (BoolIdExpr boolIdExpr){//,Map<String, Id> varsMap){
////assert 
//boolean bl = ((BooleanTypeValue)environment.get(boolIdExpr.getIdString())).getValue();
//if (((BooleanTypeValue)environment.get(boolIdExpr.getIdString())).getValue()) {
//	System.out.println("true");}else {System.out.println("false");}
////}
//// 			 if value is null / undefined -> EXCEPTION
//// assert -> if value is not boolean -> error
//return ((BooleanTypeValue)environment.get(boolIdExpr.getIdString())).getValue();
//}

//	environment.get(expr.getIdString()).typeName() = .getValue();}

//	public int visit (IntIdExpr intIdExpr){ // change to string
//		// assert											   // explain why map and not original values of Id through setvariablevisitor
////		System.out.println("kijk:-->" + varsMap.get(id.getIdString()).getNumericalValue());//.getIdNumericalValue());
////		if (!(varsMap.containsKey(id.getIdString()))){
////			throw new Error("Please enter a valid value");
////		}
////			System.out.println("visited ID: " + id.getIdString() + ": " + varsMap.get(id.getIdString()).getNumericalValue());//.getIdNumericalValue());
////		return 10000;}	
//		// 			  if value is null / undefined -> EXCEPTION
//		//  assert -> if value is not int -> throw exception
//		//			  
//		return ((NumericalTypeValue)environment.get(intIdExpr.getIdString())).getValue();}
////		if (id.getIdString() == null){
////			else {throw new Error("Please enter a valid age");
////			return null;
////			}
////		else 
////		System.out.println("visited ID: " + id.getIdString() + ": " + id.getNumericalValue());//.getIdNumericalValue());
////		return id.getNumericalValue(); //100;
////		return id.Getvalue;
////	}



//	public boolean visit (AdditionExpr expr){
//	}
//	public boolean visit (SubtractionExpr expr){
//	}
//	public boolean visit (MultiplicationExpr expr){
//	}
//	public boolean visit (DivisionExpr expr){
//		}

//	public int visit(Int int1) {
//		// TODO Auto-generated method stub
//		return 0;
//	}	

//private VariableEnvironment environment;
//	private Map<String,BoolIdExpr> environment;


//	public boolean visit (BoolIdExpr expr){//, Map<String, Id> varsMap){ // change to string
//		return environment.get(expr.getIdString()).getValue();}

//public boolean visit (AndExpr expr){//,Map<String, Id> varsMap){
//}
//public boolean visit (OrExpr expr){//,Map<String, Id> varsMap){
////	return orExpr.left.accept(this) && 
////			orExpr.right.accept(this);
//	return left && right && checkLeft && checkRight;
//}
