package ast.type;

public class IntegerType extends Type {
		
	public IntegerType() {}
			
	@Override
	public String toString() {
		return "digits";
	}
		
	@Override
	public <T> T accept(ITypeVisitor<T> visitor) {
		 return visitor.visit(this);
	}
	
	@Override
	public boolean isCompatibleToInteger() {
		return true;
	}
		
	@Override
	public boolean isCompatibleToType(Type type) {
		return type.isCompatibleToInteger();
	}
}
