package qlProject.ast.expression;

public abstract class BinaryExpression implements IExpression {
	
	protected final IExpression left;
	protected final IExpression right;
	
	public BinaryExpression(IExpression left, IExpression right){
		
		this.left = left;
		this.right = right;	
	}

	public IExpression getLeft(){
		return left;
	}
	
	public IExpression getRight(){
		return right;
	}
}