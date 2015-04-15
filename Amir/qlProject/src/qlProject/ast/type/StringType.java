package qlProject.ast.type;

public class StringType extends Type {

	@Override
	public boolean isOfType(BooleanType type){
		return true;
	}
	
	@Override
	public boolean isOfType(Type type){
		return this.isOfType(type);
	}
	
    @Override
    public boolean equals(Type type){
    	return type instanceof StringType;
    }

	@Override
	public String toString(){
		return "string";
	}
	
	@Override
	public Object accept(ITypeVisitor visitor) {
		return visitor.visit(this);
	}
}