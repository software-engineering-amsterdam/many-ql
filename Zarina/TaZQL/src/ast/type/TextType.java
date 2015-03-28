package ast.type;


public class TextType extends Type {
	
	public TextType() {}
	
	@Override
	public String toString() {
		return "text";
	}
	
	@Override
	public <T> T accept(ITypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public boolean isCompatibleToString() {
		return true;
	}
		
	@Override
	public boolean isCompatibleToType(Type type) {
		return type.isCompatibleToString();
	}
}