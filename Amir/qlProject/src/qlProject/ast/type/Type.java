package qlProject.ast.type;


public abstract class Type {

	public abstract String toString();
	
	public abstract boolean equals(Type type);

	public abstract boolean isOfType(Type type);

	
	public boolean isOfType(StringType type){
		return false;
	}

	public boolean isOfType(BooleanType type){
		return false;
	}
	
	public boolean isOfType(IntType type){
		return false;
	}

	public boolean isOfType(NullType type) {
		return false;
	}
	

	public abstract Object accept(ITypeVisitor visitor);
	
}
