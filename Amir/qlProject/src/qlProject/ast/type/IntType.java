package qlProject.ast.type;

public class IntType extends Type{

	@Override
	public boolean isOfType(IntType type){
		return true;
	}
	
	@Override
	public boolean isOfType(Type type){
		return this.isOfType(type);
	}
	
    @Override
    public boolean equals(Type type){
        return type instanceof IntType;
    }
	
	@Override
	public String toString(){
		return "numerical";
	}

	@Override
	public Object accept(ITypeVisitor visitor) {
		return visitor.visit(this);
	}

}