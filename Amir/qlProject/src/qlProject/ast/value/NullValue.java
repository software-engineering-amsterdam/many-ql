package qlProject.ast.value;

import qlProject.ast.type.NullType;
import qlProject.ast.type.Type;

public class NullValue extends Value {

	
    @Override
    public Object getValue()
    {
        return null;
    }

    public boolean equals(Value value) {
		return value instanceof NullValue;
	}

	@Override
	public boolean isOfType(NullType type){
		return true;
	}
	
	@Override
	public boolean isOfType(Type type){
		return this.isOfType(type);
	}

	@Override
	public Type getType() {
		return new NullType();
	}

}