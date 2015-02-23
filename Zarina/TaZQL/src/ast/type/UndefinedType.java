package ast.type;

public class UndefinedType extends Type {
	
	public String getValue() {
		return null;
	}
	
	@Override
	public String toString() {
		return "undefined";
	}
	
	@Override
	public <T> T accept(ITypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
		
	@Override
	public boolean isCompatibleToType(Type type) {
		return false;
	}

}
