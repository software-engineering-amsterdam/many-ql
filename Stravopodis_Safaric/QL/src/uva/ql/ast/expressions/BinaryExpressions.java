package uva.ql.ast.expressions;
import uva.ql.ast.CodeLines;
import uva.ql.ast.value.GenericValue;

public abstract class BinaryExpressions extends Expression{

	private Expression left;
	private Expression right;
	private Operator operator;
	
	public BinaryExpressions(Expression _left, Expression _right, Operator _operator, 
			CodeLines _codeLines) {
		super(_codeLines);
		
		this.left = _left;
		this.right = _right;
		this.operator = _operator;
	}
	
	public Expression getLeftExpr(){
		return this.left;
	}
	
	public Expression getRightExpr(){
		return this.right;
	}
	
	public Object getLeftValue(){
		return this.getEvaluatedValue();
	}
	
	public Object getRightValue(){
		return this.getEvaluatedValue();
	}
	
	public Operator getOperator(){
		return this.operator;
	}
	
	@Override
	public abstract GenericValue<?> evaluate();

}
