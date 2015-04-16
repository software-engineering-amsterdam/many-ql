package qlProject.ast.value;

import qlProject.ast.type.BooleanType;
import qlProject.ast.type.NullType;
import qlProject.ast.type.IntType;
import qlProject.ast.type.StringType;
import qlProject.ast.type.Type;

public abstract class Value {

	public abstract boolean isOfType(Type t);// TODO fix this.

	public abstract Object getValue();

	public abstract boolean equals(Value value);

	public abstract Type getType();

	boolean isOfType(BooleanType type){
		return false;
	}

	boolean isOfType(IntType type){
		return false;
		}

	boolean isOfType(StringType type){
		return false;
	}

	boolean isOfType(NullType type){
		return false;
	}
}