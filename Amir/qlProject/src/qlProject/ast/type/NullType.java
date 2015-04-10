package qlProject.ast.type;


public class NullType extends Type{
	
	int value;

	public NullType(int value){
	this.value = value;
	}
	
	public NullType(){
	}
	
    @Override
    public boolean equals(Type type)
    {
        return type instanceof NullType;
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
	public String toString(){
		return "numerical";
	}
	
	@Override
	public Object accept(ITypeVisitor visitor) {
		return null;
	}
}