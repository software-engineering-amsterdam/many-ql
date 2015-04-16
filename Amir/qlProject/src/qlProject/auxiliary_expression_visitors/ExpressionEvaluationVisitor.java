package qlProject.auxiliary_expression_visitors;

import java.util.Map;

import qlProject.ast.expression.BinaryExpression;
import qlProject.ast.expression.IExpression;
import qlProject.ast.expression.IExpressionVisitor;
import qlProject.ast.expression.Id;
import qlProject.ast.expression.ParenthesisExpr;
import qlProject.ast.expression.StringExpr.ConcatenationExpr;
import qlProject.ast.expression.StringExpr.StringLiteral;
import qlProject.ast.expression.arithmeticExpr.AdditionExpr;
import qlProject.ast.expression.arithmeticExpr.DivisionExpr;
import qlProject.ast.expression.arithmeticExpr.IntLiteral;
import qlProject.ast.expression.arithmeticExpr.MultiplicationExpr;
import qlProject.ast.expression.arithmeticExpr.NegationExpr;
import qlProject.ast.expression.arithmeticExpr.SubtractionExpr;
import qlProject.ast.expression.booleanExpr.BoolLiteral;
import qlProject.ast.expression.booleanExpr.comparisonExpression.BiggerEqExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.BiggerThanExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.EqualExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.SmallerEqExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.SmallerThanExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.UnequalExpr;
import qlProject.ast.expression.booleanExpr.logicalExpression.AndExpr;
import qlProject.ast.expression.booleanExpr.logicalExpression.NotExpr;
import qlProject.ast.expression.booleanExpr.logicalExpression.OrExpr;
import qlProject.ast.value.BoolValue;
import qlProject.ast.value.IntValue;
import qlProject.ast.value.NullValue;
import qlProject.ast.value.StringValue;
import qlProject.ast.value.Value;

public class ExpressionEvaluationVisitor implements IExpressionVisitor {

	private Map<String,Value> valuesMap;

	public ExpressionEvaluationVisitor(Map<String,Value> valuesMap){
		this.valuesMap = valuesMap;
	}


	@Override
	public Object visit(NegationExpr expr) {
		Value v = visitExpression(expr.getSubExpression());
		if (hasNullValue(v))
			return new NullValue();
		else
		{int result = (-(int)v.getValue());
		return new IntValue(result);
		}
	}

	@Override
	public Object visit(ParenthesisExpr e) {
		return visitExpression(e.getSubExpression());
	}

	public Value visit (NotExpr expr){
		Value v = visitExpression(expr.getSubExpression());
		if (hasNullValue(v))
			return new NullValue();
		else
		{boolean result = !(boolean)v.getValue();
		return new BoolValue(result);
		}
	}


	@Override
	public Value visit (Id id){
		if (valuesMap == null || !valuesMap.containsKey(id.getIdString()))
			return new NullValue();
		else 
			return valuesMap.get(id.getIdString());
	}


	@Override
	public Value visit (IntLiteral intLiteral){
		return new IntValue(intLiteral.getValue());
	}

	@Override
	public Value visit (BoolLiteral boolLiteral){
		return new BoolValue(boolLiteral.getValue());
	}

	@Override
	public Value visit(StringLiteral stringLiteral) {
		return new StringValue(stringLiteral.getValue());
	}


