package project.ast.values;

import project.ast.expression.booleanExpr.ExpressionEvaluationVisitor;

public class BoolValue implements Value {

	public boolean bool;

	public BoolValue(boolean bool){
		this.bool = bool;
	}
	
    @Override
    public Boolean getValue()
    {
        return bool;
    }


	@Override
	public boolean Equals(Value value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Value access(ExpressionEvaluationVisitor visitor) {
//		visitor.visit(this);
		return null;
	}

}

