package qlProject.ast.value;

import qlProject.ast.type.BooleanType;
import qlProject.ast.type.Type;

public class BoolValue extends Value {

	private final boolean bool;

	public BoolValue(boolean bool){
		this.bool = bool;
	}

	
	@Override
	public Type getType(){
		return new BooleanType();
	}

	@Override
	public boolean isOfType(BooleanType type){
		return true;
	}
	
	@Override
	public boolean isOfType(Type type){
		return this.isOfType(type);
	}

    @Override
    public Boolean getValue()
    {
        return bool;
    }

	@Override
	public boolean equals(Value value) {
		return value instanceof BoolValue;
	}

}