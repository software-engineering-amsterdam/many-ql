package qlProject.ast.value;

import qlProject.ast.type.IntType;
import qlProject.ast.type.Type;

public class IntValue extends Value {

	private final int integer;
	
	public IntValue(int integer){
		this.integer = integer;
	}
	

	@Override
    public Integer getValue()
    {
        return integer;
    }

	@Override
	public boolean equals(Value value) {
		return value instanceof IntValue;
	}

	@Override
	public boolean isOfType(IntType type){
		return true;
	}
	
	@Override
	public boolean isOfType(Type type){
		return this.isOfType(type);
	}

	@Override
	public Type getType() {
		return new IntType();
	}

}