	@Override
	public Object visit(BiggerThanExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new NullValue();
		}
		else 			
		{
			boolean result = (int)visitExpression(expr.getLeft()).getValue() > (int)visitExpression(expr.getRight()).getValue();
			return new BoolValue(result);
		}
	}

	@Override
	public Object visit(BiggerEqExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new NullValue();
		}
		else {
			boolean result = (int)visitExpression(expr.getLeft()).getValue() >= (int)visitExpression(expr.getRight()).getValue();
			return new BoolValue(result);
		}
	}

	@Override
	public Object visit(SmallerThanExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new NullValue();
		}
		else {
			boolean result = (int)visitExpression(expr.getLeft()).getValue() < (int)visitExpression(expr.getRight()).getValue();
			return new BoolValue(result);
		}
	}

	@Override
	public Object visit(SmallerEqExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new NullValue();
		}
		else {
			boolean result = (int)visitExpression(expr.getLeft()).getValue() <= (int)visitExpression(expr.getRight()).getValue();
			return new BoolValue(result);
		}
	}

	@Override
	public Object visit(EqualExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new NullValue();
		}
		else {
			Object left = visitExpression(expr.getLeft()).getValue();
			Object right = visitExpression(expr.getRight()).getValue();
			boolean result = left.equals(right);
			return new BoolValue(result);
		}
	}

	@Override
	public Object visit(UnequalExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new NullValue();
		}
		else {
			boolean result = visitExpression(expr.getLeft()).getValue() != visitExpression(expr.getRight()).getValue();
			return new BoolValue(result);
		}
	}

	@Override
	public Object visit(ConcatenationExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new NullValue();
		}
		else {
			String result = (String)visitExpression(expr.getLeft()).getValue() + (String)visitExpression(expr.getRight()).getValue();
			return new StringValue(result);
		}
	}

	
	@Override
	public Object visit(OrExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new BoolValue(false);
		}
		else {
			boolean result = (boolean)visitExpression(expr.getLeft()).getValue() || (boolean)visitExpression(expr.getRight()).getValue();
			return new BoolValue(result);
		}
	}

	@Override
	public Object visit(AndExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new BoolValue(false);
		}
		else {
			boolean result = (boolean)visitExpression(expr.getLeft()).getValue() && (boolean)visitExpression(expr.getRight()).getValue();
			return new BoolValue(result);
		}
	}

	@Override
	public Object visit(AdditionExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new NullValue();
		}
		else {
			int leftValue = (int)visitExpression(expr.getLeft()).getValue();
			int rightValue = (int)visitExpression(expr.getRight()).getValue();
			if(sumWithinIntegerRange((Integer)leftValue, (Integer)rightValue))
				return new IntValue(leftValue + rightValue);
			else return new NullValue();
		}				
	}

	@Override
	public Object visit(SubtractionExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new NullValue();
		}
		else {
			int leftValue = (int)visitExpression(expr.getLeft()).getValue();
			int rightValue = (int)visitExpression(expr.getRight()).getValue();
			if(differenceWithinIntegerRange(leftValue, rightValue))
				return new IntValue(leftValue - rightValue);
			else return new NullValue();
		}
	}

	@Override
	public Object visit(DivisionExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new NullValue();
		}
		else {
			int leftValue = (int)visitExpression(expr.getLeft()).getValue();
			int rightValue = (int)visitExpression(expr.getRight()).getValue();
			if (rightValue != 0)
				return new IntValue(leftValue / rightValue);
			else return new NullValue();
		}
	}

	@Override
	public Object visit(MultiplicationExpr expr) {
		if (isNotEvaluableBinaryExpr(expr)){
			return new NullValue();
		}
		else {
			int leftValue = (int)visitExpression(expr.getLeft()).getValue();
			int rightValue = (int)visitExpression(expr.getRight()).getValue();
			if (productWithinIntegerRagne(leftValue, rightValue))
				return new IntValue(leftValue * rightValue);
			else return new NullValue();
		}
	}


	public boolean sumWithinIntegerRange(int left, int right){
		if(left > 0 == right > 0){
			if (left < 0 && (right < Integer.MIN_VALUE - left)){
				return false;
			}
			if (left > 0 && (right > Integer.MAX_VALUE - left)){
				return false;
			}
		}
		return true;
	}

	public boolean differenceWithinIntegerRange(int left, int right){
		if(left > 0 != right > 0){
			if (left < 0 && (right > Integer.MIN_VALUE - left)){
				return false;
			}
			if (left > 0 && (right < Integer.MAX_VALUE - left)){
				return false;
			}
		}
		return true;
	}

	public boolean productWithinIntegerRagne(int left, int right){
		return Math.abs(left) < (Integer.MAX_VALUE/Math.abs(right));
	}


	public boolean hasNullValue(Value v){
		return v.equals(new NullValue());
	}

	public boolean isNotEvaluableBinaryExpr(BinaryExpression expr){
		Value l = visitExpression(expr.getLeft());
		Value r = visitExpression(expr.getRight());
		return (hasNullValue(l) || hasNullValue(r));
	}

	Value visitExpression(IExpression e){
		return ((Value)e.accept(this));
	}

}