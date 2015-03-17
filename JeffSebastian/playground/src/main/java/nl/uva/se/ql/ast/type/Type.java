package nl.uva.se.ql.ast.type;

import nl.uva.se.ql.evaluation.value.UndefinedValue;
import nl.uva.se.ql.evaluation.value.Value;

public abstract class Type {
	
	private final String typeName;
	
	public Type(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}
	
	public boolean isUndefined() {
		return false;
	}
	
	public boolean isNumerical() {
		return false;
	}
	
	public Value getDefaultValue() {
		return new UndefinedValue();
	}
	
	public Type promote() {
		return this;
	}
	
	public boolean isIn(Type... types) {
		for (Type type : types) {
			if (type.equals(this)) {
				return true;
			}
		}
		
		return false;
	}
	
	public abstract <T> T accept(TypeVisitor<T> visitor);
	
	@Override
	public String toString() {
		return typeName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Type) {
			return ((Type) obj).getTypeName().equals(typeName);
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return typeName.hashCode();
	}
	
}
