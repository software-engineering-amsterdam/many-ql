package project.ast.expression.booleanExpr;

import project.ast.expression.BinaryExpression;
import project.ast.value.NumericalTypeValue;
import project.ast.value.TypeValue;

public abstract class BinaryLogicalExpr implements BinaryExpression, BooleanExpression{ 
//extends BinaryBooleanExpr {

	public BooleanExpression left;
	public BooleanExpression right;

	public BinaryLogicalExpr(BooleanExpression left, BooleanExpression right){
		this.left = left;
		this.right = right;	
	}

//	public BinaryLogicalExpr(BooleanExpression left, BooleanExpression right) {
//		super(left, right);
//	}

	@Override
	public TypeValue getType(){
		return new NumericalTypeValue();
	};
//	public TypeValue getType();

}
