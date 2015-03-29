package org.uva.ql.ast.value;


public class UndefinedValue extends Value {

	public UndefinedValue() {
		
	}

	@Override
	public UndefinedValue value() {
		return this;
	}

	@Override
	public String toString() {
		return "Undefined";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof UndefinedValue){
			return true;
		} else {
			throw new UnsupportedOperationException("UndefinedValue is only compariable with another UndefinedValue.");
		}
	}
	
}
