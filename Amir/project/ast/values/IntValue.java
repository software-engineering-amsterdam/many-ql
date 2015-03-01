package project.ast.values;

import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;

public class IntValue implements Value {

	public int integer;
	
	public IntValue(int integer){
		this.integer = integer;
	}
	
    @Override
    public Integer getValue()
    {
        return integer;
    }

	@Override
	public boolean Equals(Value value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Value access(ExpressionEvaluationVisitor visitor) {
//		return visitor.visit(this);
		return null;
	}

}
