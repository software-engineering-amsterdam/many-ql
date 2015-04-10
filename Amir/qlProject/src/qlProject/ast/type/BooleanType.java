package qlProject.ast.type;

public class BooleanType extends Type {
	
	public BooleanType(){
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
    public boolean equals(Type type){
        return type instanceof BooleanType;
    }

	@Override
	public String toString(){
		return "boolean"; //TODO toString for constraints
	}

	@Override
	public Object accept(ITypeVisitor visitor) {
		return visitor.visit(this);
	}
	
}